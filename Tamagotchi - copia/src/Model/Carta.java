package Model;

public class Carta {
	
	private int id;
	private boolean vuelta;
	
	public Carta(int pid) {
		this.id=pid;
		this.vuelta=false;
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
	
	
}
