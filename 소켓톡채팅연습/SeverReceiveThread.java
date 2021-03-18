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

//�����带 ����ҋ��� �����带 ���� ��� �޴°ź��� �����̺� �������̽��� �޾Ƽ� ���°�����
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
			//����Ÿ ���� ����
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			send = new BufferedWriter(osw);
			
			//����Ÿ �ޱ� �۽�
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
				//����� �����͸� �޴´�  ���ŷ���� ������ �ʼ� 
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
