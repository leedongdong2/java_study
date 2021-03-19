package section16.objectStream;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.BadLocationException;
import javax.swing.text.Element;

public class ServerController implements Runnable {
    ServerFrame sf;
    ServerSocket serverSocket;
    List<SeverReceiveThread> clients;
    Element root;
    Element element;
    
    boolean threadFlag = true;
    
	public ServerController(ServerFrame sf) {
		this.sf=sf;
		String port = sf.getTfPort().getText();
		String msg;
		clients = new ArrayList<SeverReceiveThread>();
		root = sf.document.getRootElements()[0];
		element = root.getElement(0);
		
		try {
		serverSocket = new ServerSocket( Integer.parseInt(port) );
		msg = "<font color='blue'>������ ���۵Ǿ����ϴ�</font>";
		
	
		
		sf.document.insertBeforeEnd(element, msg);
		sf.getTextPane().setCaretPosition(sf.document.getLength());
			
		
		
		} catch(Exception e) {
			e.printStackTrace();
			msg ="<font color='red'>���������� �����߻�</font>";
			
			try {
				sf.document.insertBeforeEnd(element, msg);
			} catch (Exception e1) {
				e1.printStackTrace();
			} 
			sf.getTextPane().setCaretPosition(sf.document.getLength());
			
			sf.getBtnStop().setEnabled(false);
			sf.getBtnStart().setEnabled(true);	
		}
		}
	
	@Override
	public void run() {
		
	  while(threadFlag) {
		  try {
			  Socket socket = serverSocket.accept();
			  String msg = ("<div class='left'>���ο�Ŭ���̾�Ʈ�� �����ϼ˽��ϴ�</div>");
			  sf.document.insertBeforeEnd(element, msg);
			  sf.getTextPane().setCaretPosition(sf.document.getLength());
			  
			  
			  SeverReceiveThread srt = new SeverReceiveThread(sf, socket,ServerController.this);
			  Thread t = new Thread(srt);
			  t.start();
			  
			  clients.add(srt);
			  
		  }catch(Exception ex) {
			  ex.printStackTrace();
			  String msg = "<font color='red'>Ŭ���̾�Ʈ ������ �����߻�";
			  try {
			  sf.document.insertBeforeEnd(element, msg);
			  }catch(Exception e) {
				  e.printStackTrace();
			  }
			  sf.getTextPane().setCaretPosition(sf.document.getLength());
		  }
		  
		  
		  
	  }
	}
	
	// ���ӵǾ��ִ� ��� Ŭ���̾�Ʈ���� �޽����� ����
	public void sendAll(Data data) {
		try {
		
		for(SeverReceiveThread srt : clients) {
			srt.sendMsg(data);
		}
		
		String msg = String.format("<div class='right'>%s</div>", data.getMsg());
		sf.document.insertBeforeEnd(element, msg);
		sf.getTextPane().setCaretPosition(sf.document.getLength());
	
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		}
	
	
	public void serverStop() {
		//1) ��� �����ڿ��� �������� ���������
		Data data = new Data();
		data.setId("server");
		data.setCommand("shutdown");
		data.setMsg("������ �����մϴ�");
		
		
		//4) thread ���� �ڽ��� ������ ���� ȭ�Ϲ��� ����
				threadFlag = false;  // ȭ�Ϲ��� false�� �ٲٰ�
				String ip = sf.getTfServerIP().getText();
				int port = Integer.parseInt(sf.getTfPort().getText());
				try {
					//�ڽ��� ��Ʈ�� �����Ͽ� ȭ�Ϲ��� �ѹ� ������ 
					// ȭ�Ϲ��� �ѹ� ������ ������ false�� �Ǿ��ֱ� ���μ����� �״�� �����ͼ� �����
					Socket socket = new Socket(ip,port);
				} catch(Exception ex) {
					ex.printStackTrace();
				}
		
		for(SeverReceiveThread srt : clients) {
			srt.sendMsg(data); //------2) Ŭ���̾�Ʈ�鿡�� shutdown �޽��� ����	
			srt.threadFlag=false;//5) Ŭ���̾�Ʈ���� ServerReceiveThread�� �ݺ��� �����۾�
		}
		
	//3)clients collection �ʱ�ȭ
	// Ŭ���̾�Ʈ�鿡�� �޽����� ��� ������ ���� �����ؾ��Ѵ�
		clients.clear();
		
		sf.listModel.clear();
		sf.getList().setModel(sf.listModel);
		
	}

}
