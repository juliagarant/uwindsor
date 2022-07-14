package Lab5;

import java.util.Scanner;

/**
 * Tester class for Person
 */
public class testPerson {
    /**
     * @param args is not used
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Person me = new Person("Julia");
        me.befriend("Rebecca");
        me.befriend("Joe");
        me.befriend("Judy");
        me.befriend("Alex");

        me.getFriendNames();

        me.unfriend();
        me.getFriendNames();

        System.out.println(me.getFriendPos());

        me.changeFriend();

        System.out.println(me.getFriendCount());
        System.out.println(me.getNumOfPeople());
        me.getFriendNames();
    }

}
