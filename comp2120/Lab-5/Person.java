package Lab5;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This Person Class uses an array list to friend and unfriend people.
 * This class is a continuation of Person from Lab 4.
 */
public class Person {
    private String name;
    private int friendCount;
    private int numOfPeople;
    private ArrayList<String> friends = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    public Person(String name){
        this.name = name;
        friendCount = 0;
        numOfPeople = 1;
    }
    /**
     * Adds a new friend to the ArrayList.
     * Increases friendCount and numOfPeople
     * @param name String type. Contains the name of the friend
     */
    public void befriend(String name){
        friends.add(name);
        friendCount++;
        numOfPeople++;
    }
//    /**
//     * Removes friend from the ArrayList friends
//     * @param p Person type. Contains the name of the friend
//     */
//    public void unfriend(Person p){
//        for(int i = 0; i < friends.size(); i++ ){
//            if(p.name.equals(friends.get(i))){
//                friends.remove(i);
//            }
//        }
//        friendCount--;
//    }

    public void unfriend(){
        System.out.print("Enter the position of the friend you want to unfriend: ");
        int position = in.nextInt();
        friends.remove(position);
        friendCount--;
    }


    public String getFriendPos(){
        System.out.print("Enter the position of a friend: ");
        int position = in.nextInt();
        return friends.get(position);
    }
    public void changeFriend(){
        System.out.print("Enter the position of the friend you want to change: ");
        int position = in.nextInt();
        System.out.print("Enter the name of the new friend: ");
        String friend = in.next();
        friends.set(position, friend);
    }


    /**
     * Prints the current values of ArrayList friends
     */
    public void getFriendNames(){
        System.out.println(friends);
    }
    /**
     * Counts the current amount friends
     * @return int friendCount
     */
    public int getFriendCount(){
        System.out.print("Number of friends: ");
        return friendCount;
    }
    /**
     * Number of people created
     * @return int numOfPeople
     */
    public int getNumOfPeople(){
        System.out.print("Number of people created: ");
        return numOfPeople;
    }
}
