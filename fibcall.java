package fibs;

import java.util.Scanner;

public class fibcall {
	public static void main(String[] args)
	{
		
		int choice;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter 1 to print Fibbonacci Sequence using FOR LOOP");
		System.out.println("Enter 2 to print Fibbonacci Sequence Using WHILE LOOP");
		System.out.println("Enter 3 to print FIbbonacci Sequence Using RECURSION");
		System.out.println("Enter 4 to print FIbbonacci Sequence Using DO WHILE LOOP");
		choice=scanner.nextInt();
		switch(choice)
		{
		case 1:FibFor fibfors=new FibFor();
				long startTime = System.nanoTime();
				fibfors.forfib();
				long elapsedTime = System.nanoTime() - startTime;
				System.out.println();
				System.out.println(elapsedTime+" ns");
				break;
		case 2:fibwhile fibwhiles=new fibwhile();
				long startTimes = System.nanoTime();
				fibwhiles.fibwhiless();
				long elapsedTimes = System.nanoTime() - startTimes;
				System.out.println();
				System.out.println(elapsedTimes+" ns");
				break;
		case 3:fibrecursion recursions=new fibrecursion();
				long startTimess = System.nanoTime();
				recursions.inputs();
				long elapsedTimess = System.nanoTime() - startTimess;
				System.out.println();
				System.out.println(elapsedTimess+" ns");
				break;
		case 4:dowhilefib dofibss=new dowhilefib();
				long startTimesss = System.nanoTime();
				dofibss.fibdowhiless();
				long elapsedTimesss = System.nanoTime() - startTimesss;
				System.out.println();
				System.out.println(elapsedTimesss+" ns");
				break;
		default:System.out.println("Enter Valid Input!!!");
		}
		
		
		
	}
}
