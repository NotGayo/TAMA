package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import View.MiniVista;
import java.lang.Thread;



public class Tablero extends Observable {
	
	private Carta[][] cartas;
	private int parejas;
	private int parejasEncontradas;
	private static Tablero miTablero = new Tablero();
	private Timer timer = null;
	private int seconds = 0;
	private int[] posCarta =new int[2];
	private int numSeleccion = 0;
	
	private Tablero() {
		this.cartas= new Carta[2][6];
		this.parejas=6;
		this.parejasEncontradas=0;
		
		CartaState estad= new SinVoltear();
		ArrayList<Carta>c = new ArrayList<Carta>();
		for(int i=0;i<this.parejas;i++) {
			Carta k= new Carta(i,estad);
			c.add(k);
			c.add(k);
			
		}
		Collections.shuffle(c);
		int p =0;
		for (int i =0; i<2;i++) {
			for(int j=0; j<6;j++) {
				cartas[i][j]=c.get(p);
				p++;
			}
		}
		
	}
	
	public static Tablero getTablero() {
		return miTablero;
	}
	
	 public Carta[][] getCartas(){
		 return this.cartas;
	 }
	 public Carta getCarta(int fil, int col) {
		 return cartas[fil][col];
	 }
	
	
	public void seleccionarCarta(int fila,int col, int pOrder) {
		Carta c= cartas[fila][col];
		boolean estaVolteada = c.estaVolteada();
		if (!estaVolteada) {
			c.darVuelta();
			c.cambiarEstado("Volteada");
		}
		
		setChanged();	
		notifyObservers(new int[] {111,fila,col,c.getId(),pOrder });
		
	}
	
	public boolean comprobarPareja(int fila1,int col1,int fila2 ,int col2) {
		Carta c1= cartas[fila1][col1];
		Carta c2= cartas[fila2][col2];
		
		if(c1.getId()==c2.getId()) {
			this.parejasEncontradas++;
			c1.cambiarEstado("Desabilitada");
			c2.cambiarEstado("Desabilitada");
			setChanged();
			notifyObservers(new int[] {333,fila1,col1,fila2,col2});
			return true;
		}
		else {
			c1.darVuelta();
			c2.darVuelta();
			c1.cambiarEstado("SinVoltear");
			c2.cambiarEstado("SinVoltear");
			setChanged();
			notifyObservers(new int[] {222,fila1,col1,fila2,col2,c1.getId(),c2.getId()});
			return false;
		}
	}
	
	public void acabarPartida() {
		setChanged();
		if(this.parejasEncontradas==this.parejas) {
			System.out.println("Todas las aprejas encontradas");
			notifyObservers(new String[] {"fin"});
			Tamagochi.getTamagochi().exitWait();
			Tamagochi.getTamagochi().addPoints(parejasEncontradas*120);
		}		
	}
	
	public void empezar() {
		MiniVista v = new MiniVista();
		v.run();
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {
				//ESTE 'BUCLE' SE EJECUTA CADA SEGUNDO. 
				seconds++;
				setChanged();
				if(seconds != 10) 
				{
					notifyObservers(new String[] { "seconds",(20-seconds)+"" });
				}
				else if(seconds == 20) {
					notifyObservers(new String[] {"fin"});
					Tamagochi.getTamagochi().exitWait();
					Tamagochi.getTamagochi().addPoints(parejasEncontradas*100);
				}
			}
		};
		timer = new Timer();
		timer.scheduleAtFixedRate(timerTask, 0, 1000);
	}
	
	
	public void actionPerf(int pos1, int pos2) {
		
		if (numSeleccion==0) {
			
			
			Tablero.getTablero().seleccionarCarta(pos1, pos2, numSeleccion);
			posCarta[0]=pos1;
			posCarta[1]=pos2;
			numSeleccion++;
		}
			else {
				Tablero.getTablero().seleccionarCarta(pos1 , pos2,numSeleccion);
				Tablero.getTablero().comprobarPareja(posCarta[0], posCarta[1],pos1, pos2);
				Tablero.getTablero().acabarPartida();
				numSeleccion=0;
			}
		
	}
	
	
	
	
}
