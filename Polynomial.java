// no-arg constructor ()
// constructor (double[])
// .add (Polynomial)
// .evaluate (double)
// .hasRoot (double)

public class Polynomial {
	double[] coeffs;

	public Polynomial() {
		this.coeffs = new double[]{0};
	}

	public Polynomial(double[] coeff_arr) {
		this.coeffs = coeff_arr;
	}

	public Polynomial add(Polynomial add_arr) {
		int min_len = this.coeffs.length;
		int max_len = add_arr.coeffs.length;
		int i = 0;

		if (add_arr.coeffs.length < min_len ) {
			min_len = add_arr.coeffs.length;
			max_len = this.coeffs.length;
		}
		double[] result = new double[max_len];


		while (i < min_len) {
			result[i] = this.coeffs[i] + add_arr.coeffs[i];
			i++;
		}
		
		if (i < this.coeffs.length) {
			while (i < this.coeffs.length) {
				result[i] = this.coeffs[i];
				i++;
			}
		}
		else if (i < add_arr.coeffs.length) {
			while (i < add_arr.coeffs.length) {
				result[i] = add_arr.coeffs[i];
				i++;
			}
		}
		
		Polynomial newPoly = new Polynomial(result);
		return newPoly;
	}

	public double evaluate(double eval) {
		double result = 0;
		for (int i = 0; i < this.coeffs.length; i++) {
			result += this.coeffs[i]*Math.pow(eval, i+1);
		}
		return result;
	}

	public boolean hasRoot(double root) {
		double evaluated = this.evaluate(root);
		return evaluated == 0;
	}
}