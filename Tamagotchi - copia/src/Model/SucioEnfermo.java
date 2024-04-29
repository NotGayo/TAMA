package Model;

public class SucioEnfermo implements SaludState{

	@Override
	public int getDecrementoVida() {
		// TODO Auto-generated method stub
		return -12;
	}

	@Override
	public int getDecrementoComida() {
		// TODO Auto-generated method stub
		return 15;
	}

	@Override
	public String getNombreEvo() {
		// TODO Auto-generated method stub
		return "SucioEnfermo";
	}

	@Override
	public int getAumentoPuntuacion() {
		// TODO Auto-generated method stub
		return -5;
	}

}
