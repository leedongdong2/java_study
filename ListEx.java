package section11;
import java.util.ArrayList;
import java.util.List;

public class ListEx {
public void type1() {//기본형 데이터
	List<String> list = new ArrayList<String>();
	//추가(c)
	list.add("봄");
	list.add("여름");
	list.add("가을");
	list.add("겨울");
	//r(read, 읽기,검색
	System.out.println(list.get(0));//봄
	//u(Update,수정)
	System.out.println("수정전 : "+ list.get(1));
	list.set(1, "여드름");
	System.out.println("수정후 : "+list.get(1));
	//D(Delete,삭제)
	list.remove(1);
	for(String r: list) {
		System.out.println(r);
	}
	
}
public void type2() {//객체형 데이터
	
}
public static void main(String[] arg) {
	ListEx ex = new ListEx();
	ex.type1();
}
}
