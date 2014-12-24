//Kyle Riedemann
//CS 2133

/*
Recursion (10 points)
Create a file called Factorial.java. This file should have the following method:

public static long calculate(long n)

Factorial.calculate should recursively calculate n!, where 0! = 1 and n! = n(n − 1)!. The method
should also print out an error and exit if n < 0 or n > 20, since factorial is not defined for negative
numbers and will overflow Java’s long variable with larger numbers (if we used an int, it would
overflow even sooner!).
	Inside Factorial.java, also include a main method which runs a couple of tests on Facto-
rial.calculate:

java Factorial
Factorial.calculate(0) returned 1. Test passed!
Factorial.calculate(5) returned 120. Test passed!

(Obviously, if these tests do not return 1 and 120 respectively, the tests should fail and print out
an appropriate message.)
*/

public class Factorial {
	public static void main(String[] args) {
		testFactorial(0, calculate(1), 1);
		testFactorial(5, calculate(5), 120);
		testFactorial(6, calculate(6), 720);
	}

	public static boolean testFactorial(int arg, long result, long expected) {
		if(result == expected) {
			System.out.println("\nFactorial.calculate(" + arg + ") returned " + result);
			System.out.println("Expected value " + expected + " equals result, test passed");
			return true;
		} else {
			System.out.println("\nFactorial.calculate(" + arg + ") returned " + result);
			System.out.println("Expected value " + expected + " equals result, test failed");
			return false;
		}
	}

	public static long calculate(long n) {
		if(n < 0) {
			System.out.println("Error: cannot calculate tha factorial of a negative number");
			System.exit(0);
		} else if(n > 20) {
			System.out.println("Error: calculation results in overflow");
			System.exit(0);
		} 

		if(n == 0 || n == 1) {
			return 1;
		} else {
			return calculate(n-1) * n;
		}
	}
}