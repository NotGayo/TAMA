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
	//private Random rand;
	private static Tamagochi mTamagochi = new Tamagochi() {
	};

	protected Tamagochi() {

		this.puntosVida = 40;
		this.puntosComida = 40;

	}

	public void startTamagochi() {
		this.puntuacion = 0;
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				
				// OBSERVER -- ESTE ES OBSERVABLE
				setChanged();
				//GENERA UN NUMERO RANDOM DE 0-39
				//int chall = rand.nextInt(40);
				//int answer = 33;
				//SI SON IGUALES ENTONCES MANDA LA SEÑAL DEL OBSERVER PARA INICIZLIZAR EL TAMADIGOUT 
				//if (chall == answer) {
					//notifyObservers(new String[] {"TamaDigOut"});
				//}
				seconds++;
				if(seconds%2 == 0) {
				decrementarContadorVida();
				decrementarContadorComida();
				}
				if(seconds % 5 == 0) {
					puntuacion++;
				}
				if(seconds % 15 == 0 && puntosVida >0 && puntosComida > 0) {
					currentPhase++;
					notifyObservers(new String[] { evolutions[currentPhase] });
				}
				else if (puntosVida == 0 || puntosComida == 0) {
					notifyObservers(new String[] { "MUERTO" });
					cancel();
				} 

				else if (puntosVida > 0 && puntosComida > 0) {
					notifyObservers(new int[] { puntosVida, puntosComida, puntuacion });
				}
			}
		};
		timer = new Timer();
		timer.scheduleAtFixedRate(timerTask, 0, 1000);
		
	}

	public static Tamagochi getTamagochi() {
		return mTamagochi;
	}

	public void decrementarContadorVida() {
		this.puntosVida--;
		

	}

	public void decrementarContadorComida() {
		this.puntosComida--;
		
	}
	public static void main(String[] args) {
		Tamagochi t = new Tamagochi() {
		};
	}
	public void sumarVida() {
		this.puntosVida += 10;
	}
	public void sumarComida() {
		this.puntosComida += 10;
	}
}