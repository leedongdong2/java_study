package section9;


import java.util.List;

public class Start {

	public static void main(String[] args) {
	
	//	StringEx s = new StringEx();
		//객체형 변수 s1.s2가 가르키는 주소가 같음
		// new를 안붙이면 기존에 있던 스트링 주소를 재활용함
	    // 인스턴스의 주소가 같으므로 관계식 == 가능
	//	System.out.println(System.identityHashCode(s.s1));
	//	System.out.println(System.identityHashCode(s.s2));
		//스트링 인스턴스를  새로 만들기 떄문에 s3.s4가 가르키는 주소가 다름
		//new를 붙이면 주소가 새로이 생성
		//주소는 다르므로 == 불가능 equals 인스턴스의 문자열 자체가 같은지 확인
	//	System.out.println(System.identityHashCode(s.s3));
	//	System.out.println(System.identityHashCode(s.s4));
	
	//string 스피드 차이
    //StringSpeed ss = new StringSpeed();
	//ss.speedTest();
	
	//WrapperEx의 getList()결과를 출력
	WrapperEx w = new WrapperEx();
    List<Integer> a = w.getList();
    //리스트에 들어잇는 정수형객체 10이 인트형으로 언박싱되 출력됨
    System.out.println(a);
	
    String[] data= {"123","123.5","abc","abc123","123abc",
    		      "홍길동","홍길동abc","홍길동abc123"};
    PatternEx p = new PatternEx();
    for(String d : data) {
    	p.numcheck(d);
    }
    System.out.println("-------------------------");
	for(int i=0;i<data.length;i++) {
		p.alphacheck(data[i]);
	}
	System.out.println("--------------------");
	String id="abcd2111";
	String pwd = "1231112323";
	p.idCheck(id,pwd); //아이디가 영숫자 8자리이상이면 pass 암호는 숫자6자리이상 pass
	
    System.out.println("----------------------");
    String phone = "110-6351-3491";
    boolean b = p.phoneCheck(phone);
    if(b) {System.out.println("정상적 연락처입니다");}
    else {System.out.println("비정상입니다");}
	
    System.out.println("-----------------------");
    String email = "h2pwg@naver.com.kr.kr";
    boolean c = p.emailCheck(email);
    if(c) {System.out.println("정상");}
    else {System.out.println("비정상");}
	
	
    PatternEx nameCheck = new PatternEx();
	String[] name = {"이동원","이동ㅓ"};
	for(int i=0;i<name.length;i++) {
	boolean check = nameCheck.hangulCheck(name[i]);
	if(check) {
		System.out.println("정상한글이름입니다");
	}else {
		System.out.println("한글로 입력하세요");
	}
	}
	}
	
	
	
	
	
	}

}
