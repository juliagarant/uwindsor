package Lab7;

public class Shape {
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

    public double area() {
        return 0;
    };

    @Override
    public String toString() {
        return name + ", ";
    }
}
