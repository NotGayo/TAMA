package Model;
import java.util.Random;
public class Bloque {
    private int dureza;
    private boolean tarta = false;
    private boolean jugador = false;

    public Bloque(int pDureza) {
        int numAleatorio = new Random().nextInt()*3;
        if(numAleatorio==1){
            this.dureza = 1;
        }
        else if(numAleatorio==2){
            this.dureza = 2;
        }
        else if(numAleatorio==3){
            this.dureza = 3;
        }
    }

    public void setJugador() {
        this.jugador = true;
    }
    public void setTarta(){
        this.tarta = true;
    }

    public void reducirDureza(){
        this.dureza--;
    }
    public int getDureza(){
        return this.dureza;
    }
}
