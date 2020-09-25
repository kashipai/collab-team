package practice;

import java.util.*;

class MergeClass
{
	void merge(int left[], int right[], int arr[])
	{
		int nleft = left.length;
		int nright = right.length;
		
		int i = 0; int j = 0; int k = 0;
		
		while((i < nleft) && (j < nright))
		{
			if(left[i] <= right[j])
			{
				arr[k] = left[i];
				i++;
				k++;
			}
			else
			{
				arr[k] = right[j];
				k++;
				j++;
			}
		}
		
		while(i < nleft)
		{
			arr[k] = left[i];
			i++;
			k++;
		}
		
		while(j < nright)
		{
			arr[k] = right[j];
			j++;
			k++;
		}
	}
	
	void sortSubsets(int arr[])
	{
		int low = 0;
		int arrLength = arr.length;
		int mid = (arrLength/2);
		int leftSub[] = new int[mid];
		int rightSub[] = new int[arrLength - mid];
		
		if(arrLength <=1)
		{
			return;
		}
		
		for(int i = 0; i < mid; i++)
		{
			leftSub[i] = arr[i];
		}
		
		for(int i = mid; i < arrLength; i++)
		{
			rightSub[i-mid]  = arr[i];
		}
		
		sortSubsets(leftSub);
		sortSubsets(rightSub);
		merge(leftSub,rightSub,arr);
		
	}
}

public class MergeSort 
{
	public static void main(String args[])
	{
	int size;
	
	Scanner sc = new Scanner(System.in);
	System.out.println("How many elements you want to enter?");
	size = sc.nextInt();
	
	int sortArray[] = new int[size];
	
	System.out.println("Enter "+size+" elements");
	
	for(int i = 0; i < size; i++)
	{
		sortArray[i] = sc.nextInt();
	}
	
	System.out.println("Original array elements");
	
	for(int i = 0; i < size; i++)
	{
		System.out.println(sortArray[i]);
	}
	
	MergeClass ms = new MergeClass();
	ms.sortSubsets(sortArray);
	
	System.out.println("Sorted array using merge sort");
	
	for(int i = 0; i < size; i++)
	{
		System.out.println(sortArray[i]);
	}
	sc.close();
	System.gc();
	}
	
	
}
