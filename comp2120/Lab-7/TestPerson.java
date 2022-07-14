package Lab7;

public class TestPerson {
    public static void main(String[] args) {
        Person p1 = new Person("Conner Sax", 19, "Cis-Male");
        Employee p2 = new Employee("Julia Garant", 19, "Cis-Female", 70000, "October 2016");
        Manager p3 = new Manager("Rebecca Wallace", 19, "Cis-Female", 75000, "October 2019", 200);
        Student p4 = new Student("Asad Khan", 20, "Cis-Male", "Math", "Undergraduate", 2022);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
    }
}
