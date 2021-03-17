package Object_orientde_Programming1;

public class Object_Exam7_3 {
	public static void main(String[] agrs) {
		MyTv2 t =new MyTv2();
	   t.setChannel(5);
	   System.out.println(t.getChannel());
	}
}
class MyTv2{
	private boolean isPowerOn;
	private int channel;
	private int volume;
	
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	
	int getChannel() {
		return channel;
	}
	
	void setChannel(int i) {
		if(i<=MAX_CHANNEL&&i>=MIN_CHANNEL) {
		channel = i;
		return;
		}
		this.channel = channel;
	}
	
}