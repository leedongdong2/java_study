package section16;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerController implements Runnable {
    ServerFrame sf;
    ServerSocket serverSocket;
    
	public ServerController(ServerFrame sf) {
		this.sf=sf;
		String port = sf.getTfPort().getText();
		String msg;
		try {
		serverSocket = new ServerSocket( Integer.parseInt(port) );
		msg = "<font color='blue'>서버가 시작되었습니다</font>";
		sf.getTextPane().setText(msg);
		sf.getBtnStop().setEnabled(true);
		sf.getBtnStart().setEnabled(false);
		} catch(Exception e) {
			e.printStackTrace();
			msg ="<font color='red'>서버시작중 오류발생</font>";
			sf.getTextPane().setText(msg);
			sf.getBtnStop().setEnabled(false);
			sf.getBtnStart().setEnabled(true);	
		}
		}
	
	@Override
	public void run() {
		
	  while(true) {
		  try {
			  Socket socket = serverSocket.accept();
			  sf.getTextPane().setText("새로운클라이언트가 접속하셧습니다");
			  
			  SeverReceiveThread srt = new SeverReceiveThread(sf, socket);
			  Thread t = new Thread(srt);
			  t.start();
			  
		  }catch(Exception ex) {
			  ex.printStackTrace();
			  String msg = "<font color='red'>클라이언트 접속중 오류발생";
			  sf.getTextPane().setText(msg);
		  }
		  
		  
		  
	  }
	}

}
