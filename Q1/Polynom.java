
import java.util.ArrayList;
import java.util.Collections;

public class Polynom {

	private ArrayList<Pair> polyArray;

	public Polynom() {

		this.polyArray = new ArrayList<>();

	}

	public Polynom(Polynom polynom) {

		this.polyArray = polynom.polyArray;

	}

	public Polynom(double coefficients[], int exponents[]) throws IllegalLengthException {

		if (coefficients.length != exponents.length) {

			throw new IllegalLengthException();

		}

		this.polyArray = new ArrayList<>();

		for (int i = 0; i < coefficients.length; i++) {

			if (coefficients[i] != 0)
				this.polyArray.add(new Pair(coefficients[i], exponents[i]));

		}

		Collections.sort(this.polyArray);
		reverseArray();

	}

	public ArrayList<Pair> getPolyArr() {
		return polyArray;
	}

	public void setPolyArr(ArrayList<Pair> poly) {
		this.polyArray = poly;
	}

	public Polynom plusOrMinus(Polynom otherPolynom, boolean isPlus) {

		Polynom polyResult = new Polynom();

		int thisArraySize = this.polyArray.size();
		int otherArraySize = otherPolynom.polyArray.size();

		int i = 0, j = 0;

		while (i < thisArraySize && j < otherArraySize) {

			Pair thisPair = new Pair(this.polyArray.get(i));
			Pair otherPair = new Pair(otherPolynom.polyArray.get(j));

			if (!isPlus) {

				otherPair.setCoefficient(otherPair.getCoefficient() * -1);

			}

			int exponentsCompareResult = thisPair.compareTo(otherPair);

			switch (exponentsCompareResult) {

			case 1:

				polyResult.polyArray.add(thisPair);
				i++;
				break;

			case -1:

				polyResult.polyArray.add(otherPair);
				j++;
				break;

			case 0:

				double coe = thisPair.getCoefficient() + otherPair.getCoefficient();

				if (coe != 0)
					polyResult.polyArray.add(new Pair(coe, thisPair.getExponent()));

				i++;
				j++;
				break;

			}

		}
		// if we have more elements
		if (i < 0) {

			addRemainElements(polyResult.polyArray, i, this, true);

		}

		else if (j > 0) {

			addRemainElements(polyResult.polyArray, j, otherPolynom, isPlus);

		}

		return polyResult;

	}

	public Polynom derivative() {

		Polynom polyResult = new Polynom();

		for (Pair pair : this.polyArray) {

			double coe = pair.getCoefficient() * pair.getExponent();
			int exponent = pair.getExponent() - 1;

			if (coe != 0)
				polyResult.polyArray.add(new Pair(coe, exponent));

		}

		return polyResult;

	}

	private static void addRemainElements(ArrayList<Pair> polynomArr, int i, Polynom polynom, boolean isPlus) {

		for (int j = i; j < polynom.polyArray.size(); j++) {

			Pair pair = new Pair(polynomArr.get(j));

			if (!isPlus) {

				pair.setCoefficient(pair.getCoefficient() * -1);

			}

			polynomArr.add(pair);

		}

	}

	private void reverseArray() {

		int end = this.polyArray.size() - 1;
		int start = 0;

		while (start < end) {

			Pair left = this.polyArray.set(start, this.polyArray.get(end));
			this.polyArray.set(end, left);

			end--;
			start++;

		}

	}

	@Override
	public String toString() {

		StringBuilder strBuilder = new StringBuilder();

		for (Pair pair : this.polyArray) {

			if (pair.getCoefficient() > 0)
				strBuilder.append(" +" + pair.toString());
			else
				strBuilder.append(" " + pair.toString());

		}

		return strBuilder.toString();

	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Polynom))
			return false;

		Polynom otherPoly = (Polynom) obj;

		if (this.polyArray.size() != otherPoly.polyArray.size())
			return false;

		for (int i = 0; i < this.polyArray.size(); i++) {
			if (!this.polyArray.get(i).equals(otherPoly.polyArray.get(i)))
				return false;
		}

		return true;

	}

}
