package fibs;

import java.util.Scanner;

public class dowhilefib {
	public void fibdowhiless()
	{
		try
		{
			int var1=0,var2=1,temp,num;
			Scanner sc=new Scanner(System.in);
			System.out.println("Using Do While Loop");
			System.out.println("Enter the number: ");
			num=sc.nextInt();
			if(num<=0)
			{
				throw new Exception("Enter valid number");
			}
			if(num==1)
			{
				System.out.println(var1);
			}
			if(num==2)
			{
				System.out.print(var1+" ");
				System.out.print(var2+" ");
			}
			else
			{
				System.out.print(var1+" ");
				System.out.print(var2+" ");
				int i=3;
				do
				{
					temp=var1+var2;
					System.out.print(temp+" ");
					var1=var2;
					var2=temp;
					i=i+1;
				}while(i<=num);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Enter Valid Number!!!");
		}
	}

}
