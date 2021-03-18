package section16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.text.Element;
import javax.swing.text.StyledDocument;

//쓰레드를 사용할떄는 쓰레드를 직접 상속 받는거보다 런에이블 인터페이스를 받아서 쓰는게좋다
public class SeverReceiveThread implements Runnable{
	ServerFrame sf;
	ServerController sc;
	BufferedWriter send;
	BufferedReader receive;
	
    Element root;
    Element element;
    
	SeverReceiveThread(ServerFrame sf,Socket socket,ServerController sc){
		this.sf = sf;
		this.sc = sc;
		
		try {
			//데이타 쓰기 수신
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			send = new BufferedWriter(osw);
			
			//데이타 받기 송신
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			receive = new BufferedReader(isr);
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		
		
	}
	@Override
	public void run() {
		while(true) {
			try {
				//샌드된 데이터를 받는다  블로킹으로 쓰레드 필수 
				String msg = receive.readLine();
				

				root = sf.document.getRootElements()[0];
				element = root.getElement(0);
				sf.document.insertBeforeEnd(element, msg);
				sf.getTextPane().setCaretPosition(sf.document.getLength());
				sc.sendAll(msg);
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void sendMsg(String msg) {
		try {
		send.write(msg);
		send.write("\n");
		send.flush();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}

}
