package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Observable;
import java.util.Observer;

public class TableroVista extends JFrame implements Observer{
	
	private JPanel tableroVista;
	private Controler controler = null;
	private KeyController KCont = null;
	private JButton[][] botones = new JButton[8][12];
	private JButton prevPlayer = null;

	/**
	 * Launch the application.
	 */
	
			public void run() {
				try {
					TableroVista frame = new TableroVista();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
	/**
	 * Create the frame.
	 */
	public TableroVista() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		tableroVista = new JPanel();
		tableroVista.setBorder(new EmptyBorder(5, 5, 5, 5));
		tableroVista.setBackground(Color.LIGHT_GRAY);
		setContentPane(tableroVista);
		tableroVista.setLayout(new GridLayout(8, 12, 1, 1));
		TableroModelo.getTableroModelo().addObserver(this);
		addWindowListener(getControler());
		crearBotones();
	}
	private void crearBotones() {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 12; j++) {
				JButton a = new JButton("");
				a.setName(i+"-"+j);
				a.addMouseListener(getControler());
				a.addActionListener(getControler());
				tableroVista.add(a);
				botones[i][j] = a;
			}
		}
	}
	private void cambiarColorPosBoton(int pPosX,int pPosY, int pDureza, int pPlayer) {
		
		JButton act = botones[pPosX][pPosY];
		if(pDureza == 3) 
		{
			act.setBackground(Color.RED);
		}
		else if (pDureza == 2) {
			act.setBackground(Color.ORANGE);
		}
		else if(pDureza == 1) {
			 act.setBackground(Color.YELLOW);
		}
		else if(pDureza == 0 && pPlayer == 0) {
			act.setVisible(false);
		}
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		
		if(arg0 instanceof TableroModelo ) 
		{
			
			if( arg1 instanceof String[]) {
				String[] arr = (String[]) arg1;
				if(arr[0].equals("1111")) {
						System.out.println("Empieza el tablero pt2");
				
				}
			}
				
			else if(arg1 instanceof int[]) 
			{
					int[] durezaArray = (int[]) arg1;
					
					if(durezaArray.length == 1) 
					{		
						if(durezaArray[0] == 9999) 
						{
							dispose();					
						}
					}
				

					else if(durezaArray.length == 3) 
					{
						if(durezaArray[2] == 2323) 
						{
							if (prevPlayer != null) 
							{
								prevPlayer.setVisible(false);
							}
							botones[durezaArray[0]][durezaArray[1]].setVisible(true);
							botones[durezaArray[0]][durezaArray[1]].addKeyListener(getKController());
							botones[durezaArray[0]][durezaArray[1]].setBackground(Color.LIGHT_GRAY);
							botones[durezaArray[0]][durezaArray[1]].setIcon(new ImageIcon(TableroVista.class.getResource("/sprites/MarutchiMini1.png")));
							botones[durezaArray[0]][durezaArray[1]].setBorderPainted(false);
							System.out.println("ok JUGU");
							botones[durezaArray[0]][durezaArray[1]].grabFocus();
							prevPlayer = botones[durezaArray[0]][durezaArray[1]];		
						}
						
						
						else if(durezaArray[2] == 3232) 
						{
							botones[durezaArray[0]][durezaArray[1]].setVisible(true);
							botones[durezaArray[0]][durezaArray[1]].setBackground(Color.LIGHT_GRAY);
							botones[durezaArray[0]][durezaArray[1]].setIcon(new ImageIcon(TableroVista.class.getResource("/sprites/hungry.png")));
							botones[durezaArray[0]][durezaArray[1]].setBorderPainted(false);
							System.out.println("ok TART");
						}
					}
					else 
					{
							cambiarColorPosBoton(durezaArray[0], durezaArray[1], durezaArray[2], durezaArray[3]);	
					}
				
			}
		}
	}
	
	private void setVisibleTDO() {
		this.setVisible(true);
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
			TableroModelo.getTableroModelo().actualizarVista();
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
		////////////////MOUSE//////////////////////
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
			TableroModelo.getTableroModelo().reducirDureza(e.getComponent().getName());
			//todo en reducir dureza 
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private KeyController getKController() {
		if (KCont == null) {
			KCont = new KeyController();
		}
		return KCont;
	}
	
	private class KeyController implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			switch (e.getKeyCode()) {
		        	case KeyEvent.VK_UP:
		         		//MOVER ARRIBA
		        		TableroModelo.getTableroModelo().mover("UP");
		        		break;
		            case KeyEvent.VK_DOWN:
		            	//MOVER ABAJO
		        		TableroModelo.getTableroModelo().mover("DOWN");
		                break;
		            case KeyEvent.VK_LEFT:
		            	//MOVER IZQ
		        		TableroModelo.getTableroModelo().mover("LEFT");
		                break;
		            case KeyEvent.VK_RIGHT:
		            	//MOVER DER
		            	TableroModelo.getTableroModelo().mover("RIGHT");
		                break;
		        }
		    
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
