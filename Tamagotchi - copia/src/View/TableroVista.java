package View;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import javax.swing.border.Border;

import Model.Bloque;
import Model.TableroModelo;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * Esta clase representa la vista del tablero del juego.
 * Extiende JFrame e implementa Observer para actualizar la vista cuando el modelo cambia.
 */
public class TableroVista extends JFrame implements Observer {
	private JPanel panelTablero; // Panel que contiene los botones del tablero
    private JLabel puntuacionLabel; // Etiqueta para mostrar la puntuaci�n
    private JLabel mensajeLabel; // Etiqueta para mostrar mensajes al usuario
    private keyController keController = null; // Controlador para manejar eventos
    private int puntuacion; // Puntuaci�n actual del jugador
    private ImageIcon iconoPastelito; // Icono para representar el pastelito en los botones
    private ImageIcon iconoTamagotchi; // Icono para representar el Tamagotchi en los botones
    private mouseController mouController = null;



	// Constructor de la clase TableroVista
    public TableroVista(Bloque[][] bloques) {
		TableroModelo.getTableroModelo().addObserver(this);
        panelTablero = new JPanel(new GridLayout(bloques.length, bloques[0].length));
        puntuacionLabel = new JLabel("Puntuaci�n: 0");
        mensajeLabel = new JLabel("Oooh Still far away!");
        mensajeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Agregar componentes a la ventana
        add(puntuacionLabel, BorderLayout.NORTH);
        add(panelTablero, BorderLayout.CENTER);
        add(mensajeLabel, BorderLayout.SOUTH);

        // Inicializar la vista del tablero
        inicializarVista(bloques);
        
        // Configurar la ventana
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        // Cargar las im�genes una vez al inicio
        iconoPastelito = new ImageIcon(Juego.class.getResource("/sprites/Candy.png"));
        iconoTamagotchi = new ImageIcon(Juego.class.getResource("/sprites/MarutchiMini1.png"));;
           
        setFocusable(true); // Para asegurarse de que el JFrame pueda recibir eventos de teclado
        requestFocus(); // Solicitar el foco para que el JFrame pueda recibir eventos de teclado
    }
   
    // M�todo para inicializar la vista del tablero
    private void inicializarVista(Bloque[][] bloques) {
        // Asignar el manejador de eventos del mouse a cada bot�n del tablero
        for (int i = 0; i < bloques.length; i++) {
            for (int j = 0; j < bloques[0].length; j++) {
                Bloque bloque = bloques[i][j];
                JButton boton = crearBoton(bloque);
                boton.addMouseListener(getMController());
                boton.putClientProperty("bloque", bloque);               
                boton.addKeyListener(getKController());
                panelTablero.add(boton);
            }
        }
    }

    // M�todo para crear y configurar un bot�n con base en un bloque
    private JButton crearBoton(Bloque bloque) {
        JButton boton = new JButton();
        boton.setBackground(bloque.getColor());
        return boton;
    }

    // M�todo para manejar eventos de clic del raton
    private void manejarEventoRaton(JButton boton, Bloque bloque) {
        if (bloque.getDureza() > 0) {
            actualizarPuntuacion(bloque.getDureza());
            getKController().reducirDureza(bloque);
            boton.setBackground(bloque.getColor());
        }
    }

    // M�todo para actualizar la puntuaci�n
    public void actualizarPuntuacion(int puntos) {
        puntuacion += puntos;
        puntuacionLabel.setText("Puntuaci�n: " + puntuacion);
    }

    // M�todo para actualizar la imagen del bot�n seg�n el bloque asociado
	private void actualizaImagenBoton(JButton boton, Bloque bloque) {
		// TODO Auto-generated method stub
		// Actualizar la imagen del bot�n
		  if (bloque.contieneTamagotchi()) {
		    boton.setIcon(iconoTamagotchi);
		  } else {
		    boton.setIcon(null); // Eliminar el icono si no hay Tamagotchi
		  }
		  if (bloque.contienePastelito()) {
		    boton.setIcon(iconoPastelito);
		  } 
		  if (bloque.contienePastelito() && bloque.contieneTamagotchi()) {
		    boton.setIcon(iconoTamagotchi);
		  }
		
	}
	
