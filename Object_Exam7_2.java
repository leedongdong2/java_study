package Object_orientde_Programming1;



//������ �ڵ�� �������ϸ� ������ �߻��Ѵ�. �� ������ �����ϰ� ������ �����ϱ� 
// ���ؼ��� �ڵ带 ��� �ٲپ���ϴ��� �����Ͻÿ�.

//TvŬ������ �θ�Ŭ������ Product�� �����ڸ� �̹� �ϳ� ������⋚���� �⺻�����ڰ� �ڵ����� ���������ʴ´�.
//�׷��Ƿ� new Tv�� ������쿡 Product�� �����ڰ� ��������ʾ� �θ��� �ν��Ͻ� �������� �ʱ�ȭ ���������Ƿ� �θ� ����Ҽ� ����
// Tv�� �������ʴ´�
public class Object_Exam7_2 {
    public static void main(String[] args) {
    	Tv t = new Tv();	
    }
	
             
}

class Product{
	int price;
	int bonusPoint;
	
	//Product(){}//�⺻�����ڸ� ������ش�
	
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
//�ڼ� Ŭ������ �����ڿ��� ���� Ŭ������ �����ڸ� ȣ���ؾ��ϴ� ������ �����ΰ�?
// ���� ���ǵ� �ν��Ͻ� �������� �ʱ�ȭ�ǵ��� �ϱ� ���ؼ��̴�




