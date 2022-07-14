package Lab6;

public class Relative {
    private String name;
    private Contact contact;
    private String relation;
    private int priority;

    public Relative(String name, Contact contact, String relation, int priority){
        this.name = name;
        this.contact = contact;
        this.relation = relation;
        this.priority = priority;
    }
    public String toString(){
        return "Relative:" + name + ", " + contact + "\n" + relation + ", Priority: " + priority;
    }
}
