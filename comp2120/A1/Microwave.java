package Assignment1;
/*
Assignment 1 for Java
Julia Garant
104987469
Feb 9 2020
 */
public class Microwave {
    private double time;
    private String power;
    public Microwave(){
        time = 0;
        power = null;
    }
    public void thirty(){
        time = time + 30;
    }
    public void pwrLvl(String power){   //setter
        this.power = power;
    }

    public void stop(){
        time = 0;
        System.out.println("Cooking stopped.");
    }
    //supposed to change current status of microwave???
    public void start(){    //getter
        System.out.println("Cooking for "+ time +" seconds at level " + power);
    }

    public void reset(double time) { //setter
        this.time = time;
    }
}
