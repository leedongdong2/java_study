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
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ServerFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField tfServerIP;
	private JLabel lblNewLabel_1;
	private JTextField tfPort;
	private JButton btnStart;
	private JButton btnStop;
	private JScrollPane scrollPane;
	private JList list;
	private JLabel lblNewLabel_2;
	private JScrollPane scrollPane_1;
	private JTextPane textPane;
	private JLabel lblNewLabel_3;
	private JTextField tfMsg;
	private JButton btnSand;

	/**
	 * Launch the application.
	 */
	
	ServerController sc;
	
	HTMLEditorKit editorKit;
	HTMLDocument document;
	StyleSheet styleSheet;
// j리스트ui에 데이터를 집어넣는 놈
	DefaultListModel<String> listModel = new DefaultListModel<String>();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerFrame frame = new ServerFrame();
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
	public ServerFrame() {
		setTitle("\uCC44\uD305\uC11C\uBC84");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getTfServerIP());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getTfPort());
		contentPane.add(getBtnStart());
		contentPane.add(getBtnStop());
		contentPane.add(getScrollPane());
		contentPane.add(getScrollPane_1());
		contentPane.add(getTfMsg());
		contentPane.add(getBtnSand());
		try {
		InetAddress ia = InetAddress.getLocalHost();
		tfServerIP.setText(ia.getHostAddress());
		
		editorKit = new HTMLEditorKit();
		styleSheet = new StyleSheet();
		
		styleSheet.addRule("div {border:1px solid #0000ff;padding:5px;width:80%;margin-bottom:10px;}");
		styleSheet.addRule(".left{color:#ff0000;text-align:left;border:1px solid #ff0000}");
		styleSheet.addRule(".right{color:#0000ff;text-align:right;border:1px solid #0000ff}");
		
		editorKit.setStyleSheet(styleSheet);
		document = (HTMLDocument) editorKit.createDefaultDocument();
		
		textPane.setEditorKit(editorKit);
		textPane.setDocument(document);
		
		
		}       
		catch(Exception e) {
		   e.printStackTrace();
		   String msg = ("<font color='red'>IP주소를 가져오는데 오류가 났습니다");
		   Element root = document.getRootElements()[0];
		   Element element = root.getElement(0);
		   try {
			   document.insertBeforeEnd(element, msg);
			   textPane.setCaretPosition(document.getLength());
		   }catch(Exception ex2) {
			   ex2.printStackTrace();
		   }
		
		
		}
	
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Sever IP");
			lblNewLabel.setBounds(27, 24, 47, 20);
		}
		return lblNewLabel;
	}
	public JTextField getTfServerIP() {
		if (tfServerIP == null) {
			tfServerIP = new JTextField();
			tfServerIP.setBounds(83, 24, 90, 21);
			tfServerIP.setColumns(10);
		}
		return tfServerIP;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Port");
			lblNewLabel_1.setBounds(178, 27, 28, 15);
		}
		return lblNewLabel_1;
	}
	public JTextField getTfPort() {
		if (tfPort == null) {
			tfPort = new JTextField();
			tfPort.setText("4545");
			tfPort.setBounds(207, 24, 56, 21);
			tfPort.setColumns(10);
		}
		return tfPort;
	}
	public JButton getBtnStart() {
		if (btnStart == null) {
			btnStart = new JButton("\uC11C\uBC84\uC2DC\uC791");
			btnStart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sc = new ServerController(ServerFrame.this);
					Thread t = new Thread(sc);
					t.start();//스레드를 시작
					
					getBtnStop().setEnabled(true);
					getBtnSand().setEnabled(true);
					getBtnStart().setEnabled(false);
				}
			});
			btnStart.setBounds(284, 23, 91, 23);
		}
		return btnStart;
	}
	public JButton getBtnStop() {
		if (btnStop == null) {
			btnStop = new JButton("\uC11C\uBC84\uC885\uB8CC");
			btnStop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sc.serverStop();
					btnStop.setEnabled(false);
					btnSand.setEnabled(false);
					btnStart.setEnabled(true);
				}
			});
			btnStop.setEnabled(false);
			btnStop.setBounds(382, 23, 90, 23);
		}
		return btnStop;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(27, 66, 128, 200);
			scrollPane.setViewportView(getList());
			scrollPane.setColumnHeaderView(getLblNewLabel_2());
		}
		return scrollPane;
	}
	public JList getList() {
		if (list == null) {
			list = new JList();
		}
		return list;
	}
	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC811\uC18D\uC790\uBAA9\uB85D");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_2;
	}
	public JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(170, 66, 302, 200);
			scrollPane_1.setViewportView(getTextPane());
			scrollPane_1.setColumnHeaderView(getLblNewLabel_3());
		}
		return scrollPane_1;
	}
	public JTextPane getTextPane() {
		if (textPane == null) {
			textPane = new JTextPane();
			textPane.setContentType("text/html");
		    
			
		
		}
		return textPane;
	}
	public JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uBA54\uC138\uC9C0");
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_3;
	}
	public JTextField getTfMsg() {
		if (tfMsg == null) {
			tfMsg = new JTextField();
			tfMsg.setBounds(27, 276, 325, 23);
			tfMsg.setColumns(10);
		}
		return tfMsg;
	}
	public JButton getBtnSand() {
		if (btnSand == null) {
			btnSand = new JButton("\uC804\uC1A1");
			btnSand.setEnabled(false);
			btnSand.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//서버가 클라이언트에게 메시지를 전송하는 기능
					
					String msg = tfMsg.getText();
					Data data = new Data();
					data.setId("server");
					data.setMsg(msg);
					data.setCommand("msg");
					sc.sendAll(data);
					tfMsg.setText("");
					
				}
			});
			btnSand.setBounds(375, 276, 97, 23);
		}
		return btnSand;
	}
}
