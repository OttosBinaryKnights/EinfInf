/*
Weihnachtsgeschenke

Zum Einwickeln der Weihnachtsgeschenke stehen Ihnen als Materialien rotes Einwickelpapier
sowie Schleifendband zur Verfügung. Das Papier kostet 10 EUR je Rolle, wobei 5 m2 auf jeder
Rolle sind, Schleifenband kostet 3 EUR je Meter. Die Geschenke haben Quaderform, Zylinderform und Kugelform.

Folgende Klasse sei gegeben:

    abstract class Present{
      abstract double surface();
      abstract double computeRibbonLength();
      double computePaperSize(){  // same for all presents
        return surface() * 1.5;  // 50% waste
      }
    }

Die Klassen Cuboid, Cylinder und Ball für die verschiedenen Geschenkformen erben von Present.

Diese Unterklassen sollen geeignete Konstruktoren aufweisen, um die Maße der Geschenke zu übergeben,
und aus diesen Maßen den Papierbedarf in m2 (Oberfläche des Grundkörpers + 50% Verschnitt) sowie den
Schleifenbandbedarf in m (+ 10% Verschnitt) berechnen.

Schreiben Sie eine Testklasse ChristmasPresents, in dem Sie verschiedene Present-Objekte generieren:
z.B. fünf Weinflaschen, zwei (kugelrunde) Geschenkkörbe, einen Gartenzwerg, einen Teddy und drei Computerspiele.
Legen Sie die konkreten Maße dieser Geschenke fest.

Berechnen Sie den Bedarf an Einwickelpapier (in Rollen) und Schleifenband (in m) sowie den dazugehörenden Preis.
*/
public class ChristmasPresents {

    public static void main(String[] args) {
        Present[] presentsBag = new Present[12];
        for(int i = 0; i<5; i++){
            presentsBag[i] = new Cylinder(random(3, 6), random(3, 5));
        }
        presentsBag[5] = new Ball(random(70, 80));
        presentsBag[6] = new Ball(random(60, 90));
        presentsBag[7] = new Cuboid(random(10, 15), random(10, 15), random(25, 20));
        presentsBag[8] = new Cuboid(random(10, 15), random(10, 15), random(25, 20));
        for(int i = 9; i<12; i++){
            presentsBag[i] = new Cuboid(inM(15), inM(8), inM(2));
        }
        double rolles = 0.0;
        double ribbon = 0.0;
        for(int i=0; i<presentsBag.length; i++){
            rolles += presentsBag[i].computePaperSize();
            ribbon += presentsBag[i].computeRibbonLength();
        }

        System.out.println("Your need rolles for all presents: " + (int)(rolles/5) + 1);
        System.out.println("Your need ribbon for all presents: " + (int)(ribbon) + 1 + " m^2");

    }

    // in cm between first and second and return in m
    private static double random(int first, int second){
        // in cm
        int cm = first + (int)(Math.random() * (second - first));
        // in m
        return inM(cm);
    }

    private static double inM(int cm){
        return (double)cm / 100;
    }
}

public abstract class Present {
    abstract double surface();
    abstract double surfaceRibbon();

    double computeRibbonLength(){
        return surfaceRibbon() * 1.1;
    };
    double computePaperSize(){  // same for all presents
        return surface() * 1.5;  // 50% waste
    }

}

public class Ball extends Present {

    public Ball(double radius) {
        super();
        this.radius = radius;
    }

    double radius;  // in meter

    @Override
    double surface() {
        return 4*Math.PI*radius*radius;
    }

    @Override
    double surfaceRibbon() {
        return 4 * Math.PI * radius;
    }

}

public class Cuboid extends Present{

    public Cuboid(double length, double width, double height) {
        super();
        this.length = length;
        this.width = width;
        this.height = height;
    }

    double length;  // in meter
    double width;   // in meter
    double height;   // in meter

    @Override
    double surface() {
        return 2*(length * width + width * height + length * height);
    }

    @Override
    double surfaceRibbon() {
        return 2*(length + width + 2*height);
    }

}

public class Cylinder extends Present {

    public Cylinder(double height, double diameter) {
        super();
        this.height = height;
        this.diameter = diameter;
    }

    double height ;  // in meter
    double diameter; // in meter

    @Override
    double surface() {
        return Math.PI * diameter * (height + diameter/2);
    }

    @Override
    double surfaceRibbon() {
        return 4 * (height + diameter);
    }

}
