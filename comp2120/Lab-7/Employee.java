package Lab7;

public class Employee extends Person {
    private double salary;
    private String hireDate;

    public Employee(String name, int age, String gender, double salary, String hireDate) {
        super(name, age, gender);
        this.salary = salary;
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return super.toString() + " Employee, Salary = $" + salary + ", Hiring Date: $"+ hireDate + " ";
    }
}
