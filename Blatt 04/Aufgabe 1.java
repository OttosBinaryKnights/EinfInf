/*
Hornerschema

Reelle Polynome beliebigen Grades n können als Arrays der Länge n + 1
repräsentiert werden:

 ![polynom](polynom.png)

Schreiben Sie eine Methode

public static double evalSimple(double[] a, double x),

die durch sukzessive Summation der Ausdrücke aixi, 0≤i≤n den Funktionswert f(x) für eine Variable x berechnet. Wieviele Schleifendurchläufe werden benötigt (in Abhängigkeit von n)?
Hinweis: Sie dürfen nur Addition und Multiplikation verwenden.
Schreiben Sie eine weitere iterative Methode

public static double evalHorner(double[] a, double x),

zur Berechnung von f(x) nach dem Hornerschema, d. h. nach der Formel
f(x) = (((...((anx + an-1)x + an-2)...)x + a2)x + a1)x + a0.

Bestimmen Sie die Anzahl der Schleifendurchläufe, die mit dem Horner-Verfahren benötigt werden. Vergleichen Sie die Algorithmen aus a) und b) miteinander.
Schreiben Sie eine rekursive Variante des Hornerschemas als Methode

public static double evalHornerRek(double[] a, double x)
*/
