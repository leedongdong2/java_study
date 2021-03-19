package section16.objectStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.List;

import javax.swing.text.Element;
import javax.swing.text.StyledDocument;

//�����带 ����ҋ��� �����带 ���� ��� �޴°ź��� �����̺� �������̽��� �޾Ƽ� ���°�����
public class SeverReceiveThread implements Runnable{
	ServerFrame sf;
	ServerController sc;
    
	ObjectOutputStream oos;
	ObjectInputStream ois;
	
    Element root;
    Element element;
    
    boolean threadFlag = true;
    
	SeverReceiveThread(ServerFrame sf,Socket socket,ServerController sc){
		this.sf = sf;
		this.sc = sc;
		
		try {
			OutputStream os = socket.getOutputStream();
			oos = new ObjectOutputStream(os);
			
			InputStream is = socket.getInputStream();
			ois = new ObjectInputStream(is);
			
			root = sf.document.getRootElements()[0];
			element = root.getElement(0);
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		
		
	}
	@Override
	public void run() {
		while(threadFlag) {
			try {
				Data data = (Data)ois.readObject();
                  
				switch(data.getCommand()) {
				
				case "login": //���ο� ������ �߰�
					
				sf.listModel.addElement(data.getId());
				sf.getList().setModel(sf.listModel);	
				
				Object[] users = sf.listModel.toArray();
				data.setUsers(users);
				
				break;
				
				case "logout":
					//1:1Ŀ��Ʈ ��������
					threadFlag=false;
					sf.listModel.removeElement(data.getId());
					sf.getList().setModel(sf.listModel);
					// �ڽſ��� ���޵� �޽����� logout�̱� ������ clients������
					// �ڽ��� �����带 �����ؾ� ��.
					sc.clients.remove(this);
					break;
				}
				
				sc.sendAll(data);
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
		try {
			ois.close();
			oos.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
		
	}
	
	public void sendMsg(Data data) {
		try {
			
		oos.writeObject(data);
		oos.flush();
		
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}

}
