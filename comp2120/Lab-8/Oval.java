package Lab8;

public class Oval extends Shape{
    private double radius1;
    private double radius2;

    public Oval(double radius1, double radius2){
        this.setName("Oval");
        this.radius1 = radius1;
        this.radius2 = radius2;

    }

    public double getRadius1() {
        return radius1;
    }

    public double getRadius2() {
        return radius2;
    }

    @Override
    public double area() {
        return Math.PI * this.radius1 * this.radius2;
    }

    @Override
    public String toString() {
        return super.toString() + "Radius 1: " + getRadius1() + " Radius 2: " + getRadius2() + ", Area: " + area()+ "|";
    }
}

