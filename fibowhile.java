package fibanoccifor;

import java.util.Scanner;

public class fibowhile {
	public static void main(String[] args) {
	int i=0;
	int a=0;
	int b=1;
	System.out.println("enter the number of terms");
	Scanner sc=new Scanner(System.in);
	int N=sc.nextInt();
	if(N<=0){
		System.out.println("enter a valid input");
	}
	while(i<N) {
		System.out.println(a);
		int n=a+b;
		a=b;
		b=n;
		i++;
		
	}

}
}