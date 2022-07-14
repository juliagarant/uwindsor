package Assignment1;
/*
Assignment 1 for Java
Julia Garant
104987469
Feb 9 2020
 */
public class TestMicrowave {
    public static void main(String[] args){
        Microwave LG = new Microwave();
        LG.pwrLvl("Low");
        LG.reset(15);
        LG.start();
        LG.stop();
        LG.pwrLvl("High");
        LG.thirty();
        LG.start();

    }
}
