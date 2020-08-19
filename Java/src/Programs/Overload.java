package Programs;

public class Overload {
	int sum;
	int a;
	
	Overload()
	{
		System.out.println("Default Constructor");
	}
	
	Overload(int a)
	{
		this();
		System.out.println("Overloaded constructor");
	}
	
	public  void add(int a,int b)
	{
		this.a=a;
		sum=a+b;
		System.out.println(sum);
	}
	
	public void add(int a,int b,int c)
	{
		sum=a+b+c;
		System.out.println(sum);
	}
	
	public void add(int a,double b)
	{
		double sum=a+b;
		System.out.println(sum);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Overload sum=new Overload(11);
		//sum.add(10,20);
		//sum.add(5, 4.5);
		//sum.add(10, 20,30);
		

	}

}
;