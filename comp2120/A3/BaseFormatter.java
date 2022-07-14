package Assignment3;

/*
Assignment 3
Problem 1
Julia Garant
104987469
March 26 2020
 */
public class BaseFormatter implements NumberFormatter {
    public String format(int n) {
        String num = Integer.toString(n);
        return Integer.toString(Integer.parseInt(num, 10), 8);  //given base is 10, converting base is 8
    }
}