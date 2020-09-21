package sample;

import java.util.Scanner;

public class Recursion_Fibo {
	static int n1 = 0, n2 = 1, n3 = 0;
	public static void fib(long count) {
		if (count > 0) {
	         n3 = n1 + n2;
	         n1 = n2;
	         n2 = n3;
	         System.out.print(" " + n3);
	         fib(count - 1);   
		}
	}
	public static void main(String[] args) {
		int count=-1;
        System.out.println("Enter the number");
        Scanner sc = new Scanner(System.in);
        count = sc.nextInt();
        System.out.println("FIBONACCI SERIES:");
        System.out.print(n1 +" "+n2 );	
        fib(count);
	}
	
}
