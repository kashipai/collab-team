package com.company;

import java.util.Scanner;

public class Fibonacci {
    static void forFib(int n)
    {
        int first=0,second=1,nextValue,c=0;
        for (c = 0; c < n; c++) {
            if (c <= 1)
                nextValue = c;
            else {
                nextValue = first + second;
                first = second;
                second = nextValue;
            }
            System.out.print(nextValue + " ");
        }
    }
    static void whileFib(int n)
    {
        int first=0,second=1,nextValue,c=0;
        while (c < n) {
            if (c <= 1)
                nextValue = c;
            else {
                nextValue = first + second;
                first = second;
                second = nextValue;
            }
            System.out.print(nextValue + " ");
            c++;
        }
    }
    static void doFib(int n)
    {
        int first=0,second=1,nextValue,c=0;
        do {
            if (c <= 1)
                nextValue = c;
            else {
                nextValue = first + second;
                first = second;
                second = nextValue;
            }
            System.out.print(nextValue + " ");
            c++;
        } while (c < n);
    }
    static int fibonacci(int n)
    {
        if(n<=1)
            return n;
        return fibonacci(n-1)+fibonacci(n-2);
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter number of terms");
        int n=in.nextInt();

        do {
            System.out.println("\nChoices :\n1.For loop\t2.While loop\t3.Do While loop\t4.Recursion\t5.Exit\nEnter your choice:");
            int choice = in.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Fibonacci series is:");
                    forFib(n);
                    break;
                case 2:
                    System.out.println("Fibonacci series is:");
                    whileFib(n);
                    break;
                case 3:
                    System.out.println("Fibonacci series is:");
                    doFib(n);
                    break;
                case 4:
                    System.out.println("Fibonacci series is:");
                    int first=0,second=1,nextValue,c=0;
                    for (c=0;c<n;c++)
                        System.out.print(fibonacci(c)+" ");
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid Option");
                    break;

            }
        }while(true);

    }
}
