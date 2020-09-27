package begin;

public class MergeSort {
	void merge(int arr[], int Lowerindex, int MiddleIndex, int HigherIndex) {
		int n1 = MiddleIndex - Lowerindex + 1;
		int n2 =HigherIndex - MiddleIndex;

		int Left[] = new int[n1];
		int Right[] = new int[n2];

		for (int i = 0; i < n1; ++i)
			Left[i] = arr[Lowerindex + i];
		for (int j = 0; j < n2; ++j)
			Right[j] = arr[MiddleIndex+ 1 + j];

		int i = 0, j = 0;

		int k =Lowerindex;
		while (i < n1 && j < n2) {
			if (Left[i] <= Right[j]) {
				arr[k] =Left[i];
				i++;
			} else {
				arr[k] = Right[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = Left[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = Right[j];
			j++;
			k++;
		}
	}

	void sort(int arr[], int LowerIndex, int HigherIndex) {
		if (LowerIndex < HigherIndex) {

			int MiddleIndex = (LowerIndex + HigherIndex) / 2;

			sort(arr, LowerIndex, MiddleIndex);
			sort(arr, MiddleIndex + 1, HigherIndex);

			merge(arr, LowerIndex, MiddleIndex, HigherIndex);
		}
	}

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String args[]) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };

		System.out.println("Given Array");
		printArray(arr);

		MergeSort ob = new MergeSort();
		ob.sort(arr, 0, arr.length - 1);

		System.out.println("\nSorted array");
		printArray(arr);
	}
}
