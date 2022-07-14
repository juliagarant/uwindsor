package Lab8;
/*
Julia Garant
March 9 2020
Activity 1 for lab 8, using the interface "Payable"
 */
public class TestPayable {
    public static void main(String[] args) {
        Employee jeff = new Employee(40, 14.75);
        Invoice thing = new Invoice(15, 12.25);

        System.out.println("Employee payment amount:" + jeff.getPaymentAmount());
        System.out.println("Invoice payment amount:" + thing.getPaymentAmount());
    }
}