    // M�todo update de la interfaz Observer, se llama cuando el modelo del tablero cambia
	@Override
    public void update(Observable o, Object arg) {
		if(o instanceof TableroModelo && arg instanceof String[]) {
			System.out.println("entra ");
				String[] StringArray = (String[]) arg;
				//SI LA VIDA ES 0  Y RECIBE LA SEAL DE MUERTE
				if (StringArray[0].equals("fin")) {
					dispose();
					this.setVisible(false);
					this.dispose();
				}   
	        }
        if (o instanceof TableroModelo) {
        	
            TableroModelo modelo = (TableroModelo) o;
            Bloque[][] bloques = modelo.getBloques();
            for (int i = 0; i < bloques.length; i++) {
                for (int j = 0; j < bloques[0].length; j++) {
                    JButton boton = (JButton) panelTablero.getComponent(i * bloques[0].length + j);
                    Bloque bloque = bloques[i][j];
                    if (!boton.getBackground().equals(bloque.getColor())) {
                        boton.setBackground(bloque.getColor());
                    }
                    actualizaImagenBoton(boton, bloque);                    
                }
            }
            revalidate();
            repaint();
        }
        
	}
	// Clase interna para manejar eventos del raton en los botones del tablero
	private class mouseController implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			JButton boton = (JButton) e.getSource();
	        Bloque bloque = (Bloque) boton.getClientProperty("bloque");
	        manejarEventoRaton(boton, bloque);
	        TableroModelo.getTableroModelo().acabarPartida();
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub		
		}	
	}
    
	
	public mouseController getMController() {
		if (mouController == null) {
			mouController = new mouseController();
		}
		return mouController;
	}
	private class keyController implements KeyListener{
		
		 private TableroModelo tableroModelo = null; // Referencia al modelo del tablero

		 // Constructor de la clase Controlador
	     public keyController() {    
	    	 
	     }
	     
	     // M�todo para reducir la dureza de un bloque en el modelo del tablero
	     public void reducirDureza(Bloque bloque) {
	    	 TableroModelo.getTableroModelo().reducirDureza(bloque);
	     }
	     
	     // M�todo para establecer el modelo del tablero en el controlador
	     private void setModeloTablero(){
	    	 this.tableroModelo = TableroModelo.getTableroModelo();
	     }
	     
	     // M�todo para manejar eventos de teclado
	     @Override
	     public void keyPressed(KeyEvent e) {
	    	 switch (e.getKeyCode()) {
	         	case KeyEvent.VK_UP:
	         		TableroModelo.getTableroModelo().moverTamagotchi(-1, 0);
	         		TableroModelo.getTableroModelo().acabarPartida();
	                break;
	            case KeyEvent.VK_DOWN:
	            	TableroModelo.getTableroModelo().moverTamagotchi(1, 0);
	            	TableroModelo.getTableroModelo().acabarPartida();
	                break;
	            case KeyEvent.VK_LEFT:
	            	TableroModelo.getTableroModelo().moverTamagotchi(0, -1);
	            	TableroModelo.getTableroModelo().acabarPartida();
	                break;
	            case KeyEvent.VK_RIGHT:
	            	TableroModelo.getTableroModelo().moverTamagotchi(0, 1);
	            	TableroModelo.getTableroModelo().acabarPartida();
	                break;
	        }
	    }
	 
	     @Override
	     public void keyTyped(KeyEvent e) {
	    	 // TODO Auto-generated method stub
		 }

	     @Override
	     public void keyReleased(KeyEvent e) {
	    	 // TODO Auto-generated method stub
		 }

	}
	public keyController getKController() {
		if (keController == null) {
			keController = new keyController();
		}
		return keController;
	}
}
