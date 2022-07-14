package Assignment2;

import java.util.Scanner;

public class ComboLock {
    private int secret1, secret2, secret3;
    private int dial, rightTurn;
    private boolean flag1, flag2, flag3;
    Scanner in = new Scanner(System.in);
    public ComboLock(int secret1, int secret2, int secret3){
        this.secret1 = secret1;
        this.secret2 = secret2;
        this.secret3 = secret3;
        reset();
    }

    /**
     * Resets all values to 0
     */
    public void reset(){
        dial = 0;
        rightTurn = 0;
        flag1 = false;  //if first turn is equal to secret1
        flag2 = false;  //if second turn (the only left turn) equals secret2
        flag3 = false;
    }

    /**
     * Turns dial left
     * @param ticks int amount of turns
     */
    public void turnLeft(int ticks){
        if(dial == 0){
            dial = 40 - ticks;
        }
        else if(ticks > dial){
            while(dial != 0){
                dial -= 1;
                ticks--;
            }
            if(dial == 0){
                dial = 40 - ticks;
            }
        }
        else{
            dial -= ticks;
        }

        if(dial == secret2){
            flag2 = true;
        }
    }

    /**
     * Turns dial right
     * @param ticks int amount of turns
     */
    public void turnRight(int ticks){
        ++rightTurn;
        int temp = dial;
        if(dial == 39){
            dial = (-1) + ticks;
        }
        else if((temp + ticks) > 39){
            while(dial != 39){
                dial++;
                ticks--;
            }
            if(dial == 39){
                dial = (-1) + ticks;
            }
        }
        else{
            dial += ticks;
        }
        //check to see if you landed on the right number
        if(rightTurn == 1){
            if(dial == secret1){
                flag1 = true;
            }
        }
        else if(rightTurn == 2){
            if(dial == secret3){
                flag3 = true;
            }
        }

    }

    /**
     * Opens lock if all flags are true
     * @return true or false
     */
    public boolean open(){
        if(flag1 && flag2 && flag3){
            return true;
        }
        else {
            System.out.println("Not quite!");
            reset();
            return false;
        }
    }
//-------------------------------------------------------------------

    /**
     *
     * @return current value of dial
     */
    public int getDial() {
        return dial;
    }
    /**
     *
     * @return true or false
     */
    public boolean isFlag1() {
        return flag1;
    }
    /**
     *
     * @return true or false
     */
    public boolean isFlag2() {
        return flag2;
    }
    /**
     *
     * @return true or false
     */
    public boolean isFlag3() {
        return flag3;
    }
}
