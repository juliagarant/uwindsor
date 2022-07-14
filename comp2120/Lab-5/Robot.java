package Lab5;

import java.awt.*;
import java.util.ArrayList;

public class Robot {
    private Point point;
    private double x, y;
    private char NESW;
    private Direction dir;
    private ArrayList<Direction> direction = new ArrayList<>();

    public Robot(Point point, char NESW) {
        this.point = point;
        this.NESW = NESW;
        x = point.getX();
        y = point.getY();
        dir = new Direction(point, NESW);
        direction.add(dir);

    }

    public void path() {
        for (Direction printDir : direction) {
            System.out.println(printDir);
        }
    }

    public void turnLeft() {
        switch (NESW) {
            case 'N':
                NESW = 'W';
                break;
            case 'E':
                NESW = 'N';
                break;
            case 'S':
                NESW = 'E';
                break;
            case 'W':
                NESW = 'S';
                break;
        }
       add();
    }

    public void turnRight() {
        switch (NESW) {
            case 'N':
                NESW = 'E';
                break;
            case 'E':
                NESW = 'S';
                break;
            case 'S':
                NESW = 'W';
                break;
            case 'W':
                NESW = 'N';
                break;
        }
        add();
    }
    public void move(){
        switch(NESW){
            case 'N':
                y--;
                break;
            case 'E':
                x++;
                break;
            case 'S':
                y++;
                break;
            case 'W':
                x--;
                break;
        }
        add();
    }

    public void add(){
        dir = new Direction(new Point((int)x,(int)y), NESW);
        direction.add(dir);
    }

}
