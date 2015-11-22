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

public class Clock implements Comparable<Clock>{
	private int h;
	private int min;

	public int getMin() {
		return min;
	}

	public int getH() {
		return h;
	}

	public Clock(int stunden, int minuten){
		if (minuten > 59){
			stunden = stunden + minuten/60;
			minuten = minuten % 60;
		}
		min=minuten;

		if (stunden > 23){
			stunden = stunden%24;
		}
		h=stunden;
	}

	public Clock(int minuten){
		h=0;
		if (minuten > 59){
			h = h + minuten/60;
			minuten = minuten % 60;
		}
		min = minuten;

		if (h > 23){
			h = h % 24;
		}
	}

	public Clock(String strClock){
		int a = strClock.length();
		int i = 0;
		String Stunden = "";
		String Minuten = "";

		while(strClock.charAt(i) != ':'){
			Stunden = Stunden + strClock.charAt(i);
			i++;
		}

		i++;
		for (;i<a;i++){
			Minuten = Minuten + strClock.charAt(i);
		}

		h = Integer.parseInt(Stunden);
		min = Integer.parseInt(Minuten);

		if (min > 59){
			h = h + min/60;
			min = min % 60;
		}

		if (h > 23){
			h = h%24;
		}

	}

	public Clock(){
		h=0;
		min=0;
	}

	public Clock add(int min) {
		int newMin = this.min;
		int newH = this.h;
		newMin = newMin + min;

		Clock newClock = new Clock(newH, newMin);
		return newClock;

	}

	public Clock add(Clock c) {
		int newMin = this.min + c.min;
		int newH = this.h + c.h;

		Clock newClock = new Clock(newH, newMin);
		return newClock;

	}

	public String toString() {
		String strClock;

		strClock = this.h + ":" + this.min;
		return strClock;
	}

	public int compareTo(Clock c){
		if((this.getH()*60+this.getMin()) < (c.getH()*60+c.getMin())) return (-1);
		if((this.getH()*60+this.getMin()) > (c.getH()*60+c.getMin())) return 1;
		else return 0;
	}

	public boolean equalTo(Clock c){
		if((this.getH()*60+this.getMin()) == (c.getH()*60+c.getMin())) return true;
		else return false;
	}

	public static void main(String[] args) {
		Clock newClock = new Clock(23,60);			//Angabe der Zeit mit Clock(minuten, stunden)
		System.out.println(newClock.toString());

		newClock = new Clock(12345);				//Angabe der Zeit nur in Minuten
		System.out.println(newClock.toString());

		newClock = new Clock("25:61");				//Angabe der Zeit über ein String der Form "Stunden:Minuten"
		System.out.println(newClock.toString());

		Clock nextClock = new Clock();
		nextClock = newClock.add(20);				//Addieren von Minuen zu einer Clock
		System.out.println(nextClock.toString());

		nextClock = nextClock.add(nextClock);		//Addieren einer Clock zu einer Clock
		System.out.println(nextClock.toString());

	   }

}
