package Assignment1;
/*
Assignment 1 for Java
Julia Garant
104987469
Feb 9 2020
 */
public class TestBankAccount {
    public static void main(String[] args){
        BankAccount account = new BankAccount("Julia", "Savings", 500.50);
        System.out.println(account.getBalance());
        //account.withdraw(50.00);
        //System.out.println(account.getBalance());
        account.withdraw(1);
        account.withdraw(1);
        account.withdraw(1);
        account.withdraw(1);
        account.withdraw(1);    //5
        account.withdraw(1);
        account.withdraw(1);
        account.withdraw(1);
        account.withdraw(1);
        account.withdraw(1);
        //account.deposit(100);
        System.out.println(account.getBalance());
        account.deductMonthlyCharge();
        System.out.println(account.getBalance());
    }
}
