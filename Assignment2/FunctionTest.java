//Kyle Riedemann
//CS 2133

/*
Root finding (20 points)

The roots of a continuous function are points at which the value of the function is equal to zero.
If we happen to know a value for which the function is positive and another value for which it is
negative, then we know for certain that somewhere between the two values lies a zero. In other
words, if f (a) > 0 and f (b) < 0, then there exists a value x between a and b for which f (x) = 0.
This fact suggests that we can zero in on the value of x using the following algorithm, where
is the amount of error we are willing to tolerate:

Write a class FunctionTest.java and implement the following method:
public static double findRoot(double a, double b, double epsilon)
Within findRoot(), use Math.sin() as the function to be evaluated. In your main function, print
out the root of sin(x) that falls between 3 and 4, to within 0.00000001. Does the number look
familiar?
*/

public class FunctionTest extends Function {
	public static final double EPSILON = 0.00000001;

	public static void main(String[] args) {
		FunctionTest ft = new FunctionTest();

		System.out.println(ft.findRoot(3, 4, EPSILON));
	}

	public double findRoot(double a, double b,  double epsilon) {
		double x = (a + b) / 2;
		if (Math.abs(a - x) < epsilon) {
			return x;
		} else if (evaluate(a) > 0 && evaluate(x) > 0 || evaluate(a) < 0 && evaluate(x) < 0){
			return findRoot(x, b, EPSILON);
		} else {
			return findRoot(a, x, EPSILON);
		}
	}

	public double evaluate(double param){
		return Math.sin(param);
	}
}