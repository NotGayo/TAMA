package Model.TamaDigOut.FactoryBloque;

import Model.TamaDigOut.Bloque;

public class BloqueFactory {
	
	private static BloqueFactory mBloqueFactory = new BloqueFactory();
	
	private BloqueFactory() {
		
	}
	public static BloqueFactory getBloqueFactory() {
		return mBloqueFactory;
	}
	
	public Bloque crearBloque(int pDureza) {
		if(pDureza == 1) {
			return new BloqueBlando();
		}
		else if(pDureza == 2) {
			return new BloqueMedio();
		}
		else if(pDureza == 3) {
			return new BloqueDuro();
		}
		
		return null;
	}
}
