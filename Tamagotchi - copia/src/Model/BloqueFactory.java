package Model;

public class BloqueFactory {
	
	private static BloqueFactory mBloqueFactory = new BloqueFactory();
	
	private BloqueFactory() {
		
	}
	public static BloqueFactory getBloqueFactory() {
		return mBloqueFactory;
	}
	
	public Bloque crearBloque(int pDureza) {
		if(pDureza == 1) {
			return new Bloque(pDureza);
		}
		else if(pDureza == 2) {
			return new Bloque(pDureza);
		}
		else if(pDureza == 3) {
			return new Bloque(pDureza);
		}
		
		return null;
	}
}
