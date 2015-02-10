//Kyle Riedemann
//CS 2133

/*
NOTES:

Complie this with Factorial.java in the same directory

Extra Credit:

BigDecimal and BigInteger differ from regular doubles and ints in that they are persion signed representations of 
whole and decimal nuumbers. They are more suited for calculting very percise values of pi than doubles, because 
there is not the chance of possible loss of percision that there is when using doubles for calculation.
*/

/*
π revisited (10 points)

In Assignment 1, you used the Gregory formula to compute an approximation of π. Here, you
will use Ramanujan’s series, discovered in 1910. It converges much faster than Gregory’s, and has
been used to calculate π to billions of digits. Implement Ramanujan.java exactly like Gregory.java,
taking a number k specified by the user on the command line and calculating π using the first k
terms of the Ramanujan series. The program should print this approximate value of π, as well as
the percentage error between this value and the one provided by Java in the constant Math.PI.

Ramanujan’s series:

Notice that this formula makes use of the factorial function. Call your Factorial.calculate method from Problem 1.

**Extra credit:** Look at the Java API definitions of BigDecimal and BigInteger. Rework your
Factorial and Ramanujan code (call the classes so mething else, like RamanujanBig, so that you don’t
overwrite your regular-credit work) to use these instead, and calculate π to 100 digits or more. Note
that, in order for the terms to be perfectly accurate, you also need a BigDecimal representation
of √2. There is unfortunately no native library support for calculating this; however, you can
implement it yourself using a BigDecimal version of the evaluate method you will write in Problem 6.
You will get a little extra credit simply by explaining (in comments in your Ramanujan code)
how BigDecimal and BigInteger differ from ordinary doubles and ints, and why the latter are
insufficient for calculating very precise values of π.
*/

public class Ramanujan {
	public static void main(String[] args) {
		//System.out.println(Factorial.calculate(4));
		
		int input = 0;

		if(args.length ==1) {
			input = Integer.parseInt(args[0]);
			System.out.println("Pi according to Ramanujan series: " + ramanujanSeries(input));
			System.out.println("This differs from Java’s value by " + percentageDifference(ramanujanSeries(input)) + " percent.");
		} 
		else {
			System.out.println("Please enter an int as an argument.");
			System.exit(0);	
		} 
	}

	public static double percentageDifference(double approx) {
		return (100 - ((approx / Math.PI) * 100));
	}

	public static double ramanujanSeries(int k) {
		double equationRight = 0;
		double result = 0;

		for(int i = 0; i < k; i++){
			equationRight += ((Factorial.calculate(4 * i)) * (1103 + (26390 * i))) / (Math.pow(Factorial.calculate(i), 4) * Math.pow(396, (4 * i)));	
		}
		equationRight *= ((2 * Math.sqrt(2)) / 9801);
		result = 1 / equationRight;

		return result;
	}
}