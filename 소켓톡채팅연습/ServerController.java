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
		msg = "<font color='blue'>서버가 시작되었습니다</font>";
		
		root = sf.document.getRootElements()[0];
		element = root.getElement(0);
		
		sf.document.insertBeforeEnd(element, msg);
		sf.getTextPane().setCaretPosition(sf.document.getLength());
			
		
		
		sf.getBtnStop().setEnabled(true);
		sf.getBtnStart().setEnabled(false);
		} catch(Exception e) {
			e.printStackTrace();
			msg ="<font color='red'>서버시작중 오류발생</font>";
			
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
			  //소켓연결
			  Socket socket = serverSocket.accept();
			  String msg = ("<div class='left'>새로운클라이언트가 접속하셧습니다</div>");
			  sf.document.insertBeforeEnd(element, msg);
			  sf.getTextPane().setCaretPosition(sf.document.getLength());
			  
			  
			  SeverReceiveThread srt = new SeverReceiveThread(sf, socket,ServerController.this);
			  Thread t = new Thread(srt);
			  t.start();
			  
			  clients.add(srt);
			  
		  }catch(Exception ex) {
			  ex.printStackTrace();
			  String msg = "<font color='red'>클라이언트 접속중 오류발생";
			  try {
			  sf.document.insertBeforeEnd(element, msg);
			  }catch(Exception e) {
				  e.printStackTrace();
			  }
			  sf.getTextPane().setCaretPosition(sf.document.getLength());
		  }
		  
		  
		  
	  }
	}
	
	// 접속되어있는 모든 클라이언트에게 메시지를 전송
	public void sendAll(String msg) {
		for(SeverReceiveThread srt : clients) {
			srt.sendMsg(msg);
		}
		
	}
}
