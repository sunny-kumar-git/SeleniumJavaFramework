
public class ADD extends A {
	int num1;
	int num2;
	public ADD() {
		this(10,10);
	}
	public ADD(int a, int b) {
		super(10, 5);
		num1=a;
		num2=b;
	}
	void sum(){
		System.out.println(num1+num2);//20
	}
	
	

}
