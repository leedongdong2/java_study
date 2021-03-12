package section11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapEx {
public MapEx() {
	Map<String, Integer> map = new HashMap<String,Integer>();
	//�߰�
	map.put("kim",70);
	map.put("park", 89);
	map.put("lee", 60);
	//��ȸ
	Set<String> set = map.keySet();
	Iterator<String> iter = set.iterator();
	while(iter.hasNext()) {
		String key = iter.next();
		int value = map.get(key);
		System.out.println(key + ":"+value);
	}
	//����
	map.put("park", 80);
	System.out.println("park value:"+map.get("park"));
	//����
	map.remove("park");
	System.out.println("park value:"+map.get("park"));
}
	
	
	public static void main(String[] args) {
		new MapEx();

	}

}
