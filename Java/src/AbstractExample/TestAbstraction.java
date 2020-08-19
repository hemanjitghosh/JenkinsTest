package AbstractExample;

public class TestAbstraction {
	
	static void Hello()
	{
		System.out.println("Static method");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestAbstraction.Hello();
		Shape s=new Circle();
		s.draw();
		s.area();
		System.out.println(s.age);
	}

}
