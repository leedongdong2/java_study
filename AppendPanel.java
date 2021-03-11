package section11;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppendPanel extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField tfid;
	private JLabel lblNewLabel_2;
	private JTextField tfirum;
	private JTextField tfphone;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField tfadress;
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public AppendPanel() {
		setLayout(null);
		add(getLblNewLabel());
		add(getLblNewLabel_1());
		add(getTfid());
		add(getLblNewLabel_2());
		add(getTfirum());
		add(getTfphone());
		add(getLblNewLabel_3());
		add(getLblNewLabel_4());
		add(getTfadress());
		add(getBtnNewButton());

	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uD68C\uC6D0\uCD94\uAC00");
			lblNewLabel.setOpaque(true);
			lblNewLabel.setForeground(SystemColor.desktop);
			lblNewLabel.setBackground(Color.PINK);
			lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 14));
			lblNewLabel.setBounds(0, 10, 379, 28);
		}
		return lblNewLabel;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
			lblNewLabel_1.setBounds(12, 48, 53, 15);
		}
		return lblNewLabel_1;
	}
	public JTextField getTfid() {
		if (tfid == null) {
			tfid = new JTextField();
			tfid.setBounds(77, 45, 142, 21);
			tfid.setColumns(10);
		}
		return tfid;
	}
	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC774\uB984");
			lblNewLabel_2.setBounds(12, 73, 35, 27);
		}
		return lblNewLabel_2;
	}
	public JTextField getTfirum() {
		if (tfirum == null) {
			tfirum = new JTextField();
			tfirum.setBounds(77, 76, 126, 21);
			tfirum.setColumns(10);
		}
		return tfirum;
	}
	public JTextField getTfphone() {
		if (tfphone == null) {
			tfphone = new JTextField();
			tfphone.setBounds(77, 107, 105, 21);
			tfphone.setColumns(10);
		}
		return tfphone;
	}
	public JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC5F0\uB77D\uCC98");
			lblNewLabel_3.setBounds(12, 110, 57, 15);
		}
		return lblNewLabel_3;
	}
	public JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uC8FC\uC18C");
			lblNewLabel_4.setBounds(8, 141, 57, 15);
		}
		return lblNewLabel_4;
	}
	public JTextField getTfadress() {
		if (tfadress == null) {
			tfadress = new JTextField();
			tfadress.setBounds(77, 138, 210, 21);
			tfadress.setColumns(10);
		}
		return tfadress;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC800\uC7A5");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String mId = tfid.getText();
					String mIrum = tfirum.getText();
					String mPhone = tfphone.getText();
					String maddress =  tfphone.getText();
					
					Member m = new Member(mId,mIrum,mPhone,maddress);
					MemberController mc = new MemberController();
					String msg = mc.append(m);
					JOptionPane.showMessageDialog(AppendPanel.this,msg);
					
					
					//System.out.println(mId);
					//System.out.println(mIrum);
					//System.out.println(mPhone);
					//System.out.println(maddress);
				}
			});
			btnNewButton.setBounds(287, 175, 71, 27);
		}
		return btnNewButton;
	}
}
