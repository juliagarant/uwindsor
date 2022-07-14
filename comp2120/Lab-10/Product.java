package Lab10;
/*
Lab 10 for COMP2110
Julia Garant
104987469
Mar 25 2020
 */

/**
 * A class that allows the creation of a product object used in LineItem
 */
public class Product {
    String description;
    double unitPrice;

    /**
     * The constructor for Product. Get the values of description and unitprice
     * @param description a string description of the product
     * @param unitPrice a double containing the unit price of the product
     */
    public Product(String description, double unitPrice){
        this.description = description;
        this.unitPrice = unitPrice;
    }
//--------------------------------------------------------------------------------------------------------------------
//for activity 2

    public String getDescription() {
        return description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

//--------------------------------------------------------------------------------------------------------------------


    /**
     * Get the total for an item
     * @return the unit price of the product
     */
    public double total(){
        return unitPrice;
    }

    /**
     * Reset the current description of a product
     * @param description A string used to describe a product
     */
    public void setDescription(String description){
        this.description = description;
    }

    /**
     * Reset the current unit price of a product
     * @param unitPrice A double which holds the unit price of a product
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "    Desc:" + description + "    Unit Price $" + unitPrice;
    }
}
