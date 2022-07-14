package Lab5;

import java.awt.*;

public class testRobot {
    public static void main(String[] args){
        Robot C3PO = new Robot(new Point(5,5), 'E');
        C3PO.move();
        C3PO.turnRight();
        C3PO.move();
        C3PO.move();
        C3PO.turnRight();
        C3PO.move();
        C3PO.move();
        C3PO.turnLeft();
        C3PO.move();
        C3PO.path();
    }
}
