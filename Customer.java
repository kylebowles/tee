/*
Authors: Nick Barth, Nick Garcia, Kyle Bowles, Owen Leonard, Michael Gostomoski
Date: 11/18/2018
Assignment: Group Project Part 1 - Customer CDF
Section: 2
Purpose: An application to be used by a home repair and supply shop which
can create and edit customers/contractors, create and edit vendors,
create and edit inventory items,
enter sales, print receipts, and print reports.
 */

package CIS331GroupProject;

public class Customer {
    private String firstName, lastName, address, phoneNumber, emailAddress; 
    //private int customerIDCount = 0;
    int customerID;
    
     Customer(String firstName, String lastName, String address,
            String phoneNumber, String emailAddress, int uniqueID){
        if(!(firstName.equals("")))
        {
            this.firstName = firstName;
        }
        
        if(!(lastName.equals("")))
        {
            this.lastName = lastName;
        }
        
        if(phoneNumber.length() == 10)
        {
            this.phoneNumber = phoneNumber;
        }
        
        this.address = address;
        this.emailAddress = emailAddress; 
        customerID = uniqueID; 
    }
    
    /*
    *   These methods get or alter the name of the customer
    *   getName combines first and last name for display purposes
    */
    public String getFirstName(){
        return firstName;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public String getName(){
        return (firstName + " " + lastName);
    }
    
    /*
    *   Address, email, phone number getters and setters
    *
    */
    
    public String getAddress(){
        return address;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public String getPhoneNumber(){
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    
    public String getEmail(){
        return emailAddress;
    }
    
    public void setEmail(String emailAddress){
        this.emailAddress = emailAddress;
    }
    
   
    
    public String describeCustomer(){
        String output = "Name: " + this.getName() + "\nPhone Number: " + this.getPhoneNumber()
                + "\nEmail: " + this.getEmail();
        return output;
    }
    @Override
    public String toString(){
        return (this.getName() + " | ID: " + this.customerID);
    }
    
}