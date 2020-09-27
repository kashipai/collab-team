package assignment_25_9;

import java.util.Scanner;

public class MergeSort {

	void sortElements(int array[], int first, int last) {
		if (first < last) {
			int middle = (first + last) / 2;

			sortElements(array, first, middle);
			sortElements(array, middle + 1, last);
			mergeElements(array, first, middle, last);

		}
	}

	void mergeElements(int array[], int first, int middle, int last) {

		int left = middle - first + 1;
		int right = last - middle;

		int LeftArray[] = new int[left];
		int RightArray[] = new int[right];

		for (int i = 0; i < left; ++i)
			LeftArray[i] = array[first + i];

		for (int j = 0; j < right; ++j)
			RightArray[j] = array[middle + 1 + j];

		int i = 0, j = 0;
		int k = first;

		while (i < left && j < right) {
			if (LeftArray[i] <= RightArray[j]) {
				array[k] = LeftArray[i];
				i++;
			} else {
				array[k] = RightArray[j];
				j++;
			}
			k++;
		}
		while (i < left) {
			array[k] = LeftArray[i];
			i++;
			k++;
		}

		while (j < right) {
			array[k] = RightArray[j];
			j++;
			k++;
		}

	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the total number of elements in an array:");
		int length = sc.nextInt();
		int array[] = new int[length];
		
		System.out.println("Enter the elements:");
		for (int i = 0; i < array.length; i++) {
			array[i] = sc.nextInt();
		}
		System.out.println("\nGiven array:");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "  ");
		}
		MergeSort mergeSorting = new MergeSort();
		mergeSorting.sortElements(array, 0, array.length - 1);

		System.out.println("\n\nSorted array:");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "  ");
		}
		sc.close();
	}
}
