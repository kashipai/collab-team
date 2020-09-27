package assignment_25_9;

import java.util.Scanner;

public class QuickSort {
 int partition(int array[], int small, int high) 
 { 
     int pivot = array[high];  
     int i = (small-1); 
     for (int j=small; j<high; j++) 
     { 
         if (array[j] < pivot) 
         { 
             i++; 
             int temp = array[i]; 
             array[i] = array[j]; 
             array[j] = temp; 
         } 
     } 
     int temp = array[i+1]; 
     array[i+1] = array[high]; 
     array[high] = temp; 

     return i+1; 
 } 

 void sortElements(int array[], int small, int high) 
 { 
     if (small < high) 
     { 
         int pi = partition(array, small, high); 
         sortElements(array, small, pi-1); 
         sortElements(array, pi+1, high); 
     } 
 } 

 public static void main(String args[]) 
 { 
	 Scanner sc = new Scanner(System.in);

		System.out.println("Enter the total number of elements in an array:");
		int length = sc.nextInt();
		int array[] = new int[length];
		
		System.out.println("Enter the elements:");
		for (int i = 0; i < array.length; i++) {
			array[i] = sc.nextInt();
		}

     System.out.println("\nGiven array:");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "  ");
		}
     QuickSort quickSorting = new QuickSort(); 
     quickSorting.sortElements(array, 0, length-1); 
 
     System.out.println("\n\nSorted array:");
		for (int i = 0; i < length; i++) {
			System.out.print(array[i] + "  ");
		}
		sc.close();
 } 

}
