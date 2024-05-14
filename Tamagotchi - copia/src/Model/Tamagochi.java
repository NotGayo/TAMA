package Model;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import View.Juego;

import java.util.Random;

public class Tamagochi extends Observable {
	protected int puntosVida;
	protected int puntosComida;
	private Timer timer = null;
	private int puntuacion;
	protected int seconds = 0;
	protected final String[] evolutions = {"egg","kuchipatchi","mimitchi","maskutchi","mametchi"};
	protected int currentPhase = 0;
	private State state = new Egg();
	private SaludState salState = new Limpio();
	private Random rand = new Random();
	private int nPiruletas = 0;
	private int nCucharadas = 0;
	private boolean enfermedad = false;
	private boolean suciedad = false;
	private boolean wait = false;
	private ComboComida combo = new ComboComida();
	private boolean comiendo = false;
	private int contComida = 0;
	private static Tamagochi mTamagochi = new Tamagochi() {
	};

	protected Tamagochi() {

		this.puntosVida = 40;
		this.puntosComida = 40;

	}
	
	public void changeState(State pState) {
		state = pState;
	}
	public void changeSaludState(SaludState pSState) {
		salState = pSState;
	}
	public int getDecVida() {
		return state.getDecrementoVida();
	}
	public int getDecComida() {
		return state.getDecrementoComida();
	}
	public String getNombreEvo() {
		return state.getNombreEvo();
	}
	
	public void startTamagochi() {
		this.puntuacion = 0;
		puntosVida = 40;
		puntosComida = 40;
		currentPhase = 0;
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				if(!wait) {
					// OBSERVER -- ESTE ES OBSERVABLE
					setChanged();
					
					
					//PARTE DE CONTADORES DE COSAS ALEATORIAS
					
					//RANDOM TAMADIGOUT
					int TMD = rand.nextInt(40);
					int goTMD = 33;
					//SI SON IGUALES ENTONCES MANDA LA SE�AL DEL OBSERVER PARA INICIZLIZAR EL TAMADIGOUT 
					if (TMD == goTMD) {
						wait = true;
						setChanged();
						notifyObservers(new String[] {"TamaDigOut"});
						TableroModelo.getTableroModelo().startDigOut();
						
					}
					//RANDOM SUCIEDAD
					int SUC = rand.nextInt(5);
					int goSUC = 3;
					if(SUC == goSUC) {
						suciedad = true;
					}
					//RANDOM ENFERMEDAD
					int ENF1 = rand.nextInt(10);
					int ENF2 = rand.nextInt(10);
					int ENF3 = rand.nextInt(10);
					int goENF = 5;
					if(ENF1 == goENF || ENF2== goENF || ENF3 == goENF)
					{
						enfermedad = true;
						
					}	
					
					if(suciedad && enfermedad && !salState.getNombreEvo().equals("SucioEnfermo")) {
						changeSaludState(new SucioEnfermo());
					}
					else if(!suciedad && enfermedad && !salState.getNombreEvo().equals("Enfermo")) {
						changeSaludState(new Enfermo());
					}
					else if(suciedad && !enfermedad && !salState.getNombreEvo().equals("Sucio")) {
						changeSaludState(new Sucio());
					}
					else if(!suciedad && !enfermedad && !salState.getNombreEvo().equals("Limpio")) {
						changeSaludState(new Limpio());
					}
					
					
					if(puntosVida > 40) {
						puntosVida = 40;
					}
					if(puntosComida > 40) {
						puntosComida = 40;
					}
					seconds++;
					contComida++;
					if(seconds%2 == 0) {
						decrementarContadorVida();
						decrementarContadorComida();
						actualizarPuntuacion();
					
					}
					if(seconds%4 == 0) {
						puntuacion +=1;
	
					}
					
					if(seconds % 4 == 0) {
						comiendo = true;
						combo.consumirElementos();
						System.out.println(combo.getValorVida());
						System.out.println(combo.getValorComida());
						puntosVida += combo.getValorVida();
						puntosComida += combo.getValorComida();
						nCucharadas = 0;
						nPiruletas = 0;
						comiendo = false;
						contComida = 0;
					}
					if(seconds == 15 ) {
						changeState(new Kuchipatchi());
						notifyObservers(new String[] { state.getNombreEvo() });
						System.out.println("evo");
					}
					else if(seconds == 30 ) {
						changeState(new Mimitchi());
						notifyObservers(new String[] { state.getNombreEvo() });
					}
					else if(seconds == 45 && puntosVida > 20 ) {
						changeState(new Mametchi());
						notifyObservers(new String[] { state.getNombreEvo() });
					}
					else if(seconds == 45 && puntosVida <= 20 ) {
						changeState(new Maskutchi());
						notifyObservers(new String[] { state.getNombreEvo() });
					}
					
					
					else if (puntosVida <= 0 || puntosComida <= 0) {
						notifyObservers(new String[] { "MUERTO" });
						cancel();
	
					} 
	
					else if (puntosVida > 0 && puntosComida > 0) {
							
						notifyObservers(new int[] { puntosVida, puntosComida, puntuacion, nPiruletas, nCucharadas, getEnfermedad(), getSuciedad(),contComida });
						
					}
					System.out.println("VIDA:"+puntosVida+", COMDIDA: "+puntosComida+", RELOJ INTERNO: "+seconds);
					}
				}
			
			
		};
		timer = new Timer();
		timer.scheduleAtFixedRate(timerTask, 0, 1000);
		
		}
	
	public static Tamagochi getTamagochi() {
		return mTamagochi;
	}

	public int getEnfermedad() {
		if(this.enfermedad) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public int getSuciedad() {
		if(this.suciedad) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public int getNCuch() {
		return nCucharadas;
	}
	public int getNPir() {
		return nPiruletas;
	}
	
	public void decrementarContadorVida() {
		puntosVida += state.getDecrementoVida();
		puntosVida += salState.getDecrementoVida();
		if(puntosComida > 40) {
			puntosComida = 40;
		}
	}
	
	public void decrementarContadorComida() {
		puntosComida += state.getDecrementoComida();
		puntosComida += salState.getDecrementoComida();
		if(puntosComida > 40) {
			puntosComida = 40;
		}
	}
	
	private void actualizarPuntuacion() {
		puntuacion += salState.getAumentoPuntuacion();
	}
	

	public void sumarVida() 
	{
		if(!comiendo) {
			combo.addComible(new Piruleta());
			nPiruletas++;
		}
	}
	
	public void sumarComida() 
	{
		if(!comiendo) {
			combo.addComible(new Cucharada());
			nCucharadas++;
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
	}
	public void exitWait() {
		wait = false;
		System.out.println("wait false");
		Juego j = new Juego();
		j.run();
	}
	
	public void iniciarCardGame() {
		wait = true;
		setChanged();
		notifyObservers(new String[] { "TamaDigOut" });
		Tablero.getTablero().empezar();
	}


}