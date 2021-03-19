package BMI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;

public class Newperson extends JPanel {
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JTextField textField_1;
	private JLabel lblNewLabel_2;
	private JTextField textField_2;
	private JLabel lblNewLabel_3;
	private JTextField textField_3;
	private JLabel lblNewLabel_4;
	private JTextField textField_4;
	private JLabel lblNewLabel_5;
	private JTextField textField_5;
	private JLabel lblNewLabel_6;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Create the panel.
	 */
	public Newperson() {
		setLayout(null);
		add(getLblNewLabel());
		add(getTextField());
		add(getLblNewLabel_1());
		add(getTextField_1());
		add(getLblNewLabel_2());
		add(getTextField_2());
		add(getLblNewLabel_3());
		add(getTextField_3());
		add(getLblNewLabel_4());
		add(getTextField_4());
		add(getLblNewLabel_5());
		add(getTextField_5());
		add(getLblNewLabel_6());
		add(getBtnNewButton());
		add(getBtnNewButton_1());

	}

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("ID");
			lblNewLabel.setBounds(253, 177, 57, 15);
		}
		return lblNewLabel;
	}
	public JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(275, 174, 172, 21);
			textField.setColumns(10);
		}
		return textField;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("PassWord");
			lblNewLabel_1.setBounds(206, 205, 57, 15);
		}
		return lblNewLabel_1;
	}
	public JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(275, 202, 172, 21);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("PassWordCheck");
			lblNewLabel_2.setBounds(170, 236, 107, 15);
		}
		return lblNewLabel_2;
	}
	public JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setBounds(275, 233, 172, 21);
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	public JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC774\uB984");
			lblNewLabel_3.setBounds(234, 264, 57, 15);
		}
		return lblNewLabel_3;
	}
	public JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setBounds(275, 261, 172, 21);
			textField_3.setColumns(10);
		}
		return textField_3;
	}
	public JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uC131\uBCC4");
			lblNewLabel_4.setBounds(234, 292, 57, 15);
		}
		return lblNewLabel_4;
	}
	public JTextField getTextField_4() {
		if (textField_4 == null) {
			textField_4 = new JTextField();
			textField_4.setBounds(275, 289, 44, 21);
			textField_4.setColumns(10);
		}
		return textField_4;
	}
	public JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("\uB098\uC774");
			lblNewLabel_5.setBounds(234, 317, 57, 15);
		}
		return lblNewLabel_5;
	}
	public JTextField getTextField_5() {
		if (textField_5 == null) {
			textField_5 = new JTextField();
			textField_5.setBounds(275, 314, 44, 21);
			textField_5.setColumns(10);
		}
		return textField_5;
	}
	public JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("\uD68C\uC6D0\uAC00\uC785");
			lblNewLabel_6.setBounds(271, 94, 88, 35);
			lblNewLabel_6.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		}
		return lblNewLabel_6;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC00\uC785");
			btnNewButton.setBounds(350, 375, 97, 23);
		}
		return btnNewButton;
	}
	public JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC911\uBCF5\uCCB4\uD06C");
			btnNewButton_1.setBounds(457, 173, 88, 23);
		}
		return btnNewButton_1;
	}
}
