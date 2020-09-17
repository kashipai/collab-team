package assignment_16_9;

import java.util.Scanner;

public class FibonacciFor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the total number of elements to be displayed in Fibonacci Series");
		int totalElements = sc.nextInt();
		/*
		int[] fibonacci = new int[totalElements];
		fibonacci[0]=0;
		fibonacci[1]=1;
		for(int i = 2;i<totalElements;i=i+1)
		{
			fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
		}
		System.out.println("Fibonacci series:");
		for(int i = 0;i<totalElements;i=i+1)
		{ 
		System.out.print(fibonacci[i] + "\t");
		}*/
		
		int first = 0;
		int second = 1;
		int c;
		System.out.println("Fibonacci series:");
		if (totalElements == 0)
			System.out.println(first);
		if (totalElements == 1)
			System.out.println(first + "\t" + second);
		else {
			System.out.print(first + "\t" + second);
			for (int i = 2; i < totalElements; i++) {
				c = first + second;
				System.out.print("\t" + c);
				first = second;
				second = c;
			}
		}
		
		sc.close();
	}
}
