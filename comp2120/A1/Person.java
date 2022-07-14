package Assignment1;
/*
Assignment 1 for Java
Julia Garant
104987469
Feb 9 2020
 */
public class Person {
    private String name;
    private int age;
    private boolean hungry;
    private boolean tired;
    private double maxWalk;
    private double totalWalked;
    private boolean hasFriend;

    public Person(String name, int age){
        System.out.println("\nNEW CHARACTER\n");
        this.name = name;
        this.age = age;
        eat();    //default, not hungry
        awake();  //default, not tired
        totalWalked = 0;
        hasFriend = false;
        if(this.age < 55){
            maxWalk = 4;
        }
        else{
            maxWalk = 2;
        }
    }
    public void talk(){
        if(age >= 2){
            System.out.println("Hello, I am "+name+". I am "+age+" years old.");
        }
        else
            System.out.println(name + " can't talk yet.");
    }
    public void grow(){
        ++age;
        if(age >= 55){
            if(age % 5 == 0){
                if(maxWalk > 0) {
                    maxWalk /= 2;
                    System.out.println(name+" can only walk " + maxWalk + " km.");
                }
                else
                    System.out.println("No more walking for "+name);
            }
        }
        System.out.println("Current age: "+age);
    }
    public void needFood(){
        hungry = true;
        System.out.println(name+" is hungry.");
    }
    public void eat(){
        hungry = false;
        System.out.println(name+" has eaten and is now full.");
    }
    public void awake(){
        tired = false;
        System.out.println(name+" is awake and ready to go.");
    }
    public void sleep(){
        tired = true;
        totalWalked = 0;
        System.out.println("You put "+name+" to sleep!");
    }
    public void walk(double distance){
        if(tired == false) {
            totalWalked += distance;

            if (maxWalk > 0) {

                if (distance > maxWalk) {
                    tired = true;
                    System.out.println(name + " doesn't want to walk anymore.");
                } else {
                    if (totalWalked > maxWalk) {
                        tired = true;
                        System.out.println(name + " doesn't want to walk anymore.");
                    } else {
                        System.out.println(name + " walked " + distance + " km!");
                    }
                }

            }else{  //maxWalk <= 0
                System.out.println(name+" is too old to walk for fun.");
            }

        }//if tired
        else{
            System.out.println("You tired " + name + " out! No more walking until they sleep.");
        }
    }//walk
    public void getFriend(Person friend){
        if(hasFriend == true){
            System.out.println(name+" has a friend already!");
        }
        else{
            hasFriend = true;
            System.out.println(name+" and "+friend.name+" are now friends!");
        }
    }
    public void changeFriend(Person friend){
        System.out.println(name+" wants to change friends.");
        if(hasFriend == true){
            System.out.println(name+" and "+friend.name+" are now friends!");
        }
        else{
            System.out.println(name+" needs to have a friend first.");
        }
    }
}
