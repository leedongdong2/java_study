package section9;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class PatternEx {
	
	public void numcheck(String data) {
    String reg = "[0-9]*";
    Pattern p = Pattern.compile(reg);
    Matcher m = p.matcher(data);
    if(m.matches()) {
    	System.out.println(data+"��"+reg+"�� �մ���");
    }else {
    	System.out.println(data +"�������ѵ�������.");
    }
	}
	
	public void alphacheck(String data) {
		String reg = "[a-zA-Z]*";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(data);
		if(m.matches()) {
			System.out.println(data+"��"+reg+"�� �մ�");
		}else {
			System.out.println(data+"����������Ÿ");
		}
	}
//��밡�� ���̵� �н����� üũ�ϱ�	
	public void idCheck(String id,String pwd) {
		String idcheck = "^[a-zA-Z0-9]{7}.+";
		String pwdcheck = "[0-9]{5}.[0-9]+";
		
		Pattern idc = Pattern.compile(idcheck);
		Matcher idM = idc.matcher(id);
		boolean idB = idM.matches();
		
		Pattern pwdc = Pattern.compile(pwdcheck);
		Matcher pwdM = pwdc.matcher(pwd);
		boolean pwdB = pwdM.matches();
		
		if(idB) {
			System.out.println("��밡���Ѿ��̵��Դϴ�");
		}else {
			 System.out.println("����");
		}
		
		if(pwdB) {
	    System.out.println("��밡���Ѿ��̵��Դϴ�");		
		}else {
			System.out.println("����");
		}	
	}
	// �� ������ȭ��ȣüũ�ϱ�
	public boolean phoneCheck(String phone) {
		boolean b = false;
		String reg = "0[\\d]{2,3}-\\d{3,4}-\\d{4}";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(phone);
		b = m.matches();
		
		return b;
	}
//�̸��� üũ�ϱ�
	public boolean emailCheck(String email) {
		boolean b = false;
		String reg = "^[a-zA-z]+[\\w]+@[a-zA-Z]+(\\.[a-zA-Z_]+){1,3}$";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(email);
		b = m.matches();
		return b;
	}
// �ѱ�üũ�ϱ�
	public boolean hangulCheck(String name){
		boolean b = false;
		Pattern p = Pattern.compile("[��-�R]*");
		Matcher m = p.matcher(name);
		b = m.matches();
		return b;
	}
	
}
