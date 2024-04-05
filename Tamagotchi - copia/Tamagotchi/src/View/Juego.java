package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Tamagochi;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Panel;
import java.awt.GridLayout;

public class Juego extends JFrame implements Observer {

	private JPanel contentPane;
	private JButton BtnRet;
	private Controler controler = null;
	JLabel comida = new JLabel("New label");
	JLabel vida = new JLabel("New label");
	JLabel personaje = new JLabel("New label");
	JLabel puntuacion = new JLabel("");
	JButton cucharada = new JButton("");
	JButton caramelo = new JButton("");
	JLabel comida_4 = new JLabel("New label");
	JLabel comida_3 = new JLabel("New label");
	JLabel comida_2 = new JLabel("New label");
	JLabel comida_1 = new JLabel("New label");
	JLabel corazon_4 = new JLabel("New label");
	JLabel corazon_3 = new JLabel("New label");
	JLabel corazon_2 = new JLabel("New label");
	JLabel corazon_1 = new JLabel("New label");

	/**
	 * Launch the application.
	 */

	public void run() {
		try {
			Juego frame = new Juego();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg0 instanceof Tamagochi) { // MIENTRAS QUE LA VIDA ES MAYOR QUE 0
			if (arg1 instanceof int[]) {
				int[] intArray = (int[]) arg1;
				vida.setText(intArray[0] + "");
				comida.setText(intArray[1] + "");
				puntuacion.setText("Puntuacion: " + intArray[2] + "");
				representarCorazones(intArray[0]/10);
				representarComida(intArray[1]/10);
				System.out.println("ok");
				
			}
		
			else if (arg1 instanceof String[]) {
				String[] StringArray = (String[]) arg1;
				//SI LA VIDA ES 0  Y RECIBE LA SEÑAL DE MUERTE
				if (StringArray[0] == "MUERTO") {
					deathScreen();
				}
				else if (StringArray[0] == "TamaDigOut") {
					//SALTAR A TAMA DIG OUT
					
				}
				else if (StringArray[0] == "kuchipatchi") {
					//CAMBIAR EVOLUCION DEL TAMAGOTCHI
					System.out.println("KUTCHIPACHI");
					personaje.setIcon(
							new ImageIcon(Juego.class.getResource("/sprites/Kuchipatchi1.png")));
				}	
			
				else if(StringArray[0] == "mimitchi") {
					System.out.println("KUTCHIPACH2EADSI");
					personaje.setIcon(
						new ImageIcon(Juego.class.getResource("/sprites/Mimitchi1.png")));
				}
				else if(StringArray[0] == "maskutchi") {
					System.out.println("KUTCHIPACHISSSSSSSSSSSSSS");
					personaje.setIcon(
						new ImageIcon(Juego.class.getResource("/sprites/Maskutchi1.png")));
			}
			}
		}

	}

