package Lab10;
/*
Lab 10 for COMP2110
Julia Garant
104987469
Mar 25 2020
 */

/**
 * A class to create a LineItem used in Invoice
 */
public class LineItem {
    private int quantity;
    private Product product;

    /**
     * Constructor for LineItem. To gain the values for quantity and product
     * @param quantity an int value of how many lineItems are required
     * @param product a Product type that contains the desired product
     */
    public LineItem(int quantity, Product product){
        this.quantity = quantity;
        this.product = product;
    }
//--------------------------------------------------------------------------------------------------------------------
//for activity 2

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }
//--------------------------------------------------------------------------------------------------------------------
    /**
     * Get the total price of a LineItem
     * @return quantity * total price of product
     */
    public double total(){
        return (double)quantity * product.total();
    }

    /**
     * Reset the current values of desc and price
     * @param desc a string that contains the description of a lineItem
     * @param price a double that contains the price of a lineItem
     */
    public void setProduct(String desc, double price) {
        product.setDescription(desc);   //I use 2 methods to change the description and unit price
        product.setUnitPrice(price);
    }

    @Override
    public String toString() {
        return "Qty: " + quantity + product;
    }
}
