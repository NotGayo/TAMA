package Model;

import java.awt.Color;

/*
 * Clase que representa un bloque con una dureza y un color asociado
 * */

public class Bloque {
	private int dureza; // Almacena la dureza del bloque
	private Color color; // Almacena el color del bloque
	private boolean contienePastelito; // Indica si el bloque contiene un pastelito
	private boolean contieneTamagotchi; // Indica si el bloque contiene un Tamagotchi


	// Constructora que inicializa el bloque con una dureza dada
	public Bloque(int dureza) {
		this.dureza = dureza; // Asigna la dureza recibida
		setColor(); // Llama al método para determinar el color del bloque
		// Inicialmente no contiene ni pastelito ni Tamagotchi
		contienePastelito = false;
		contieneTamagotchi = false;
	}

	// Método para obtener la dureza del bloque
	public int getDureza() {
		return dureza; // Devuelve la dureza del bloque
	}

	// Método para obtener el color del bloque
	public Color getColor() {
		return color; // Devuelve el color del bloque
	}

	// Método para reducir la dureza del bloque
	public void reducirDureza() {
		if (dureza > 0) { // Verifica que la dureza sea mayor que 0
			dureza--; // Reduce la dureza del bloque
			setColor(); // Actualiza el color del bloque
		}
	}

	// Método privado para determinar el color del bloque basado en su dureza
	private void setColor() {
		switch (dureza) { // Determina el color del bloque según su dureza
	    case 3:
    	   color = new Color(164, 0, 0);
           break;
        case 2:
    	   color = new Color(100, 0, 0);
           break;
        case 1:
    	   color = new Color(70, 0, 0);
           break;
        default:
           color = Color.BLACK;
   }
}


	public boolean contienePastelito() {
		return contienePastelito;
	}

	public boolean contieneTamagotchi() {
		return contieneTamagotchi;
	}

	public void setContienePastelito(boolean contienePastelito) {
		this.contienePastelito = contienePastelito;
	}

	public void setContieneTamagotchi(boolean contieneTamagotchi) {
		this.contieneTamagotchi = contieneTamagotchi;
	}

}


