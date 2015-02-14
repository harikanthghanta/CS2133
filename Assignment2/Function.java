//Kyle Riedemann
//CS 2133

/*
The findRoot() function in FunctionTest.java works great, but only specifically for the sine function.
That’s nice and all, but hardly general. We would like to be able to use the same code for any
function at all, and we will use inheritance to make that happen. Create a new class called
Function.java that supports an abstract method:

public abstract double evaluate(double x)

Refactor your FunctionTest.findRoot() method so that it belongs to the Function class, and instead
of calling Math.sin(), it calls this evaluate() method. Note that findRoot() will no longer be static.
Write a class SinFunc.java that extends Function and implements evaluate() using Math.sin().
Write a similar class CosFunc.java that does the same for Math.cos(). Copy your code from
Poly.java into a new class PolyFunc.java which also extends Function. Look at that – you’ve
already implemented evaluate() for Poly.
In Function.main(), create some tests. Instantiate a few functions and find some roots. Verify
that the root of sin(x) between 3 and 4 is the same as it was before. Find the root of cos(x)=
between 1 and 3. Find the positive root (x > 0) of x
Finally, for all of the classes in this problem (Function.java, SinFunc.java, CosFunc.java and
PolyFunc.java), write javadoc comments explaining the purpose of each class and the uses of each
method.
*/

/**
 * The purpose of this class is to provide subclasses with a way to find the root
 * of a continuous function between two numbers given an acceptable ammount of error.
 * The class must be extended and provide it's own evaluate class containing the 
 * continuous function for which the user wishes to find the roots.
 *
 * @author      Kyle Riedemann
 * @version     1.0
 * @since       02-10-2015
 */

public abstract class Function {
	/**
 	 * EPSILON is the ammount of acceptable error.
 	 */
	public static final double EPSILON = 0.00000001;

	/**
	 * Abstract method for subclasses impliment their
	 * contuous function that will be used with findRoot
	 *
	 * @param  x The value that will be evaluated for the implimented function
     * @return The value of the implimented function at the given value
	 */
	public abstract double evaluate(double x);

	/**
	 * findRoot will find the value of x where the function 
	 * evaluated is equal to 0 between points a and b
	 * <p>
 	 * The method works using recursive devision.
 	 * If the value of x is not within a certain level of error,
 	 * then we call the findRoot method again with x taking the place of a or b
 	 * <p>
	 *
	 * @param  a the first bound to search within
	 * @param  b the second bound to search within
	 * @param  epsilon the level of acceptable error
	 * @return Description text text text.
	 */
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

	public static void main(String[] args){
		System.out.println("\nSine Find Root\n");
		SinFunc sn = new SinFunc();
		System.out.println(sn.findRoot(3, 4, EPSILON));

		System.out.println("\nCosine Find Root\n");
		CosFunc cn = new CosFunc();
		System.out.println(cn.findRoot(1, 3, EPSILON));

		System.out.println("\nPolynomial Find Root\n");
		int[] coef1 = {-3, 0, 1};
		PolyFunc poly1 = new PolyFunc(coef1);

		int[] coef2 = {-2, -1, 1};
		PolyFunc poly2 = new PolyFunc(coef2);

		System.out.println(poly1.findRoot(0, 100, EPSILON));
        System.out.println(poly2.findRoot(0, 100, EPSILON));

        System.out.println("");
	}
}
