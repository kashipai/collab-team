package fibanoccifor;

import java.util.Scanner;

public class fibore {
              static int recursion(int n) {
            	  if(n==0) {
            		  return 0;
            	  }
            	  if(n==1 || n==2) {
            		  return 1;
            	  }
            	  else {
            		  return recursion(n-2)+recursion(n-1);
            	  }
              }
              
              public static void main(String[] args) {
            	  Scanner sc=new Scanner(System.in);
    	          System.out.println("enter the number of fibonaccy series");
    	          int N=sc.nextInt();
            	  for(int i=0;i<N;i++) {
            		  System.out.println(recursion(i));
            	  }
              }
}                       
