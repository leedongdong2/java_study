package section11;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DelPanel extends JPanel {
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_4;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_3;
	private JTextField textField_2;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1;
	private JTextField textField_3;
	private JButton btnNewButton;
	private JTextField textField_4;
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public DelPanel() {
		setLayout(null);
		add(getBtnNewButton_1());
		add(getLblNewLabel_4());
		add(getTextField());
		add(getTextField_1());
		add(getLblNewLabel_3());
		add(getTextField_2());
		add(getLblNewLabel_2());
		add(getLblNewLabel_1());
		add(getTextField_3());
		add(getBtnNewButton());
		add(getTextField_4());
		add(getLblNewLabel());

	}
	public JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC0AD\uC81C");
			btnNewButton_1.setBorderPainted(false);
			btnNewButton_1.setBackground(Color.RED);
			btnNewButton_1.setBounds(82, 236, 71, 27);
		}
		return btnNewButton_1;
	}
	public JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uC8FC\uC18C");
			lblNewLabel_4.setBounds(18, 208, 46, 15);
		}
		return lblNewLabel_4;
	}
	public JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(81, 205, 210, 21);
		}
		return textField;
	}
	public JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(81, 174, 105, 21);
		}
		return textField_1;
	}
	public JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC5F0\uB77D\uCC98");
			lblNewLabel_3.setBounds(16, 177, 57, 15);
		}
		return lblNewLabel_3;
	}
	public JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(81, 143, 126, 21);
		}
		return textField_2;
	}
	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC774\uB984");
			lblNewLabel_2.setBounds(16, 140, 35, 27);
		}
		return lblNewLabel_2;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
			lblNewLabel_1.setBounds(16, 115, 53, 15);
		}
		return lblNewLabel_1;
	}
	public JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(81, 112, 142, 21);
		}
		return textField_3;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			
			btnNewButton.setBounds(140, 66, 83, 22);
		}
		return btnNewButton;
	}
	public JTextField getTextField_4() {
		if (textField_4 == null) {
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(12, 67, 116, 21);
		}
		return textField_4;
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uD68C\uC6D0\uC0AD\uC81C");
			lblNewLabel.setOpaque(true);
			lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 17));
			lblNewLabel.setBackground(SystemColor.activeCaption);
			lblNewLabel.setBounds(12, 29, 421, 28);
		}
		return lblNewLabel;
	}
}
