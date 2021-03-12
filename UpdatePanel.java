package section11;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdatePanel extends JPanel {
	private JLabel lblNewLabel;
	private JTextField tffindstr;
	private JButton btnNewButton;
	private JSeparator separator;
	private JTextField tfaddress;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_3;
	private JTextField tfphone;
	private JTextField tfirum;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1;
	private JTextField tfid;
	private JButton btnNewButton_1;

	/**
	 * Create the panel.
	 */
	public UpdatePanel() {
		setLayout(null);
		add(getLblNewLabel());
		add(getTffindstr());
		add(getBtnNewButton());
		add(getSeparator());
		add(getTfaddress());
		add(getLblNewLabel_4());
		add(getLblNewLabel_3());
		add(getTfphone());
		add(getTfirum());
		add(getLblNewLabel_2());
		add(getLblNewLabel_1());
		add(getTfid());
		add(getBtnNewButton_1());

	}

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uD68C\uC6D0\uC218\uC815");
			lblNewLabel.setOpaque(true);
			lblNewLabel.setBackground(SystemColor.activeCaption);
			lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 17));
			lblNewLabel.setBounds(12, 10, 421, 28);
		}
		return lblNewLabel;
	}
	public JTextField getTffindstr() {
		if (tffindstr == null) {
			tffindstr = new JTextField();
			tffindstr.setBounds(12, 48, 116, 21);
			tffindstr.setColumns(10);
		}
		return tffindstr;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String id = tffindstr.getText();
					String msg = "검색할 데이터가 없습니다";
					MemberController mc = new MemberController();
					Member m = mc.selectOne(id);
					if(m==null) {
						JOptionPane.showMessageDialog(UpdatePanel.this,msg);
					}else {
					tfid.setText(m.id);
					tfirum.setText(m.irum);
					tfphone.setText(m.phone);
					tfaddress.setText(m.address);
					}
				}
			});
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
	public JTextField getTfaddress() {
		if (tfaddress == null) {
			tfaddress = new JTextField();
			tfaddress.setColumns(10);
			tfaddress.setBounds(81, 186, 210, 21);
		}
		return tfaddress;
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
	public JTextField getTfphone() {
		if (tfphone == null) {
			tfphone = new JTextField();
			tfphone.setColumns(10);
			tfphone.setBounds(81, 155, 105, 21);
		}
		return tfphone;
	}
	public JTextField getTfirum() {
		if (tfirum == null) {
			tfirum = new JTextField();
			tfirum.setColumns(10);
			tfirum.setBounds(81, 124, 126, 21);
		}
		return tfirum;
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
	public JTextField getTfid() {
		if (tfid == null) {
			tfid = new JTextField();
			tfid.setEditable(false);
			tfid.setColumns(10);
			tfid.setBounds(81, 93, 142, 21);
		}
		return tfid;
	}
	public JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC218\uC815");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String id = tffindstr.getText();
					MemberController mc = new MemberController();
					Member m = mc.selectOne(id);
					m.setIrum(tfirum.getText());
					m.setPhone(tfphone.getText());
					m.setAddress(tfaddress.getText());
					String msg = mc.update(m);
					JOptionPane.showMessageDialog(UpdatePanel.this, msg);
					
				}
			});
			btnNewButton_1.setBounds(82, 217, 71, 27);
		}
		return btnNewButton_1;
	}
}
