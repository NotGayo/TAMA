package Model;

public class Mimitchi extends Tamagochi{
	public Mimitchi() {
		super();
	}
	package Model;
	
	@Override
	public void decrementarContadorVida() {
		puntosVida = puntosVida-7;
	}
		@Override
	public void decrementarContadorComida() {
		puntosComida= puntosComida-7;
	}
		
}

