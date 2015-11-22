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

public class simpsonsFight {

	public static int[] differenceDisputes(int x){
		int[] diffDisp = new int[x];
		int lastDispute = 0;
		int actualDispute = 1;
		int i = 1;

		while (i<x){
			if (dispute(actualDispute)==true){
				diffDisp[i] = (actualDispute-lastDispute);
				lastDispute=actualDispute;
				i++;
			}
			actualDispute++;
		}
		return diffDisp;
	}

	public static boolean dispute(int n){
		if (marge(n)==homer(n)){
			return false;
		}else return true;
	}

	public static int homer(int n){
		if (n<=0){
			return 0;
		} else {
			return n-marge(homer(n-1));
		}
	}

	public static int marge(int n){
		if (n==0){
			return 1;
		} else if (n<0){
			return 0;
		} else {
			return n - homer(marge(n-1));
		}
	}

	public static void main(String[] args) {
		System.out.println("Haben Homer und Marge am 7. Hochzeitstag einen Streit? " + dispute(7));		//Ja
		System.out.println("Haben Homer und Marge am 25. Hochzeitstag einen Streit? " + dispute(25));	//Nein
		for (int i=1;i<25;i++) System.out.println(dispute(i));

		int[] test=new int[8];
		test=differenceDisputes(8);

		for (int i=0;i<test.length;i++){			//Dies ist die Fibonacci-Folge
			System.out.println(test[i]);
		}

		//Homer und Marge verstehen sich im Laufe der Zeit besser

	}

}
