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
		//����ƮŸ���� �迭Ÿ������ �ٲ㼭 ����غ���
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
//���ø��� ��ȿ�ǰ��� �������� ���� ��Ŀ������� ��ȿ�� ���� �Է������ʴ´�.
//��Ŀ������� �����ڰ� �������ϼ� �ִ�. ���ø��� �Ѱ� 
// ���ø��� limit�� �ɰ����� �迭�� ��(����)�� ���Ҽ� �ִ�
// ���Խ� �����ڷ� �̿��ؼ� �������� �̿밡��
}
