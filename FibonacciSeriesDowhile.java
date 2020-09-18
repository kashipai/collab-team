package begin;

import java.util.Scanner;

public class FibonacciSeriesDowhile {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of terms");
		int number = input.nextInt();
		int term1 = 0, term2 = 1, term3, i = 0;
		System.out.print("The Fibonacci series is \t");
		do {
			System.out.print(term1 + "\t");
			term3 = term1 + term2;
			term1 = term2;
			term2 = term3;
			++i;
		} while (i < number);
		input.close();
	}

}
