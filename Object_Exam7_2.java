package Object_orientde_Programming1;



//다음의 코드는 컴파일하면 에러가 발생한다. 그 이유를 설명하고 에러를 수정하기 
// 위해서는 코드를 어떻게 바꾸어야하는지 설명하시오.

//Tv클래스에 부모클래스인 Product는 생성자를 이미 하나 만들었기떄문에 기본생성자가 자동으로 생성되지않는다.
//그러므로 new Tv를 햇을경우에 Product의 생성자가 실행되지않아 부모의 인스턴스 변수들이 초기화 되지않으므로 부모를 사용할수 없고
// Tv로 사용되지않는다
public class Object_Exam7_2 {
    public static void main(String[] args) {
    	Tv t = new Tv();	
    }
	
             
}

class Product{
	int price;
	int bonusPoint;
	
	//Product(){}//기본생성자를 만들어준다
	
	Product(int price){
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}
}


class Tv extends Product{
	 
	Tv() {}
	
	public String toString() {
		return "TV";
	}
}
//자손 클래스의 생성자에서 조상 클래스의 생성자를 호출해야하는 이유는 무엇인가?
// 조상에 정의된 인스턴스 변수들이 초기화되도록 하기 위해서이다




