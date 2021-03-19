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




ObjectOutputStream oos;// 객체아웃풋 수신
ObjectInputStream ois; //  객체인풋 송신

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

  OutputStream os = socket.getOutputStream();//장치명으로 아웃스프림
  oos = new ObjectOutputStream(os);
  

  InputStream is = socket.getInputStream();
  ois = new ObjectInputStream(is);
  
	root = cf.document.getRootElements()[0];
	element = root.getElement(0);
	
  Data data = new Data();
  data.setId(cf.getTfId().getText());
  data.setCommand("login");
  data.setMsg(data.getId()+"로그인하엿습니다");
  sendMsg(data);

  
  }catch(Exception e) {
	  e.printStackTrace();
	  msg = "<font color='red'>서버 접속중 오류가 낫습니다</font>";
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
				//자신이 로그인한 경우와 다른유저가 로그인한 경우 분리
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
	data.setMsg("다음에봐요~");
	try {
	oos.writeObject(data);
	oos.flush();
	}catch(Exception ex) {
		ex.printStackTrace();
	}
}
	
}
