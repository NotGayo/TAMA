package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class TamaDigOut extends JFrame implements ActionListener, KeyListener {

  private final int TAMANO_TABLERO_FILAS = 8; // define el tamaño del tablero (10x10)
  private final int TAMANO_TABLERO_COLUMNAS = 12;
  private final int DURACION_JUEGO = 20; // tiempo restante en segundos

  private JButton[][] botones; // matriz para almacenar los botones del tablero
  private JLabel puntuacionValor;
  private JLabel tiempoValor;
  private JLabel mensajes;
  private Timer timer;
  private int puntuacion;
  private int tiempoRestante;
  private Random random;
  private int posicionXTamagotchi;
  private int posicionYTamagotchi;
  private int posicionXPastelillo;
  private int posicionYPastelillo;
  
  public static void main(String[] args) {
	  SwingUtilities.invokeLater(() -> new TamaDigOut());
	}

  public TamaDigOut() {
    super("TamaDigOut");
    getContentPane().setBackground(Color.WHITE);
    getContentPane().setLayout(new BorderLayout());

    // inicializar componentes
    botones = new JButton[TAMANO_TABLERO_FILAS][TAMANO_TABLERO_COLUMNAS];
    puntuacionValor = new JLabel("0");
    tiempoValor = new JLabel("" + DURACION_JUEGO);
    mensajes = new JLabel();
    timer = new Timer(1000, this); // temporizador con intervalo de 1 segundo
    random = new Random();
    puntuacion = 0;
    tiempoRestante = DURACION_JUEGO;

    // crear tablero
    JPanel tablero = crearTablero();
    getContentPane().add(tablero, BorderLayout.CENTER);

    // panel inferior con puntuacion y tiempo
    JPanel panelSuperior = new JPanel(); 
    panelSuperior.setForeground(Color.WHITE);
    panelSuperior.setBackground(getBackground());
    panelSuperior.add(new JLabel("Mimitchi: "));
    panelSuperior.add(puntuacionValor);
    panelSuperior.add(Box.createHorizontalStrut(20));
    panelSuperior.add(new JLabel("Tiempo restante: "));
    panelSuperior.add(tiempoValor);
    getContentPane().add(panelSuperior, BorderLayout.SOUTH);

    // panel superior con mensajes
    getContentPane().add(mensajes, BorderLayout.NORTH);

    // configurar ventana
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);

    // iniciar juego
    iniciarJuego();
  }

  private JPanel crearTablero() {
	  JPanel tablero = new JPanel(new GridLayout(TAMANO_TABLERO_FILAS, TAMANO_TABLERO_COLUMNAS));
	  tablero.setForeground(Color.WHITE);
	  tablero.setBackground(Color.WHITE);
	  for (int i = 0; i < TAMANO_TABLERO_FILAS; i++) {
	    for (int j = 0; j < TAMANO_TABLERO_COLUMNAS; j++) {
	      JButton boton = new JButton();
	      boton.addActionListener(this);
	      botones[i][j] = boton;
	      
	      // Asignar color aleatorio al botón
	      int color = random.nextInt(3);
	      switch (color) {
	        case 0:
	          boton.setBackground(new Color(204,0,0));
	          break;
	        case 1:
	          boton.setBackground(new Color(153,0,0));
	          break;
	        case 2:
	          boton.setBackground(new Color(255,51,51));
	          break;
	      }
	      
	      tablero.add(boton);
	    }
	  }
	  return tablero;
	}

  private void iniciarJuego() {
    //colocarTamagotchi y Pastelillo();
    actualizarTablero();
    timer.start();
  }

  private void colocarTamagotchiYPastelillo() {
	  do {
	    posicionXTamagotchi = random.nextInt(TAMANO_TABLERO_COLUMNAS); // Cambia TAMANO_TABLERO por TAMANO_TABLERO_COLUMNAS
	    posicionYTamagotchi = random.nextInt(TAMANO_TABLERO_FILAS); // Cambia TAMANO_TABLERO por TAMANO_TABLERO_FILAS
	    posicionXPastelillo = random.nextInt(TAMANO_TABLERO_COLUMNAS); // Cambia TAMANO_TABLERO por TAMANO_TABLERO_COLUMNAS
	    posicionYPastelillo = random.nextInt(TAMANO_TABLERO_FILAS); // Cambia TAMANO_TABLERO por TAMANO_TABLERO_FILAS
	  } while (posicionXTamagotchi == posicionXPastelillo && posicionYTamagotchi == posicionYPastelillo);
	}


  private void actualizarTablero() {
    for (int i = 0; i < TAMANO_TABLERO_FILAS; i++) {
      for (int j = 0; j < TAMANO_TABLERO_COLUMNAS; j++) {
        JButton boton = botones[i][j];
        int dureza = random.nextInt(3) + 1; // genera dureza aleatoria entre 1 y 3
        //boton.setText("" + dureza);
        boton.setEnabled(true);
      }
    }
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() instanceof Timer) {
      tiempoRestante--;
      tiempoValor.setText("" + tiempoRestante);
      if (tiempoRestante == 0) {
        finDelJuego(false);
      }
    } else {
      JButton boton = (JButton) e.getSource(); // Cast the source to a JButton
      int fila = buscarFila(boton);
      int columna = buscarColumna(boton);

      // Comprobar si se encontró a Tamagotchi o al pastelillo
      if (fila == posicionXTamagotchi && columna == posicionYTamagotchi) {
        mensajes.setText("¡Encontraste a Mimitchi!");
      } else if (fila == posicionXPastelillo && columna == posicionYPastelillo) {
        mensajes.setText("¡Encontraste el pastelito!");
        // Deshabilitar el botón del pastelito para evitar clicks repetidos
        boton.setEnabled(false);
      } else {
        // Obtener la dureza del bloque y actualizar la puntuación
        int dureza = Integer.parseInt(boton.getText());
        puntuacion += dureza;
        puntuacionValor.setText("" + puntuacion);
        boton.setText(""); // Limpiar el texto del botón una vez golpeado
        
        // Comprobar si se rompió el bloque por completo
        if (dureza == 1) {
          boton.setEnabled(false); // Deshabilitar el botón si la dureza era 1
        } else {
          dureza--;  // Reducir la dureza del bloque en 1
          boton.setText("" + dureza);
        }
      }
    }
  }

