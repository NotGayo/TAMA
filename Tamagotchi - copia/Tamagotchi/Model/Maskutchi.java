package Model;

public class Maskutchi extends Tamagochi{
	
	
	public Maskutchi() {
		super();
	}
	@Override
	public void decrementarContadorVida() {
		puntosVida = puntosVida-3;
	}
		@Override
		public void decrementarContadorComida() {
			puntosComida= puntosComida-14;
		}
		
}

