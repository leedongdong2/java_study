package section9;

import java.text.DecimalFormat;

public class FormatEx {
	public FormatEx() {
		//format ����               
		String s1 = String.format("%d��%c�����Դϴ�.\n", 100,'a');
		System.out.println(s1);
		
		String s2 = String.format("%10.2f", 123.1234567);
		System.out.println("["+s2+"]");
		
		String name = "�ڿ���";
		String nicname ="ȫ�浿";
		String fmt = String.format("'%s'�� ������'%s'�Դϴ�",name,nicname);
		System.out.println(fmt);
		
		//format���ڿ��� ����Ͽ� ������ ���
		int dan=2;
		String rst;
		String frm2 = "%d * %d = %d";
		for(int i=1; i<10;i++) {
		  rst = String.format(frm2, dan,i,(dan*i));
		  System.out.println(rst);
		}
		// decimalFormat ����
		// ���ڿ� õ���� �и���ȣ�� �ٿ� ����ϱ�
		double value=1234567.899023;
		String pattern = "###,###.###"; //����
		//�Ҽ�����3�ڸ��� �Ѵ´ٸ� �ڵ����� �ݿø� �ȴ� #���0�� ������ ���� �ڸ����� 0���� ä����
		DecimalFormat d =new DecimalFormat(pattern);
		//���ֱ�
		System.out.println(d.format(value));
		
	}
	
	public static void main(String[] args) {
		new FormatEx();
		
	}
}
