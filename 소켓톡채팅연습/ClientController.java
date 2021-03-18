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

public class ClientController implements Runnable{
ClientFrame cf;




BufferedWriter send;//�����͸� ����
BufferedReader receive;//�����͸� ����

Element root;
Element element;

public ClientController(ClientFrame cf){
	this.cf = cf;
  String ip = cf.getTfServerIP().getText();
  String port = cf.getTfPort().getText();
  String msg;
  try {
  Socket socket = new Socket(ip,Integer.parseInt(port));
  //��ġ �۽� Writer ���� ����
  //input ���� output�� �׻� ������
  OutputStream os = socket.getOutputStream();//��ġ������ �ƿ�������
  //��Ʈ���� ����Ʈ ������� �ѱ� ���ڱ�� ��Ʈ���� ���������
  OutputStreamWriter ow = new OutputStreamWriter(os);// �ƿ������� ������
  //�ӵ���
  send = new BufferedWriter(ow);//�����ͷ� �۹�
  //��ġ ���� Input ���� ����
  InputStream is = socket.getInputStream();
  //��Ʈ���� ����Ʈ ������� �ѱ� ���ڱ�� ��Ʈ���� ���������
  InputStreamReader isr = new InputStreamReader(is);
  //�ӵ���
  receive = new BufferedReader(isr);
  
  sendMsg("<div>�ڿ������ �����ϼ˽��ϴ�.</div>");

  
  }catch(Exception e) {
	  e.printStackTrace();
	  msg = "<font color='red'>���� ������ ������ �����ϴ�</font>";
	  cf.getTextPane().setText(msg);
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

@Override
public void run() {
	while(true) {
		try {
			String msg = receive.readLine();
	
			
			root = cf.document.getRootElements()[0];
			element = root.getElement(0);
			cf.document.insertBeforeEnd(element,msg);
			cf.getTextPane().setCaretPosition(cf.document.getLength());
	
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
	
}
