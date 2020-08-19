package Programs;

public class Swap {

	public static void main(String[] args) {

		int a=10;
		int b=20;
		
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println("Swapped variable A:" +a+  "//Swapped variable B:" +b);

	}

}
