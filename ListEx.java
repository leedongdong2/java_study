package section11;
import java.util.ArrayList;
import java.util.List;

public class ListEx {
public void type1() {//�⺻�� ������
	List<String> list = new ArrayList<String>();
	//�߰�(c)
	list.add("��");
	list.add("����");
	list.add("����");
	list.add("�ܿ�");
	//r(read, �б�,�˻�
	System.out.println(list.get(0));//��
	//u(Update,����)
	System.out.println("������ : "+ list.get(1));
	list.set(1, "���帧");
	System.out.println("������ : "+list.get(1));
	//D(Delete,����)
	list.remove(1);
	for(String r: list) {
		System.out.println(r);
	}
	
}
public void type2() {//��ü�� ������
	
}
public static void main(String[] arg) {
	ListEx ex = new ListEx();
	ex.type1();
}
}
