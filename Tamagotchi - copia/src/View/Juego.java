package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.TamaDigOut.TableroModelo;
import Model.Tamagotchi.Tamagochi;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Panel;
import java.awt.GridLayout;
import javax.swing.Box;

public class Juego extends JFrame implements Observer {

	private JPanel contentPane;
	private JButton BtnRet;
	private Controler controler = null;
	JLabel comida = new JLabel("");
	JLabel vida = new JLabel("");
	JLabel personaje = new JLabel("");
	JLabel puntuacion = new JLabel("");
	JButton cucharada = new JButton("");
	JButton caramelo = new JButton("");
	JLabel comida_4 = new JLabel("");
	JLabel comida_3 = new JLabel("");
	JLabel comida_2 = new JLabel("");
	JLabel comida_1 = new JLabel("");
	JLabel corazon_4 = new JLabel("");
	JLabel corazon_3 = new JLabel("");
	JLabel corazon_2 = new JLabel("");
	JLabel corazon_1 = new JLabel("");
	JLabel p3 = new JLabel("");
	JLabel p2 = new JLabel("");
	JLabel p1 = new JLabel("");
	JLabel c3 = new JLabel("");
	JLabel c2 = new JLabel("");
	JLabel c1 = new JLabel("");
	JButton enfermedad = new JButton("");
	JButton suciedad = new JButton("");
	JButton cardGame;
	JLabel foodTime = new JLabel("");
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
	public void update(Observable arg0, Object arg1) 
	{
		if (arg0 instanceof Tamagochi) 
		{ 
		// MIENTRAS QUE LA VIDA ES MAYOR QUE 0
			
			if (arg1 instanceof int[])
			{
					int[] intArray = (int[]) arg1;
					if(intArray.length >= 3) 
					{
						representarPiruletas(intArray[3]);
						representarCucharadas(intArray[4]);
						puntuacion.setText("Puntuacion: " + intArray[2] + "");
						representarCorazones(intArray[0] / 10);
						representarComida(intArray[1] / 10);
						if(intArray[5] == 1) {enfermedad.setVisible(true);}
						if(intArray[6] == 1) {suciedad.setVisible(true);}
						foodTime.setText("TIME TO EAT: "+ (4-intArray[7]) +"!");
					}
			}
			
			else if (arg1 instanceof String[]) 
			{
				String[] StringArray = (String[]) arg1;
				//PANTALLA MUERTE
				if (StringArray[0] == "MUERTO") {deathScreen();}
				//TDO
				else if (StringArray[0] == "TamaDigOut") {dispose();}
				//EVOLUCIONES
				else if (StringArray[0] == "Kuchipatchi") {personaje.setIcon(new ImageIcon(Juego.class.getResource("/sprites/Kuchipatchi1.png")));}
				else if (StringArray[0] == "Mimitchi") {personaje.setIcon(new ImageIcon(Juego.class.getResource("/sprites/Mimitchi1.png")));} 
				else if (StringArray[0] == "Maskutchi") {personaje.setIcon(new ImageIcon(Juego.class.getResource("/sprites/Maskutchi1.png")));}
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
	private void representarPiruletas(int nPiruletas) {
		
		if(nPiruletas == 1) {
			p1.setVisible(true);
			p2.setVisible(false);
			p3.setVisible(false);
			
			
		}
		else if(nPiruletas == 2) {
			p1.setVisible(true);
			p2.setVisible(true);
			p3.setVisible(false);
		}
		else if(nPiruletas == 3) {
			p1.setVisible(true);
			p2.setVisible(true);
			p3.setVisible(true);
		}
		else if(nPiruletas == 4) {
			p1.setVisible(true);
			p2.setVisible(true);
			p3.setVisible(true);
		}
		else if(nPiruletas == 0) {
			p1.setVisible(false);
			p2.setVisible(false);
			p3.setVisible(false);
		}
	}
	private void representarCucharadas(int nCucharadas) {
		if(nCucharadas == 1) {
			c1.setVisible(true);
			c2.setVisible(false);
			c3.setVisible(false);
			
		}
		else if(nCucharadas == 2) {
			c1.setVisible(true);
			c2.setVisible(true);
			c3.setVisible(false);
		}
		else if(nCucharadas == 3) {
			c1.setVisible(true);
			c2.setVisible(true);
			c3.setVisible(true);
		}
		else if(nCucharadas == 4) {
			c1.setVisible(true);
			c2.setVisible(true);
			c3.setVisible(true);
		}
		else if(nCucharadas == 0) {
			c1.setVisible(false);
			c2.setVisible(false);
			c3.setVisible(false);
		}
	}
	
	private void interpretarEnfermedad(int enf) {
		if(enf == 0) {
			enfermedad.setVisible(false);
		}
		else if(enf == 1) {
			enfermedad.setVisible(true);
		}
	}
	private void interpretarSuciedad(int suc) {
		if(suc == 0) {
			suciedad.setVisible(false);
		}
		else if(suc == 1) {
			suciedad.setVisible(true);
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
		TableroModelo.getTableroModelo().addObserver(this);
		JLabel lblNewLabel = new JLabel("Tamagotchi :<");
		lblNewLabel.setFont(new Font("Jokerman", Font.PLAIN, 21));
		lblNewLabel.setBounds(167, 29, 144, 25);
		lblNewLabel.setForeground(Color.WHITE);
		contentPane.add(lblNewLabel);

		personaje.setBounds(171, 147, 125, 124);
		contentPane.add(personaje);
		personaje.setIcon(
				new ImageIcon(Juego.class.getResource("/sprites/Egg1.png")));

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
		
		
		caramelo.setForeground(Color.BLACK);
		caramelo.setBackground(Color.BLACK);
		caramelo.setIcon(new ImageIcon(Juego.class.getResource("/sprites/candy.png")));
		caramelo.setBounds(110, 109, 35, 31);
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
		
		
		
		cucharada.setForeground(Color.BLACK);
		cucharada.setBackground(Color.BLACK);
		cucharada.setIcon(new ImageIcon(Juego.class.getResource("/sprites/spoon.png")));
		cucharada.setBounds(317, 110, 35, 31);
		cucharada.addActionListener(getControler());
		contentPane.add(cucharada);
		
		
		corazon_4.setIcon(new ImageIcon(Juego.class.getResource("/sprites/heart.png")));
		corazon_4.setBounds(25, 147, 43, 31);
		contentPane.add(corazon_4);
		
		
		corazon_3.setIcon(new ImageIcon(Juego.class.getResource("/sprites/heart.png")));
		corazon_3.setBounds(25, 178, 43, 31);
		contentPane.add(corazon_3);
		
		
		corazon_2.setIcon(new ImageIcon(Juego.class.getResource("/sprites/heart.png")));
		corazon_2.setBounds(25, 209, 43, 31);
		contentPane.add(corazon_2);
		
		
		corazon_1.setIcon(new ImageIcon(Juego.class.getResource("/sprites/heart.png")));
		corazon_1.setBounds(25, 240, 45, 31);
		contentPane.add(corazon_1);
		
		
		p3.setIcon(new ImageIcon(Juego.class.getResource("/sprites/candy.png")));
		p3.setBounds(80, 289, 35, 38);
		contentPane.add(p3);
		
		
		p2.setIcon(new ImageIcon(Juego.class.getResource("/sprites/candy.png")));
		p2.setBounds(125, 289, 35, 38);
		contentPane.add(p2);
		
		
		p1.setIcon(new ImageIcon(Juego.class.getResource("/sprites/candy.png")));
		p1.setBounds(167, 289, 35, 38);
		contentPane.add(p1);
		
		
		c3.setIcon(new ImageIcon(Juego.class.getResource("/sprites/spoon.png")));
		c3.setBounds(377, 289, 35, 38);
		contentPane.add(c3);
		
		
		c2.setIcon(new ImageIcon(Juego.class.getResource("/sprites/spoon.png")));
		c2.setBounds(333, 289, 35, 38);
		contentPane.add(c2);
		
		c1.setIcon(new ImageIcon(Juego.class.getResource("/sprites/spoon.png")));
		c1.setBounds(287, 289, 35, 38);
		contentPane.add(c1);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBounds(77, 289, 125, 44);
		contentPane.add(horizontalBox);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setBounds(272, 289, 130, 44);
		contentPane.add(horizontalBox_1);
		enfermedad.setBackground(Color.BLACK);
		
		
		enfermedad.setIcon(new ImageIcon(Juego.class.getResource("/sprites/Virus.png")));
		enfermedad.setBounds(77, 178, 86, 62);
		contentPane.add(enfermedad);
		enfermedad.addActionListener(getControler());
		enfermedad.setVisible(false);
		suciedad.setBackground(Color.BLACK);
		
		
		suciedad.setIcon(new ImageIcon(Juego.class.getResource("/sprites/kk.png")));
		suciedad.setBounds(295, 178, 86, 62);
		contentPane.add(suciedad);
		
		cardGame = new JButton("");
		cardGame.setForeground(Color.BLACK);
		cardGame.setIcon(new ImageIcon(Juego.class.getResource("/sprites/gamegame.jpg")));
		cardGame.setBackground(Color.BLACK);
		cardGame.setBounds(212, 289, 50, 38);
		contentPane.add(cardGame);
		
		
		foodTime.setForeground(Color.WHITE);
		foodTime.setBounds(177, 340, 116, 13);
		contentPane.add(foodTime);
		cardGame.addActionListener(getControler());
		suciedad.addActionListener(getControler());
		suciedad.setVisible(false);
		
		p1.setVisible(false);
		p2.setVisible(false);
		p3.setVisible(false);
		c1.setVisible(false);
		c2.setVisible(false);
		c3.setVisible(false);
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
			else if (e.getSource().equals(cucharada)) 
			{
				Tamagochi.getTamagochi().sumarComida();
				representarCucharadas(Tamagochi.getTamagochi().getNCuch());
			}
			
			else if(e.getSource().equals(caramelo)) 
			{
				Tamagochi.getTamagochi().sumarVida();
				representarPiruletas(Tamagochi.getTamagochi().getNPir());
			}
			
			else if(e.getSource().equals(enfermedad)) 
			{
				Tamagochi.getTamagochi().quitarEnf();
				if(Tamagochi.getTamagochi().getEnfermedad() == 0) 
				{
					enfermedad.setVisible(false);
				}
				else 
				{
					enfermedad.setVisible(true);
				}
			}
			else if(e.getSource().equals(suciedad)) 
			{
				Tamagochi.getTamagochi().quitarSuc();
				if(Tamagochi.getTamagochi().getSuciedad() == 0) 
				{
					suciedad.setVisible(false);
				}
				else 
				{
					suciedad.setVisible(true);
				}
			}
			else if(e.getSource().equals(cardGame)) 
			{
				Tamagochi.getTamagochi().iniciarCardGame();
				dispose();
			}
	}
	}
	}
