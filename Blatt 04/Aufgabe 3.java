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
