package chapter23;

import java.util.Scanner;

public class GCD2 {
	public static int gcd (int m, int n) {
		if (m % n == 0) 
			return n;
		else
			return gcd(n, m % n);
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter first integer: ");
		int m = input.nextInt();
		System.out.println("Enter second interger: ");
		int n = input.nextInt();
		
		input.close();
		
		System.out.println("The greatest common divisor for " + m + 
				" and " + n + " is " + gcd(m, n));
	}
}
