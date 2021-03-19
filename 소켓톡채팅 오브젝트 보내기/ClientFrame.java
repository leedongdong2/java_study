package section16.objectStream;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.net.InetAddress;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Element;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClientFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblIp;
	private JTextField tfServerIP;
	private JTextField tfPort;
	private JLabel lblNewLabel_1;
	private JTextField tfMsg;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton btnConnect;
	private JButton btnDisConnect;
	private JButton btnSend;
    private JTextPane textPane;
    
    ClientController cc;
    
    HTMLEditorKit editorKit;
	HTMLDocument document;
	StyleSheet styleSheet;
	private JLabel lblNewLabel;
	private JTextField tfId;
	
	DefaultListModel<String> listModel = new DefaultListModel<String>();
	private JList list;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientFrame frame = new ClientFrame();
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
	
	public ClientFrame() {
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				disConnect();
			}
		});
		setTitle("\uC0AC\uC6A9\uC790");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblIp());
		contentPane.add(getTfServerIP());
		contentPane.add(getTfPort());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getTfMsg());
		contentPane.add(getScrollPane());
		contentPane.add(getScrollPane_1());
		contentPane.add(getBtnConnect());
		contentPane.add(getBtnDisConnect());
		contentPane.add(getBtnSend());
		try {
			InetAddress ia = InetAddress.getLocalHost();
			tfServerIP.setText(ia.getHostAddress());
			
			editorKit = new HTMLEditorKit();
			styleSheet = new StyleSheet();
			
			styleSheet.addRule("div {border:1px solid #0000ff;padding:5px;width:80%;margin-bottom:10px;}");
	          
			styleSheet.addRule(".left{color:#ff0000;text-align:left;border:1px solid #ff0000}");
			styleSheet.addRule(".right{color:#0000ff;text-align:right;border:1px solid #0000ff}");
			styleSheet.addRule(".dd{color:#000000}");
			
			editorKit.setStyleSheet(styleSheet);
			document = (HTMLDocument) editorKit.createDefaultDocument();
			
			textPane.setEditorKit(editorKit);
			textPane.setDocument(document);
			contentPane.add(getLblNewLabel());
			contentPane.add(getTfId());
			
			}       
			catch(Exception e) {
			   e.printStackTrace();
			   String msg = ("<font color='red'>IP주소를 가져오는데 오류가 났습니다");
			   Element root = document.getRootElements()[0];
			   Element element = root.getElement(0);
			   try {
			   document.insertBeforeEnd(element, msg);
			   }catch(Exception e1) {
				   e1.printStackTrace();
			   }
			   textPane.setCaretPosition(document.getLength());
			}
	}
	
	public void disConnect() {
		cc.disConnect();
		//2) 접속자 목록 초기화
		listModel.clear();
		getList().setModel(listModel);
		//3)버튼 상태처리
		btnConnect.setEnabled(true);
		btnDisConnect.setEnabled(false);
		btnSend.setEnabled(false);
	}

	public JLabel getLblIp() {
		if (lblIp == null) {
			lblIp = new JLabel("IP");
			lblIp.setBounds(12, 24, 47, 20);
		}
		return lblIp;
	}
	public JTextField getTfServerIP() {
		if (tfServerIP == null) {
			tfServerIP = new JTextField();
			tfServerIP.setColumns(10);
			tfServerIP.setBounds(32, 24, 74, 21);
		}
		return tfServerIP;
	}
	public JTextField getTfPort() {
		if (tfPort == null) {
			tfPort = new JTextField();
			tfPort.setText("4545");
			tfPort.setColumns(10);
			tfPort.setBounds(147, 24, 35, 21);
		}
		return tfPort;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Port");
			lblNewLabel_1.setBounds(118, 27, 28, 15);
		}
		return lblNewLabel_1;
	}
	public JTextField getTfMsg() {
		if (tfMsg == null) {
			tfMsg = new JTextField();
			tfMsg.setColumns(10);
			tfMsg.setBounds(27, 278, 325, 23);
		}
		return tfMsg;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(27, 68, 128, 200);
			scrollPane.setColumnHeaderView(getLblNewLabel_2());
			scrollPane.setViewportView(getList());
		}
		return scrollPane;
	}
	public JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(170, 68, 302, 200);
			scrollPane_1.setColumnHeaderView(getLblNewLabel_3());
			scrollPane_1.setViewportView(getTextPane());
		}
		return scrollPane_1;
	}
	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC811\uC18D\uC790");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_2;
	}
	public JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uBA54\uC2DC\uC9C0");
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_3;
	}
	public JButton getBtnConnect() {
		if (btnConnect == null) {
			btnConnect = new JButton("\uC811\uC18D");
			btnConnect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						cc = new ClientController(ClientFrame.this);
						Thread t = new Thread(cc);
						t.start();
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					btnConnect.setEnabled(false);
					btnDisConnect.setEnabled(true);
				}
			});
			btnConnect.setBounds(330, 23, 80, 23);
		}
		return btnConnect;
	}
	public JButton getBtnDisConnect() {
		if (btnDisConnect == null) {
			btnDisConnect = new JButton("\uD574\uC81C");
			btnDisConnect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					disConnect();
				}
			});
			btnDisConnect.setEnabled(false);
			btnDisConnect.setBounds(412, 23, 74, 23);
		}
		return btnDisConnect;
	}
	public JButton getBtnSend() {
		if (btnSend == null) {
			btnSend = new JButton("\uC804\uC1A1");
			btnSend.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			
				String msg = tfMsg.getText();
				Data data = new Data();	
				data.setId(tfId.getText());				
				data.setCommand("msg");				
				data.setMsg(msg);
				cc.sendMsg(data);
				tfMsg.setText("");
				}
			});
			btnSend.setBounds(375, 278, 97, 23);
		}
		return btnSend;
	}
	public JTextPane getTextPane() {
		if (textPane == null) {
			textPane = new JTextPane();
			textPane.setContentType("text/html");
		}
		return textPane;
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC544\uC774\uB514");
			lblNewLabel.setBounds(194, 27, 47, 15);
		}
		return lblNewLabel;
	}
	public JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setBounds(237, 24, 80, 21);
			tfId.setColumns(10);
		}
		return tfId;
	}
	public JList getList() {
		if (list == null) {
			list = new JList();
		}
		return list;
	}
}
