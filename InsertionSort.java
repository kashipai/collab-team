package trainingAssignment;

public class InsertionSort {
	static void printArray(int[] array) {
		
		for(int i: array) {
			System.out.print(i + " ");
		}
		System.out.println();
		
	}
	public static int[] insertionSort (int[] list) {
		int i, j, key, temp;
		for (i = 1; i < list.length; i++) {
			key = list[i];
			j = i - 1;
			while (j >= 0 && key < list[j]) {
				temp = list[j];
				list[j] = list[j + 1];
				list[j + 1] = temp;
				j--;
			}
		}
		return list;
	}
    public static void main(String[] args) {
    	int[] array = { 5, 4, 3, 2, 1 };
		System.out.println("Initial Array: ");
		printArray(array);
		array = insertionSort(array);
		System.out.println("Sorted Array: ");
		printArray(array);
	}
}
