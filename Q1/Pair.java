

public class Pair implements Comparable<Pair> {

	private double coefficient;
	private int exponent;

	public Pair(double coefficient, int exponent) {
		this.coefficient = coefficient;
		this.exponent = exponent;
	}

	public Pair(Pair pair) {

		this.coefficient = pair.coefficient;
		this.exponent = pair.exponent;

	}

	public double getCoefficient() {

		return coefficient;
	}

	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}

	public int getExponent() {
		return exponent;
	}

	public void setExponent(int exponent) {
		this.exponent = exponent;
	}

	/*
	 * For sorting the array by the exponent, The coefficient does not matter
	 */
	public int comparePairs(Pair pair) {

		int exponentCompareResult = this.compareTo(pair);

		switch (exponentCompareResult) {

		case 1:

			if (this.coefficient > 0)
				return 1;
			else
				return -1;

		case -1:
			if (pair.coefficient < 0)
				return 1;
			else
				return -1;

		case 0:

			if (this.coefficient > pair.coefficient)
				return 1;

			else if (this.coefficient < pair.coefficient)
				return -1;

			else
				return 0;

		}

		return 0;

	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Pair))
			return false;

		Pair pairObject = (Pair) obj;

		if (this.exponent == pairObject.exponent && this.coefficient == pairObject.coefficient)
			return true;

		return false;

	}

	@Override
	public int compareTo(Pair pair) {

		if (this.exponent > pair.exponent)
			return 1;

		else if (this.exponent < pair.exponent)
			return -1;

		return 0;

	}

	public String toString() {

		if (this.getExponent() == 0)
			return "" + this.coefficient;
		if (this.getExponent() == 1)
			return this.coefficient + "x";

		return this.coefficient + "x^" + this.exponent;

	}

}
