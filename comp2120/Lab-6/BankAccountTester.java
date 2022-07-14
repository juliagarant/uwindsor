package Lab3;

public class BankAccountTester {
    public static void main(String[] args){
        BankAccount bankAccount1 = new BankAccount("Julia", "Checking");
        BankAccount bankAccount2 = new BankAccount("Rebecca", "Saving", 50);
        double transferAmount = 50;

        bankAccount1.setBalance(100);

        System.out.println(bankAccount1.getName() +" "+ bankAccount1.getBalance());
        System.out.println(bankAccount2.getName() +" "+ bankAccount2.getBalance());

        //do it in one method somehow
//        bankAccount1.withdraw(transferAmount);
//        bankAccount2.deposit(transferAmount);
        bankAccount1.transfer(bankAccount2, 50);
        System.out.println("Transfer");

        System.out.println(bankAccount1.getName() +" "+ bankAccount1.getBalance());
        System.out.println(bankAccount2.getName() +" "+ bankAccount2.getBalance());
    }
}
