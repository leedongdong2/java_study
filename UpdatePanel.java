package section11;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdatePanel extends JPanel {
	private JLabel lblNewLabel;
	private JTextField textField;
	private JButton btnNewButton;
	private JSeparator separator;
	private JTextField textField_1;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_3;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1;
	private JTextField textField_4;
	private JButton btnNewButton_1;

	/**
	 * Create the panel.
	 */
	public UpdatePanel() {
		setLayout(null);
		add(getLblNewLabel());
		add(getTextField());
		add(getBtnNewButton());
		add(getSeparator());
		add(getTextField_1());
		add(getLblNewLabel_4());
		add(getLblNewLabel_3());
		add(getTextField_2());
		add(getTextField_3());
		add(getLblNewLabel_2());
		add(getLblNewLabel_1());
		add(getTextField_4());
		add(getBtnNewButton_1());

	}

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uD68C\uC6D0\uC218\uC815");
			lblNewLabel.setOpaque(true);
			lblNewLabel.setBackground(SystemColor.activeCaption);
			lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 17));
			lblNewLabel.setBounds(12, 10, 421, 28);
		}
		return lblNewLabel;
	}
	public JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(12, 48, 116, 21);
			textField.setColumns(10);
		}
		return textField;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.setBounds(140, 47, 83, 22);
		}
		return btnNewButton;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(12, 81, 410, 2);
		}
		return separator;
	}
	public JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(81, 186, 210, 21);
		}
		return textField_1;
	}
	public JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uC8FC\uC18C");
			lblNewLabel_4.setBounds(18, 189, 46, 15);
		}
		return lblNewLabel_4;
	}
	public JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC5F0\uB77D\uCC98");
			lblNewLabel_3.setBounds(16, 158, 57, 15);
		}
		return lblNewLabel_3;
	}
	public JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(81, 155, 105, 21);
		}
		return textField_2;
	}
	public JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(81, 124, 126, 21);
		}
		return textField_3;
	}
	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC774\uB984");
			lblNewLabel_2.setBounds(16, 121, 35, 27);
		}
		return lblNewLabel_2;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
			lblNewLabel_1.setBounds(16, 96, 53, 15);
		}
		return lblNewLabel_1;
	}
	public JTextField getTextField_4() {
		if (textField_4 == null) {
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(81, 93, 142, 21);
		}
		return textField_4;
	}
	public JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC218\uC815");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnNewButton_1.setBounds(82, 217, 71, 27);
		}
		return btnNewButton_1;
	}
}
