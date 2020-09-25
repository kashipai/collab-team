package practice;

import java.util.Scanner;

public class QuickSort 
{
	
	int partition(int array[], int start, int end)
	{
		int pivot = array[end];
		int pIndex = start;
		
		for(int i = start; i < end; i++)
		{
			if(array[i] <= pivot)
			{
				int temp = array[i];
				array[i] = array[pIndex];
				array[pIndex] = temp;
				pIndex++;
			}
		}
		int temp = array[pIndex];
		array[pIndex] = array[end];
		array[end] = temp;
		
		return pIndex;
	}
	
	void sortPivot(int arr[], int start, int end)
	{	
		if(start >= end)
		{
			return;
		}
		else
		{
		int pIndex = partition(arr, start, end);
		sortPivot(arr, start, pIndex - 1);
		sortPivot(arr, pIndex, end);
		}
	}
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
	
	QuickSort qs = new QuickSort();
	qs.sortPivot(sortArray, 0, (size - 1));
	
	
	System.out.println("Sorted array using Quick sort");
	
	for(int i = 0; i < size; i++)
	{
		System.out.println(sortArray[i]);
	}
	sc.close();
	System.gc();
	}
}
