package Assignment2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Uses class person to create a list
 */
public class FriendsList {
    private ArrayList<Person> list = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    public FriendsList(){
    }

    private ArrayList<Person> copy = new ArrayList<Person>(list);

//-------------------------------------------------------------------------------------------

    /**
     * Removes all occurrences of shane from copy
     */
    public void copy(){
        for(int i = 0; i < copy.size(); i++) {
            Person p = copy.get(i);
            if(p.getFirstName().equals("Shane")) {
                copy.remove(i);
                i--;
            }
        }
        System.out.println("Copied list: " + copy);
    }
// ------------------------------------------------------------------------------------------

    /**
     * Adds person list and to copy
     * @param person Person to add to the list
     */
    public void addFriends(Person person){
        list.add(person);
        copy.add(person);
    }

    /**
     * Allows the user to delete or modify a friend in their list
     * @param choice, int type, allows choice of deletion or modification
     */
    public void editFriends(int choice){
        int index;
        if(choice == 1){
            System.out.print("What position do you want to delete(0 - "+(size()-1)+"): ");
            index = in.nextInt();
            list.remove(index);
                copy.remove(index);
        }else if(choice == 2){
            System.out.println(list);
            System.out.print("What position do you want to change(0 - "+(size()-1)+"): ");
            index = in.nextInt();
            Person newName = newPerson();
            list.set(index, newName);
                copy.set(index, newName);
        }else{
            System.out.println("Lets continue then...");
        }
    }

    /**
     * Used if the user wishes to modify/create a new friend
     * @return Person type
     */
    public Person newPerson(){
        Scanner in = new Scanner(System.in);
        //To add a friend
        System.out.print("\nEnter your friend's first and last names: ");
        String fName = in.next();
        String lName = in.next();
        System.out.print("Enter their phone number(separated by dashes): ");
        String phone = in.next();
        System.out.print("Enter their birthday(Month Day): ");
        String month = in.next();
        int day = in.nextInt();
        return (new Person(fName, lName, phone, month, day));
    }

    /**
     * Determines the size of the list
     * @return number of friends(elements) in the list
     */
    public int size(){
        return list.size();
    }

    /**
     * Outputs a cell-number depending on the first name and last name given
     * @param fName String, first name
     * @param lName String, last name
     */
    public void getCell(String fName, String lName){
        //if fName and lName match an element in list, use the index to get
        //that index and use index in get, then return temp.getCellNumber
        for(int i = 0; i < list.size(); i++){
            Person p = list.get(i);
            if(p.getFirstName().equals(fName) && p.getLastName().equals(lName)){
                System.out.println(fName+"'s cell number is: "+ p.getCellNumber());
            }
        }
    }
//----------------------------------------------------------------------
    /**
     * Prints out the current friends in order of their last names
     */
    public void compareLast(){
        Collections.sort(list, Person.NameComparator);
        for(Person str: list){
            System.out.println(str);
        }
    }
    /**
     * Prints out the current friends in order of their birth DAY
     * if they are born in the specified month
     * @param month String type, the month is to be shown
     */
    public void compareMonthDay(String month){
        Collections.sort(list, Person.DayComparator);
        for(int i = 0; i < list.size(); i++){
            Person p = list.get(i);
            if(p.getMonth().equals(month)) {
                System.out.println(p);
            }
        }
    }

    /**
     *Prints out the current friends in order of last name
     * if they are born on the specified day
     * @param day int type, the specified day
     */
    public void compareDayLast(int day){
        Collections.sort(list, Person.NameComparator);
        for(int i = 0; i < list.size(); i++){
            Person p = list.get(i);
            if(p.getDay() == day){
                System.out.println(p);
            }
        }
    }

    /**
     * This shows the elements in the list unsorted
     * @return String value of list
     */
    @Override
    public String toString() {
        return "Friends: "+ list;
    }
}