	private void deathScreen() {

		contentPane.removeAll();
		contentPane.revalidate();
		setTitle("Partida de " + View.Inner.getTextF().getText());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 500, 400);
		contentPane.setBackground(Color.BLACK);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		JLabel DEATH_GIF = new JLabel("New label");
		DEATH_GIF.setBounds(212, 142, 51, 123);
		contentPane.add(DEATH_GIF);
		DEATH_GIF
				.setIcon(new ImageIcon(Juego.class.getResource("/sprites/death.gif")));
		contentPane.add(getBtnRet());
	}
	private void representarCorazones(int nCorazones) {
		if(nCorazones == 1) {
			corazon_1.setIcon(new ImageIcon(Juego.class.getResource("/sprites/heart.png")));
			corazon_2.setIcon(new ImageIcon(Juego.class.getResource("/sprites/emptyHeart.png")));
			corazon_3.setIcon(new ImageIcon(Juego.class.getResource("/sprites/emptyHeart.png")));
			corazon_4.setIcon(new ImageIcon(Juego.class.getResource("/sprites/emptyHeart.png")));
		}
		else if(nCorazones == 2) {
			corazon_1.setIcon(new ImageIcon(Juego.class.getResource("/sprites/heart.png")));
			corazon_2.setIcon(new ImageIcon(Juego.class.getResource("/sprites/heart.png")));
			corazon_3.setIcon(new ImageIcon(Juego.class.getResource("/sprites/emptyHeart.png")));
			corazon_4.setIcon(new ImageIcon(Juego.class.getResource("/sprites/emptyHeart.png")));
		}
		else if(nCorazones == 3) {
			corazon_1.setIcon(new ImageIcon(Juego.class.getResource("/sprites/heart.png")));
			corazon_2.setIcon(new ImageIcon(Juego.class.getResource("/sprites/heart.png")));
			corazon_3.setIcon(new ImageIcon(Juego.class.getResource("/sprites/heart.png")));
			corazon_4.setIcon(new ImageIcon(Juego.class.getResource("/sprites/emptyHeart.png")));
		}
		else if(nCorazones == 4) {
			corazon_1.setIcon(new ImageIcon(Juego.class.getResource("/sprites/heart.png")));
			corazon_2.setIcon(new ImageIcon(Juego.class.getResource("/sprites/heart.png")));
			corazon_3.setIcon(new ImageIcon(Juego.class.getResource("/sprites/heart.png")));
			corazon_4.setIcon(new ImageIcon(Juego.class.getResource("/sprites/heart.png")));
		}
	}
	private void representarComida(int nComida) {
		if(nComida == 1) {
			comida_1.setIcon(new ImageIcon(Juego.class.getResource("/sprites/hungry.png")));
			comida_2.setIcon(new ImageIcon(Juego.class.getResource("/sprites/emptyHungry.png")));
			comida_3.setIcon(new ImageIcon(Juego.class.getResource("/sprites/emptyHungry.png")));
			comida_4.setIcon(new ImageIcon(Juego.class.getResource("/sprites/emptyHungry.png")));
		}
		else if(nComida == 2) {
			comida_1.setIcon(new ImageIcon(Juego.class.getResource("/sprites/hungry.png")));
			comida_2.setIcon(new ImageIcon(Juego.class.getResource("/sprites/hungry.png")));
			comida_3.setIcon(new ImageIcon(Juego.class.getResource("/sprites/emptyHungry.png")));
			comida_4.setIcon(new ImageIcon(Juego.class.getResource("/sprites/emptyHungry.png")));
		}
		else if(nComida == 3) {
			comida_1.setIcon(new ImageIcon(Juego.class.getResource("/sprites/hungry.png")));
			comida_2.setIcon(new ImageIcon(Juego.class.getResource("/sprites/hungry.png")));
			comida_3.setIcon(new ImageIcon(Juego.class.getResource("/sprites/hungry.png")));
			comida_4.setIcon(new ImageIcon(Juego.class.getResource("/sprites/emptyHungry.png")));
		}
		else if(nComida == 4) {
			comida_1.setIcon(new ImageIcon(Juego.class.getResource("/sprites/hungry.png")));
			comida_2.setIcon(new ImageIcon(Juego.class.getResource("/sprites/hungry.png")));
			comida_3.setIcon(new ImageIcon(Juego.class.getResource("/sprites/hungry.png")));
			comida_4.setIcon(new ImageIcon(Juego.class.getResource("/sprites/hungry.png")));
		}
	}

	/**
	 * Create the frame.
	 */
	public Juego() {
		setTitle("Partida de " + View.Inner.getTextF().getText());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 500, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(getBtnRet());
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Tamagochi.getTamagochi().addObserver(this);

		JLabel lblNewLabel = new JLabel("Tamagotchi :<");
		lblNewLabel.setFont(new Font("Jokerman", Font.PLAIN, 21));
		lblNewLabel.setBounds(167, 29, 144, 25);
		lblNewLabel.setForeground(Color.WHITE);
		contentPane.add(lblNewLabel);

		Panel panel_5 = new Panel();
		panel_5.setBounds(72, 289, 28, 25);
		contentPane.add(panel_5);

		Panel panel_5_1 = new Panel();
		panel_5_1.setBounds(106, 289, 28, 25);
		contentPane.add(panel_5_1);

		Panel panel_5_2 = new Panel();
		panel_5_2.setBounds(140, 289, 28, 25);
		contentPane.add(panel_5_2);

		Panel panel_5_3 = new Panel();
		panel_5_3.setBounds(174, 289, 28, 25);
		contentPane.add(panel_5_3);

		Panel panel_5_4 = new Panel();
		panel_5_4.setBounds(385, 289, 28, 25);
		contentPane.add(panel_5_4);

		Panel panel_5_5 = new Panel();
		panel_5_5.setBounds(351, 289, 28, 25);
		contentPane.add(panel_5_5);

		Panel panel_5_6 = new Panel();
		panel_5_6.setBounds(317, 289, 28, 25);
		contentPane.add(panel_5_6);

		Panel panel_5_7 = new Panel();
		panel_5_7.setBounds(283, 289, 28, 25);
		contentPane.add(panel_5_7);

		personaje.setBounds(189, 142, 109, 123);
		contentPane.add(personaje);
		personaje.setIcon(
				new ImageIcon(Juego.class.getResource("/sprites/gudetama1.gif")));

		vida.setForeground(Color.WHITE);
		vida.setFont(new Font("Tahoma", Font.PLAIN, 21));
		vida.setBounds(25, 116, 45, 25);
		contentPane.add(vida);

		comida.setFont(new Font("Tahoma", Font.PLAIN, 21));
		comida.setForeground(Color.WHITE);
		comida.setBounds(385, 109, 74, 38);
		contentPane.add(comida);

		JLabel lblNewLabel_2 = new JLabel("VIDA");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(32, 94, 68, 19);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("COMIDA");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(385, 85, 74, 25);
		contentPane.add(lblNewLabel_3);
		
		puntuacion.setFont(new Font("Consolas", Font.BOLD, 14));
		puntuacion.setForeground(Color.YELLOW);
		puntuacion.setBounds(339, 29, 137, 31);
		contentPane.add(puntuacion);
		caramelo.addActionListener(getControler());
		
		
		caramelo.setForeground(Color.BLACK);
		caramelo.setBackground(Color.BLACK);
		caramelo.setIcon(new ImageIcon(Juego.class.getResource("/sprites/candy.png")));
		caramelo.setBounds(133, 110, 35, 31);
		caramelo.addActionListener(getControler());
		contentPane.add(caramelo);
		
		
		comida_4.setBounds(417, 147, 80, 31);
		contentPane.add(comida_4);
		comida_4.setIcon(new ImageIcon(Juego.class.getResource("/sprites/hungry.png")));
		
		
		comida_3.setIcon(new ImageIcon(Juego.class.getResource("/sprites/hungry.png")));
		comida_3.setBounds(417, 178, 80, 31);
		contentPane.add(comida_3);
		
		
		comida_2.setIcon(new ImageIcon(Juego.class.getResource("/sprites/hungry.png")));
		comida_2.setBounds(417, 209, 80, 31);
		contentPane.add(comida_2);
		
		
		comida_1.setIcon(new ImageIcon(Juego.class.getResource("/sprites/hungry.png")));
		comida_1.setBounds(417, 240, 80, 31);
		contentPane.add(comida_1);
		
		
		cucharada.setIcon(new ImageIcon(Juego.class.getResource("/sprites/spoon.png")));
		cucharada.setForeground(Color.BLACK);
		cucharada.setBackground(Color.BLACK);
		cucharada.setBounds(317, 110, 35, 31);
		cucharada.addActionListener(getControler());
		contentPane.add(cucharada);
		
		
		corazon_4.setIcon(new ImageIcon(Juego.class.getResource("/sprites/heart.png")));
		corazon_4.setBounds(25, 147, 80, 31);
		contentPane.add(corazon_4);
		
		
		corazon_3.setIcon(new ImageIcon(Juego.class.getResource("/sprites/heart.png")));
		corazon_3.setBounds(25, 178, 80, 31);
		contentPane.add(corazon_3);
		
		
		corazon_2.setIcon(new ImageIcon(Juego.class.getResource("/sprites/heart.png")));
		corazon_2.setBounds(25, 209, 80, 31);
		contentPane.add(corazon_2);
		
		
		corazon_1.setIcon(new ImageIcon(Juego.class.getResource("/sprites/heart.png")));
		corazon_1.setBounds(25, 240, 80, 31);
		contentPane.add(corazon_1);
	}

	private JButton getBtnRet() {
		if (BtnRet == null) {
			BtnRet = new JButton("<-");
			BtnRet.setFont(new Font("Ravie", Font.PLAIN, 8));
			BtnRet.setForeground(Color.WHITE);
			BtnRet.setBackground(Color.DARK_GRAY);
			BtnRet.addActionListener(getControler());
			BtnRet.setBounds(10, 10, 43, 44);
		}
		return BtnRet;
	}

	public void closeWindow() {
		this.setVisible(false);
	}

	private Controler getControler() {
		if (controler == null) {
			controler = new Controler();
		}
		return controler;
	}

	private class Controler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(BtnRet)) {
				Inner menu = new Inner();
				menu.setVisibleMenu();
				// OBSERVER PARA CAMBIAR DE PANTALLA
				closeWindow();

			}
			else if (e.getSource().equals(cucharada)) {
				Tamagochi.getTamagochi().sumarComida();
		}
			else if(e.getSource().equals(caramelo)) {
				Tamagochi.getTamagochi().sumarVida();
			}
	}
	}
	}
