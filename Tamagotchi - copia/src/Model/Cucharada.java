package Model;

public class Cucharada implements Comible {

	private String nombre = "Cucharada";

	private int cucharadas = 0;
	
	@Override
	public int getValorComida() {
		// TODO Auto-generated method stub
		
		return 10;
	}

	@Override
	public int getValorVida() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void consumirElementos() {
		// TODO Auto-generated method stub
		this.cucharadas += 10;
	}
	public String getNombre() {
		return this.nombre;
	}
}
