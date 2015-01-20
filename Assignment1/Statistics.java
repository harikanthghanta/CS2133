//Kyle Riedemann
//CS 2133

/*
Statistics (30 points)

Write a program called Average.java that prompts a user to enter a number, and allows the user to
continue to enter numbers until she responds with a negative number. At that point, the program
should print out how many numbers the user entered (not including the negative one), and the
average of those numbers.

$ java Average
Enter a series of numbers. Enter a negative number to quit.
1
2
4.5
3
5
-1
You entered 5 numbers averaging 3.1.
*/

import java.util.Scanner;

public class Statistics {
	public static void main(String[] args) {
		double sum = 0;
		int count = 0;

		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter a series of numbers. Enter a negative number to quit.");

		while(keyboard.hasNextDouble()) {
			double mInput = keyboard.nextDouble();

			if(mInput < 0.0) {
				break;
			}

			sum += mInput;
			count++;
		}

		System.out.println("You entered " + count + " numbers averaging " + Average(sum, count));
	}

	private static double Average(double sum, int count) {
		double result = ((double)sum / count);
		return result;
	}
}