
	public class MergeSort 
	{ 
	
		void mergealgo(int arr[], int l, int m, int r) 
		{ 		
			int n1 = m-l+1; 
			int n2 = r-m; 
		
			int F[] = new int [n1]; 
			int S[] = new int [n2]; 

			
			for (int i=0; i<n1; ++i) 
				F[i] = arr[l + i]; 
			for (int j=0; j<n2; ++j) 
				S[j] = arr[m + 1+ j]; 
			int i = 0, j = 0; 
			int k = l; 
			while (i < n1 && j < n2) 
			{ 
				if (F[i] <= S[j]) 
				{ 
					arr[k] = F[i]; 
					i++; 
				} 
				else
				{ 
					arr[k] = S[j]; 
					j++; 
				} 
				k++; 
			} 

			
			while (i < n1) 
			{ 
				arr[k] = F[i]; 
				i++; 
				k++; 
			} 

			
			while (j < n2) 
			{ 
				arr[k] = S[j]; 
				j++; 
				k++; 
			} 
		} 

		
		void sort(int arr[], int l, int r) 
		{ 
			if (l < r) 
			{ 
				
				int m = (l+r)/2; 


				sort(arr, l, m); 
				sort(arr , m+1, r); 

	
				mergealgo(arr, l, m, r); 
			} 
		} 

	
		
		public static void main(String args[]) 
		{ 
			int arr[] = {10,20,50,30,40,5}; 

			System.out.println("Given Array"); 
			int n = arr.length; 
			for (int i=0; i<n; ++i) 
				System.out.print(arr[i] + " ");

			MergeSort ob = new MergeSort(); 
			ob.sort(arr, 0, arr.length-1); 

			System.out.println("\nSorted array"); 
			 
			for (int i=0; i<n; ++i) 
				System.out.print(arr[i] + " ");
		} 
	} 




