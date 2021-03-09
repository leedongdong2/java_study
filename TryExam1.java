package section8;
// 밖에다 쓸수 있는거 주석 import @ 패키지는 상단 한개만 쓸수있다
public class TryExam1 {
	// 8장 예외처리
	// 1) 직접캐치 try ~ catch절을 사용하여 예외를 직접처리한다.
	// 2) throws 절을 사용하여 예외를 자신을 호출한 곳으로 넘긴다. 던짐
	// 3) throw문을 사용하여 예외를 강제로 발생시킨다.
	public static void main(String[] arg) {
		new TryExam1();
	
	}
	TryExam1(){
	    test1(); // try ~ catch test
	    try {
			test2();  // throws test
		} catch (Exception e) {
			e.printStackTrace();
		} 
	    test3();  // throw test
	    System.out.println("tryExam1().");
	}
	
  void test1 () {
	  System.out.println("test1()");
	  int su1=100;
	  int su2=0;
	  double d = 0;
	  try {
	   d = su1/su2;
	  } catch(Exception ex) {
		  System.out.println("연산오류");
	  }
	  System.out.println("su1/su2="+d);
  }
  // 호출된곳으로 예외를 던져버림
  void test2 () throws Exception{
	  System.out.println("test2()");
  }
 
  void test3 () {
	  System.out.println("test3()");
	  try {
		  //강제로 익셉션 생성
		  throw new Exception("에러났어요~~");
	  }catch(Exception ex) {
		  //메시지를 받아준다 
		  System.out.println(ex.getMessage());
	  }
  }
}
