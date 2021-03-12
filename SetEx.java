package section11;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class SetEx {
     //생성자 
	SetEx(){
		//중복 x,순서 x
		Set<Integer> set = new HashSet<Integer>();
		
		set.add(10);
		set.add(20);
		set.add(30);
		set.add(40);
		set.add(50);
		
		set.add(10);
		set.add(20);
		//출력하기 위해서는 Iterator를 생성해야한다
		System.out.println(set);
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		//set 구조를 사용한 중복되지 않는 번호 6개를 추출해보자
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
	
	//저장된 객체 출력
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
