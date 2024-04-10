package Model;

public class Kuchipatchi extends Tamagochi{
	public Kuchipatchi() {
		super();
	}
	@Override
	public void decrementarContadorVida() {
		puntosVida = puntosVida-2;
	}
	@Override
	public void decrementarContadorComida() {
		puntosComida= puntosComida-5;
	}
	
}
