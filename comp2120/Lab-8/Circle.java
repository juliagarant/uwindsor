package Lab8;


public class Circle extends Shape{
    private double radius;

    public Circle(double radius){
        this.setName("Circle");
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double area() {
        return Math.PI * this.radius * this.radius;
    }

    @Override
    public String toString() {
        return super.toString() + "Radius: " + getRadius() + ", Area: " + area()+ "|";
    }

}
