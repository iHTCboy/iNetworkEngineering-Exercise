public class Circle {

	public static double pi;
	public static int sum;
	private double rad;
	
	Circle(double P,int S,double r)
	{
		pi=P;
		sum=S;
		rad=r;
	}
	
	static void szpi()
	{
		System.out.println("圆周率为："+pi);
	}
	static void yuan()
	{
		System.out.println("圆个数为："+sum);
	}
	void bj()
	{
		System.out.println("圆半径为："+rad);
	}
	
	public static void main(String[] args) {
		Circle t=new Circle(3.14,5,2.7);
		Circle.szpi();
		Circle.yuan();
		t.bj();

	}

}
