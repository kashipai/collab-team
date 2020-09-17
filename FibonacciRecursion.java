package assignment_16_9;

import java.util.Scanner;

public class FibonacciRecursion {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the total number of elements to be displayed in Fibonacci Series:");
		int totalElements = sc.nextInt();
		FibonacciRecursion object = new FibonacciRecursion();
		System.out.println("Fibonacci Series:");
		for (int i = 0; i < totalElements; i = i + 1) {
			System.out.print(object.fibonacciSeries(i) + "\t");
		}
		sc.close();
	}

	int fibonacciSeries(int number) {
		if (number == 0)
			return 0;
		if (number == 1)
			return 1;
		return (fibonacciSeries(number - 1) + fibonacciSeries(number - 2));

	}
}
