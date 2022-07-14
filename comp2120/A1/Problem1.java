package Assignment1;
import java.lang.*;
/*
Assignment 1 for Java
Julia Garant
104987469
Feb 9 2020
 */
public class Problem1 {
    public static void main(String[] args){
//        double radius = 15;
//        double area;
//        area = Math.PI * radius * radius;
//        System.out.println(area);
        double s = 0, s0 = 10, v0 = 5, g = 6, t = 2;
        double pow3 = Math.pow(t,3);
        s = s0 * v0 - (g*0.5) * pow3;
        System.out.println("The value of s should be 26. It is:  "+ s);

        double G = 0, a = 3, p = 4, m1 = 6, m2 = 4;
        double pi = Math.pow(Math.PI, 2);
        double sqrt = Math.pow(p,0.5);
        double a3 = Math.pow(a, 3);
        G = (.75*pi)*(a3 / (sqrt * (m1 - m2)) );
        System.out.println("The value of G should be 49.9648. It is:  "+ G);

    }
}
