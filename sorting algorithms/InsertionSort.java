import java.util.Scanner;

public class InsertionSort { 
	void sort(int arr[]) 
	{ 
		int n = arr.length; 
		for (int i = 1; i < n; ++i) { 
			int key = arr[i]; 
			int j = i - 1; 
			while (j >= 0 && arr[j] > key) { 
				arr[j + 1] = arr[j]; 
				j = j - 1; 
			} 
			arr[j + 1] = key; 
		} 
	} 

	static void printArray(int arr[]) 
	{ 
		int n = arr.length; 
		for (int i = 0; i < n; ++i) 
			System.out.print(arr[i] + " "); 

		System.out.println(); 
	} 
	
	public static void main(String args[]) 
	{ 
		int len;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the length of the array");
		len=sc.nextInt();
		int arr[]=new int[len];
		System.out.println("Enter the array elements");
		for(int i=0;i<len;i++)
		{
			arr[i]=sc.nextInt();
		}
		InsertionSort i1 = new InsertionSort(); 
		i1.sort(arr); 

		printArray(arr); 
	} 
} 