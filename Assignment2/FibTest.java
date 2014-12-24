//Kyle Riedemann
//CS 2133

/*
Fibonacci revisited (10 points)

Create a file called FibTest.java. Refactor your Fib.java from assignment 1 to be a static method in
FibTest. Odds are that your assignment 1 answer is coded in iterative style, where you are looping
from 1 to n and adding up numbers as you go. If not, you should write an iterative Fibonacci
calculator that does so (and refactor the version that you wrote for assignment 1 for the next part
of the problem). This method should be called

public static int fibIter(int n)

The recurrence relation for the Fibonacci sequence is the following:
	f ib(1) = 1
	f ib(2) = 1
	f ib(n) = f ib(n − 1) + f ib(n − 2)
	Write another static method in the same FibTest class, this time in recursive style, using this
relationship.

public static int fibRecur(int n)

In FibTest’s main method, write a series of tests that establishes that both of these functions work
correctly. Finally, using Java’s System.currentTimeMillis() function, print out the time it takes
to execute FibTest.fibIter(40) and FibTest.fibRecur(40).
*/

public class FibTest {
	public static void main(String[] args) {
		int testNum = 40;

		long startTime;
		long endTimeIter;
		long endTimeRecur;
		long totalTimeIter;
		long totalTimeRecur;
		long resultIter;
		long resultRecur;

		//tests for 4
		if(valueTest(fibIter(4), 3)) System.out.println("fibIter passed for value 4");
		else System.out.println("fibIter failed for value 4");
		if(valueTest(fibRecur(4), 3)) System.out.println("fibRecur passed for value 4");
		else System.out.println("fibRecur failed for value 4");

		//test for 7
		if(valueTest(fibIter(7), 13)) System.out.println("fibIter passed for value 7");
		else System.out.println("fibIter failed for value 7");
		if(valueTest(fibRecur(7), 13)) System.out.println("fibRecur passed for value 7");
		else System.out.println("fibRecur failed for value 7");

		//tests for 11
		if(valueTest(fibIter(11), 89)) System.out.println("fibIter passed for value 11");
		else System.out.println("fibIter failed for value 11");
		if(valueTest(fibRecur(11), 89)) System.out.println("fibRecur passed for value 11");
		else System.out.println("fibRecur failed for value 11");

		startTime = System.currentTimeMillis();
		resultIter = fibIter(testNum);
		endTimeIter = System.currentTimeMillis();
		totalTimeIter = endTimeIter - startTime;

		startTime = System.currentTimeMillis();
		resultRecur = fibRecur(testNum);
		endTimeRecur = System.currentTimeMillis();
		totalTimeRecur = endTimeRecur - startTime;

		System.out.println("Iterative calculation for " + testNum + " returned " + resultIter + " and finished in " + totalTimeIter);
		System.out.println("Recursive calculation for " + testNum + " returned " + resultRecur + " and finished in " + totalTimeRecur);
	}

	public static int fibIter(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;

		int last = 1;
  		int beforeLast = 0;
  		int result = 0;

  		for(int i = 2; i <= n; i++) {
	    	
	    	result = last + beforeLast;
	    
	    	beforeLast = last;
	    	last = result;

	    	
    	}
    	return result;
	}

	public static int fibRecur(int n) {
		if(n == 0) return 0;
		else if(n == 1) return 1;
		else return fibRecur(n-1) + fibRecur(n-2);
	}

	public static boolean valueTest(int result, int expected) {
		if(result == expected) {
			return true;
		} else {
			return false;
		}
	}
}

/*
$ java Fib 4
3
$ java Fib 7
13
$ java Fib 11
89
*/