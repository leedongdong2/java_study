package section8;

/*public class TryExam2 {
	public static void main(String[] args) {
		TryExam2 t = new TryExam2();
       int [] score = t.score;
       t.test(score);
       t.output(score);
	}
int[] score = new int[5];


int[] test(int[] score) {
	
  try {    
	for(int i=0;i<6;i++) {
    	score[i] = i+1;
    }
	}catch(Exception e) {
		System.out.println("ũ�Ⱚ����");
	}
    return score;
}
void output(int[] score) {
	try {
	for(int i=0;i<6;i++) {
		System.out.println(score[i]);
	}
	}catch(Exception e) {
		System.out.println("ũ�Ⱚ�̳��Ŀ�");
	}
	
	int sum = 0;
	try {
	for(int i=0;i<6;i++) {
		sum = sum + score[i];
	}
	} catch (Exception e) {
		System.out.println("sum="+sum);
	    System.out.println("avg="+sum/score.length);
		System.out.println("ũ�Ⱚ ������ ũ�⸸ŭ�ǰ��� ���ϰ� ���������");
	}
}
}*/
public class TryExam2{
	int[] score;
	
	TryExam2() {
		this.score = new int[5];	
	}
	
	void test() {
	try {
		score[0] = 10;
		score[1] = 20;
		score[2] = 30;
		score[3] = 40;
		score[4] = 50;
		score[5] = 60;
	}catch(Exception ex) {
	  System.out.println("����");	
		}
	}
	
	void output() {
		int sum = 0;
		double avg = 0.0;
		for(int index=0;index<score.length;index++) {
			System.out.println(score[index]);
			sum += score[index];
		}
		avg=(double)sum/score.length;
		System.out.println("�հ�:"+ sum);
		System.out.println("���:"+ avg);
	}
public static void main(String[] a) {
	TryExam2 t = new TryExam2();
	t.test();
	t.output();
	
	
}
}


