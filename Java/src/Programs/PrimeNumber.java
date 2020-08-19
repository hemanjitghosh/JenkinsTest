package Programs;

public class PrimeNumber {

	public static void main(String[] args) {

		int number=4;
		boolean flag=false;
		
		for(int i=2;i<=number/2;i++)
		{
			if(number%i==0)
			{
				flag =true;
				break;
			}
		}
		
		if(flag==true)
			System.out.println("Not a PRime Number");
		else
			System.out.println("Prime number");

	}

}
