package Lab6;

public class Address {
    private int apt;
    private int house;
    private String street;
    private String city;
    private String province;
    private String postal;

    public Address(int house,String street, String city, String province, String postal){
        this.house = house;
        this.street = street;
        this.city = city;
        this.province = province;
        this.postal = postal;
    }
    public Address(int apt, int house,String street, String city, String province, String postal){
        this.apt = apt;
        this.house = house;
        this.street = street;
        this.city = city;
        this.province = province;
        this.postal = postal;
    }

    @Override
    public String toString() {
        return "Address{" +apt +house +street +city + province + postal + "}";
    }
}
