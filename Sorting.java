package TrainingSession;

import java.util.Scanner;

public class Sorting {
	
	//-----------------MERGE SORT----------- 
	public void MergeSort(int array[], int beg, int end) {
		if(beg < end) {
			int mid = (beg+end)/2;
			MergeSort(array, beg, mid);
			MergeSort(array, mid+1, end);
			Merge(array, beg, mid, end);
		}
	}
	
	public void Merge(int array[], int beg, int mid, int end) {
		int left = mid - beg + 1;
		int right = end - mid;
		int leftArray[] = new int[left];
		int rightArray[] = new int[right];
		
		for(int i = 0; i < left; i++) {
			leftArray[i] = array[beg + i];
		}
		
		for(int j = 0; j < right; j++) {
			rightArray[j] = array[mid + 1 + j];
		}
		
		int i = 0, j = 0;  
		int k = beg;  
		while (i < left && j < right) {
			if (leftArray[i] <= rightArray[j]) {
				array[k] = leftArray[i];  
				i++; 
				
			}
			else {
				array[k] = rightArray[j];  
				j++;  
				
			}
			k++;
			
		}
		while (i < left) {
			array[k] = leftArray[i];  
			i++;  
			k++;  
		}
		  
		while (j < right) {  
			array[k] = rightArray[j];  
			j++;  
			k++;  
		}  
	}
	
	// -------------------QUICK SORT-------------------

	int partition(int arr[], int low, int high) { 
		int pivot = arr[high]; 
		int i = (low-1); 
		for (int j = low; j < high; j++) { 
			
			if (arr[j] < pivot) { 
				i++; 
				int temp = arr[i]; 
				arr[i] = arr[j]; 
				arr[j] = temp; 
			} 
		} 

		
		int temp = arr[i+1]; 
		arr[i+1] = arr[high]; 
		arr[high] = temp; 

		return i+1; 
	} 

	void QuickSort(int arr[], int low, int high) { 
		if (low < high) { 
			int pi = partition(arr, low, high); 
			QuickSort(arr, low, pi-1); 
			QuickSort(arr, pi+1, high); 
		} 
	} 

	//---------------- INSERTION SORT -------------------

    public void insertionSort(int array[]) {  
        int n = array.length;  
        for (int j = 1; j < n; j++) {  
            int key = array[j];  
            int i = j-1;  
            while ( (i > -1) && ( array [i] > key ) ) {  
                array [i+1] = array [i];  
                i--;  
            }  
            array[i+1] = key;  
        }  
    }
    
	public void display(int array[]) {
		int n = array.length;
		for(int i = 0; i < n; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}


	public static void main(String[] args) {
		
		int n, choice;
		Sorting obj = new Sorting(); 
		Scanner sc = new Scanner(System.in);
	
		do {
			System.out.println("enter the choice");
			System.out.println("1.Merge sort , 2. Quick sort, 3. insertion sort 4. exit");
			choice = sc.nextInt();
			switch(choice) {
			case 1 : 
				System.out.println("enter the size of array");
				n = sc.nextInt();
				int array[] = new int[n];
				System.out.println("enter the array:-");
				for(int i = 0;i < n; i++) {
					array[i] = sc.nextInt();
				}
				System.out.println("-----MERGE SORT------");
				System.out.println("your array");
				obj.display(array);
				System.out.println("after sorting");
				obj.MergeSort(array, 0, array.length-1);
				obj.display(array);
				break;
			
			case 2 :
				System.out.println("enter the size of array");
				n = sc.nextInt();
				int arrayOne[] = new int[n];
				System.out.println("enter the array:-");
				for(int i = 0;i < n; i++) {
					arrayOne[i] = sc.nextInt();
				}
				System.out.println("-----QUICK SORT------");
				System.out.println("your array");
				obj.display(arrayOne);
				System.out.println("after sorting");
				obj.QuickSort(arrayOne, 0, arrayOne.length-1);
				obj.display(arrayOne);
				break;
				
			case 3 :
				System.out.println("enter the size of array");
				n = sc.nextInt();
				int arrayTwo[] = new int[n];
				System.out.println("enter the array:-");
				for(int i = 0;i < n; i++) {
					arrayTwo[i] = sc.nextInt();
				}
				System.out.println("-----insertion SORT------");
				System.out.println("your array");
				obj.display(arrayTwo);
				System.out.println("after sorting");
				obj.insertionSort(arrayTwo);
				obj.display(arrayTwo);
				break;
			
			case 4 :
				System.out.println("terminating the program");
				System.exit(0);
				break;
				
			default :
				System.out.println("invalid choice");
				break;		
			}
		} while(true);
		
	}

}
