package Model;

public class Carta {
	
	private int id;
	private boolean vuelta;
	private CartaState estado;
	
	public Carta(int pid,CartaState c) {
		this.id=pid;
		this.vuelta=false;
		this.estado=c;
	}
	
	public int  getId() {
		return this.id;
	}
	
	public boolean estaVolteada() {
		return this.vuelta;
	}
	
	public void darVuelta() {
		this.vuelta = !this.vuelta;
	}
	
	public void cambiarEstado(String e) {
		CartaState s = null;
		if(e.equals("Volteada")) {
			s = new Volteada();
			this.estado=s;
			system.out.println("cambiado el estado a volteada")
		}
		else if (e.equals("SinVoltear")){
			s = new SinVoltear();
			this.estado=s;
			system.out.println("cambiado el estado a sin voltear")
	}
		else if(e.equals("Desabilitada")) {
			s = new Desabilitada();
			this.estado=s;
			system.out.println("cambiado el estado a desabilitada")
		}
}
}
