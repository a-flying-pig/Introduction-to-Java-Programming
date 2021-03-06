package chapter23;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EfficientPrimeNumbers {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Find all prime numbers <= n, enter n: ");
		int n = input.nextInt();
		
		// A list to hold prime numbers
		List<Integer> list = new ArrayList<>(); 
		
		final int NUMBER_PER_LINE = 10;
		int count = 0;
		int number = 2;
		int squareRoot = 1;
		
		System.out.println("The prime numbers are \n");
		
		while (number <= n) {
			boolean isPrime = true;
			
			if (squareRoot * squareRoot < number) squareRoot++;
			
			// Test whether number is prime
			for(int k = 0; k < list.size() 
					&& list.get(k) <= squareRoot; k++) {
				if (number % list.get(k) == 0) { // If true, not prime
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				count++;
				list.add(number); // Add a new prime to the list
				if (count % NUMBER_PER_LINE == 0) {
					System.out.println(number);
				} else {
					System.out.printf("%7d", number);
				}
			}
			number++;
		}
		
		System.out.println("\n" + count + 
				" prime(s) less than or equal to " + n);;
	}
}
