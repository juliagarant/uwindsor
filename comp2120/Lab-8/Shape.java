package Lab8;

/*
Julia Garant
March 9 2020
Activity 2 for lab 8, using the interface "Comparable" and manipulating the
compareTo method
 */
public abstract class Shape implements Comparable<Shape>{
    private String name;

    public Shape(){
        this.name = "General Shape";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract double area();

    @Override
    public String toString() {
        return name + ", ";
    }


    public int compareTo(Shape shape){
        if(area() == shape.area())
            return 0;
        else if(area() > shape.area())
            return 1;
        else
            return -1;
    }
}
