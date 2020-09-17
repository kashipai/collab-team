package trainingAssignment;

import java.util.Scanner;

public class Fibonacci {
	static void doWhile(int n) {
		int previous1=0;
		int previous2=1;
		int i = 0;
		do {
			if (i <= 1) {
				System.out.print(i+"\t");
			}
			else {
				int sum = previous1 + previous2;
				System.out.print(sum+"\t");
				previous1 = previous2;
				previous2 = sum;
			}
			i += 1;
		}while(i < n);
		
	}
	static void While(int n) {
		int previous1=0;
		int previous2=1;
		int i = 0;
		while(i < n) {
			if (i <= 1) {
				System.out.print(i+"\t");
			}
			else {
				int sum = previous1 + previous2;
				System.out.print(sum+"\t");
				previous1 = previous2;
				previous2 = sum;
			}
			i += 1;
		}
	}
	static void For(int n) {
		int previous1=0;
		int previous2=1;
		for(int i = 0; i < n; i++) {
			if (i <= 1) {
				System.out.print(i+"\t");
			}
			else {
					int sum = previous1 + previous2;
					System.out.print(sum+"\t");
					previous1 = previous2;
					previous2 = sum;			
			}
		}
	}
	static int fib(int n) {
		if(n <= 1) {
			return n;
		}
		else {
			return fib(n-1) + fib(n-2);
		}
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of fibonacci sequenece : ");
		int n = sc.nextInt();
		System.out.println("Pick one of the following: (doWhile(1) | While(2) | For(3) | Recurrsion(4)) ");
		int choice = sc.nextInt();
		sc.close();
	    switch(choice) {
	    case 1: doWhile(n);
	    		break;
	    case 2: While(n);
	            break;
	    case 3: For(n);
	    		break;
	    case 4: for(int i = 0; i < n; i++) {
    		        System.out.print(fib(i)+"\t");
    	          }
	    		break;
	    
	    }
		
	}
}
