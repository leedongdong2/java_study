package section9;


import java.util.List;

public class Start {

	public static void main(String[] args) {
	
	//	StringEx s = new StringEx();
		//��ü�� ���� s1.s2�� ����Ű�� �ּҰ� ����
		// new�� �Ⱥ��̸� ������ �ִ� ��Ʈ�� �ּҸ� ��Ȱ����
	    // �ν��Ͻ��� �ּҰ� �����Ƿ� ����� == ����
	//	System.out.println(System.identityHashCode(s.s1));
	//	System.out.println(System.identityHashCode(s.s2));
		//��Ʈ�� �ν��Ͻ���  ���� ����� ������ s3.s4�� ����Ű�� �ּҰ� �ٸ�
		//new�� ���̸� �ּҰ� ������ ����
		//�ּҴ� �ٸ��Ƿ� == �Ұ��� equals �ν��Ͻ��� ���ڿ� ��ü�� ������ Ȯ��
	//	System.out.println(System.identityHashCode(s.s3));
	//	System.out.println(System.identityHashCode(s.s4));
	
	//string ���ǵ� ����
    //StringSpeed ss = new StringSpeed();
	//ss.speedTest();
	
	//WrapperEx�� getList()����� ���
	WrapperEx w = new WrapperEx();
    List<Integer> a = w.getList();
    //����Ʈ�� ����մ� ��������ü 10�� ��Ʈ������ ��ڽ̵� ��µ�
    System.out.println(a);
	
    String[] data= {"123","123.5","abc","abc123","123abc",
    		      "ȫ�浿","ȫ�浿abc","ȫ�浿abc123"};
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
	p.idCheck(id,pwd); //���̵� ������ 8�ڸ��̻��̸� pass ��ȣ�� ����6�ڸ��̻� pass
	
    System.out.println("----------------------");
    String phone = "110-6351-3491";
    boolean b = p.phoneCheck(phone);
    if(b) {System.out.println("������ ����ó�Դϴ�");}
    else {System.out.println("�������Դϴ�");}
	
    System.out.println("-----------------------");
    String email = "h2pwg@naver.com.kr.kr";
    boolean c = p.emailCheck(email);
    if(c) {System.out.println("����");}
    else {System.out.println("������");}
	
	
    PatternEx nameCheck = new PatternEx();
	String[] name = {"�̵���","�̵���"};
	for(int i=0;i<name.length;i++) {
	boolean check = nameCheck.hangulCheck(name[i]);
	if(check) {
		System.out.println("�����ѱ��̸��Դϴ�");
	}else {
		System.out.println("�ѱ۷� �Է��ϼ���");
	}
	}
	}
	
	
	
	
	
	}

}
