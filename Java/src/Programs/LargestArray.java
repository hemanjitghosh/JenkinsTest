package Programs;

public class LargestArray {

	public static void main(String[] args) {
		
		int arr[]=new int[]{55,65,75,101};
		
		int max;
		max=arr[0];
		
		for (int i=0;i<arr.length;i++)
		{
			if(arr[i]>max)
					{
						max=arr[i];
				
					}
		}
		
		System.out.println(max);
		

	}

}
