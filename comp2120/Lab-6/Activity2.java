package Lab3;
/*
Jan 24 2020
The output of the following code would be HELLO and Hello. This is because
the String method "toUpperCase" is an accessor, not a mutator. It does not permanently
change the value of the string "s" it is applied to.
 */
public class Activity2 {
    public static void main(String[] args){
        String s = "Hello";
        System.out.println(s.toUpperCase());
        String t = s;
        System.out.println(t);
    }
}
