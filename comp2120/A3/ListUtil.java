package Assignment3;
/*
Assignment 3
Problem 6
Julia Garant
104987469
Mar 27 2020
 */
import java.util.LinkedList;

/**
 This class supplies a utility method to reverse the entries in a linked list.
 */
public class ListUtil
{
    /**
     Reverses the elements in a linked list
     @param strings the linked list to reverse
     */
    public static void reverse(LinkedList<String> strings)
    {
        // Complete this static method based on its JavaDoc comment.
        LinkedList<String> temp = new LinkedList<>();

        for(int i = strings.size()-1; i >= 0; i--) {
            temp.addFirst(strings.remove(i));
        }
        // System.out.println("Temp:" + temp);
        for (int i = 0; i < temp.size() ; i++) {
            strings.addFirst(temp.get(i));
        }
    }
}
