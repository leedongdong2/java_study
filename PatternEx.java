package section9;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class PatternEx {
	
	public void numcheck(String data) {
    String reg = "[0-9]*";
    Pattern p = Pattern.compile(reg);
    Matcher m = p.matcher(data);
    if(m.matches()) {
    	System.out.println(data+"는"+reg+"에 합당함");
    }else {
    	System.out.println(data +"부적절한데이터임.");
    }
	}
	
	public void alphacheck(String data) {
		String reg = "[a-zA-Z]*";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(data);
		if(m.matches()) {
			System.out.println(data+"는"+reg+"에 합당");
		}else {
			System.out.println(data+"부적절데이타");
		}
	}
//사용가능 아이디 패스워드 체크하기	
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
			System.out.println("사용가능한아이디입니다");
		}else {
			 System.out.println("ㄴㄴ");
		}
		
		if(pwdB) {
	    System.out.println("사용가능한아이디입니다");		
		}else {
			System.out.println("ㄴㄴ");
		}	
	}
	// 폰 유선전화번호체크하기
	public boolean phoneCheck(String phone) {
		boolean b = false;
		String reg = "0[\\d]{2,3}-\\d{3,4}-\\d{4}";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(phone);
		b = m.matches();
		
		return b;
	}
//이메일 체크하기
	public boolean emailCheck(String email) {
		boolean b = false;
		String reg = "^[a-zA-z]+[\\w]+@[a-zA-Z]+(\\.[a-zA-Z_]+){1,3}$";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(email);
		b = m.matches();
		return b;
	}
// 한글체크하기
	public boolean hangulCheck(String name){
		boolean b = false;
		Pattern p = Pattern.compile("[가-힣]*");
		Matcher m = p.matcher(name);
		b = m.matches();
		return b;
	}
	
}
