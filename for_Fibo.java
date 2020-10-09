import java.util.Scanner;


public class for_Fibo {
    public static void main(String[] args) {
        int a = 0,b = 1,n,i,c;
        System.out.println("Enter the number");
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        System.out.println("FIBONACCI SERIES:");
        System.out.print(a+"\t"+b+"\t");
        for(i=0;i<n;i++){
            c=a+b;
            a=b;
            b=c;
            System.out.print(c+"\t");

        }

    }


}
