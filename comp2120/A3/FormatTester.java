package Assignment3;
/*
Assignment 3
Problem 1
Julia Garant
104987469
March 26 2020
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FormatTester {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(new File("Numbers.txt"));
        PrintWriter out = new PrintWriter(new File("FormattedNumbers.txt"));

//        ArrayList<Integer> list = new ArrayList<>();
        int num1= 0,num2= 0,num3= 0,num4 = 0;
        while(in.hasNextInt()){
//            list.add(in.nextInt());
            num1 = in.nextInt();
            num2 = in.nextInt();
            num3 = in.nextInt();
            num4 = in.nextInt();
        }
//        for( int element : list) {
//            out.println(defaultF.format(list.get(element)));
//        }
        DefaultFormatter defaultF = new DefaultFormatter();
        out.println("Default Format: " + defaultF.format(num1) + " " + defaultF.format(num2) + " " + defaultF.format(num3) + " " + defaultF.format(num4));

        DecimalSeparatorFormatter decimal = new DecimalSeparatorFormatter();
        out.println("Decimal Format: " + decimal.format(num1) + " " + decimal.format(num2) + " " + decimal.format(num3) + " " + decimal.format(num4));

        AccountingFormatter acc = new AccountingFormatter();
        out.println("Accounting Format: " + acc.format(num1) + " " + acc.format(num2) + " " + acc.format(num3) + " " + acc.format(num4));

        BaseFormatter base = new BaseFormatter();
        out.println("Base 8 Format: " + base.format(num1) + " " + base.format(num2) + " " + base.format(num3) + " " + base.format(num4));


        in.close();
        out.close();
    }
}
