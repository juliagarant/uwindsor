package Lab3;

public class BankAccount {
    private String name;    //account holder's name
    private String type;    //saving or checking
    private double balance;
    public BankAccount(String name, String type){
        this.name = name;
        this.type = type;
        balance = 0;
    }
    public BankAccount(String name, String type, double balance){
        this.name = name;
        this.type = type;
        this.balance = balance;
    }
    //--------------------------------------------------------
    public void withdraw(double amount){
        if (balance < amount || balance == 0) {
            System.out.println("Not enough funds to withdraw");
        }
        else{
            balance = balance - amount;
        }
    }
    public void deposit(double amount){
        balance = balance + amount;
    }
    /*
Also try to see if you can provide a method, by which you can withdraw some money from one
BankAccount object and deposit it into another BankAccount object. Note that you should provide only
one single method to perform this task that changes the state (balance) of two BankAccount objects.
 */
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
        return balance;
    }
}
