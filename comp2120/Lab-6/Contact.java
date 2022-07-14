package Lab6;

public class Contact {
    private int areacode;
    private int num;
    public Contact(int areacode, int num){
        this.areacode = areacode;
        this.num = num;
    }

    @Override
    public String toString() {
        return "("+areacode + ")" + num;
    }
}
