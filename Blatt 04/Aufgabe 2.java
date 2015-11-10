/*
Variante der Ackermann-Funktion

Die folgende Funktion berechnet eine Version (nach Abelson, Sussman: Structure and Interpretation of Computer Programs) der mathematischen Funktion mit dem Namen Ackermann:
Algorithm Ackermann (x, y):

   Input: natuerliche Zahlen x, y
   Output: Ackermann-Zahl

   if (y = 0) then 0
   if (x = 0) then 2*y
   if (y = 1) then 2
   else Ackermann(x-1, Ackermann(x, y-1))

Schreiben Sie eine Java-Methode

  public static BigInteger ackermann(BigInteger x, BigInteger y)

zur Berechnung der Ackermann-Zahl. Hinweis: Informieren Sie sich über die Klasse BigInteger in der Java-API (http://download.oracle.com/javase/6/docs/api/index.html).
Welches sind die Werte der Methodenaufrufe ackermann(1, 10), ackermann(2, 4), ackermann(3, 3)?
Die Klasse BigInteger dient der Verarbeitung beliebig großer ganzer Zahlen. Warum gibt es bei der Berechnung der Ackermann-Zahl trotzdem Probleme?
*/

	import java.math.BigInteger;

	public class ackermann {

	public static final BigInteger TWO = BigInteger.valueOf(2);

	public static BigInteger ackermann(BigInteger x, BigInteger y){

		if (y.equals(BigInteger.ZERO)) return y;
		if (x.equals(BigInteger.ZERO)) return y.multiply(TWO);
		if (y.equals(BigInteger.ONE)) {
			return TWO;
		} else {
			return ackermann(x.subtract(BigInteger.ONE), ackermann(x,y.subtract(BigInteger.ONE)));
		}

	}

	public static void main(String[] args) {


		System.out.println(ackermann(BigInteger.ONE,BigInteger.TEN));			//Ergebnis: 1024
		System.out.println(ackermann(new BigInteger("2"),new BigInteger("4")));
		System.out.println(ackermann(new BigInteger("3"),new BigInteger("3")));


	}

}
