package Model;

import java.util.Observable;
import java.util.Random;

import View.TableroVista;

import java.util.Observable;

import java.util.Observable;
import java.util.Random;

/**
 * Esta clase representa el modelo del tablero del juego.
 * Extiende Observable para notificar cambios a los observadores.
 */
public class TableroModelo extends Observable {
    private Bloque[][] bloques; // Matriz de bloques que representan el tablero del juego
    private static TableroModelo mTableroModelo = new TableroModelo();
    /**
     * Constructor de la clase TableroModelo.
     */
    private TableroModelo() {
        bloques = new Bloque[12][8];
        // Inicializa los bloques del tablero con durezas aleatorias
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 8; j++) {
                bloques[i][j] = new BloqueFactory().crearBloque();
            }
        }
    }
    public static TableroModelo getTableroModelo() {
    	return mTableroModelo;
    }
    /**
     * M�todo para obtener la matriz de bloques del tablero.
     * @return Matriz de bloques del tablero.
     */
    public Bloque[][] getBloques() {
        return bloques;
    }
    
    public void startDigOut() {
    	TableroVista tv = new TableroVista(getBloques());


    }
    
    // M�todo para mover el Tamagotchi en el tablero.
    public void moverTamagotchi(int diferenciaFila, int diferenciaColumna) {
        int[] posicionActual = obtenerPosicionTamagotchi();
        int nuevaFila = posicionActual[0] + diferenciaFila;
        int nuevaColumna = posicionActual[1] + diferenciaColumna;

        if (esPosicionValida(nuevaFila, nuevaColumna) && bloques[nuevaFila][nuevaColumna].getDureza() == 0) {
            bloques[posicionActual[0]][posicionActual[1]].setContieneTamagotchi(false);
            bloques[nuevaFila][nuevaColumna].setContieneTamagotchi(true);
            
            setChanged();
            notifyObservers();
        }
    }
    
    // M�todo para obtener la posici�n actual del Tamagotchi en el tablero.
    public int[] obtenerPosicionTamagotchi() {
        for (int i = 0; i < bloques.length; i++) {
            for (int j = 0; j < bloques[0].length; j++) {
                if (bloques[i][j].contieneTamagotchi()) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
    public int[] obtenerPosicionPastel() {
        for (int i = 0; i < bloques.length; i++) {
            for (int j = 0; j < bloques[0].length; j++) {
                if (bloques[i][j].contienePastelito()) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
    
    // M�todo para verificar si una posici�n en el tablero es v�lida.
    private boolean esPosicionValida(int fila, int columna) {
        return fila >= 0 && fila < bloques.length && columna >= 0 && columna < bloques[0].length && bloques[fila][columna].getDureza() == 0;
    }


    
    // M�todo para verificar si el Tamagotchi se ha colocado.
    private boolean seHaColocadoTamagotchi() {
        for (Bloque[] fila : bloques) {
            for (Bloque bloque : fila) {
                if (bloque.contieneTamagotchi()) {
                    return true;
                }
            }
        }
        return false;
    }

    // M�todo para verificar si el Pastelito se ha colocado.
    private boolean seHaColocadoPastelito() {
        for (Bloque[] fila : bloques) {
            for (Bloque bloque : fila) {
                if (bloque.contienePastelito()) {
                    return true;
                }
            }
        }
        return false;
    }

    // M�todo para colocar el Tamagotchi en el tablero.
    private void colocarTamagotchi(Bloque bloque) {
        bloque.setContieneTamagotchi(true);
        System.out.println("Se ha encontrado el Tamagotchi");
    }
    // M�todo para colocar el pastelito en el tablero.
    private void colocarPastelito(Bloque bloque) {
        bloque.setContienePastelito(true);
        System.out.println("Se ha encontrado el Pastelito");
    }

    public void reducirDureza(Bloque bloque) {
        // Reduce la dureza del bloque
        bloque.reducirDureza();
        // Verifica si se ha colocado un pastelito o un Tamagotchi
        boolean pastelitoColocado = seHaColocadoPastelito();
        boolean tamagotchiColocado = seHaColocadoTamagotchi();
        // Coloca un pastelito o un Tamagotchi si la dureza del bloque es 0 y a�n no se ha colocado ese elemento
        if (bloque.getDureza() == 0 && (!pastelitoColocado || !tamagotchiColocado)) {
            Random random = new Random();
            if (!pastelitoColocado && random.nextBoolean()) {
                colocarPastelito(bloque);
            } else if (!tamagotchiColocado) {
                colocarTamagotchi(bloque);
            }
        }
        // Notifica a los observadores del cambio en el tablero
        setChanged();
        notifyObservers();
    }
    
    public void acabarPartida() {
      setChanged();
        if (obtenerPosicionTamagotchi() != null && obtenerPosicionPastel() != null){

            int[] posicionTama = obtenerPosicionTamagotchi();
            int[] posicionPast = obtenerPosicionPastel();
            System.out.println("TAMA: "+ posicionTama[0] + " | " + posicionTama[1]);
            System.out.println("Pastel: "+ posicionPast[0] + " | " + posicionPast[1]);
            if (posicionTama[0] == posicionPast[0] && posicionTama[1] == posicionPast[1]) {
                System.out.println("correcto");
                notifyObservers(new String[]{"fin"});
                Tamagochi.getTamagochi().addPoints(20);

            }
        }
    	
    }
}














