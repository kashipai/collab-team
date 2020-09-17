package assignment_16_9;

import java.util.Scanner;

public class FibonacciWhile {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the total number of elements to be displayed in Fibonacci Series");
		int totalElements = sc.nextInt();
		int first = 0;
		int second = 1;
		int third;
		System.out.println("Fibonacci series:");
		if (totalElements == 0)
			System.out.println(first);
		if (totalElements == 1)
			System.out.println(first + "\t" + second);
		else {
			System.out.print(first + "\t" + second);
			int i = 2;
			while (i < totalElements) {
				third = first + second;
				System.out.print("\t" + third);
				first = second;
				second = third;
				i = i + 1;
			}
		}
		sc.close();
	}
}
