package Model.MiniCartas;

import Model.MiniCartas.CartaState.CartaState;
import Model.MiniCartas.CartaState.Desabilitada;
import Model.MiniCartas.CartaState.SinVoltear;
import Model.MiniCartas.CartaState.Volteada;

public abstract class Carta {
	
	protected int id;
	protected CartaState estado;
	
	public Carta(CartaState c) {
		this.estado=c;
	}
	
	public int  getId() {
		return this.id;
	}
	


	
	public void cambiarEstado(String e) {
		CartaState s = null;
		if(e.equals("Volteada")) {
			s = new Volteada();
			this.estado=s;
			System.out.println("cambiado el estado a volteada");
		}
		else if (e.equals("SinVoltear")){
			s = new SinVoltear();
			this.estado=s;
			System.out.println("cambiado el estado a sin voltear");
	}
		else if(e.equals("Desabilitada")) {
			s = new Desabilitada();
			this.estado=s;
			System.out.println("cambiado el estado a desabilitada");
		}
}
}
