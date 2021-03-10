package section9;

import java.text.DecimalFormat;

public class FormatEx {
	public FormatEx() {
		//format 사용법               
		String s1 = String.format("%d는%c학점입니다.\n", 100,'a');
		System.out.println(s1);
		
		String s2 = String.format("%10.2f", 123.1234567);
		System.out.println("["+s2+"]");
		
		String name = "박원기";
		String nicname ="홍길동";
		String fmt = String.format("'%s'의 별명은'%s'입니다",name,nicname);
		System.out.println(fmt);
		
		//format문자열을 사용하여 구구단 출력
		int dan=2;
		String rst;
		String frm2 = "%d * %d = %d";
		for(int i=1; i<10;i++) {
		  rst = String.format(frm2, dan,i,(dan*i));
		  System.out.println(rst);
		}
		// decimalFormat 사용법
		// 숫자에 천단위 분리기호를 붙여 출력하기
		double value=1234567.899023;
		String pattern = "###,###.###"; //패턴
		//소수점이3자리를 넘는다면 자동으로 반올림 된다 #대신0을 넣으면 남는 자릿수가 0으로 채워짐
		DecimalFormat d =new DecimalFormat(pattern);
		//값넣기
		System.out.println(d.format(value));
		
	}
	
	public static void main(String[] args) {
		new FormatEx();
		
	}
}
