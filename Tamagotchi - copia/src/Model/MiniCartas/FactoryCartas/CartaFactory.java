package Model.MiniCartas.FactoryCartas;

import Model.MiniCartas.Carta;
import Model.MiniCartas.CartaState.CartaState;
import Model.MiniCartas.CartaState.Desabilitada;

public class CartaFactory {
	private static CartaFactory mCartaFactory = new CartaFactory();
	
	private CartaFactory() {
		
	}
	
	public static CartaFactory getCF() {
		return mCartaFactory;
	}
	
	public Carta crearCarta(int pId) {
		if(pId == 0) {
			return new CartaRayo(new Desabilitada());
		}
		else if(pId == 1) {
			return new CartaHierba(new Desabilitada());
		}
		else if(pId == 2) {
			return new CartaOjo(new Desabilitada());
		}
		else if(pId == 3) {
			return new CartaAgua(new Desabilitada());
		}
		else if(pId == 4) {
			return new CartaEstrella(new Desabilitada());
		}
		else if(pId == 5) {
			return new CartaFuego(new Desabilitada());
		}
		return null;
	}
}
