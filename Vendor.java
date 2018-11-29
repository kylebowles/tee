/*
Authors: Nick Barth, Nick Garcia, Kyle Bowles, Owen Leonard, Michael Gostomoski
Date: 11/18/2018
Assignment: Group Project Part 1 - Vendor CDF
Section: 2
Purpose: An application to be used by a home repair and supply shop which
can create and edit customers/contractors, create and edit vendors,
create and edit inventory items,
enter sales, print receipts, and print reports.
 */

package CIS331GroupProject;


public class Vendor {
    private String businessName;
    private String businessAddress;
    private String phoneNumber; 
    int vendorID;
    
    Vendor(int uniqueID, String businessName, String businessAddress, String phoneNumber){
        this.businessName = businessName;
        this.businessAddress = businessAddress;
        this.phoneNumber = phoneNumber;
        this.vendorID = uniqueID;
    }
    
    public String getBusinessName(){
        return this.businessName;
    }
    
    public void setBusinessName(String businessName){
        this.businessName = businessName;
    }
    
    public String getBusinessAddress(){
        return this.businessAddress;
    }
    
    public void setBusinessAddress(String businessAddress){
        this.businessAddress = businessAddress;
    }
    
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString(){
        return (this.getBusinessName() + " | ID: " + this.vendorID);
    }
    
}
