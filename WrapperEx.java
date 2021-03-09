package section9;

import java.util.*;

public class WrapperEx {
// Integer autoBox(), int autoUnBox()메서드 추가
  public Integer IntegerAutoBox() {
	  int a = 10;
	   return a;
	  // 오토방싱되어 자동으로 객체 인티져로 변환해 반환된다
	  // return new Integer(a);
  }
  public int AutoUnBox() {
	Integer i = new Integer(10);  
	 return i;
	 // 오토언방싱이 되어 자동으로 인트로 변환해 반환된다
	 // return int i 
  }
  
  public List getList() {
	List<Integer> abc = new ArrayList<Integer>();
	  abc.add(10);
	  return abc;
	  
  }
}
