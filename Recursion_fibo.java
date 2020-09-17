import java.util.Scanner;

class Recursion_fibo {
    static int a = 0, b = 1,c = 0;

    static void fibo(int n){
        if(n>0) {
            c = a + b;
            a = b;
            b = c;
            System.out.print(c + "\t");
            fibo(n - 1);
        }
    }


    public static void main(String[] args) {
        int n;
        System.out.println("Enter the number");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        System.out.println("FIBONACCI SERIES:");
        System.out.print(a+"\t"+b+"\t");
        fibo(n);
    }

}
