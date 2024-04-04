package Model;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Tamagochi extends Observable {
	protected int puntosVida;
	protected int puntosComida;
	private Timer timer = null;
	private int puntuacion;
	
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
				decrementarContadorVida();
				decrementarContadorComida();
				// OBSERVER -- ESTE ES OBSERVABLE
				setChanged();

				if (puntosVida == 0 || puntosComida == 0) {
					notifyObservers(new String[] { "MUERTO" });
					cancel();
				} 

				else if (puntosVida > 0 && puntosComida > 0) {
					notifyObservers(new int[] { puntosVida, puntosComida, puntuacion, puntosVida%10, puntosComida%10 });
				}
			}
		};
		timer = new Timer();
		timer.scheduleAtFixedRate(timerTask, 0, 200);
	}

	public static Tamagochi getTamagochi() {
		return mTamagochi;
	}

	public void decrementarContadorVida() {
		this.puntosVida--;
		System.out.printf("Vida " + puntosVida);

	}

	public void decrementarContadorComida() {
		this.puntosComida--;
		System.out.printf("Comida " + puntosComida);
	}
	private void aumentarPuntuacionSobreElTiempo() {
		
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