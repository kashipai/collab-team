package fibanoccifor;
import java.util.Scanner;
public class fibo {
	public static void main(String[] args) {	
	int n;
	int a=0;
	int b=1;
	System.out.println("enter the number of terms");
	Scanner sc=new Scanner(System.in);
	int N=sc.nextInt();
	if(N<=0){
		System.out.println("enter a valid input");
	}
	else {
	    for(int i=0;i<N;i++) {
	       System.out.println(a);
		   n=a+b;
		   a=b;
		   b=n;
		   
	}

}
	}
}