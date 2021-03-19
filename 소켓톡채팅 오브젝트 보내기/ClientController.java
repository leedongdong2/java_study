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
import java.util.Arrays;
import java.util.List;

import javax.swing.text.Element;
import javax.swing.text.StyledDocument;

public class ClientController implements Runnable{
ClientFrame cf;




ObjectOutputStream oos;// ��ü�ƿ�ǲ ����
ObjectInputStream ois; //  ��ü��ǲ �۽�

Element root;
Element element;

boolean threadFlag = true;

public ClientController(ClientFrame cf){
	this.cf = cf;
  String ip = cf.getTfServerIP().getText();
  String port = cf.getTfPort().getText();
  String msg;
  try {
  Socket socket = new Socket(ip,Integer.parseInt(port));

  OutputStream os = socket.getOutputStream();//��ġ������ �ƿ�������
  oos = new ObjectOutputStream(os);
  

  InputStream is = socket.getInputStream();
  ois = new ObjectInputStream(is);
  
	root = cf.document.getRootElements()[0];
	element = root.getElement(0);
	
  Data data = new Data();
  data.setId(cf.getTfId().getText());
  data.setCommand("login");
  data.setMsg(data.getId()+"�α����Ͽ����ϴ�");
  sendMsg(data);

  
  }catch(Exception e) {
	  e.printStackTrace();
	  msg = "<font color='red'>���� ������ ������ �����ϴ�</font>";
	  cf.getTextPane().setText(msg);
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

@Override
public void run() {
	while(threadFlag) {
		try {
			Data data = (Data)ois.readObject();
			
			
			switch(data.getCommand()) {
			case "login":
				//�ڽ��� �α����� ���� �ٸ������� �α����� ��� �и�
				if(data.getId().equals(cf.getTfId().getText())) {
					
				   List users = Arrays.asList(data.getUsers());
				   cf.listModel.addAll(users);
				  cf.getList().setModel(cf.listModel);
					
				} else {
					
				cf.listModel.addElement(data.getId());
				cf.getList().setModel(cf.listModel);
				
				}
				break;
			case "logout":
				cf.listModel.removeElement(data.getId());
				cf.getList().setModel(cf.listModel);
				if(data.getId().equals(cf.getTfId().getText())) {
					threadFlag = false;
					ois.close();
					oos.close();
				}
				
			case "shutdown":
				threadFlag = false;
				ois.close();
				oos.close();
				break;
			}
			
			
			
			
			String msg = "";
			if(data.getId().equals(cf.getTfId().getText())) {
				msg = String.format("<div class='%s'><b>%s : </b><br/>%s</div>","right",data.getId(),data.getMsg());
			}else {
				msg = String.format("<div class='%s'><b>%s : </b><br/>%s</div>","dd",data.getId(),data.getMsg());
			}
			
			cf.document.insertBeforeEnd(element,msg);
			cf.getTextPane().setCaretPosition(cf.document.getLength());
	
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
}

public void disConnect() {
	Data data = new Data();
	data.setId(cf.getTfId().getText());
	data.setCommand("logout");
	data.setMsg("����������~");
	try {
	oos.writeObject(data);
	oos.flush();
	}catch(Exception ex) {
		ex.printStackTrace();
	}
}
	
}
