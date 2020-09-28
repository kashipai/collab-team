package innsertionsort;

import java.util.Scanner;

public class insertion {
	void sort(int array[]) {
	int l=array.length;
		for(int k=1;k<l;k++) {
			int key=array[k];
			int m=k-1;
			
			while(m>=0 && array[m]>key){
				array[m+1]=array[m];
				m=m-1;
				System.out.println(m);
				array[m+1]=key;
				
			}
			
				
			}
			
		
	}
	void printarray(int array[]) {
		int s=array.length;
		for(int j=0;j<s;j++) {
			System.out.print(array[j]);
			}
		
	}



public static void main(String args[]) {
	insertion i=new insertion();
	Scanner sc=new Scanner(System.in);
	System.out.print("enter the size of array");
	int len=sc.nextInt();
	int array[]=new int[len];
	
	System.out.println("enter the array to sort");
	for(int j=0;j<len;j++) {
		array[j]=sc.nextInt();
	}
	
	i.sort(array);
	System.out.println("sorted array is");
	i.printarray(array);
	
		
	}
	
	
		
	}
