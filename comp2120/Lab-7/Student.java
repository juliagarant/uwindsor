package Lab7;

public class Student extends Person {
    private String program;
    private String level;
    private int year;

    public Student(String name, int age, String gender,String program, String level, int year){
        super(name, age, gender);
        this.program = program;
        this.level = level;
        this.year = year;
    }

    @Override
    public String toString() {
        return super.toString() + "Student, " + program + ", " + level + ", Grad Year:" + year;
    }
}
