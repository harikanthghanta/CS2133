//Kyle Riedemann
//CS 2133

public class PolyFunc extends Function {
	private int[] coefficients;

	public PolyFunc(int[] coefficients){
		this.coefficients = coefficients;
	}

	public int polyFuncSize(){
		return this.coefficients.length;
	}

	public int degree(){
		return this.coefficients.length - 1;
	}

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

	public double evaluate(double x){
		double result = 0;

		for(int i = 0; i < this.polyFuncSize(); i++){
			result += coefficients[i] * Math.pow(x, i);
		}

		return result;
	}
}