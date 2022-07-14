package Lab10;

import java.util.ArrayList;

/*
Lab 10 for COMP2110
Julia Garant
104987469
Mar 25 2020
 */

/**
 * A class to create and manage an invoice
 */
public class Invoice {
    private LineItem item;
    private Address address;
    private final int maxItem = 5;
    private boolean sameFlag = false;

    private ArrayList<LineItem> itemList = new ArrayList<>();

    /**
     * Create an invoice
     * @param item LineItem type of an item added to the invoice
     * @param address Address type of the address of the invoice
     */
    public Invoice(LineItem item, Address address){
        this.item = item;
        addLineItem(item);
        this.address = address;
    }

    /**
     * Get the total price of the order
     * @return a double containing the total price
     */
    public double total(){
        double total = 0;
        for (LineItem element: itemList ) {
            total += element.total();
        }
        return total;
    }

    /**
     * Reset an item in the invoice
     * @param desc a string containing the description of an item
     * @param price a double containing the price of an item
     */
    public void setItem(String desc, double price){
        item.setProduct(desc, price);
    }

    /**
     * Add a LineItem to the ArrayList
     * @param item LineItem type, the item to add to the list
     */
    public void addLineItem(LineItem item){
        if(itemList.size() == 0){   //there's nothing in the invoice yet
            if(item.getQuantity() <= maxItem) { //5
                itemList.add(item);
            }
            else{
                System.out.println("Too many of the same item!");
            }
        }
        else{   //things are already in the invoice

            sameItemCheck(item);    //are you adding the same item?
            //if YES its been taken care of
            //if NO you will get output from the sameItemCheck and continue
            if(!sameFlag) {
                if (item.getQuantity() > maxItem) {  //if you are trying to add more than 5 of this new item
                    System.out.println("\tNo! Too many items. MAX: " + maxItem);
                } else if (item.getQuantity() <= maxItem) {
                    itemList.add(item);
                }
            }
        }
    }

    public void sameItemCheck(LineItem item){
        for (int i = 0; i < itemList.size(); i++) {
            if(itemList.get(i).getProduct().getDescription().equals( item.getProduct().getDescription() )){ //current item already in list = new item to be added?
                //yes, the same type of item
                // check the quantities
                if(itemList.get(i).getQuantity() == maxItem){
                    System.out.println("\tYou already have the max of this item.");
                    break;
                }
                else if(itemList.get(i).getQuantity() < maxItem){ //<5 already in invoice
                    //if adding the new item will be <=5
                    if(itemList.get(i).getQuantity() + item.getQuantity() <= maxItem){
                        itemList.get(i).setQuantity(itemList.get(i).getQuantity() + item.getQuantity());   //set the current item quantity
                    }
                    else {
                        System.out.println("\tAdd less of this item! You will exceed 5.");
                        sameFlag = true;    //you're trying to add too much
                    }
                }

            }
            else    //different item
                System.out.println("\tNot the same item as "+ itemList.get(i).getProduct().getDescription() +". You may proceed.");
        }

    }
    @Override
    public String toString() {
        return "\nINVOICE:\n" + itemList + "\n" + address;
    }
}
