package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Tamagochi;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

public class Inner extends JFrame {

	private JPanel contentPane;
	private JButton btnB1;
	private JButton btnB2;
	private Controler controler = null;
	private static JTextField textField;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel topNam1;
	private JLabel topNam2;
	private JLabel topNam3;
	private JLabel topNam4;
	private JLabel topNam5;
	private JLabel topSco1;
	private JLabel topSco2;
	private GridBagConstraints gbc_topSco1;
	private JLabel topSco3;
	private JLabel topSco4;
	private JLabel topSco5;

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
	public static JTextField getTextF() {
		JTextField A = textField;
		return A;
	}

	/**
	 * Create the frame.
	 */
	public void setVisibleMenu() {
		this.setVisible(true);
	}
	public Inner() {
		setTitle("V vs C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 500, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 196, 0, 0, 76, 89, 0};
		gbl_contentPane.rowHeights = new int[]{77, 25, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		contentPane.add(getLblNewLabel_2(), gbc_lblNewLabel_2);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		contentPane.add(getTextField(), gbc_textField);
		GridBagConstraints gbc_btnB1 = new GridBagConstraints();
		gbc_btnB1.fill = GridBagConstraints.BOTH;
		gbc_btnB1.insets = new Insets(0, 0, 5, 5);
		gbc_btnB1.gridx = 4;
		gbc_btnB1.gridy = 1;
		contentPane.add(getBtnB1(), gbc_btnB1);
		GridBagConstraints gbc_btnB2 = new GridBagConstraints();
		gbc_btnB2.insets = new Insets(0, 0, 5, 0);
		gbc_btnB2.fill = GridBagConstraints.BOTH;
		gbc_btnB2.gridx = 5;
		gbc_btnB2.gridy = 1;
		contentPane.add(getBtnB2(), gbc_btnB2);
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 1;
		gbc_lblNewLabel_8.gridy = 3;
		contentPane.add(getLblNewLabel_8(), gbc_lblNewLabel_8);
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 0;
		gbc_lblNewLabel_1_1.gridy = 4;
		contentPane.add(getLblNewLabel_1_1(), gbc_lblNewLabel_1_1);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 4;
		contentPane.add(getLblNewLabel_1(), gbc_lblNewLabel_1);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 4;
		contentPane.add(getLblNewLabel(), gbc_lblNewLabel);
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 5;
		contentPane.add(getLabel_1(), gbc_lblNewLabel_3);
		GridBagConstraints gbc_TopSco1 = new GridBagConstraints();
		gbc_TopSco1.insets = new Insets(0, 0, 5, 5);
		gbc_TopSco1.gridx = 1;
		gbc_TopSco1.gridy = 5;
		contentPane.add(getTopNam1(), gbc_TopSco1);
		gbc_topSco1 = new GridBagConstraints();
		gbc_topSco1.insets = new Insets(0, 0, 5, 5);
		gbc_topSco1.gridx = 2;
		gbc_topSco1.gridy = 5;
		contentPane.add(getTopSco1(), gbc_topSco1);
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 6;
		contentPane.add(getLabel_2(), gbc_lblNewLabel_4);
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 1;
		gbc_lblNewLabel_10.gridy = 6;
		contentPane.add(getTopNam2(), gbc_lblNewLabel_10);
		GridBagConstraints gbc_topSco2 = new GridBagConstraints();
		gbc_topSco2.insets = new Insets(0, 0, 5, 5);
		gbc_topSco2.gridx = 2;
		gbc_topSco2.gridy = 6;
		contentPane.add(getTopSco2(), gbc_topSco2);
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 7;
		contentPane.add(getLabel_3(), gbc_lblNewLabel_5);
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_11.gridx = 1;
		gbc_lblNewLabel_11.gridy = 7;
		contentPane.add(getTopNam3(), gbc_lblNewLabel_11);
		GridBagConstraints gbc_topSco3 = new GridBagConstraints();
		gbc_topSco3.insets = new Insets(0, 0, 5, 5);
		gbc_topSco3.gridx = 2;
		gbc_topSco3.gridy = 7;
		contentPane.add(getTopSco3(), gbc_topSco3);
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 8;
		contentPane.add(getLabel_4(), gbc_lblNewLabel_6);
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_12.gridx = 1;
		gbc_lblNewLabel_12.gridy = 8;
		contentPane.add(getTopNam4(), gbc_lblNewLabel_12);
		GridBagConstraints gbc_topSco4 = new GridBagConstraints();
		gbc_topSco4.insets = new Insets(0, 0, 5, 5);
		gbc_topSco4.gridx = 2;
		gbc_topSco4.gridy = 8;
		contentPane.add(getTopSco4(), gbc_topSco4);
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 9;
		contentPane.add(getLabel_5(), gbc_lblNewLabel_7);
		GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
		gbc_lblNewLabel_13.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_13.gridx = 1;
		gbc_lblNewLabel_13.gridy = 9;
		contentPane.add(getTopNam5(), gbc_lblNewLabel_13);
		GridBagConstraints gbc_topSco5 = new GridBagConstraints();
		gbc_topSco5.insets = new Insets(0, 0, 0, 5);
		gbc_topSco5.gridx = 2;
		gbc_topSco5.gridy = 9;
		contentPane.add(getTopSco5(), gbc_topSco5);
	}
	private JButton getBtnB1() {
		if (btnB1 == null) {
			btnB1 = new JButton("GO!");
			btnB1.setForeground(new Color(0, 0, 0));
			btnB1.setBackground(new Color(255, 0, 0));
			btnB1.addActionListener(getControler());
		}
		return btnB1;
	}
	private JButton getBtnB2() {
		if (btnB2 == null) {
			btnB2 = new JButton("Salir");
			btnB2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnB2.setBackground(new Color(255, 0, 0));
			btnB2.setForeground(new Color(0, 0, 0));
			btnB2.addActionListener(getControler());
		}
		return btnB2;
	}
	public void closeWindow() {
		//this.dispose();
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
			if (e.getSource().equals(btnB1)){
				Juego juego =  new Juego();
				juego.run();
				closeWindow();
				Tamagochi.getTamagochi().startTamagochi();
				// CUANDO SE PULSE ESTE BOTON HAY Q AÑADIR EL NOMBRE A ALGUN SITIO :(
				
			}
			if (e.getSource().equals(btnB2)){
				dispose();
			}
		}
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					if(textField.getText().length() >= 3)
				    {
				        e.consume();
				        }

				}
			});
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("YOUR NAME:");
			lblNewLabel_2.setForeground(Color.WHITE);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("Rank");
			lblNewLabel_1_1.setToolTipText("Rank");
			lblNewLabel_1_1.setForeground(Color.WHITE);
			lblNewLabel_1_1.setBackground(Color.BLACK);
		}
		return lblNewLabel_1_1;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Score");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setBackground(new Color(0, 0, 0));
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Name");
			lblNewLabel_1.setForeground(new Color(255, 255, 255));
			lblNewLabel_1.setBackground(new Color(0, 0, 0));
		}
		return lblNewLabel_1;
	}
	private JLabel getLabel_1() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("1st");
			lblNewLabel_3.setForeground(new Color(128, 128, 64));
			lblNewLabel_3.setBackground(new Color(0, 0, 0));
		}
		return lblNewLabel_3;
	}
	private JLabel getLabel_2() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("2nd");
			lblNewLabel_4.setForeground(new Color(0, 128, 255));
			lblNewLabel_4.setBackground(new Color(0, 0, 0));
		}
		return lblNewLabel_4;
	}
	private JLabel getLabel_3() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("3rd");
			lblNewLabel_5.setForeground(new Color(128, 128, 192));
			lblNewLabel_5.setBackground(new Color(0, 0, 0));
		}
		return lblNewLabel_5;
	}
	private JLabel getLabel_4() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("4th");
			lblNewLabel_6.setForeground(new Color(128, 0, 255));
			lblNewLabel_1.setBackground(new Color(0, 0, 0));
		}
		return lblNewLabel_6;
	}
	private JLabel getLabel_5() {
		if (lblNewLabel_7 == null) {
			lblNewLabel_7 = new JLabel("5th");
			lblNewLabel_7.setForeground(new Color(255, 128, 192));
			lblNewLabel_7.setForeground(new Color(255, 255, 255));
			lblNewLabel_7.setBackground(new Color(0, 0, 0));
		}
		return lblNewLabel_7;
	}
	private JLabel getLblNewLabel_8() {
		if (lblNewLabel_8 == null) {
			lblNewLabel_8 = new JLabel("LEADERBOARD");
			lblNewLabel_8.setForeground(new Color(255, 255, 255));
			lblNewLabel_8.setBackground(new Color(0, 0, 0));
		}
		return lblNewLabel_8;
	}
	private JLabel getTopNam1() {
		if (topNam1 == null) {
			topNam1 = new JLabel("X");
			topNam1.setForeground(new Color(128, 128, 64));
			topNam1.setBackground(new Color(0, 0, 0));
		}
		return topNam1;
	}
	private JLabel getTopNam2() {
		if (topNam2 == null) {
			topNam2 = new JLabel("X2");
			topNam2.setForeground(new Color(0, 128, 255));
			topNam2.setBackground(new Color(0, 0, 0));
		}
		return topNam2;
	}
	private JLabel getTopNam3() {
		if (topNam3 == null) {
			topNam3 = new JLabel("X3");
			topNam3.setForeground(new Color(128, 128, 192));
			topNam3.setBackground(new Color(0, 0, 0));
		}
		return topNam3;
	}
	private JLabel getTopNam4() {
		if (topNam4 == null) {
			topNam4 = new JLabel("X4");
			topNam4.setForeground(new Color(128, 0, 255));
			topNam4.setBackground(new Color(0, 0, 0));
		}
		return topNam4;
	}
	private JLabel getTopNam5() {
		if (topNam5 == null) {
			topNam5 = new JLabel("X5");
			topNam5.setForeground(new Color(255, 128, 192));
			topNam5.setBackground(new Color(0, 0, 0));
		}
		return topNam5;
	}
	private JLabel getTopSco1() {
		if (topSco1 == null) {
			topSco1 = new JLabel("000000");
			topSco1.setForeground(new Color(128, 128, 64));
			topSco1.setBackground(new Color(0, 0, 0));
		}
		return topSco1;
	}
	private JLabel getTopSco2() {
		if (topSco2 == null) {
			topSco2 = new JLabel("000000");
			topSco2.setForeground(new Color(0, 128, 255));
			topSco2.setBackground(new Color(0, 0, 0));
		}
		return topSco2;
	}
	private JLabel getTopSco3() {
		if (topSco3 == null) {
			topSco3 = new JLabel("000000");
			topSco3.setForeground(new Color(128, 128, 192));
			topSco3.setBackground(new Color(0, 0, 0));
		}
		return topSco3;
	}
	private JLabel getTopSco4() {
		if (topSco4 == null) {
			topSco4 = new JLabel("000000");
			topSco4.setForeground(new Color(128, 0, 255));
			topSco4.setBackground(new Color(0, 0, 0));
		}
		return topSco4;
	}
	private JLabel getTopSco5() {
		if (topSco5 == null) {
			topSco5 = new JLabel("000000");
			topSco5.setForeground(new Color(255, 128, 192));
			topSco5.setBackground(new Color(0, 0, 0));
		}
		return topSco5;
	}
}