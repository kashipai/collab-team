package fibs;
import java.util.Scanner;

public class FibFor {
	public void forfib() {
		try
		{
			int var1=0,var2=1,temp,number;
			Scanner sc=new Scanner(System.in);
			System.out.println("Using For Loop");
			System.out.println("Enter the number: "); //Input
			number=sc.nextInt(); 
			if(number<=0)
			{
				throw new Exception("Enter valid number");
			}
			if(number==1)
			{
				System.out.print(var1);
			}
			else
			{
				System.out.print(var1+" ");
				System.out.print(var2+" ");
				for(int i = 3; i <= number; i++)
				{
					temp=var1+var2;
					System.out.print(temp+" ");
					var1=var2;
					var2=temp;
				}
			}
		}	
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Enter valid number!!!");
		}
	}

}
