package Programs;

public class DuplicateArray {

	public static void main(String[] args) {
		
		//int arr[]=new int[5];
		int arr[]=new int[]{1,2,2,4,5,6,2,5,8,7,8};
		System.out.println("Array length is:" +arr.length);
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]==arr[j])
				{
					System.out.println(arr[i]);
				}
			}
			
		}
		
		
	

	}

}
