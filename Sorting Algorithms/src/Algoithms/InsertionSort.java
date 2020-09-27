package Algoithms;

public class InsertionSort {
	
	
	    public static void insertionSort(int array[]) {  
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
	       
	    public static void main(String a[]){    
	        int[] arr1 = {48,27,79,85,34,12,69,54,93};    
	            
	        insertionSort(arr1);   
	           
	        System.out.println("After Insertion Sort");    
	        for(int i:arr1){    
	            System.out.print(i+" ");    
	        }    
	    }    
	}  


