package Lab10;
/*
Lab 10 for COMP2110
Julia Garant
104987469
Mar 25 2020
 */

/**
 * A class to create and edit an address of an Invoice
 */
public class Address {
    private String name, street, city, province, country, postal;
    private int number;

    /**
     * Create an address
     * @param name person's name receiving the invoice
     * @param number house number
     * @param street street of occupancy
     * @param city city of occupancy
     * @param province province of occupancy
     * @param country country of occupancy
     * @param postal postal code associated with rest of address
     */
    public Address(String name, int number, String street, String city, String province, String country, String postal){
        this.name=name;
        this.number=number;
        this.street=street;
        this.city=city;
        this.province=province;
        this.country=country;
        this.postal=postal;
    }

    @Override
    public String toString() {
        return name + "\n" + number + " " + street + "\n" + city + ", " + province + "\n" + country + "\n" + postal;
    }
}
