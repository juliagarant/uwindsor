package Lab7;

public class Person {
    private String name;
    private int age;
    private String gender;

    public Person(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return name + ", " + age + ", " + gender + " ";
    }
}
