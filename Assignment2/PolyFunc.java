//Kyle Riedemann
//CS 2133

/**
 * This class impliments evaluate to return the result of
 * the evaluation of a polynomial. Also provides functionality
 * for creating and manipulating polynomials.
 *
 * @author      Kyle Riedemann
 * @version     1.0
 * @since       02-10-2015
 */
public class PolyFunc extends Function {
    /**
     * Array to hold the values of the polynomial's
     * coefficients. The values of the coefficients
     * go in the index of the exponent. A 0 can be put
     * in the array if the polynomial does not contain
     * a value for a particular exponent.
     */
	private int[] coefficients;

    /**
     * Default constructor for polynomial objects
     *
     * @param coefficients the array of coefficients described above
     */
	public PolyFunc(int[] coefficients){
		this.coefficients = coefficients;
	}

    /**
     * Method that returns the length of the array
     * of the coefficient array that belongs to the
     * polynomail.
     *
     * @return this.coefficients.length the lenth of the array of the object
     */
	public int polyFuncSize(){
		return this.coefficients.length;
	}

    /**
     * Returns the power of the highest term.
     *
     * @return this.coefficients.length - 1
     */
	public int degree(){
		return this.coefficients.length - 1;
	}

    /**
     * Method to convert the polynomial to a string.
     *
     *
     * @return sb.toString() The StringBuilder used to convert the polynomial to a string returned as a string
     */
	public String toString(){
		StringBuilder sb = new StringBuilder();

		for(int i = this.polyFuncSize() - 1; i >= 0; i--){
			if(i == this.polyFuncSize() - 1){
				sb.append(this.coefficients[i] + "x^" + i);
			} else if(i == 0){
				if(this.coefficients[i] > 0) {
					sb.append("+" + this.coefficients[i]);
				} else {
					sb.append(this.coefficients[i]);
				}
			} else if(i == 1){
				if(this.coefficients[i] == 0){
					continue;
				} else if(this.coefficients[i] > 0){
					sb.append("+" + this.coefficients[i] + "x");
				} else {
					sb.append(this.coefficients[i] + "x");
				}
			} else if (this.coefficients[i] == 0) {
				continue;
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

    /**
     * Method to add a polynomial to the polynomail object that calls this method.
     *
     * @param a polynomail to be added to the object this is called from
     * @return myPolyFunc a new polynomail object that is the result of the addition
     */
	public PolyFunc add(PolyFunc a){
		if(this.polyFuncSize() < a.polyFuncSize()){
			int[] newPolyFunc = new int[a.polyFuncSize()];
			for(int i = 0; i < this.polyFuncSize() - 1; i++){
				newPolyFunc[i] = this.coefficients[i] + a.coefficients[i];
			}
			for(int i = this.polyFuncSize() - 1; i < a.polyFuncSize(); i++){
				newPolyFunc[i] = a.coefficients[i];
			}
			PolyFunc myPolyFunc = new PolyFunc(newPolyFunc);
			return myPolyFunc;
		} else if(this.polyFuncSize() > a.polyFuncSize()){
			int[] newPolyFunc = new int[this.polyFuncSize()];
			for(int i = 0; i < a.polyFuncSize() - 1; i++){
				newPolyFunc[i] = this.coefficients[i] + a.coefficients[i];
			}
			for(int i = a.polyFuncSize() - 1; i < this.polyFuncSize(); i++){
				newPolyFunc[i] = this.coefficients[i];
			}
			PolyFunc myPolyFunc = new PolyFunc(newPolyFunc);
			return myPolyFunc;
		} else {
			int[] newPolyFunc = new int[a.polyFuncSize()];
			for(int i = 0; i < a.polyFuncSize() - 1; i++){
				newPolyFunc[i] = this.coefficients[i] + a.coefficients[i];
			}
			PolyFunc myPolyFunc = new PolyFunc(newPolyFunc);
			return myPolyFunc;
		}
	}

    /**
     * Method to evaluate a polynomial for a given number
     *
     * @param x The variable to evaluate a polynomial at
     * @return result The total value of the polynomial at a specific number
     */
	public double evaluate(double x){
		double result = 0;

		for(int i = 0; i < this.polyFuncSize(); i++){
			result += coefficients[i] * Math.pow(x, i);
		}

		return result;
	}
}