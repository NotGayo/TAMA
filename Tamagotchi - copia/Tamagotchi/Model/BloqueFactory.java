package Model;

import java.util.Random;

/**
 * Esta clase representa la fábrica de bloques.
 * Implementa BloqueFactoryInter para crear bloques.
 */

public class BloqueFactory implements BloqueFactoryInter {
	// Método para crear un nuevo bloque con una dureza aleatoria entre 1 y 3
	@Override
    public Bloque crearBloque() {
		Random random = new Random();
		int dureza = random.nextInt(3) + 1; // Dureza aleatoria entre 1 y 3
		return new Bloque(dureza); // Devuelve un nuevo bloque con la dureza aleatoria
	}
}

