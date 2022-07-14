package Assignment2;

import java.util.Comparator;

public class Person {
    private String firstName;
    private String lastName;
    private String cellNumber;
    private String month;
    private int day;

    public Person(String firstName, String lastName, String cellNumber, String month, int day){
    this.firstName = firstName;
    this.lastName = lastName;
    this.cellNumber = cellNumber;
    this.month = month;
    this.day = day;
    }
//getters and setters --------------------------------------------------------------------
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getMonth() {
        return month;
    }
    public void setMonth(String month) {
        this.month = month;
    }
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }

    public String getCellNumber() {
        return cellNumber;
    }
    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    /**
     *
     * @return String value of all variables used
     */
    @Override
    public String toString() {
        return "(" + firstName + " " + lastName + ", "+ cellNumber + ", "+ month +" "+ day + ')';
    }
    /**
     * Comparator for sorting the list by Last Name
     */
    public static Comparator<Person> NameComparator = new Comparator<Person>() {
        public int compare(Person n1, Person n2) {
            String name1 = n1.getLastName().toUpperCase();
            String name2 = n2.getLastName().toUpperCase();
            return name1.compareTo(name2);  //ascending order
        }
    };

    /**
     * Comparator for sorting the list by Day in month
     */
    public static Comparator<Person> DayComparator = new Comparator<Person>() {
        public int compare(Person d1, Person d2) {
            int day1 = d1.getDay();
            int day2 = d2.getDay();
            return day1 - day2;
        }
    };
}
