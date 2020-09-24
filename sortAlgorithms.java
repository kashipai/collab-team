package com.company;

import java.util.Scanner;

public class sortAlgorithms {
//Array will be printed
    public static void myArray(int[] myArr)
    {
        for (int index=0;index<myArr.length;index++)
            System.out.print(myArr[index]+" ");
    }

//Code for merge sort
    void mergesort(int[] myArr, int begin, int end)
    {
        if (begin<end)
        {
            int mid = (begin+end)/2;
            mergesort(myArr, begin, mid);
            mergesort(myArr , mid+1, end);
            merge(myArr, begin, mid, end);
        }
    }
    
    private void merge(int[] myArr, int begin, int mid, int end)
    {
        int l = mid - begin + 1;
        int r = end - mid;

        int LeftArray[] = new int [l];
        int RightArray[] = new int [r];

        for (int i=0; i<l; ++i)
            LeftArray[i] = myArr[begin + i];

        for (int j=0; j<r; ++j)
            RightArray[j] = myArr[mid + 1+ j];


        int i = 0, j = 0;
        int k = begin;
        while (i<l&&j<r)
        {
            if (LeftArray[i] <= RightArray[j])
            {
                myArr[k] = LeftArray[i];
                i++;
            }
            else
            {
                myArr[k] = RightArray[j];
                j++;
            }
            k++;
        }
        while (i<l)
        {
            myArr[k] = LeftArray[i];
            i++;
            k++;
        }

        while (j<r)
        {
            myArr[k] = RightArray[j];
            j++;
            k++;
        }
    }

//Code for quick sort
    void quicksort(int[] myArr, int begin, int end)
    {
        if (begin < end)
        {
            int pivot = partition(myArr, begin, end);//find pivot element
            quicksort(myArr, begin, pivot-1);//recursive call
            quicksort(myArr, pivot+1, end);//recursive call
        }
    }

     int partition(int[] myArr, int begin, int end)
    {
        int pivot = myArr[end];
        int i = (begin-1);
        for (int j=begin; j<end; j++)
        {
            // If  element is smaller than the pivot
            if (myArr[j] < pivot)
            {
                i++;

                //swap
                int temp = myArr[i];
                myArr[i] = myArr[j];
                myArr[j] = temp;
            }
        }

        int temp = myArr[i+1];
        myArr[i+1] = myArr[end];
        myArr[end] = temp;

        return i+1;
    }

//Code for insertion sort
    void insertionsort(int[] myArr)
    {
        int n = myArr.length;
        for (int i = 1; i < n; ++i) {
            int key = myArr[i];
            int j = i - 1;


            while (j >= 0 && myArr[j] > key) {
                myArr[j + 1] = myArr[j];
                j = j - 1;
            }
            myArr[j + 1] = key;
        }
    }


    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int[] myArr=new int[10];

        sortAlgorithms sa=new sortAlgorithms();

        System.out.println("Enter elements to an array:");
        for (int i=0;i<myArr.length;i++)
        {
            myArr[i]=in.nextInt();
        }

        do
        {
            System.out.print("\nSorting Algorithms\n1.Merge Sort\t2.Quick Sort\t3.Insertion Sort\t4.Exit\nEnter your choice:");
            int choice=in.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("Input Array");
                    myArray(myArr);
                    sa.mergesort(myArr, 0, myArr.length - 1);
                    System.out.println("\nSorted array");
                    myArray(myArr);
                    break;
                case 2:
                    System.out.println("Input Array");
                    myArray(myArr);
                    sa.quicksort(myArr, 0, myArr.length - 1);
                    System.out.println("\nSorted array");
                    myArray(myArr);
                    break;
                case 3:
                    System.out.println("Input Array");
                    myArray(myArr);
                    sa.insertionsort(myArr);
                    System.out.println("\nSorted array");
                    myArray(myArr);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }while(true);
    }
}

