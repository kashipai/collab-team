package begin;

import java.util.Scanner;

public class FibonacciRecursive {
	static int term1 = 0, term2 = 1, term3;

	static void Fibonacci(int number) {
		if (number > 0) {
			System.out.print(term1 + "\t");
			term3 = term1 + term2;
			term1 = term2;
			term2 = term3;
			Fibonacci(number - 1);
		}
	}

	public static void main(String[] args) {
		{
			Scanner input = new Scanner(System.in);
			System.out.println("Enter the number of terms");
			int number = input.nextInt();
			System.out.print("The Fibonacci series is ");
			Fibonacci(number);
			input.close();
		}
	}
}
