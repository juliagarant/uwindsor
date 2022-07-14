package Assignment1;
/*
Assignment 1 for Java
Julia Garant
104987469
Feb 9 2020
 */
import java.awt.geom.Line2D;
import java.awt.geom.Ellipse2D;

public class Problem3 {
    public static void main(String[] args) {
        Line2D.Double line = new Line2D.Double(3, 12, 17, 31);
        line.setLine(3,12,19,13);
        //System.out.println("Line (expected true) " + line.intersectsLine(3, 12, 17, 31));
        System.out.println("Line:");
        System.out.print("x1 expected 3, actual: "+line.getX1());
        System.out.print(", y1 expected 12, actual: "+line.getY1());
        System.out.print(", x2 expected 19, actual: "+line.getX2());
        System.out.println(", y2 expected 13, actual: "+line.getY2());

        Ellipse2D.Double ellipse = new Ellipse2D.Double(4, 13, 60, 25);
        System.out.println("Ellipse:");
        System.out.print("x expected 4, actual: " + ellipse.getX());
        System.out.print(", y expected 13, actual: " + ellipse.getY());
        System.out.print(", width expected 60, actual: " + ellipse.getWidth());
        System.out.println(", height expected 25, actual: " + ellipse.getHeight());
        //System.out.println("Ellipse (expected true) " + ellipse.intersects(4, 13, 60, 25));
    }
}
