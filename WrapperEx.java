package section9;

import java.util.*;

public class WrapperEx {
// Integer autoBox(), int autoUnBox()�޼��� �߰�
  public Integer IntegerAutoBox() {
	  int a = 10;
	   return a;
	  // �����̵Ǿ� �ڵ����� ��ü ��Ƽ���� ��ȯ�� ��ȯ�ȴ�
	  // return new Integer(a);
  }
  public int AutoUnBox() {
	Integer i = new Integer(10);  
	 return i;
	 // ��������� �Ǿ� �ڵ����� ��Ʈ�� ��ȯ�� ��ȯ�ȴ�
	 // return int i 
  }
  
  public List getList() {
	List<Integer> abc = new ArrayList<Integer>();
	  abc.add(10);
	  return abc;
	  
  }
}
