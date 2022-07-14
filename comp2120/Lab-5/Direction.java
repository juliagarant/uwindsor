package Lab5;

import java.awt.*;

public class Direction {
    private Point point;
    private char NESW;
    public Direction(Point point, char NESW){
        this.point = point;
        this.NESW = NESW;
    }
    @Override
    public String toString() {
        return "(" + point.getX() + ", " + point.getY() + "), " + NESW;
    }
}
