package model;

public class Bloque {
	private int dureza;
	private boolean roto;
	private boolean contieneTamagochi;
	private boolean contienePastelito;
	
	public Bloque() {
		this.dureza=(int)(Math.random()*3)+1;
		this.roto=false;
		this.contieneTamagochi= false;
		this.contienePastelito=false;
	}
	public int getDureza() {
		return dureza;
	}
	public boolean estaRoto() {
		return roto;
	}

	public void romper() {
		if(!roto) {
			dureza=dureza-1;
			if(dureza==0) {
				roto=true;
				if(Math.random()<0.5) {
					contieneTamagochi=true;
				}
				else {
					contienePastelito=true;
				}
			}
		}
	}
	public boolean contieneTamagochi() {
		return contieneTamagochi;
	}
	public boolean contienePastelito() {
		return contienePastelito;
	}
}
