/*
Klasse Clock

Uhrzeiten werden durch die Angaben von Stunden (zwischen 0 und 23) und Minuten (zwischen 0 und 59) repräsentiert.
Schreiben Sie eine Klasse Clock, die solche Zeit-Objekte erzeugen, addieren und ausgeben kann.
Die Klasse soll enthalten:
die Attribute: Stunden und Minuten (beide vom Typ int) mit den get-Methoden getMin und getH,
verschiedene Konstruktoren zum Erzeugen der Objekte durch Angabe der Stunden und Minuten, nur durch Minuten oder durch Angaben in der Form "hour:min",
die Methoden (overloading)
  public Clock add(int min),

  public Clock add(Clock c),
zum Addieren von Zeiten,
die Methode
  public String toString()
zur Ausgabe der Uhrzeit als String.
Testen Sie Clock in main. Erzeugen Sie darin zufällige Clock-Objekte und prüfen Sie daran die obigen Methoden.
*/
