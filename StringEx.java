package section9;


public class StringEx {
			
	
	String s1;
	String s2;
	String s3;
	String s4;
	
   public StringEx() {
	   s1 = "�ڿ���";
	   s2 = "�ڿ���";
	   
	   s3 = new String("ȫ�浿");
	   s4 = new String("ȫ�浿");
	   
	   boolean b = false;
		if(s1==s2) {
			b = true;
			System.out.println(b+"1");
		}
		if(s1.equals(s2)) {
			b = true;
			System.out.println(b+"2");
		}
		if(s3==s4) {
			b = true;
			System.out.println(b+"3");
		}
		if(s3.equals(s4)) {
			b = true;
			System.out.println(b+"4");
		}
   }

   

}
