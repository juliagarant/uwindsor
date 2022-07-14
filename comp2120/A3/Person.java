package Assignment3;
/*
Assignment 3
Problem 3
Julia Garant
104987469
March 26 2020
 */
public class Person implements Comparable<Person> {
    private String name;
    public Person(String name){
        this.name  = name;
    }

    @Override
    public int compareTo(Person person) {
        return this.name.compareTo(person.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
