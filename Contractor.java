/*
Authors: Nick Barth, Nick Garcia, Kyle Bowles, Owen Leonard, Michael Gostomoski
Date: 11/18/2018
Assignment: Group Project Part 1 - Contractor CDF
Section: 2
Purpose: An application to be used by a home repair and supply shop which
can create and edit customers/contractors, create and edit vendors,
create and edit inventory items,
enter sales, print receipts, and print reports.
 */

package CIS331GroupProject;

public class Contractor extends Customer{
    String businessName;
    static int contractorIDCount;
    int contractorID;
    
    Contractor(String firstName, String lastName, String businessName, String address, String phoneNumber, String emailAddress,
                     int uniqueID)
    {
        super(firstName, lastName, address, phoneNumber, emailAddress, uniqueID);
        
        if(!(businessName.equals("")))
        {
            this.businessName = businessName;
        }
    }
    
    public String getBusinessName(){
        return businessName;
    }
    
    public void setBusinessName(String businessName){
        this.businessName = businessName;
    }
    @Override
    public String toString(){
        return (this.getName() + " | Business Name: " + this.businessName + " | ID: " + this.customerID);
    }
    
}