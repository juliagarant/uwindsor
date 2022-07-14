package Lab4;

import java.util.Scanner;

public class Activity1 {
    /**
     Uses printf and multiplication
     @param args not used
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter three numbers: ");
        double num1 = in.nextDouble();
        double num2 = in.nextDouble();
        double num3 = in.nextDouble();
        double mul = (num1*num2*num3);
        System.out.printf("The multiplication is %.2f", mul);

    }
}
