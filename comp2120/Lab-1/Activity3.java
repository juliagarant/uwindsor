/*
Lab 1 Activity 3
Julia Garant
Jan 13 2020
This program prints an Input Dialog Box asking the user for their name.
Then it outputs "Hello, name!"
 */
package Lab1;
import javax.swing.JOptionPane;
public class Activity3 {
    public static void main(String[] args){
        String name = JOptionPane.showInputDialog("What is your name?");
        System.out.print("Hello, "+name+"!");
    }
}