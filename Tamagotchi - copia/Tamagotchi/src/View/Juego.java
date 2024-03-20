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
	JLabel lblNewLabel_1 = new JLabel("New label");
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
		 if (arg0 instanceof Tamagochi) {
			 if(arg1 instanceof int[]) {
				 int[] intArray = (int[])arg1;
				 vida.setText(intArray[0]+"");
				 comida.setText(intArray[1]+"");
				 System.out.println(intArray[0] +" ,"+intArray[1]);
			 }
			 else if(arg1 instanceof String[]) {
				 String[] stringArray = (String[])arg1;
				 contentPane.remove(lblNewLabel_1);
				 lblNewLabel_1 = new JLabel("New label");
				 lblNewLabel_1.setBounds(212, 142, 51, 123);
				 contentPane.add(lblNewLabel_1);
				 lblNewLabel_1.setIcon(new ImageIcon(stringArray[0]));
				 System.out.println("OKOKOKOKOKOKOKOKOKOKOKOKOK");
			 }
		 }
		 
	}

	/**
	 * Create the frame.
	 */
	public Juego() {
		setTitle("Partida de "+View.Inner.getTextF().getText());
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
		
		Panel panel = new Panel();
		panel.setBounds(32, 147, 28, 25);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(32, 178, 28, 25);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(32, 209, 28, 25);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		Panel panel_3 = new Panel();
		panel_3.setBounds(32, 240, 28, 25);
		contentPane.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		
		Panel panel_4 = new Panel();
		panel_4.setBounds(417, 147, 28, 25);
		contentPane.add(panel_4);
		
		Panel panel_1_1 = new Panel();
		panel_1_1.setBounds(417, 178, 28, 25);
		contentPane.add(panel_1_1);
		
		Panel panel_2_1 = new Panel();
		panel_2_1.setBounds(417, 209, 28, 25);
		contentPane.add(panel_2_1);
		
		Panel panel_3_1 = new Panel();
		panel_3_1.setBounds(417, 240, 28, 25);
		contentPane.add(panel_3_1);
		
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
		
		
		
		lblNewLabel_1.setBounds(212, 142, 51, 123);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\Tamagotchi\\Tamagotchi\\src\\sprites\\gudetama1.gif"));
		
		
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
		lblNewLabel_2.setBounds(32, 94, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("COMIDA");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(400, 94, 45, 13);
		contentPane.add(lblNewLabel_3);
		
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
			if (e.getSource().equals(BtnRet)){
				Inner menu =  new Inner();
				menu.setVisibleMenu();
				//OBSERVER PARA CAMBIAR DE PANTALLA	
				closeWindow();
			
				
			}
			
		}
	}
}