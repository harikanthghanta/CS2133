//Kyle Riedemann
//CS 2133

/*
Inheritance (20 points)

The findRoot() function in FunctionTest.java works great, but only specifically for the sine function.
That’s nice and all, but hardly general. We would like to be able to use the same code for any function at all, and we will use inheritance to make that happen. Create a new class called Function.java that supports an abstract method:

public abstract double evaluate(double x)

Refactor your FunctionTest.findRoot() method so that it belongs to the Function class, and instead of calling Math.sin(), it calls this evaluate() method. 
Note that findRoot() will no longer be static.
Write a class SinFunc.java that extends Function and implements evaluate() using Math.sin().
Write a similar class CosFunc.java that does the same for Math.cos(). 
Copy your code from Poly.java into a new class PolyFunc.java which also extends Function. 
Look at that – you’ve already implemented evaluate() for Poly.
In Function.main(), create some tests. 
Instantiate a few functions and find some roots. 
Verify that the root of sin(x) between 3 and 4 is the same as it was before. 
Find the root of cos(x) between 1 and 3. Find the positive root (x > 0) of x 2 − 3 and x 2 − x − 2.
Finally, for all of the classes in this problem (Function.java, SinFunc.java, CosFunc.java and PolyFunc.java), write javadoc comments explaining the purpose of each class and the uses of each method.
*/

public class FunctionRefactor {
	public static void main(String[] args) {

	}
}