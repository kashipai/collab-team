package fibs;

import java.util.Scanner;

public class fibwhile {
	public void fibwhiless()
	{
		try
		{
			int var1=0,var2=1,temp,num;
			Scanner sc=new Scanner(System.in);
			System.out.println("Using While Loop");
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
			else
			{
				System.out.print(var1+" ");
				System.out.print(var2+" ");
				int i=3;
				while(i<=num)
				{
					temp=var1+var2;
					System.out.print(temp+" ");
					var1=var2;
					var2=temp;
					i=i+1;
				}
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Enter Valid Number!!!");
		}
	}

}
