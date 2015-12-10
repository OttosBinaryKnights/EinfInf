/*
Deduktiver Algorithmus

Gegeben seien ein Fakt und eine Regel eines deduktiven Algorithmus (für natürliche Zahlen X und Y) wie folgt:
    f(0,1).
    X>0 AND f(X-1,Y) -> f(X,2*Y).
a) Was sind die Ergebnisse der Anfragen:
    f(X,64)? f(X+1,32) f(X+2,16) f(X+3,8) f(X+4,4) f(X+5,2) f(X+6,1) return f(6,64)
    f(X,67)? f(X+1,33) f(X+2,16) f(X+3,8) f(X+4,4) f(X+5,2) f(X+6,1) return f(6,67) -> nicht sicher
    f(3,Y)? f(2,2*y) f(1,2*2*y) f(0,2*2*2*1) return f(3,8)
b) Welche Relation beschreibt dieser deduktive Algorithmus für natürliche Zahlen X und Y?
   f(x)=y=2^x
*/
