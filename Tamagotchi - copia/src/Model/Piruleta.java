package Model;

public class Piruleta implements Comible {

	private String nombre = "Piruleta";
	private int piruletas = 0;
	@Override
	public int getValorComida() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getValorVida() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public void consumirElementos() {
		// TODO Auto-generated method stub
		this.piruletas += 10;
	}
	
	public String getNombre() {
		return this.nombre;
	}

}
