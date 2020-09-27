package assignment_25_9;

import java.util.Scanner;

public class InsertionSort {

    public static void sortElements(int array[]) {  
        int length = array.length;  
        for (int i = 1; i < length; i++) {  
            int temp = array[i];  
            int j;  
            for(j=i-1;j>=0;j--)
            {
            	if(array[j]>temp)
            	{
            		array [j+1] = array [j]; 
            	}
            	else
            		break;	 
            }
            array[j+1] = temp;  
        }  
    }  
       
     
    public static void main(String a[]){    
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
		sortElements(array);

		System.out.println("\n\nSorted array:");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "  ");
		}
		sc.close();
    }    
}    