package Programs;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		
		String str1="mary";
		String str2="army";
		
		char[] val1=str1.toCharArray();
		char[] val2=str2.toCharArray();
		
		Arrays.sort(val1);
		Arrays.sort(val2);
		System.out.println(val1);
		System.out.println(val2);
		

	}

}
