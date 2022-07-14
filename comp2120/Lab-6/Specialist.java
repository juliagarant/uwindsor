package Lab6;

public class Specialist {
    private String name;
    private String specialty;
    private Contact contact;
    private Address address;

    public Specialist(String name, String specialty, Contact contact, Address address){
        this.name = name;
        this.specialty = specialty;
        this.contact = contact;
        this.address = address;
    }

    public String toString(){
        return "Specialist: " + name + ", " + specialty + ", " + contact + ", " + address;
    }
}
