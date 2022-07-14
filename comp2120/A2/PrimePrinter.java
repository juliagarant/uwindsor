package Assignment2;

import java.util.Scanner;

/**
 * This class prints prime numbers
 */
public class PrimePrinter {
    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter upper limit: ");
        int limit = in.nextInt();

        PrimeGenerator prime = new PrimeGenerator();

        for (int i = 0; i < 100; i++) {//prints all prime numbers up to 100
            if(prime.nextPrime() < limit) {//until the number is greater than limit
                System.out.println(prime.getCurrent());
            }
        }
    }
}
