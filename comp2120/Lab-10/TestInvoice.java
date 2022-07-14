package Lab10;

import java.util.ArrayList;

/*
Lab 10 for COMP2110
Julia Garant
104987469
Mar 25 2020
 */

/**
 * This class is a tester class to create invoice objects
 */
public class TestInvoice {
    /**
     * Where you can add, edit, and manage invoice objects
     * @param args is not used
     */
    public static void main(String[] args){
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(new Product("Bag o' rats", 0.99));
        productList.add(new Product("Bag o' cats", 1000));
        productList.add(new Product("Bag o' hats", 24.99));


        Invoice target = new Invoice(new LineItem(2, productList.get(0)), new Address("Joe Srigley", 1783, "Addell", "Cottam", "ON","Canada", "N9Y 2J2"));  //2 bags of rats for target
        Invoice jcpenney = new Invoice(new LineItem(1, productList.get(1)), new Address("John Smith", 1908, "Spruce", "London", "ON","Canada", "N9E 4X2"));

        System.out.println(jcpenney);   //invoice of jcpenney
        System.out.println("Estimated total: $1000 Actual total: $" + jcpenney.total());

        jcpenney.addLineItem(new LineItem(1, productList.get(2)));
        System.out.println("Estimated total: $1024.99 Actual total: $" + jcpenney.total());
        System.out.println(jcpenney);   //invoice of jcpenney

        System.out.println("Estimated total: $1.98 Actual total: $" + target.total());

        //method change the description and unit price
        System.out.println(target);
        target.setItem("Gum",2.01);
        System.out.println(target);

        //testing out of stock
        Invoice macs = new Invoice(new LineItem(5, productList.get(0)), new Address("Brooke Meloche", 221, "Glendale", "Lasalle", "ON","Canada", "K7T W9U"));
        System.out.println(macs);
        macs.addLineItem(new LineItem(2, productList.get(1)) );
        System.out.println(macs);
        macs.addLineItem(new LineItem(4, productList.get(1)) );
        System.out.println(macs);

    }
}
