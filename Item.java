/*
Authors: Nick Barth, Nick Garcia, Kyle Bowles, Owen Leonard, Michael Gostomoski
Date: 11/18/2018
Assignment: Group Project Part 1 - Item CDF
Section: 2
Purpose: An application to be used by a home repair and supply shop which
can create and edit customers/contractors, create and edit vendors,
create and edit inventory items,
enter sales, print receipts, and print reports.
 */

package CIS331GroupProject;

import java.util.*;

public class Item {
    String itemName;
    double weight;
    String description;
    private double salePrice;
    private double pricePaid; 
    private int inventory;
    public int vendorID;
    Sale sold;
    int id;//////////////////////////////////
    
    ArrayList<String> itemHistory = new ArrayList<String>();
    
    //In main method, must list all the vendorID's before asking them to select the vendor
    Item(int id, String itemName, double weight, String description, double salePrice, 
                double pricePaid, int quantity, int vendorID){
        //this.id; //whatever the static id counter in main is named
        if(!(itemName.equals("")))
        {
            this.itemName = itemName;
        }
        
        if(weight > 0.0)
        {
            this.weight = weight;
        }
        this.description = description;
        
        if(salePrice >= 0.0)
        {
            this.salePrice = salePrice;
        }
        
        if(pricePaid >= 0.0)
        {
            this.pricePaid = pricePaid;
        }
        
        if(quantity >= 0)
        {
            this.inventory = quantity;  
        }
        
        this.vendorID = vendorID; 
    }
    public double getPrice(){
        return salePrice; 
    }
    
    public void setPrice(double salePrice){
        this.salePrice = salePrice;
    }
    
    public int getInventory(){
        return inventory;
    }
    
    public void setInventory(int inventory){
        this.inventory = inventory;
    }
    
    public void addInventory(int inventoryChange){
        this.inventory += inventoryChange;
    }
    
    public void subtractInventory(int inventoryChange){
        this.inventory -= inventoryChange;
           
    }
    
    public int inventoryStatus(int inventoryChange){
         if(inventory - inventoryChange > 0){
           this.inventory -= inventoryChange;
           return 0;
        }
        else if(inventory - inventoryChange > 0 && inventory - inventoryChange < 5){
           System.out.println("Inventory Level Low");
           this.inventory -= inventoryChange; 
           return 1;
        }
        else
            System.out.println("Not enough inventory to fill order");
            return 2;
    }
    
    public int getVendorId(){
        return vendorID; 
    }
    
    public void setVendorId(int vendorID){
        this.vendorID = vendorID;
    }
    
    public void recordTransaction(Sale sold){
        //
        //get customerID, FROM SALE get Date of Sale, getQuantities
        
        this.sold = sold;
        String customer = sold.getCustomer().getName();
        itemHistory.add(itemName + ": " + "\n\tCustomer: " + customer  + " \n\tOn: "
                + sold.date + "\n\tBought: " + Integer.toString(sold.quantity)); 
    }
    
    public ArrayList<String> passItemTransHistory(){
        return itemHistory; 
    }
    ///////////////////////////////////////////////////////////////////////////
    @Override
    public String toString(){
        return (this.itemName + " Unique ID Number: " + id);
    }
    
    public String getItemName(){
        return itemName;
    }
    
    public void setItemName(String itemName){
        this.itemName = itemName;
    }
    
    public double getWeight(){
        return this.weight;
    }
    
    public void setWeight(double weight){
        this.weight = weight;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public double getPricePaid(){
        return this.pricePaid;
    }
    
    public void setPricePaid(double pricePaid){
        this.pricePaid = pricePaid;
    }
}
