public class Rectangle {
	private int x, y;
	private int width;
	private int height;

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public int getWidth(){
		return width;
	}

	public int getHeight(){
		return height;
	}

	public void setX(int x0){
		x=x0;
	}

	public void setY(int y0){
		y=y0;
	}

	public void setWidth(int w){
		width=w;
	}

	public void setHeight(int h){
		height=h;
	}

	public Rectangle(int x0, int y0, int w, int h) {
		x=x0;
		y=y0;
		width=w;
		height=h;

	}

	public String toString(){
		String recDataStr;
		recDataStr= "[" + x + " " + y + " " + width + " " + height + "]";
		return recDataStr;

	}

	public boolean proofIntersect(int pos1, int pos2, int pos3, int pos4){
		if ((pos1 <= pos3 && pos2 >= pos4) || (pos3 <= pos1 && pos4 >= pos2)) return true;
		if ((pos1 >= pos3 && pos1 <= pos4) || (pos2 >= pos3 && pos2 <= pos4)) return true;  //Prüft ob pos1 bzw pos2 zwischen 3 und 4 ist
		if ((pos3 >= pos1 && pos3 <= pos2) || (pos4 >= pos1 && pos4 <= pos2)) return true;  //Prüft ob pos3 bzw pos4 zwischen 1 und 2 ist
		return false;
	}

	public boolean intersect(Rectangle r2) {
		int thisRecX1 = this.getX();						//4 Ecken dieses Rechteckes
		int thisRecY1 = this.getY();
		int thisRecX2 = this.getWidth() + this.getX();
		int thisRecY2 = this.getHeight() + this.getY();

		int r2X1 = r2.getX();								//4 Ecken des r2 Rechteckes
		int r2Y1 = r2.getY();
		int r2X2 = r2.getWidth() + r2.getX();
		int r2Y2 = r2.getHeight() + r2.getY();

		if ((thisRecX1 <= r2X1) && (thisRecX2 >= r2X2) && (thisRecY1 <= r2Y1) && (thisRecY2 >= r2Y2)) return false;
		if ((r2X1 <= thisRecX1) && (r2X2 >= thisRecX2) && (r2Y1 <= thisRecY1) && (r2Y2 >= thisRecY2)) return false;
		if (proofIntersect(thisRecX1, thisRecX2, r2X1, r2X2) && proofIntersect(thisRecY1, thisRecY2, r2Y1, r2Y2)) return true;
		return false;
		/*
		 * Diese Funktion ergibt nur true, wenn:
		 * 		die Quadrate sich wirklich schneiden
		 * Liegen die Quadrate ineinander
		 * 			--> soll dieser Fall false zurück geben, so muss das logische UND (&&) durch die Gleichheit (==) ersetzt werden
		 *  			--> Sonderfall: Quadrate liegen aufeinander: liefert false
		 * Verändert man die Frage von Schnittkanten auf Flächen, die aufeinander leigen, so müssen die ersten beiden Zeilen der
		 * Funktion proofIntersec() wegfallen.
		 *
		 * Berühren sich die Rechtecke an einer Stelle, so ist der Rückgabewert true. Änderung ist möglich durch durch Fallabfrage.
		 *
		 */

	}

	public Rectangle union(Rectangle r2) {
		int thisRecX = this.getX();
		int thisRecY = this.getY();
		int thisRecW = this.getWidth();
		int thisRecH = this.getHeight();

		int r2X = r2.getX();
		int r2Y = r2.getY();
		int r2W = r2.getWidth();
		int r2H = r2.getHeight();

		if (r2X < thisRecX){								//Vergleich dieses x-Wertes mit dem von r2--> der kleinere wird zurückgegeben
			thisRecX = r2X;
		}

		if (r2Y < thisRecY){								//Vergleich dieses y-Wertes mit dem von r2--> der kleinere wird zurückgegeben
			thisRecY = r2Y;
		}

		if ((thisRecX+thisRecW) < (r2X+r2W)){				//die weiteste ausdehnung im Koordinatensystem wird genommen
			thisRecW = (r2X + r2W) - thisRecX;				//hart r2 die größere Ausdehnung wir die Weite verändert
		}

		if ((thisRecY+thisRecH) < (r2Y+r2H)){				//die weiteste ausdehnung im Koordinatensystem wird genommen
			thisRecH = (r2Y + r2H) - thisRecY;				//hart r2 die größere Ausdehnung wir die Weite verändert
		}

		Rectangle newRec = new Rectangle(thisRecX, thisRecY, thisRecW, thisRecH);
		return newRec;

	}

	public static void main(String[] args) {
		Rectangle rec = new Rectangle(0,0,2,2);
		Rectangle r2 = new Rectangle(3,2,3,3);
		Rectangle r1 = new Rectangle(1,1,1,1);

		rec.setHeight(3);

		System.out.println(rec.height);
	    System.out.println(rec.toString());

	    rec = r1.union(r2);
	    System.out.println(rec.toString());
	    /*
	     * 1. Fall:
	     * ^
	     * |      ______      Die beiden Rechtecke schneiden sich. Das Ergebis sollte true sein
	     * |     |Rec2  |
	     * |  ___|__    |
	     * | |   |__|___|
	     * | |Rec1  |
	     * | |______|
	     * |_______________>
	     */

	    Rectangle rec1 = new Rectangle(1,1,2,2);
	    Rectangle rec2 = new Rectangle(2,2,2,2);
	    System.out.println("Im Fall 1: Schneiden sich die Rechtecke (schneiden sich)? " + rec1.intersect(rec2));

	    /*
	     * 2. Fall
	     * ^
	     * |        ___         Die beiden Rechtecke schneiden sich nicht. Das Ergebnis sollte false sein.
	     * |       |   |
	     * |  ___  |___| Rec2
	     * | |   |
	     * | |___| Rec1
	     * |________________>
	     */

	    rec1 = new Rectangle (1,1,1,1);
	    rec2 = new Rectangle (3,2,1,1);
	    System.out.println("Im Fall 2: Schneiden sich die Rechtecke(schnieden sich nicht)? " + rec1.intersect(rec2));

	    /*
	     * 3. Fall
	     * ^
	     * |  _________         Die beiden Rechtecke liegen ineinander. Das Ergebnis sollte false sein.
	     * | |  _____  |
	     * | | | Rec2| |
	     * | | |_____| |
	     * | |_________| Rec1
	     * |________________>
	     */

	    rec1 = new Rectangle (1,1,3,3);
	    rec2 = new Rectangle (2,2,1,1);
	    System.out.println("Im Fall 3: Schneiden sich die Rechtecke(ineinander)? " + rec1.intersect(rec2));

	    rec1 = new Rectangle (1,1,3,3);
	    rec2 = new Rectangle (1,1,3,3);
	    System.out.println("Im Fall 4: Schneiden sich die Rechtecke(gleich)? " + rec1.intersect(rec2));

	    rec1 = new Rectangle (2,1,3,2);
	    rec2 = new Rectangle (3,2,1,3);
	    System.out.println("Im Fall 5: Schneiden sich die Rechtecke(Eine Seite drin)? " + rec1.intersect(rec2));
	}

}
