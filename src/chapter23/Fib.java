package chapter23;

import java.util.Scanner;

public class Fib {
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);
		System.out.println("Enter an index for the Fibonacci number: ");
		int index = input.nextInt();
		
		double startTime = System.currentTimeMillis();
		long value = fib(index);
		double finishTime = System.currentTimeMillis();
		
		System.out.println("Value is " + value + " fib time is :" + 
			(finishTime - startTime));
		
		startTime = System.currentTimeMillis();
		long value1 = fib1(index);
		finishTime = System.currentTimeMillis();
		System.out.println("Value1 is " + value1 + " fib1 time is :" + 
				(finishTime - startTime));
	}
	
	public static long fib(long index) {
		if (index == 0) // Base case	
			return 0;
		else if (index == 1) //Base case
			return 1;
		else 
			return fib(index - 1) + fib(index -2);
	}
	
	public static long fib1(long n) {
		long f0 = 0;
		long f1 = 1;
		long f2 = 1;
		if (n == 0)
			return f0;
		else if (n == 1)
		    return f1;
		else {
			long result;
			for (long i = 2; i <= n; i++) {
				f2 = f0 + f1;
				f0 = f1;
				f1 = f2;
			}
			result = f2;
			return result;
		}
	}
}
