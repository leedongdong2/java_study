package section16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.text.StyledDocument;

//�����带 ����ҋ��� �����带 ���� ��� �޴°ź��� �����̺� �������̽��� �޾Ƽ� ���°�����
public class SeverReceiveThread implements Runnable{
	ServerFrame sf;
	
	BufferedWriter send;
	BufferedReader receive;
	
	SeverReceiveThread(ServerFrame sf,Socket socket){
		this.sf = sf;
		
		try {
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			send = new BufferedWriter(osw);
			
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
				String msg = receive.readLine();
				
				StyledDocument doc = sf.getTextPane().getStyledDocument();
				doc.insertString(doc.getLength(), msg, null);
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}
