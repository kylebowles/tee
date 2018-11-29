/*
Authors: Nick Barth, Nick Garcia, Kyle Bowles, Owen Leonard, Michael Gostomoski
Date: 11/18/2018
Assignment: Group Project Part 1 - Sale
Section: 2
Purpose: An application to be used by a home repair and supply shop which
can create and edit customers/contractors, create and edit vendors,
create and edit inventory items,
enter sales, print receipts, and print reports.
 */

package CIS331GroupProject;

public class Sale {
    Item itemSold;
    int quantity;
    String date;
    Customer customer;
    public static int saleCount;
    int saleID;
    
    
    Sale(Item itemSold, int quantity, String date, Customer customer){
        if(itemSold != null)
        {
            this.itemSold = itemSold;
        }
        
        if(quantity > 0)
        {
            this.quantity = quantity;
        }
        
        this.date = date;
        
        if(!(customer.equals(null)))
        {
            this.customer = customer;
        }
        this.saleID = saleCount;
        saleCount++;
    }
    
    public Customer getCustomer(){
        return this.customer;
    }
    
    public void setSaleID(int saleID){
        this.saleID = saleID;
    }
    public int getSaleID(){
        return this.saleID;
    }
    
    @Override
    public String toString(){
        String sale = "Customer: " + customer.getName() + "\nSaleID: " + this.saleID + "\nItem: " + itemSold.itemName + "    Price: $" 
                + itemSold.getPrice() + "\tQuantity: " + this.quantity 
                + "     Sale Total: " + (itemSold.getPrice() * this.quantity);
        return sale;
    }
}

