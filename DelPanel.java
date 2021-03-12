package section11;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DelPanel extends JPanel {
	Member m;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_4;
	private JTextField tfaddress;
	private JTextField tfphone;
	private JLabel lblNewLabel_3;
	private JTextField tfirum;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1;
	private JTextField tfid;
	private JButton btnNewButton;
	private JTextField tffind;
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public DelPanel() {
		setLayout(null);
		add(getBtnNewButton_1());
		add(getLblNewLabel_4());
		add(getTfaddress());
		add(getTfphone());
		add(getLblNewLabel_3());
		add(getTfirum());
		add(getLblNewLabel_2());
		add(getLblNewLabel_1());
		add(getTfid());
		add(getBtnNewButton());
		add(getTffind());
		add(getLblNewLabel());

	}
	public JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC0AD\uC81C");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			
					if(m==null) {
						JOptionPane.showMessageDialog(DelPanel.this, "먼저검색하세요");
					}else {
					MemberController mc = new MemberController();
					String msg = mc.delete(m);
					JOptionPane.showMessageDialog(DelPanel.this, msg);
					}
				}
			});
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
	public JTextField getTfaddress() {
		if (tfaddress == null) {
			tfaddress = new JTextField();
			tfaddress.setColumns(10);
			tfaddress.setBounds(81, 205, 210, 21);
		}
		return tfaddress;
	}
	public JTextField getTfphone() {
		if (tfphone == null) {
			tfphone = new JTextField();
			tfphone.setColumns(10);
			tfphone.setBounds(81, 174, 105, 21);
		}
		return tfphone;
	}
	public JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC5F0\uB77D\uCC98");
			lblNewLabel_3.setBounds(16, 177, 57, 15);
		}
		return lblNewLabel_3;
	}
	public JTextField getTfirum() {
		if (tfirum == null) {
			tfirum = new JTextField();
			tfirum.setColumns(10);
			tfirum.setBounds(81, 143, 126, 21);
		}
		return tfirum;
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
	public JTextField getTfid() {
		if (tfid == null) {
			tfid = new JTextField();
			tfid.setEditable(false);
			tfid.setColumns(10);
			tfid.setBounds(81, 112, 142, 21);
		}
		return tfid;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {	
					String id = tffind.getText();
					String msg2 = "아이디먼저 입력";
						if(id.equals("")) {
							JOptionPane.showMessageDialog(DelPanel.this, msg2);
						}
					MemberController mc = new MemberController();
					m = mc.selectOne(id);	
					String msg = "찾으시는 데이터가 없습니다";
					if(m==null) {
						JOptionPane.showMessageDialog(DelPanel.this, msg);
					}else {
						tfid.setText(m.id);
						tfirum.setText(m.irum);
						tfphone.setText(m.phone);
						tfaddress.setText(m.address);
					}
					
				}
			});
			
			btnNewButton.setBounds(140, 66, 83, 22);
		}
		return btnNewButton;
	}
	public JTextField getTffind() {
		if (tffind == null) {
			tffind = new JTextField();
			tffind.setColumns(10);
			tffind.setBounds(12, 67, 116, 21);
		}
		return tffind;
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uD68C\uC6D0\uC0AD\uC81C");
			lblNewLabel.setOpaque(true);
			lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 17));
			lblNewLabel.setBackground(SystemColor.activeCaption);
			lblNewLabel.setBounds(12, 29, 421, 28);
		}
		return lblNewLabel;
	}
}
