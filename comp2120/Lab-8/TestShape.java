package Lab8;

import java.util.Random;

public class TestShape {
    public static void main(String[] args){
        Random generator = new Random();

        int radius = 1 + generator.nextInt(21);
        Circle circle = new Circle(radius);

        int base = 1 + generator.nextInt(11);
        int height = 1 + generator.nextInt(11);
        Triangle triangle = new Triangle(base,height);

        int side = 1 + generator.nextInt(11);
        Square square = new Square(side);

        int radius1 = 1 + generator.nextInt(21);
        int radius2 = 1 + generator.nextInt(21);
        Oval oval = new Oval(radius1, radius2);

        System.out.println("Tri area " + triangle.area() + " , Circle area " + circle.area());
        System.out.println("Triangle and Circle?: " + triangle.compareTo(circle));
        System.out.println("Triangle and Triangle?: " + triangle.compareTo(triangle));
        System.out.println("Circle and Triangle?: " + circle.compareTo(triangle));

    }
}
