package section9;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class PatternEx {
	
	public void numcheck(String data) {
    String reg = "[0-9]*";
    Pattern p = Pattern.compile(reg);
    Matcher m = p.matcher(data);
    if(m.matches()) {
    	System.out.println(data+"´Â"+reg+"¿¡ ÇÕ´çÇÔ");
    }else {
    	System.out.println(data +"ºÎÀûÀıÇÑµ¥ÀÌÅÍÀÓ.");
    }
	}
	
	public void alphacheck(String data) {
		String reg = "[a-zA-Z]*";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(data);
		if(m.matches()) {
			System.out.println(data+"´Â"+reg+"¿¡ ÇÕ´ç");
		}else {
			System.out.println(data+"ºÎÀûÀıµ¥ÀÌÅ¸");
		}
	}
//»ç¿ë°¡´É ¾ÆÀÌµğ ÆĞ½º¿öµå Ã¼Å©ÇÏ±â	
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
			System.out.println("»ç¿ë°¡´ÉÇÑ¾ÆÀÌµğÀÔ´Ï´Ù");
		}else {
			 System.out.println("¤¤¤¤");
		}
		
		if(pwdB) {
	    System.out.println("»ç¿ë°¡´ÉÇÑ¾ÆÀÌµğÀÔ´Ï´Ù");		
		}else {
			System.out.println("¤¤¤¤");
		}	
	}
	// Æù À¯¼±ÀüÈ­¹øÈ£Ã¼Å©ÇÏ±â
	public boolean phoneCheck(String phone) {
		boolean b = false;
		String reg = "0[\\d]{2,3}-\\d{3,4}-\\d{4}";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(phone);
		b = m.matches();
		
		return b;
	}
//ÀÌ¸ŞÀÏ Ã¼Å©ÇÏ±â
	public boolean emailCheck(String email) {
		boolean b = false;
		String reg = "^[a-zA-z]+[\\w]+@[a-zA-Z]+(\\.[a-zA-Z_]+){1,3}$";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(email);
		b = m.matches();
		return b;
	}
// ÇÑ±ÛÃ¼Å©ÇÏ±â
	public boolean hangulCheck(String name){
		boolean b = false;
		Pattern p = Pattern.compile("[°¡-ÆR]*");
		Matcher m = p.matcher(name);
		b = m.matches();
		return b;
	}
	
}
