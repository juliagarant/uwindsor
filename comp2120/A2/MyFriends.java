package Assignment2;

import java.util.Scanner;

public class MyFriends {
    /**
     * Tester for FriendsList
     * @param args Not used
     */
    public static void main(String[] args){
        FriendsList Alice = new FriendsList();
        Scanner in = new Scanner(System.in);
        Alice.addFriends(Alice.newPerson());
        Alice.addFriends(Alice.newPerson());
        Alice.addFriends(Alice.newPerson());

        Alice.compareLast();    //prints friends by last name
        System.out.println("\nCurrent number of friends: " + Alice.size());

        System.out.print("\nEnter 1 to delete, 2 to modify, other # to skip: ");
        int choice = in.nextInt();
        Alice.editFriends(choice);

        System.out.print("\nEnter a month: ");
        String month = in.next();
        Alice.compareMonthDay(month);    //prints friends by DAY of birth ONLY in specific month

        System.out.print("\nEnter a day(#): ");
        int day = in.nextInt();
        Alice.compareDayLast(day);      //prints friends by last name ONLY born on specific day

        System.out.println("\nEnter a friend's first and last names: ");
        String fname = in.next();
        String lname = in.next();
        Alice.getCell(fname, lname);

        Alice.copy();
        System.out.println(Alice.toString());
    }

}
