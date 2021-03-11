package section11;

import java.util.ArrayList;
import java.util.List;

public class MemberController {		
   public static List<Member> members = new ArrayList<Member>();
  
   public String append(Member m) {
	   String msg = "�����Ͱ� ���������� ����Ǿ����ϴ�";
	   try {
	   members.add(m);
	   }catch(Exception ex) {
		   ex.printStackTrace();//�����ڸ����� �޽���
		   msg = "������ ������ �����߻�";// ����ڸ� ���� �޽���
	   }
	   return msg;
   }
   
   public String update(Member m) {
	   String msg = "�����Ͱ� ���������� �����Ǿ����ϴ�";
	   try {
	   for(int index=0;index<members.size();index++) {
		   // ��� ������Ÿ���� ���� target �� ���������Ʈ�� �ִ� ��� ������ ���Խ�Ų��
		   Member target = members.get(index);
		   // Ÿ�� ������ ���̵��  �Էµ� �Ű����� m�� ���̵� ���ٸ�
		   if(target.getId().equals(m.getId())) {
			   // ���������Ʈ�� �ִ� �ε����� �����Ѵ�.
			   members.set(index, m);
			   break;
		   }
	   }
	   }catch(Exception ex) {
		   ex.printStackTrace();
		   msg = "������ ������ �����߻�";
	   }
	   return msg;
   }
   
   public String delete(Member m) {
	   String msg = "�����Ͱ� ���������� ���������ϴ�";
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
		   msg = "������ ������ �����ϴ�";
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
