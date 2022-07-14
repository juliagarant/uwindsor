package Lab8;
/*
Julia Garant
March 9 2020
Activity 1 for lab 8, using the interface "Payable"
 */
public class Invoice implements Payable{
    int numberOfProduct;
    double unitPrice;
    double tax;

    Invoice(int numberOfProduct, double unitPrice){
        this.numberOfProduct = numberOfProduct;
        this.unitPrice = unitPrice;
        tax = (numberOfProduct*unitPrice) * 0.13;
    }

    public double getPaymentAmount(){
        return numberOfProduct*unitPrice + tax;
    }
}
