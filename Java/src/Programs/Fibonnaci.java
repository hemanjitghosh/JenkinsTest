package Programs;

public class Fibonnaci {

	public static void main(String[] args) {
		int number=5;
		int n1=0;
		int n2=1;
		
		for(int i=0;i<=number;i++)
		{
			int n3=n1+n2;
			System.out.println(n3);
			n1=n2;
			n2=n3;
			
		}
		

	}

}
