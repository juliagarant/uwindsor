package Assignment3;

/*
Assignment 3
Problem 1
Julia Garant
104987469
March 26 2020
 */
public class AccountingFormatter implements NumberFormatter {
    public String format(int n) {
        if(n<0)
        {
            n = n / -1;
            return "(" + Integer.toString(n) + ")";
        }
        return Integer.toString(n);
    }
}
