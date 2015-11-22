/*
Polynom: Differentiation (Ableitung)

Reelle Polynome beliebigen Grades n können als Arrays der Länge n + 1 repräsentiert werden:

![Polynom](polynom.png)

Implementieren sie eine Java Methode

public static double[] diffPoly(double[] coeffs),

die die Koeffizienten des einmal differenzierten (abgeleiteten) Polynoms zurück gibt.

Beispiel: 7+5x+3x² (entspricht [7,5,3]) --> 5+6x (entspricht [5,6])
*/

public class differentitation {

	public static double[] diffPoly(double[] coeffs){
		int n = coeffs.length-1;
		double[] diffArray = new double[n];

		for (int i=0; i<n;i++){
			diffArray[i]=coeffs[i+1]*(i+1);
		}

		return diffArray;
	}

	public static double[] diffPoly2(double[] coeffs, int n){
		double[] newCoeffs = new double[coeffs.length-1];

		if (n>=coeffs.length) return new double[0];

		for (int i=1; i<n; i++){
			newCoeffs=diffPoly(coeffs);
			coeffs=newCoeffs;
		}

		return newCoeffs;
	}

	public static void main(String[] args) {
		double[] coeffs = {1,2,3,4};
		String printIt="[" + diffPoly(coeffs)[0];

		for (int i=1;i<coeffs.length-1;i++){
			printIt = printIt + ", " + diffPoly2(coeffs, 4)[i];
		}
		System.out.println(printIt + "]");



	}

}
