
public class FibonacciSerieswhile {
	
	public static void main(String[] args) {
		
		//long startTime = System.nanoTime();

        int i = 1, len= 10, num1 = 0, num2 = 1;
        System.out.println("Fibonacci Series");

        while (i <= len)
        {
            if(i==len) {
        		
                System.out.print(num1);

        	}else {
        		
            System.out.print(num1 + " , ");
        	}

            int temp = num1 + num2;
            num1 = num2;
            num2 = temp;

            i++;
        }
//        long endTime = System.nanoTime();
//        long time = endTime - startTime;
//        System.out.println("\nExecution time : " +time/1000);
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memory = runtime.totalMemory()-runtime.freeMemory();
        System.out.println("\nUsed memory in kilobytes : " +memory/1000);
    }

}
