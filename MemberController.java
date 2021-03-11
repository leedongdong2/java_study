package section11;

import java.util.ArrayList;
import java.util.List;

public class MemberController {		
   public static List<Member> members = new ArrayList<Member>();
  
   public String append(Member m) {
	   String msg = "데이터가 정상적으로 저장되었습니다";
	   try {
	   members.add(m);
	   }catch(Exception ex) {
		   ex.printStackTrace();//개발자를위한 메시지
		   msg = "데이터 저장중 오류발생";// 사용자를 위한 메시지
	   }
	   return msg;
   }
   
   public String update(Member m) {
	   String msg = "데이터가 정삭적으로 수정되었습니다";
	   try {
	   for(int index=0;index<members.size();index++) {
		   // 멤버 데이터타입의 변수 target 에 멤버스리스트에 있는 멤버 값들을 대입시킨다
		   Member target = members.get(index);
		   // 타겟 변수의 아이디와  입력된 매개변수 m의 아이디가 같다면
		   if(target.getId().equals(m.getId())) {
			   // 멤버스리스트의 있는 인덱스를 수정한다.
			   members.set(index, m);
			   break;
		   }
	   }
	   }catch(Exception ex) {
		   ex.printStackTrace();
		   msg = "데이터 수정중 오류발생";
	   }
	   return msg;
   }
   
   public String delete(Member m) {
	   String msg = "데이터가 정상적으로 지워졌습니다";
	   try {
	   for(int index=members.size()-1;index>=0;index--) {
		   Member target = members.get(index);
		   if(target.getId().equals(m.getId())) {
			   members.remove(index);
			   break;
		   }
	   }
	   }catch(Exception ex) {
		   ex.printStackTrace();
		   msg = "삭제중 오류가 났습니다";
	   }
	   return msg;
   }
   
   public List<Member> search(String findstr) {
	  List<Member> returnList = new ArrayList<Member>();
	  for(int index=0;index<members.size();index++){
		  Member target = members.get(index);
		  if  (target.getId().indexOf(findstr)>-1||
		     target.getIrum().indexOf(findstr)>-1||
		    target.getPhone().indexOf(findstr)>-1||
		  target.getAddress().indexOf(findstr)>-1) {
	                 returnList.add(target);		  
		  }
	  }
	   
	   return returnList;
   }
}
