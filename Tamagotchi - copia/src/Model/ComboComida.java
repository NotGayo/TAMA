package Model;

import java.util.ArrayList;
import java.util.Iterator;

public class ComboComida implements Comible {
	
	private ArrayList<Comible> combo = new ArrayList<Comible>();
	private int cucharadas = 0;
	private int piruletas = 0;
	
	public void addComible(Comible pComida) {
		combo.add(pComida);
		System.out.println("add");
	}
	
	public void deleteComible(Comible pComida) {
		combo.remove(pComida);
	}
	
	@Override
	public int getValorComida() {
		// TODO Auto-generated method stub
		return piruletas;
	}

	@Override
	public int getValorVida() {
		// TODO Auto-generated method stub
		return cucharadas;
	}

	@Override
	public void consumirElementos() {
		// TODO Auto-generated method stub
		Iterator<Comible> it = combo.iterator();
		System.out.println(combo.size());
		Comible s = null;
		while(it.hasNext()) {
			s = it.next();
			if(s.getNombre().equals("Piruleta")) {
				s.consumirElementos();
				piruletas += s.getValorVida();
				System.out.println("comer piruleta");
				
			}
			else if(s.getNombre().equals("Cucharada")) {
				s.consumirElementos();
				cucharadas += s.getValorComida();
				System.out.println("comer cuchara");
				
			}
		}
		combo = new ArrayList<Comible>();
		
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}
}
