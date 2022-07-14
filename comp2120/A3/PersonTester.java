package Assignment3;
/*
Assignment 3 COMP2110
Problem 3
Julia Garant
104987469
March 26 2020
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PersonTester {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        ArrayList<Person> names = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            System.out.print("Enter a name: ");
            names.add(new Person(in.next()));
        }

        System.out.println(names);

        Collections.sort(names);
        System.out.println(names.get(0));
        System.out.println(names.get(names.size()-1));

    }
}
