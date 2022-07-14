package Assignment1;
/*
Assignment 1 for Java
Julia Garant
104987469
Feb 9 2020
 */
public class TestPerson {
    public static void main(String[] args){
        Person mySim = new Person("Claire", 54);
        mySim.talk();
        mySim.grow();   //55
//        mySim.talk();
//        mySim.needFood();
//        mySim.eat();
        mySim.walk(3);
        mySim.sleep();
        mySim.awake();
        mySim.grow();   //age 56
        mySim.grow();   //57
        mySim.grow();   //58
        mySim.grow();   //59
        mySim.grow();   //60
        //mySim.getFriend(new Person("Lillian", 16));
        //mySim.getFriend(new Person("Satan", 666));
        mySim.changeFriend(new Person("God", 0));
        //        mySim.walk(2);
//        mySim.walk(0.1);
    }
}
