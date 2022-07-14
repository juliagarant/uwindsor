package Lab1;

import javax.swing.*;

public class Activity4 {
    public static void main(String[] args){
        String name1, name2, name3;
        int i=1;

        name1 = JOptionPane.showInputDialog("What is your 1st friends name?");
        name2 = JOptionPane.showInputDialog("What is your 2nd friends name?");
        name3 = JOptionPane.showInputDialog("What is your 3rd friends name?");

        System.out.println(i+"\t"+name1);
        i++;
        System.out.println(i+"\t"+name2);
        i++;
        System.out.print(i+"\t"+name3);
    }
}
