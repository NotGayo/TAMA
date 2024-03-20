package tamagochi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Inner extends JFrame {

	private JPanel contentPane;
	private JButton btnB1;
	private JButton btnB2;
	private Controler controler = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inner frame = new Inner();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inner() {
		setTitle("V vs C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 218, 133);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnB1());
		contentPane.add(getBtnB2());
	}
	private JButton getBtnB1() {
		if (btnB1 == null) {
			btnB1 = new JButton("Button1");
			btnB1.setForeground(Color.WHITE);
			btnB1.setBackground(Color.DARK_GRAY);
			btnB1.addActionListener(getControler());
			btnB1.setBounds(46, 12, 117, 25);
		}
		return btnB1;
	}
	private JButton getBtnB2() {
		if (btnB2 == null) {
			btnB2 = new JButton("Button2");
			btnB2.setBackground(Color.DARK_GRAY);
			btnB2.setForeground(Color.WHITE);
			btnB2.addActionListener(getControler());
			btnB2.setBounds(46, 38, 117, 25);
		}
		return btnB2;
	}
	
	private Controler getControler() {
		if (controler == null) {
			controler = new Controler();
		}
		return controler;
	}
	
	private class Controler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(btnB1)){
				System.out.println("Click1!");
			}
			if (e.getSource().equals(btnB2)){
				System.out.println("Click2!");
			}
		}
	}
}
