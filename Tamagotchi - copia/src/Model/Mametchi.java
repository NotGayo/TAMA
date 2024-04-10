package Model;

public class Mametchi extends Tamagochi{
	
	public Mametchi() {
			super();
		}
	@Override
	public void decrementarContadorVida() {
		puntosVida = puntosVida-1;
	}
	@Override
	public void decrementarContadorComida() {
		puntosComida= puntosComida-1;
	}
		
}

