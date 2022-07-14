package Lab8;
/*
Julia Garant
March 9 2020
Activity 1 for lab 8, using the interface "Payable"
 */
public class Employee implements Payable {
    double workingHours;
    double hourlyRate;

    Employee(double workingHours, double hourlyRate){
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }

    public double getPaymentAmount(){
        return workingHours*hourlyRate;
    }
}
