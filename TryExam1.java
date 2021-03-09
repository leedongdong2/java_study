package section8;
// �ۿ��� ���� �ִ°� �ּ� import @ ��Ű���� ��� �Ѱ��� �����ִ�
public class TryExam1 {
	// 8�� ����ó��
	// 1) ����ĳġ try ~ catch���� ����Ͽ� ���ܸ� ����ó���Ѵ�.
	// 2) throws ���� ����Ͽ� ���ܸ� �ڽ��� ȣ���� ������ �ѱ��. ����
	// 3) throw���� ����Ͽ� ���ܸ� ������ �߻���Ų��.
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
		  System.out.println("�������");
	  }
	  System.out.println("su1/su2="+d);
  }
  // ȣ��Ȱ����� ���ܸ� ��������
  void test2 () throws Exception{
	  System.out.println("test2()");
  }
 
  void test3 () {
	  System.out.println("test3()");
	  try {
		  //������ �ͼ��� ����
		  throw new Exception("���������~~");
	  }catch(Exception ex) {
		  //�޽����� �޾��ش� 
		  System.out.println(ex.getMessage());
	  }
  }
}
