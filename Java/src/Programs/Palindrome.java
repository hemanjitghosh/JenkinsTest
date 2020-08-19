package Programs;

public class Palindrome {

	public static void main(String[] args) {
		
		String name="Nitin";
		String revstr = "";
		
		System.out.println("String lenght" +name.length());
		for (int i=name.length()-1;i>=0;i--)
		{
			revstr=revstr+name.charAt(i);
			System.out.println(revstr);
		}
		
		if (name.equalsIgnoreCase(revstr))
		{
			System.out.println("It is a Palindrome!");
		}
		
		else
		{
			System.out.println("Not a Palindrome");
		}
		
		
		
	
	}

}
