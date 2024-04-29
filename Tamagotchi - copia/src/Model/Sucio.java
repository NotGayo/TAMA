package Model;

public class Sucio implements SaludState {

	@Override
	public int getDecrementoVida() {
		// TODO Auto-generated method stub
		return -5;
	}

	@Override
	public int getDecrementoComida() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public int getAumentoPuntuacion() {
		// TODO Auto-generated method stub
		return -5;
	}

	@Override
	public String getNombreEvo() {
		// TODO Auto-generated method stub
		return "Sucio";
	}

}
