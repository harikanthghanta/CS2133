//Kyle Riedemann
//CS 2133

/*
Polynomials (30 points)
Write a class Poly.java to represent polynomials (ie, functions of the form ax n + bx n−1 + · · · + cx 2 + dx + e). Implement the following methods:

• Poly(int[] coefficients): Constructor for an array of coefficients where c[n] is the coefficient of
x n . In other words, the polynomial 2x 5 + 3x 4 − 8x 2 + 4 would be represented by the array [4, 0, −8, 0, 3, 2]. This way, if I want to know the 
coefficient of x 2 , I look at c[2], and get −8. This convenience is worth the confusion that arises because we usually write arrays left-to-right 
starting from the smallest index, whereas we usually write polynomials left-to-right starting from the largest coefficient.

• int degree(): Return the power of the highest non-zero term

• String toString(): Overriding the Object class’s toString method, this should return a String representation of the polynomial using x as the variable, 
arranged in decreasing order of exponent and printing nothing for terms with a coefficient of zero. For example, the Poly represented by the 
array [4, 0, −8, 0, 3, 2] should return the string:

2x^5+3x^4-8x^2+4 

• Poly add(Poly a): To add two polynomials, simply add together each scale degree in turn. 
Thus, (2x 5 + 3x 4 − 8x 2 + 4) + (x 3 + 4x 2 − 2x) = (2x 5 + 3x 4 + x 3 − 4x 2 − 2x + 4). 
Create a method that constructs and returns a new Poly object with a new coefficient array created by adding the coefficients of the current object 
and the Poly object a passed as an argument to the add() function.

• double evaluate(double x): Return the value of the function at the point x. In other words, if the Poly object 
represents 2x 5 + 3x 4 − 8x 2 + 4 and evaluate(2.0) is called, the method should calculate 2(2) 5 + 3(2) 4 − 8(2) 2 + 4 and return 84.

Within the main() method of the Poly class, create a series of tests which exercise each of these methods and report their success or failure.
*/

public class Poly {
	private int[] coefficients;

	public Poly(int[] coefficients){
		this.coefficients = coefficients;
	}

	public int polySize(){
		return this.coefficients.length;
	}

	public int degree(){
		return this.coefficients.length - 1;
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();

		for(int i = this.polySize() - 1; i >= 0; i--){
			if(i == this.polySize() - 1){
				sb.append(this.coefficients[i] + "x^" + i);
			} else if(i == 0){
				if(this.coefficients[i] > 0) {
					sb.append("+" + this.coefficients[i]);
				} else {
					sb.append(this.coefficients[i]);
				}
			} else if(i == 1){
				if(this.coefficients[i] > 0){
					sb.append("+" + this.coefficients[i] + "x");
				} else {
					sb.append(this.coefficients[i] + "x");
				}
			} else if(this.coefficients[i] == 1){
				sb.append("+x^" + i);
			} else {
				if(this.coefficients[i] > 0){
					sb.append("+" + this.coefficients[i] + "x^" + i);
				} else {
					sb.append(this.coefficients[i] + "x^" + i);
				}
			}
		}
		
		return sb.toString();
	}

	public Poly add(Poly a){
		if(this.polySize() < a.polySize()){
			int[] newPoly = new int[a.polySize()];
			for(int i = 0; i < this.polySize() - 1; i++){
				newPoly[i] = this.coefficients[i] + a.coefficients[i];
			}
			for(int i = this.polySize() - 1; i < a.polySize(); i++){
				newPoly[i] = a.coefficients[i];
			}
			Poly myPoly = new Poly(newPoly);
			return myPoly;
		} else if(this.polySize() > a.polySize()){
			int[] newPoly = new int[this.polySize()];
			for(int i = 0; i < a.polySize() - 1; i++){
				newPoly[i] = this.coefficients[i] + a.coefficients[i];
			}
			for(int i = a.polySize() - 1; i < this.polySize(); i++){
				newPoly[i] = this.coefficients[i];
			}
			Poly myPoly = new Poly(newPoly);
			return myPoly;
		} else {
			int[] newPoly = new int[a.polySize()];
			for(int i = 0; i < a.polySize() - 1; i++){
				newPoly[i] = this.coefficients[i] + a.coefficients[i];
			}
			Poly myPoly = new Poly(newPoly);
			return myPoly;
		}
	}

	public static void main(String[] args) {
		int[] test1 = {4, 0, -8, 0, 3, 2};
		Poly poly1 = new Poly(test1);

		System.out.println("\n" + poly1.toString() + " should be 2x^5+3x^4-8x^2+4\n"); //should print 2x^5+3x^4-8x^2+4

		int[] test2 = {0, -2, 4, 1};
		Poly poly2 = new Poly(test2);

		Poly poly3 = poly1.add(poly2);

		System.out.println("\n" + poly3.toString() + " should be 2x^5+3x^4+x3-4x^2-2x+4\n"); //should print 2x^5+3x^4+x3−4x^2−2x+4

		int[] test4 = {4, -2, -4, 1, 3, 2};
		Poly poly4 = new Poly(test4);
		System.out.println("\n" + poly3.toString() + "\n");
	}
}