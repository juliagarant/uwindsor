package Lab7;

public class Square extends Shape {

    private double side;

    public Square(double side){
        this.setName("Square");
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public double area() {
        return this.side * this.side;
    }

    @Override
    public String toString() {
        return super.toString() + "Side: " + getSide() + ", Area: " + area() + "|";
    }
}