@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

private int buscarFila(JButton boton) {
	  for (int i = 0; i < TAMANO_TABLERO_FILAS; i++) {
	    for (int j = 0; j < TAMANO_TABLERO_COLUMNAS; j++) {
	      if (botones[i][j] == boton) {
	        return i;
	      }
	    }
	  }
	  return -1; // No se encontró el botón
	}

	private int buscarColumna(JButton boton) {
	  for (int i = 0; i < TAMANO_TABLERO_FILAS; i++) {
	    for (int j = 0; j < TAMANO_TABLERO_COLUMNAS; j++) {
	      if (botones[i][j] == boton) {
	        return j;
	      }
	    }
	  }
	  return -1; // No se encontró el botón
	}
	
	private void finDelJuego(boolean victoria) {
		  timer.stop(); // Detener el temporizador

		  // Mostrar mensaje de fin de juego
		  String mensaje;
		  if (victoria) {
		    mensaje = "¡Enhorabuena! Encontraste a Mimitchi y el pastelito.";
		    puntuacion += 20; // Bonificación por completar el juego
		  } else {
		    mensaje = "Se acabó el tiempo. ¡Inténtalo de nuevo!";
		    puntuacion -= 20; // Penalización por no completar el juego (opcional)
		  }
		  mensajes.setText(mensaje);
		  puntuacionValor.setText("" + puntuacion);

		  // Deshabilitar todos los botones para evitar interacción
		  for (int i = 0; i < TAMANO_TABLERO_FILAS; i++) {
		    for (int j = 0; j < TAMANO_TABLERO_COLUMNAS; j++) {
		      botones[i][j].setEnabled(false);
		    }
		  }

		  // Opcional: permitir reiniciar el juego
		  // Puedes agregar un botón u otra opción para reiniciar el juego desde aquí.
		}
}



	








