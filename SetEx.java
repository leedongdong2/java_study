package section11;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class SetEx {
     //������ 
	SetEx(){
		//�ߺ� x,���� x
		Set<Integer> set = new HashSet<Integer>();
		
		set.add(10);
		set.add(20);
		set.add(30);
		set.add(40);
		set.add(50);
		
		set.add(10);
		set.add(20);
		//����ϱ� ���ؼ��� Iterator�� �����ؾ��Ѵ�
		System.out.println(set);
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		//set ������ ����� �ߺ����� �ʴ� ��ȣ 6���� �����غ���
		Set<Integer> lotto = new HashSet<Integer>();
		Random r = new Random();
		
		while(lotto.size()<6) {
			lotto.add(r.nextInt(45)+1);
		}
		System.out.println(lotto);		
	
	
	Member m1 = new Member("hong","gil dong","010","busan");
	Member m2 = new Member("kim","gil dong","010","busan");
	Member m3 = new Member("lee","gil dong","010","busan");
	Member m4 = new Member("park","gil dong","010","busan");
	
	Set<Member> setMember = new HashSet<Member>();
	
	setMember.add(m1);
	setMember.add(m2);
	setMember.add(m3);
	setMember.add(m4);
	
	//����� ��ü ���
	Iterator<Member> show = setMember.iterator();
	while(show.hasNext()) {
    Member m = show.next();
    System.out.printf("%s[%s] phone:%s Address:%s%n",
    		m.getId(),m.getIrum(),m.getPhone(),m.getAddress());
	}
	
	}
	
	
	
	
	
	public static void main(String[] args) {
	SetEx set = new SetEx();

	}

}
