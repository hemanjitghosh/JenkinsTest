package Practice;

public class Prime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int number=1;
		boolean flag =false;
		
		for(int i=2;i<=number/2;i++)
		{
			if(number%i==0)
			{
				flag=true;
				break;
			}
		}
		
		if(flag==true)
		{
			System.out.println("Not PRime number");
		}
		else
		{
			System.out.println("prime number");
		}
		
		

	}

}
