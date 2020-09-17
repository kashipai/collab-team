package fibs;

import java.util.Scanner;

public class fibrecursion {
	int nums,var1=0,var2=1,temp;
	public void inputs()
	{
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println("Using Recursion");
			System.out.println("Enter the number");
			nums=sc.nextInt();
			if(nums<=0)
			{
				throw new Exception("Enter valid number");
			}
			else
			{
				//recursivefib(nums);
				for(int i = 0; i < nums; i++){
					System.out.print(recursivefib(i) +" ");
				}
			}
		} 
		
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Enter valid number!!");
		}
	}
	
	
	public int recursivefib(int n)
	{
		if(n == 0){
			return 0;
		}
		if(n == 1 || n == 2){
				return 1;
			}
			return(recursivefib(n-2)+recursivefib(n-1));	
		}

}
