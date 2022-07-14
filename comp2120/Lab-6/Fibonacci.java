package Lab5;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class performs a simple fibonacci sequence using an ArrayList.
 * The user is prompted for a number to decide the length of the sequence.
 * The user is then asked for an index, starting at 1, and the value at that index is returned
 */
public class Fibonacci {

    public static void main(String[] args) {
        int num1 = 0, num2 = 1;
        int i=1;
        ArrayList<Integer> fib = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = in.nextInt();

        System.out.print("Fibonacci Series of "+n+" numbers: ");

        while(i <= n)
        {
            System.out.print(num1+", ");
            fib.add(num1);
            int sumPrev = num1 + num2;
            num1 = num2;
            num2 = sumPrev;
            i++;
        }

        System.out.print("\nEnter an index(1-"+n+"): ");
        int userIndex = in.nextInt();
        while(userIndex >= n){
            System.out.println("That index is out of range.");
            System.out.print("\nEnter an index(1-"+n+"): ");
            userIndex = in.nextInt();
        }

        int userVal = fib.get(userIndex-1);

        System.out.println("The element at position " + userIndex + " is: " + userVal);

    }
}
