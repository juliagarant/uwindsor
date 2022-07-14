package Assignment3;

import java.util.ArrayList;
import java.util.Collections;

/*
Assignment 3
Problem 5
Julia Garant
104987469
Apr 1 2020
 */
public class ArrayListUtil {

    //Provide a static method that reverses the elements of a generic ArrayList.
    public static <E> void reverseMod(ArrayList<E> list){
        ArrayList<E> temp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            temp.add(list.get(i));
        }
        list.clear();
        for (int i = temp.size()-1; i >= 0 ; i--) {
            list.add(temp.get(i));
        }
    }

    //Provide another static method that returns the reverse of a generic ArrayList, without modifying the original list.
    public static <E> ArrayList<E> reverseNonMod(ArrayList<E> list){
        ArrayList<E> reversed = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            reversed.add(list.get(i));
        }
        Collections.reverse(reversed);
        return reversed;
    }
}
