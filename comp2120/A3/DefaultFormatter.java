package Assignment3;

/*
Assignment 3
Problem 1
Julia Garant
104987469
March 26 2020
 */
public class DefaultFormatter implements NumberFormatter {
    public String format(int n){
        String str = Integer.toString(n);
        return str;
    }
}
