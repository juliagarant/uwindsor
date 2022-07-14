package Lab7;

public class Manager extends Employee {
    private double bonus;

    public Manager(String name, int age, String gender, double salary, String hireDate, double bonus){
        super(name, age, gender, salary, hireDate);
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return super.toString() + ", Manager, " + "Weekly bonus = $" + bonus;
    }
}