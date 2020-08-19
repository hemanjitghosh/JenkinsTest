package Practice;

public class PAlindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name="Nitin";
		String revstr="";
		
		for(int i=name.length()-1;i>0;i--)
		{
			revstr=revstr+name.charAt(i);
		}
		
		System.out.println("Revtr value is" +revstr );
		if(revstr.equalsIgnoreCase(name))
		{
			System.out.println("PAlindrome");
		}
		else
		{
			System.out.println("Not a palindrome");
		}
		
	}

}
