package BMI;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class Login extends JPanel {
	private JButton btnNew;
	private JButton btnLogin;
	private JTextField textField;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1;
	private JTextField textField_1;
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public Login() {
		setLayout(null);
		add(getBtnNew());
		add(getBtnLogin());
		add(getTextField());
		add(getLblNewLabel_2());
		add(getLblNewLabel_1());
		add(getTextField_1());
		add(getLblNewLabel());

	}

	public JButton getBtnNew() {
		if (btnNew == null) {
			btnNew = new JButton("\uD68C\uC6D0\uAC00\uC785");
			btnNew.setBounds(312, 281, 90, 23);
		}
		return btnNew;
	}
	public JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("\uB85C\uADF8\uC778");
			btnLogin.setBounds(414, 281, 75, 23);
		}
		return btnLogin;
	}
	public JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(302, 225, 187, 26);
		}
		return textField;
	}
	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("PassWord");
			lblNewLabel_2.setFont(new Font("±¼¸²", Font.PLAIN, 20));
			lblNewLabel_2.setBounds(202, 225, 133, 25);
		}
		return lblNewLabel_2;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("ID");
			lblNewLabel_1.setFont(new Font("±¼¸²", Font.PLAIN, 20));
			lblNewLabel_1.setBounds(274, 189, 75, 26);
		}
		return lblNewLabel_1;
	}
	public JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(302, 189, 187, 26);
		}
		return textField_1;
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("BMI \uACC4\uC0B0\uAE30");
			lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 24));
			lblNewLabel.setBounds(302, 141, 125, 38);
		}
		return lblNewLabel;
	}
}
