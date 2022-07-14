package Assignment2;

import java.util.Scanner;

/**
 * Tester class for ComboLock
 */
public class ComboLockTester {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int first = 1;
        int second = 1;
        int last = 1;
        while(first != 0 && second != 0 && last != 0) {
            System.out.println("0 0 0 to exit.");
            System.out.print("Enter your locker combination(R,L,R): ");
            first = in.nextInt();
            second = in.nextInt();
            last = in.nextInt();

            if(first == 0 && second == 0 && last == 0){
                break;
            }
            ComboLock lock = new ComboLock(first, second, last);

            System.out.print("Turn right how many? ");
            int right = in.nextInt();
            lock.turnRight(right);

            System.out.print("Turn left how many? ");
            int left = in.nextInt();
            lock.turnLeft(left);

            System.out.print("Turn right how many? ");
            right = in.nextInt();
            lock.turnRight(right);

            System.out.println("Is the lock open? " + lock.open());
        }
        System.out.println("Bye!");
    }
}

