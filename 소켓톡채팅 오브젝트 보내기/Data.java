package section16.objectStream;
//������(Ŭ����)(��ü) �ۼ���
import java.io.Serializable;

//����ȭ Serializable ��ſ� ���Ǵ� ��ü�� ����ȭ�� ���� ����������Ѵ�

public class Data implements Serializable {
// �ڹٴ� �����͸� �ۼ����ҋ� �Ȱ��� Ŭ�󽺶� �ٸ� �ΰ����� ������ �ϰ� �Ǹ� �ڹٴ� �ٸ�Ŭ������� �ν��ϱ⋚����
// serversionUID�� �̿��Ͽ� �ø���ѹ��� ������ ���� Ŭ������� �����ϰ� ���ش�
	
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
