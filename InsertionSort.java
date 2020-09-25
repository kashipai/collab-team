package practice;

import java.util.Scanner;

public class InsertionSort 
{
	void Insert(int arr[])
	{
		int length = arr.length;
		
		for(int i  = 1; i < length; i++)
		{
			int value = arr[i];
			int hole = i;
			
			while((hole > 0) && ((arr[hole-1]) > value))
			{
				arr[hole] = arr[hole-1];
				hole = hole - 1;
			}
			arr[hole] = value;
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
		
		InsertionSort isort = new InsertionSort(); 
		isort.Insert(sortArray);
		
		System.out.println("Sorted array using Insertion sort");
		
		for(int i = 0; i < size; i++)
		{
			System.out.println(sortArray[i]);
		}
		sc.close();
		System.gc();
	}
}
