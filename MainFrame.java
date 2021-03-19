package BMI;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.removeAll();
		Login login = new Login();
		login.getBtnNew().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane.removeAll();
				Newperson newperson = new Newperson();
				contentPane.add(newperson);
				contentPane.updateUI();
			}
		});
		login.getBtnLogin().setLocation(410, 289);
		login.getBtnNew().setLocation(308, 289);
		login.getLblNewLabel_1().setLocation(270, 197);
		login.getTextField_1().setLocation(298, 197);
		login.getTextField().setLocation(298, 233);
		login.getLblNewLabel_2().setLocation(198, 233);
		login.getLblNewLabel().setLocation(298, 149);
		contentPane.add(login);
		contentPane.updateUI();

	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("New button");
			
			btnNewButton.setBounds(112, 197, 97, 23);
		}
		return btnNewButton;
	}
}
