package Practice;

public class Fibo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int number=7;
		int n1=0;
		int n2=1;
		//int n3;
		
		for (int i=0;i<number;++i)
		{
			System.out.println(n1);
			int n3=n1+n2;
			
			n1=n2;
			n2=n3;
		}
		

	}

}
