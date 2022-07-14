package Assignment3;
/*
Assignment 3
Problem 6
Julia Garant
104987469
Mar 27 2020
 */
import java.util.LinkedList;

public class ReverseTester {
    public static void main(String[] args)
    {
        LinkedList<String> employeeNames = new LinkedList<>();
        employeeNames.addLast("Dick");
        employeeNames.addLast("Harry");
        employeeNames.addLast("Romeo");
        employeeNames.addLast("Tom");
        ListUtil.reverse(employeeNames);
        System.out.println(employeeNames);
        System.out.println("Expected: [Tom, Romeo, Harry, Dick]");
    }
}
