package Object_orientde_Programming1;

public class Object_Exam7_1 {
//1~10까지의 숫자가 적힌 카드 한쌍을 만들고 1,3,8일경우엔 뒤에 광을 붙이시오
//섯다덱 클래스의 shuffle, pick(int i),pick()-random,메서드를 추가하고 테스트하시오
//
	public static void main(String[] args) {
		SutdaDeck deck = new SutdaDeck();

		for(int i=0;i<deck.cards.length;i++) {
			System.out.print(deck.cards[i]+",");
		}
		System.out.println();
		System.out.println(deck.pick(2));
		System.out.println(deck.pick());
        deck.shuffle();        
        for(int i=0;i<deck.cards.length;i++) {
			System.out.print(deck.cards[i].toString()+",");
		}
        System.out.println();
		System.out.println(deck.pick(2));
		System.out.println(deck.pick());
        
	}

}

class SutdaDeck{
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];
	
	
	SutdaDeck() {
		for(int i =0;i<cards.length;i++) {
			boolean isKwang = false;
			int num = (i%10)+1;
			if(num<10&&(num==1||num==3||num==8)) {
		         isKwang=true;
			}
			cards[i]= new SutdaCard(num,isKwang);
			cards[i].toString();
		}
		
	}
	
	void shuffle() {
	 
		for(int i=0;i<cards.length*2;i++) {
			int tmp = (int)(Math.random()*cards.length);
			int tmp2 = (int)(Math.random()*cards.length);
	        SutdaCard save = cards[tmp];
	        cards[tmp] = cards[tmp2];
	        cards[tmp2] = save;
	
		}
	}
	SutdaCard pick (int index) {
	return cards[index]; 	
	}
	
	SutdaCard pick() {
		int i = (int)(Math.random()*cards.length);
		
		return cards[i];
	}
	
}

class SutdaCard{
	int num;
	boolean isKwang;
	
	SutdaCard(){
		this(1,true);
	}
	
	SutdaCard(int num, boolean isKwang){
		this.num = num;
		this.isKwang = isKwang;
	}
	
	public String toString() {
		return num + (isKwang ? "K":""); 
	}
}