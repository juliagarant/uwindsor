package Lab7;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TestShape {
    public static void main(String[] args) {
        ArrayList<Shape> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        Random generator = new Random();
        String choice = "";
        do{
            System.out.print("Triangle = T, Circle = C, Square = Q, Oval = O, Exit = E\nChoice: ");
            choice = in.next();
            choice = choice.toUpperCase();
            if(choice.equals("T")){
                System.out.println("New Triangle Added!");
                int base = 1 + generator.nextInt(11);
                int height = 1 + generator.nextInt(11);
                Triangle tri = new Triangle(base,height);
                list.add(tri);
            }
            else if(choice.equals("C")){
                System.out.println("New Circle Added!");
                int radius = 1 + generator.nextInt(21);
                Circle cir = new Circle(radius);
                list.add(cir);
            }
            else if(choice.equals("Q")){
                System.out.println("New Square Added!");
                int side = 1 + generator.nextInt(11);
                Square squ = new Square(side);
                list.add(squ);
            }
            else if(choice.equals("O")){
                System.out.println("New Oval Added!");
                int radius1 = 1 + generator.nextInt(21);
                int radius2 = 1 + generator.nextInt(21);
                Oval ov = new Oval(radius1, radius2);
                list.add(ov);
            }
        }while (!choice.equals("E"));

        System.out.println(list);

    }
}
