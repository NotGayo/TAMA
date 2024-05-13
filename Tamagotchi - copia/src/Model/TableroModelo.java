package Model;

import java.util.Observable;
import java.util.Random;

import View.TableroVista;

public class TableroModelo extends Observable{

    private static TableroModelo mTableroModelo = new TableroModelo();
    private Bloque[][] tablero;
    int[][] numTablero = new int[8][12];
    private Random rand = new Random();
    private int[] posJugador = new int[2];
    private int[] posTarta = new int[2];
    boolean pDone = false;
	boolean tDone = false;
	

    private TableroModelo(){
        tablero = new Bloque[8][12];
        crearTablero();
        setJugador();
        inicializarTarta();
        System.out.println("PLAYER: "+posJugador[0]+"-"+posJugador[1]);
        System.out.println("TARTA :"+ posTarta[0]+"-"+posTarta[1]);
        
    }

    public static TableroModelo getTableroModelo(){
        return mTableroModelo;
    }

    public void startDigOut(){
    	TableroVista tv = new TableroVista();
    	tv.run();
    	setChanged();
    	posJugador = new int[2];
    	posTarta = new int[2];
    	pDone = false;
    	tDone = false;
    	notifyObservers(new String[] { "1111" });
    	System.out.println("TABLEROMODELO -> TABLEROVISTA");
    	tablero = new Bloque[8][12];
        crearTablero();
        setJugador();
        inicializarTarta();
    }
    
    private int[][] crearTablero(){
    	int randDureza = rand.nextInt(3)+1;
    	for(int i = 0; i < 8; i++) {
    		for(int j = 0; j < 12;j++) {
    			randDureza = rand.nextInt(3)+1;
    			tablero[i][j] = BloqueFactory.getBloqueFactory().crearBloque(randDureza);
    			numTablero[i][j] = randDureza;
    			//System.out.println("POS: "+i+","+j+","+randDureza);
    			
    		}
    	}
    	return numTablero;
    	//System.out.println(tablero.length+" ---- "+ tablero[0].length);
    }
    
    public void actualizarVista() {
    	int randDureza;
    	int player = 0;
    	for(int i = 0; i < 8; i++) {
    		for(int j = 0; j < 12;j++) {
    			randDureza = numTablero[i][j];
    			player = 0;
    			if(randDureza == 0 && posJugador[0] == i && posJugador[1] == j) {
    				player = 1;
    			}
    			if(randDureza == 0 && posTarta[0] == i && posTarta[1] == j) {
    				player = 1;
    			}
    			setChanged();
    			notifyObservers(  new int[] {i,j, randDureza, player, 4242} );
    			//System.out.println("POS: "+i+","+j+","+randDureza);
    		}
    	}
    }
    
    public void actualizarJugador() {
    	setChanged();
    	if(numTablero[posJugador[0]][posJugador[1]] == 0 && !pDone) {
    		pDone = true;
    		notifyObservers(new int[] { posJugador[0],posJugador[1],2323 });
    	}

    }
    
    public void actualizarTarta() {
    	setChanged();
    	if(numTablero[posTarta[0]][posTarta[1]] == 0 && !tDone) {
    		tDone = true;
    		notifyObservers(new int[] { posTarta[0],posTarta[1],3232 });
    	}
    }
    
    public void reducirDureza(String pPos) 
    {
    	String posX = null;
    	String posY = null;
    	
    	if(pPos.length() == 3) {
    		String[] pos = pPos.split("");
    		posX = pos[0];
    		posY = pos[2];
    		
    	}
    	else if(pPos.length() == 4) {
    		String[] pos = pPos.split("");
    		posX = pos[0];
    		posY = pos[2]+pos[3];
    	}
    	int realPosX = Integer.parseInt(posX);
    	int realPosY = Integer.parseInt(posY);
    	numTablero[realPosX][realPosY] -= 1;

    }
   
    
    public void moverJugador(String pDireccion) {
    	if(pDireccion.equals("UP")) {
    		if(posJugador[0] != 0) {
    			posJugador[0] -= 1;
    		}
    	}
    	else if(pDireccion.equals("DOWN")) {
    		if(posJugador[0] != 7) {
    			posJugador[0] += 1;
    		}
    	}
    	else if(pDireccion.equals("LEFT")) {
    		if(posJugador[1] != 0) {
    			posJugador[1] -= 1;
    		}
    	}
    	else if(pDireccion.equals("RIGHT")) {
    		if(posJugador[1] != 11) {
    			posJugador[1] += 1;
    		}
    	}
    	
    	System.out.println("PLAYER: "+posJugador[0]+"-"+posJugador[1]);
    }
    
    public void setPlayerDone(boolean state) {
    	pDone = state;
    }
    
    private void setJugador(){
    	
    	int posX = rand.nextInt(8);
    	int posY = rand.nextInt(12);
    	posJugador[0] = posX;
    	posJugador[1] = posY;
    	
    }
    private void inicializarTarta(){
    	
    	int posX = rand.nextInt(8);
    	int posY = rand.nextInt(12);
    	while(posX == posJugador[0] && posY == posJugador[1]) {
    		posX = rand.nextInt(8);
    		posY = rand.nextInt(12);
    	}
    	posTarta[0] = posX;
    	posTarta[1] = posY;
    }
    
    public void comprobarFin(){
    	setChanged();
        if(posJugador[0] == posTarta[0] && posJugador[1] == posTarta[1]) {
        	notifyObservers(new int[] { 9999 });
        	System.out.println("end");
        	Tamagochi.getTamagochi().exitWait();
        	Tamagochi.getTamagochi().addPoints(200);
        }
        else if(numTablero[posJugador[0]][posJugador[1]] > 0) {
        	notifyObservers(new int[] { 9999 });
        	System.out.println("end");
        	Tamagochi.getTamagochi().exitWait();
        	Tamagochi.getTamagochi().addPoints(-100);
        }
    }
    
}
