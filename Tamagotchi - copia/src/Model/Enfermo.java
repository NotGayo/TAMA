package Model;

public class Enfermo implements SaludState{

	@Override
	public int getDecrementoVida() {
		// TODO Auto-generated method stub
		return -7;
	}

	@Override
	public int getDecrementoComida() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int getAumentoPuntuacion() {
		// TODO Auto-generated method stub
		return -5;
	}

	@Override
	public String getNombreEvo() {
		// TODO Auto-generated method stub
		return "Enfermo";
	}

}
