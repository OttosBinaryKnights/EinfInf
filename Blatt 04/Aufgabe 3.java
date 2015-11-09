/*
Fibonacci-Zahlen

Eine besondere Folge von Zahlen sind die Fibonacci-Zahlen, die rekursiv definiert werden können als

  fib(x) =	if (x = 0) ∨ (x = 1) then 1
  else fib(x-2) + fib(x-1)
  fi

Schreiben Sie eine rekursive Methode

  public static BigInteger fib1(int n)

zur Berechnung der x-ten Fibonacci-Zahl. Geben Sie im Hauptprogramm die ersten 15 Fibonacci-Zahlen aus.
Zeigen Sie am Beispiel fib1(5), wie die Anzahl der Aufrufe dieser Methode wächst (Baumrekursion) (Lösung als Block-Kommentar).
Formulieren Sie eine iterative Methode

  public static BigInteger fib2(int n)

zur Berechnung der Fibonacci-Zahlen und zeigen Sie am Beispiel fib2(5), dass fib2 effizienter arbeitet als fib1.
Hinweis: Merken Sie sich jeweils die beiden Vorgänger in gesonderten Variablen.
Berechnen Sie innerhalb der main-Methode nach beiden Varianten die Fibonacci-Zahl von n = 23 und zählen Sie dabei die notwendigen Schleifendurchläufe bzw. rekursiven Aufrufe.
*/

import java.math.BigInteger;

public class fibonacci {
	static int countIter=0;
	static int countRek=0;

	public static BigInteger fib2(int n){
		BigInteger fib = BigInteger.ZERO;
	    BigInteger currentFib = BigInteger.ZERO;
	    BigInteger nextFib = BigInteger.ONE;

	    for (int i=0;i <= n;i++) {
	     fib = nextFib;
	     nextFib=nextFib.add(currentFib);
	     currentFib = fib;
	     countIter++;
	    }
	    return fib;
	}

	public static BigInteger berechneFib1(BigInteger fib){
		if (fib.equals(BigInteger.ZERO) || fib.equals(BigInteger.ONE)){
			return new BigInteger("1");
		} else {
			countRek++;
			return (berechneFib1(fib.subtract(new BigInteger("2"))).add(berechneFib1(fib.subtract(BigInteger.ONE))));
		}
	}

	public static BigInteger fib1(int n){
		if (n==0 || n==1){
			return new BigInteger("1");
		} else {
			return berechneFib1(new BigInteger(String.valueOf(n)) );
		}
	}

	public static void main(String[] args) {

		 //for (int i=0;i<16;i++){
		//	System.out.println(fib1(i));
		 //}
		 //countRek=0;
		 //fib1(5);
		 //System.out.println(countRek);
		 countRek=0;
		 System.out.println("Iterativ berechnet ist die 23. Fibonaccizahl " + fib2(5) + ". Es wurden " + countIter + " Durchläufe verwendet.");
		 System.out.println("Rekursiv berechnet ist die 23. Fibonaccizahl " + fib1(5) + ". Es wurden " + countRek + " Durchläufe verwendet.");


	}

}
