package section9;

import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

public class TokenEx {
	String str;
	String delim;
	boolean add;
	
	public TokenEx(String str,String delim){
	this.str = str;
	this.delim = delim;	
	}
	
	public TokenEx(String str,String delim,boolean add){
		this.str = str;
		this.delim = delim;
		this.add = add;
	}
	
	public List<String> getToken() {
        StringTokenizer st = new StringTokenizer(this.str,this.delim);
        List<String> list = new Vector();
        
        while(st.hasMoreElements()) {
        	String t = st.nextToken();
        	list.add(t);
        	System.out.println(t);
        }
        
		return list;
	}
	
	public List<String> getTokendelim() {
        StringTokenizer st = new StringTokenizer(this.str,this.delim,this.add);
        List<String> list = new Vector();
        
        while(st.hasMoreElements()) {
        	String t = st.nextToken();
        	list.add(t);
        	System.out.println(t);
        }
        
		return list;
	}
	
	public void spilt(String str,String delim) {
		String[] r = str.split(delim);
        for(String a : r) {
        	System.out.println(a);
        }
	}
	
	
}
