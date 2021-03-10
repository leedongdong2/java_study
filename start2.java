package section9;

import java.util.Arrays;
import java.util.List;

public class start2 {

	public static void main(String[] args) {
		System.out.println("--------tokens----------");
		String str = "a,.b.c.d";
		String delim = ",."
				+ "";
		TokenEx tk = new TokenEx(str,delim);
		tk.getToken();
		
		
		System.out.println("------------token+delim---------");
		TokenEx tk1 = new TokenEx(str,delim,true);
		List<String> list = tk1.getTokendelim();
		for(String s : list) {
			System.out.println(s);
		}
		Object[] aba= list.toArray();
		System.out.println(list);
		//리스트타입을 배열타입으로 바꿔서 출력해보기
		for(int i=0;i<aba.length;i++) {
			System.out.println(aba[i]);	
		}
		
		
		System.out.println("------------String split---------");
		tk1.spilt(str, delim);
		
		
		System.out.println("-------split regex ---------");
		str = "adacbd";
		delim = "[a]";
		tk1.spilt(str, delim);
	}
//스플릿은 무효의값도 공백으로 포함 토커라이즈는 무효의 값을 입력하지않는다.
//토커라이즈는 구분자가 여러개일수 있다. 스플릿은 한개 
// 스플릿은 limit로 쪼개지는 배열의 수(범위)를 정할수 있다
// 정규식 구분자로 이용해서 다중으로 이용가능
}
