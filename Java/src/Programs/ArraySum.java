package Programs;

public class ArraySum {

	public static void main(String[] args) {

		 int arr[] = {10,70,30,90,20,20,30,40,70,50};
		 int sum=0;
		 int temp;
		 
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]<arr[j])
				{
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
				
			}
			System.out.println(arr[i]);
		}
		
		

	}

}
