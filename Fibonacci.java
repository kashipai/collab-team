package practice;

import java.util.Scanner;

public class Fibonacci {
	
	public int RecursiveFib(int n)
	{
		if(n == 1) {
			return 0;
		}
		else if(n == 2) {
			return 1;
		}
		else {
			return RecursiveFib(n-2) + RecursiveFib(n-1);
		}
	}
	
	public int ForLoop(int n) {
		int variableone = 0, variableTwo = 1, temp;
		if(n == 1)
		{
			return variableone;
		}
		if(n == 2)
		{
			return variableTwo;
		}
		for(int i = 2; i < n; i++)
		{
			temp = variableone + variableTwo;
			variableone = variableTwo;
			variableTwo = temp;
		}
		return variableTwo;
	}
	
	public int WhileLoop(int n) {
		int z = 3;
		if(n == 1)
		{
			return 0;
		}
		if(n == 2)
		{
			return 1;
		}
		int[] fib = new int[n+1];
		fib[1] = 0;
		fib[2] = 1;
		while(z <= n)
		{
			fib[z] = fib[z-1] + fib[z-2];
			z += 1;
			
		}
		return fib[n];
	}
	
	public int DoWhile(int n) {
		int variableone = 0, variabletwo = 1, temp, index = 2;

		do
		{
			if(n == 1)
			{
				return variableone;
			}
			if( n == 2)
			{
				return variabletwo;
			}
			
			temp = variableone + variabletwo;
			variableone = variabletwo;
			variabletwo = temp;
			index = index + 1;
			
		} while(index < n);
		return variabletwo;
		
	}


	public static void main(String[] args) {
		int n;
		Fibonacci recursive = new Fibonacci();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter n..");
		n = sc.nextInt();
		if(n > 0) {
			
			System.out.println("fibonacci by recurcive");
			for(int i = 1; i <=n; i++) {
				System.out.print(recursive.RecursiveFib(i)+" ");
				
			}
			System.out.println();
			
			System.out.println("fibonacci by FOR LOOP");
			for(int i = 1; i <=n; i++) {
				System.out.print(recursive.ForLoop(i)+" ");
				
			}
			System.out.println();
			
			System.out.println("fibonacci by WHILE LOOP");
			for(int i = 1; i <=n; i++) {
				System.out.print(recursive.WhileLoop(i)+" ");
				
			}
			System.out.println();
			
			System.out.println("fibonacci by DO WHILE");
			for(int i = 1; i <=n; i++) {
				System.out.print(recursive.DoWhile(i)+" ");
				
			}	

		}
		else {
			System.out.println("enter valid number or greater than 0");
		}

	}

}
