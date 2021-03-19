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
		msg = "<font color='blue'>서버가 시작되었습니다</font>";
		
	
		
		sf.document.insertBeforeEnd(element, msg);
		sf.getTextPane().setCaretPosition(sf.document.getLength());
			
		
		
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
		
	  while(threadFlag) {
		  try {
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
		//1) 모든 접속자에게 서버종료 사실을전달
		Data data = new Data();
		data.setId("server");
		data.setCommand("shutdown");
		data.setMsg("서버를 종료합니다");
		
		
		//4) thread 중지 자신의 서버를 여는 화일문을 중지
				threadFlag = false;  // 화일문을 false로 바꾸고
				String ip = sf.getTfServerIP().getText();
				int port = Integer.parseInt(sf.getTfPort().getText());
				try {
					//자신을 포트로 연결하여 화일문을 한번 돌게함 
					// 화일문이 한번 돌으면 다음은 false가 되어있기 프로세스가 그대로 내려와서 종료됨
					Socket socket = new Socket(ip,port);
				} catch(Exception ex) {
					ex.printStackTrace();
				}
		
		for(SeverReceiveThread srt : clients) {
			srt.sendMsg(data); //------2) 클라이언트들에게 shutdown 메시지 전달	
			srt.threadFlag=false;//5) 클라이언트들의 ServerReceiveThread의 반복문 중지작업
		}
		
	//3)clients collection 초기화
	// 클라이언트들에게 메시지를 모두 보내고 나서 정리해야한다
		clients.clear();
		
		sf.listModel.clear();
		sf.getList().setModel(sf.listModel);
		
	}

}
