package section16;

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
    
	public ServerController(ServerFrame sf) {
		this.sf=sf;
		String port = sf.getTfPort().getText();
		String msg;
		clients = new ArrayList<SeverReceiveThread>();
		
		try {
		serverSocket = new ServerSocket( Integer.parseInt(port) );
		msg = "<font color='blue'>������ ���۵Ǿ����ϴ�</font>";
		
		root = sf.document.getRootElements()[0];
		element = root.getElement(0);
		
		sf.document.insertBeforeEnd(element, msg);
		sf.getTextPane().setCaretPosition(sf.document.getLength());
			
		
		
		sf.getBtnStop().setEnabled(true);
		sf.getBtnStart().setEnabled(false);
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
		
	  while(true) {
		  try {
			  //���Ͽ���
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
	public void sendAll(String msg) {
		for(SeverReceiveThread srt : clients) {
			srt.sendMsg(msg);
		}
		
	}
}
