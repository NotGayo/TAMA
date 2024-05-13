package View;

import java.awt.EventQueue;

import java.lang.Thread;
import java.math.BigInteger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.util.concurrent.TimeUnit;

import Model.Carta;
import Model.Tablero;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Panel;
import java.awt.Button;
import java.awt.*;

public class MiniVista implements Observer {

	private JFrame frame;
    private JButton[][] botones;
    private Carta[][] cartas;
    private Controler controler;
    private JLabel tiempo;
    private ImageIcon a;
    private ImageIcon b;
    private ImageIcon c;
    private ImageIcon d;
    private ImageIcon e;
    private ImageIcon f;
    private ImageIcon image;
    private int numSeleccion =0;
    private int[] posCarta =new int[2];
    private boolean drawed = false;
    private Timer timer = null;
    
	/**
	 * Launch the application.
	 */
    
    	public void run() {
    		try {
    			MiniVista window = new MiniVista();
    			window.frame.setVisible(true);
    			} 
    		catch (Exception e) {
    				e.printStackTrace();
    			}
    		}
    		


	/**
	 * Create the application.
	 */
	public MiniVista() {
		initialize();
		
		
		a = new ImageIcon(getClass().getResource("/sprites/cartaA.png"));
		b = new ImageIcon(getClass().getResource("/sprites/cartaB.png"));
		c = new ImageIcon(getClass().getResource("/sprites/cartaC.png"));
		d = new ImageIcon(getClass().getResource("/sprites/cartaD.png"));
		e = new ImageIcon(getClass().getResource("/sprites/cartaE.png"));
		f = new ImageIcon(getClass().getResource("/sprites/cartaF.png"));
		JPanel panelTablero = new JPanel(new GridLayout(2,6));
		 image = new ImageIcon(getClass().getResource("/sprites/carta.png"));
		
        botones = new JButton[2][6];
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                JButton boton = new JButton(image);
                boton.setBackground(Color.BLACK);
                boton.setPreferredSize(new Dimension(60,80 ));
                boton.setName(i +"-"+j);
                boton.addActionListener(getControler());
                botones[i][j] = boton;
                panelTablero.add(boton);
                
            }
        }
        frame.add(panelTablero, BorderLayout.CENTER);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBounds(100, 100, 450, 40);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("ADIVINA LAS PAREJAS");
		panel.add(lblNewLabel);
		
		this.tiempo = new JLabel("Tiempo restante:       ");
		panel.add(tiempo);
		Tablero.getTablero().addObserver(this);
		
	}
	
	
	private void interpretarCarta(JButton pBoton, int pId) {
		if(pId==0) {
			pBoton.setIcon(a);
	   	}
	   	else if(pId==1) {
	   		pBoton.setIcon(b);
	   	}
	   	else if(pId==2) {
	   		pBoton.setIcon(c);
	   	}
	   	else if(pId==3) {
	   		pBoton.setIcon(d);
	   	}
	   	else if(pId==4) {
	   		pBoton.setIcon(e);
	   	}
	   	else if(pId==5) {
	   		pBoton.setIcon(f);
	   	}
		drawed = true;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (o instanceof Tablero) 
		{
			if(arg instanceof String[]) 
			{
				String[] ak= (String[])arg;
				
				if(ak[0].equals("fin")) 
				{
					frame.dispose();
				}
				
				else if(ak[0].equals("seconds")) 
				{
					tiempo.setText("Tiempo restante:    "+ak[1]+" ");
				}
				
			}
			else if(arg instanceof int[]) {
				int[] arr= (int[])arg;
				if(arr[0]==111) 
				{
					int fil = arr[1];
					int col = arr[2];
					interpretarCarta(botones[fil][col], arr[3]);
				}
				
				
				
				else if(arr[0]==222) 
				{
					int fil=	arr[1];
					int col = arr[2];
					int fil2=	arr[3];
					int col2 = arr[4];
					
					ActionListener listener = new ActionListener(){
					public void actionPerformed(ActionEvent event)
					{
						    //darvuelta
						System.out.println("changing...");
						botones[fil][col].setIcon(image);
						botones[fil2][col2].setIcon(image);
							
					}
					};

					timer = new Timer(770, listener);
					
					timer.setRepeats(false);

					timer.start();
					
					
					//timer
					
					
					   
				}
				else if(arr[0]==333) 
				{
					int fil=	arr[1];
					int col = arr[2];
					int fil2=	arr[3];
					int col2 = arr[4];
					botones[fil][col].removeActionListener(getControler());
					botones[fil2][col2].removeActionListener(getControler());
				}
			}
		}
	}
	private Controler getControler() {
        if (controler == null) {
            controler = new Controler();
        }
        return controler;
    }
	
	
	
	
	private class Controler implements WindowListener, MouseListener, ActionListener {

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void actionPerformed(ActionEvent e) 
		{
		Tablero.getTablero().actionPerf(Integer.parseInt(e.getSource().toString().charAt(20)+""), Integer.parseInt(e.getSource().toString().charAt(22)+""));
		}

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
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		
	}
}
