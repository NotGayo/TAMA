package Model;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;

public abstract class Tamagochi extends Observable {
	protected int puntosVida;
	protected int puntosComida;
	private Timer timer = null;
	private int puntuacion;
	protected int seconds = 0;
	protected final String[] evolutions = {"egg","kuchipatchi","mimitchi","maskutchi","mametchi"};
	protected int currentPhase = 0;
	private Random rand = new Random();
	private int nPiruletas = 0;
	private int nCucharadas = 0;
	private boolean enfermedad = false;
	private boolean suciedad = false;
	private static Tamagochi mTamagochi = new Tamagochi() {
	};

	protected Tamagochi() {

		this.puntosVida = 40;
		this.puntosComida = 40;

	}

	public void startTamagochi() {
		this.puntuacion = 0;
		puntosVida = 40;
		puntosComida = 40;
		currentPhase = 0;
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				
				// OBSERVER -- ESTE ES OBSERVABLE
				setChanged();
				//GENERA UN NUMERO RANDOM DE 0-39
				int TMD = rand.nextInt(40);
				int goTMD = 33;
				//SI SON IGUALES ENTONCES MANDA LA SE�AL DEL OBSERVER PARA INICIZLIZAR EL TAMADIGOUT 
				if (TMD == goTMD) {
					notifyObservers(new String[] {"TamaDigOut"});
					TableroModelo.getTableroModelo().startDigOut();
				}
				//SI SON IGUALES ENTONCES SE PONE sucio (20%)
				int SUC = rand.nextInt(5);
				int goSUC = 3;
				if(SUC == goSUC) {
					suciedad = true;
				}
				
				
				//SI SON IGUALES ENTONCES SE PONE enfermo (30%)
				int ENF1 = rand.nextInt(10);
				int ENF2 = rand.nextInt(10);
				int ENF3 = rand.nextInt(10);
				int goENF = 5;
				if(ENF1 == goENF || ENF2== goENF || ENF3 == goENF){
					enfermedad = true;
				}
				
				//CALCULAMOS LA PUNTUACION
				puntuacion += calcularPuntuacion(seconds, enfermedad, suciedad, evolutions[currentPhase]);
				
				if(puntosVida > 40) {
					puntosVida = 40;
				}
				if(puntosComida > 40) {
					puntosComida = 40;
				}
				seconds++;
				if(seconds%2 == 0) {
				decrementarContadorVida();
				decrementarContadorComida();
				
				}
				if(seconds%4 == 0) {
					puntuacion +=1;

				}
				if(seconds == 15 ) {
					currentPhase = 1;
					notifyObservers(new String[] { evolutions[currentPhase] });
				}
				else if(seconds == 30 ) {
					currentPhase = 2;
					notifyObservers(new String[] { evolutions[currentPhase] });
				}
				else if(seconds == 45 && puntosVida > 20 ) {
					puntuacion += 20;
					currentPhase = 3;
					notifyObservers(new String[] { evolutions[currentPhase] });
				}
				else if(seconds == 45 && puntosVida <= 20 ) {
					currentPhase = 4;
					notifyObservers(new String[] { evolutions[currentPhase] });
				}
				
				
				if(seconds % 3 == 0) {
					if(nCucharadas > 0) {
						nCucharadas--;
						puntosComida += 10;
					}
					if(nPiruletas > 0) {
						nPiruletas--;
						puntosVida += 10;
					}
				}
				
				else if (puntosVida <= 0 || puntosComida <= 0) {
					notifyObservers(new String[] { "MUERTO" });
					cancel();

				} 

				else if (puntosVida > 0 && puntosComida > 0) {
						
					notifyObservers(new int[] { puntosVida, puntosComida, puntuacion, nPiruletas, nCucharadas, getEnfermedad(), getSuciedad() });
					
				}
				}
			
		};
		timer = new Timer();
		timer.scheduleAtFixedRate(timerTask, 0, 1000);
		
		}
	

	public static Tamagochi getTamagochi() {
		return mTamagochi;
	}

	
	private int calcularPuntuacion(int pSegundo, boolean pEnfermo, boolean pSucio, String pEvo) {
		return 0;
	}
	private int getEnfermedad() {
		if(this.enfermedad) {
			return 1;
		}
		else {
			return 0;
		}
	}
	private int getSuciedad() {
		if(this.suciedad) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public void decrementarContadorVida() {
		if(enfermedad) {
			puntosVida -= 5;
		}
		else if(suciedad) {
			puntosVida -= 10;
		}
		else if(evolutions[currentPhase] == "egg") {
			this.puntosVida -= 0;
		}
		else if(evolutions[currentPhase] == "kuchipatchi") {
			this.puntosVida-=2;
		}
		else if(evolutions[currentPhase] == "mimitchi") {
			this.puntosVida-=7;
		}
		else if(evolutions[currentPhase] == "maskutchi") {
			this.puntosVida-=3;
		}
		else if(evolutions[currentPhase] == "mametchi") {
			this.puntosVida-=1;
		}
		if(puntosComida > 40) {
			puntosComida = 40;
		}
	}
	
	public void decrementarContadorComida() {
		if(enfermedad) {
			puntosComida -= 5;
		}
		else if(suciedad) {
			puntosComida -= 10;
		}
		else if(evolutions[currentPhase] == "egg") {
			this.puntosComida -= 0;
		}
		else if(evolutions[currentPhase] == "kuchipatchi") {
			this.puntosComida-=5;
		}
		else if(evolutions[currentPhase] == "mimitchi") {
			this.puntosComida-=7;
		}
		else if(evolutions[currentPhase] == "maskutchi") {
			this.puntosComida-=14;
		}
		else if(evolutions[currentPhase] == "mametchi") {
			this.puntosComida-=1;
		}
		if(puntosComida > 40) {
			puntosComida = 40;
		}
	}
	
	public void sumarVida() {
		if(nCucharadas + nPiruletas < 4 || nPiruletas < 3) {
			
			this.nPiruletas++;
			puntuacion += 3;
			}
	}
	public void sumarComida() {
		if(nCucharadas + nPiruletas < 4 || nCucharadas < 3) {
		
		this.nCucharadas++;
		puntuacion += 3;
		}
	}
	public void quitarEnf() {
		this.enfermedad = false;
	}
	public void quitarSuc() {
		this.suciedad = false;
	}
	public void addPoints(int pPoints) {

		puntuacion += pPoints;
		System.out.println("Puntos añadidos: " + puntuacion);
		setChanged();
		notifyObservers(new double[] {2.03});
	}


}