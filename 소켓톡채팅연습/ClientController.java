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




BufferedWriter send;//데이터를 전송
BufferedReader receive;//데이터를 수신

Element root;
Element element;

public ClientController(ClientFrame cf){
	this.cf = cf;
  String ip = cf.getTfServerIP().getText();
  String port = cf.getTfPort().getText();
  String msg;
  try {
  Socket socket = new Socket(ip,Integer.parseInt(port));
  //장치 송신 Writer 정석 순서
  //input 보다 output을 항상 먼저함
  OutputStream os = socket.getOutputStream();//장치명으로 아웃스프림
  //스트림은 바이트 기반으로 한글 문자기반 스트림을 만들기위함
  OutputStreamWriter ow = new OutputStreamWriter(os);// 아웃스프림 라이터
  //속도업
  send = new BufferedWriter(ow);//라이터로 퍼버
  //장치 수신 Input 정석 순서
  InputStream is = socket.getInputStream();
  //스트림은 바이트 기반으로 한글 문자기반 스트림을 만들기위함
  InputStreamReader isr = new InputStreamReader(is);
  //속도업
  receive = new BufferedReader(isr);
  
  sendMsg("<div>박원기님이 접속하셧습니다.</div>");

  
  }catch(Exception e) {
	  e.printStackTrace();
	  msg = "<font color='red'>서버 접속중 오류가 낫습니다</font>";
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
