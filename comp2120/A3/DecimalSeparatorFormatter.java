package Assignment3;
/*
Assignment 3
Problem 1
Julia Garant
104987469
March 26 2020
 */
import java.text.NumberFormat;

public class DecimalSeparatorFormatter implements NumberFormatter {
    public String format(int n){
        NumberFormat commaFormat = NumberFormat.getInstance();
        commaFormat.setGroupingUsed(true); //will place a comma after every group of 3(3 is the default size)
        return commaFormat.format(n);
    }
}
