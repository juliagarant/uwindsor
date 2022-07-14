package Assignment1;
/*
Assignment 1 for Java
Julia Garant
104987469
Feb 9 2020
 */
public class BankAccount {

    private String name;    //account holder's name
    private String type;    //saving or checking
    private double balance;
    private double fee;
    private int transaction, actualTrans;

    public BankAccount(String name, String type){
        this.name = name;
        this.type = type;
        balance = 0;
        fee = 0.50;
        transaction = 0;
        actualTrans = 0;
    }
    public BankAccount(String name, String type, double balance){
        this.name = name;
        this.type = type;
        this.balance = balance;
        fee = 0.50;
        transaction = 0;
        actualTrans = 0;
    }
        //--------------------------------------------------------
    public void fee(){
        System.out.println("FEE!");
        balance = balance - fee;
    }
    public void deductMonthlyCharge(){
        //Use Math.max(actualTrans, transaction) somewhere???
            if(transaction <= 10){
                System.out.println("User only used free transactions (10)");
            }
            else{
                balance = balance + (actualTrans * fee);
            }
        transaction = 0;
        actualTrans = 0;
    }

    public void withdraw(double amount){
        if (balance < amount || balance == 0) {
            System.out.println("Not enough funds to withdraw");
        }
        else{
            balance = balance - amount;
            transaction++;
            if (transaction > 10) {
                actualTrans++;
                fee();
            }
        }
    }
    public void deposit(double amount){
        balance = balance + amount;
        transaction++;
        if (transaction > 10) {
            actualTrans++;
            fee();
        }
    }
    public void transfer(BankAccount destination, double transfer){
        destination.balance = destination.balance + transfer;
        this.balance = this.balance - transfer;
    }
    //---------------------------------------------------------
    public void setName(String name){
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName(){
        return name;
    }
    public String getType() {
        return type;
    }
    public double getBalance() {
        System.out.print("Current balance: ");
        return balance;
    }


}
