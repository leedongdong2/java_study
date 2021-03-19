package section16.objectStream;
//데이터(클래스)(객체) 송수신
import java.io.Serializable;

//직렬화 Serializable 통신에 사용되는 객체는 직렬화를 통해 정리해줘야한다

public class Data implements Serializable {
// 자바는 데이터를 송수신할떄 똑같은 클라스라도 다른 두곳에서 컴파일 하게 되면 자바는 다른클래스라고 인식하기떄문에
// serversionUID를 이용하여 시리얼넘버를 같게해 같은 클래스라고 인지하게 해준다
	
   public static final long serversionUID=10l;
	
   String id;
   String command;
   String msg;
   Object[] users;
   
public Object[] getUsers() {
	return users;
}
public void setUsers(Object[] users) {
	this.users = users;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getCommand() {
	return command;
}
public void setCommand(String command) {
	this.command = command;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
   
   
	
}
