/*
Streit bei Simpsons

Gegeben seien die beiden folgenden rekursiven Algorithmen (n sei dabei eine natürliche Zahl von 0 an gerechnet):
Algorithm:

  marge(n)
  Input:     n ganzzahlig, n>=0
  Output:    ?
    if n = 0 then 1
            else n - homer(marge(n - 1))
    fi

Algorithm:

  homer(n)
  Input:     n ganzzahlig, n>=0
  Output:    ?
    if n = 0 then 0
            else n - marge(homer(n - 1))
    fi

Jetzt kommt noch die Funktion dispute hinzu, die ermittelt, ob am Hochzeitstag gestritten wird:
Algorithm:

  dispute(n)
  Input:     n ganzzahlig, n>=0
  Output:    ?
    not(marge(n) = homer(n))

hinzu.
Programmieren Sie die obigen Algorithmen als Java-Methoden

  public static int marge(int n)

  public static int homer(int n)

  public static boolean dispute(int n)

Wie entwickelt sich die Differenz der Streits an den Hochzeitstagen? Am nullten und am ersten Hochzeitstag gibt es Streit. Demzufolge ist die erste Differenz zwischen den Streitereien 1 (nämlich ein Jahr). Schreiben Sie die Methode

  public static int[] differenceDisputes(int x)

zur Bestimmung der ersten x Differenzen zwischen den Streits an den Hochzeitstagen. Erkennen Sie eine Gesetzmäßigkeit bzw. Zahlenfolge?
Schreiben Sie innerhalb der main-Methode einen geeigneten Testrahmen, damit Sie folgende Fragen beantworten können:
Finden dann die Kupferne (copper or wool wedding - nach 7 Jahren)- und die Silberne Hochzeit (silver wedding) in Frieden oder im Streit statt?
Verstehen sich Homer und Marge über die Jahre hinweg besser oder schlechter?
*/
