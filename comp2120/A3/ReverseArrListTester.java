package Assignment3;

import java.util.ArrayList;

/*
Assignment 3
Problem 5
Julia Garant
104987469
Apr 1 2020
 */
public class ReverseArrListTester {
    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<>();
        list.add("Becca");
        list.add("Conner");
        list.add("Ryan");
//        list.add(9);
//        list.add(6);
//        list.add(12);
        System.out.println(list);

        ArrayListUtil.reverseMod(list);
        System.out.println("After reverse with modification: " + list);
//---------------------------------------------------------------------------------
        System.out.println("\nReset");
        ArrayListUtil.reverseMod(list);
        System.out.println(list);

        System.out.println("Reverse:" + ArrayListUtil.reverseNonMod(list));
        System.out.println("After reverse without modification: " + list);

    }
}
