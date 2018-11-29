/*
Authors: Nick Barth, Nick Garcia, Kyle Bowles, Owen Leonard, Michael Gostomoski
Date: 11/18/2018
Assignment: Group Project Part 1 - Valley Depot Main Application
Section: 2
Purpose: An application to be used by a home repair and supply shop which
can create and edit customers/contractors, create and edit vendors,
create and edit inventory items,
enter sales, print receipts, and print reports.
 */


// Nick Garcia, Nick Barth, Owen Leonard, Kyle Bowles, Michael Gostomski
// Group Project Part 1
// Section 2

package CIS331GroupProject;

import java.util.*;

public class ValleyDepotApplication {
    // Variable for unique IDs
    static int countID;

    
    public static void main(String[] args) {
    
        
    int menuChoice = 0;
    countID = 0;
    ArrayList<Customer> customerList = new ArrayList<Customer>();
    ArrayList<Contractor> contractorList = new ArrayList<Contractor>();
    ArrayList<Item> itemList = new ArrayList<Item>();
    ArrayList<Sale> saleList = new ArrayList<Sale>();
    ArrayList<Vendor> vendorList = new ArrayList<Vendor>();
    Scanner in = new Scanner(System.in);
    
    // Creates customers in the system
    Customer nick = new Customer("Nick", "Garcia", "1107 S Dickenson Ave", "5714204140", "garcianm@dukes.jmu.edu", countID); 
    countID++;
    Customer owen = new Customer("Owen", "Leonard", "401 Weaver St", "7021114521", "leonarop@dukes.jmu.edu", countID);
    countID++;
    Customer barth = new Customer("Nick", "Barth", "123 Greenbrair Dr", "5712223341", "barthna@dukes.jmu.edu", countID);
    countID++;
    Customer kyle = new Customer("Kyle", "Bowles", "55 S Main St", "7035550124", "bowlesk@dukes.jmu.edu", countID);
    countID++;
    customerList.add(nick);
    customerList.add(owen);
    customerList.add(barth);
    customerList.add(kyle);
    
    // Creates contractors in the system 
    Contractor nickBarth = new Contractor("Nick", "Barth", "Costco", "1107 S Dickenson Ave", "5714204140", "garcianm@dukes.jmu.edu", countID); 
    countID++;
    Contractor leonard = new Contractor("Owen", "Leonard", "Best Buy", "401 Weaver St", "7021114521", "leonarop@dukes.jmu.edu", countID);
    countID++;
    Contractor garcia = new Contractor("Nick", "Garcia", "IKEA", "123 Greenbrair Dr", "5712223341", "barthna@dukes.jmu.edu", countID);
    countID++;
    contractorList.add(garcia);
    contractorList.add(leonard);
    contractorList.add(nickBarth);
    
    // Creates items in the system
    itemList.add(new Item(countID, "Lamp", 2.45, "Nightstand Lamp", 24.99, 12.99, 30, 1));
        countID++;
        Item tv = new Item(countID, "LED TV", 14.0, "50\" LED Television", 599.90, 300.00, 10, 2);
        countID++;
        Item table = new Item(countID, "Coffee Table", 35.00, "IKEA Coffee Table Concrete & Glass",159.00, 100.00, 15, 3);
        countID++;
        Item candle = new Item(countID, "Scented Candle",1.5,"Lavendar Oaks Farm Candle",29.99, 17.99, 50, 1);
        countID++;
        Item computer = new Item(countID, "Laptop",4.0,"Dell Laptop",1299.99, 800.00, 30, 2);
        countID++;
        Item couch = new Item(countID, "Recliner Couch",30.0,"IKEA Leather Recliner Couch",129.99, 90.00, 50, 3);
        countID++;
        Item monitor = new Item(countID, "Monitor",4.0,"Dell Monior",1099.99, 700.00, 30, 2);
        countID++;
        Item plant = new Item(countID, "Plant", 4.0, "Outdoor Fern", 22.90, 7.00, 30, 1);
        countID++;
        Item flower = new Item(countID, "Flower", 2.0, "Purple Flower", 14.99, 5.00, 30, 1);
        countID++;
        Item chair = new Item(countID, "Desk Chair",16.0, "IKEA Brown Desk Chair",22.99, 15.00, 50, 3);
        countID++;
        itemList.add(tv);
        itemList.add(table);
        itemList.add(candle);
        itemList.add(computer);
        itemList.add(couch);
        itemList.add(monitor);
        itemList.add(plant);
        itemList.add(flower);
        itemList.add(chair);
        
        // Creates vendors in the system
        vendorList.add(new Vendor(countID, "Costco", "1830 Reservoir Street", "5404328989"));
        countID++;
        vendorList.add(new Vendor(countID, "Best Buy", "1800 South Main Street", "5404329460"));
        countID++;
        vendorList.add(new Vendor(countID, "IKEA", "920 Port Republic Road", "5406104320"));
        countID++;
      saleList.add(new Sale(tv, 2, "11/11/18", nick, countID));
        countID++;
        Sale sale1 = new Sale(computer, 1, "11/12/18", barth , countID);
        countID++;
        Sale sale2 = new Sale(chair, 2, "10/30/18", owen , countID);
        countID++;
        Sale sale3 = new Sale(couch, 3, "10/31/18", kyle, countID);
        countID++;
        Sale sale4 = new Sale(candle, 5, "11/1//18", nickBarth, countID);
        countID++;
        saleList.add(sale1);
        computer.recordTransaction(sale1);
        saleList.add(sale2);
        chair.recordTransaction(sale2);
        saleList.add(sale3);
        couch.recordTransaction(sale3);
        saleList.add(sale4);
        candle.recordTransaction(sale4);
    
    // Allows user to make a selecion on the main menu
    while (menuChoice != 7)
    {
        System.out.println("        Valley Depot System Menu");
        System.out.println("======================================");
        System.out.println("Please make a selection between 1 - 7");
        System.out.println("1. Create/Edit a Customer");
        System.out.println("2. Create/Edit an Inventory Item");
        System.out.println("3. Create/Edit a Vendor");
        System.out.println("4. Enter a Sale");
        System.out.println("5. Print a Receipt");
        System.out.println("6. Print a Report");
        System.out.println("7. Exit System");
        System.out.println("======================================");
        System.out.print("Selection: ");
        menuChoice = in.nextInt();
        in.nextLine();
        
        switch (menuChoice)
        {
            // Creating/Editing a Customer
            case 1:
                int uniqueID, choice;
                String scannerRead;
                Customer tempCust;
                Contractor tempCont;
                String firstName, lastName, address, phoneNumber, emailAddress;
                    
                System.out.println("Would you like to Create or Edit? (Enter Option 1 or 2");
                System.out.println("1a. Create Customer");
                System.out.println("1b. Create Contractor");
                System.out.println("2a. Edit Customer");
                System.out.println("2b. Edit Contractor");
                System.out.print("Selection: ");
                String createOrEditChoice = in.nextLine();
                
                //Creates Customer Object, add it to customer ArrayList
                switch (createOrEditChoice) {
                    case "1a":
                        uniqueID = countID;
                        System.out.println("Enter Customer First Name: ");
                        firstName = in.nextLine();
                        while(firstName.equals("") || firstName.equals(" "))
                        {
                            System.out.println("Please make an entry.");
                            System.out.print("Enter Customer First Name: ");
                            firstName = in.nextLine();
                        }
                        
                        System.out.println("Enter Customer Last Name: ");
                        lastName = in.nextLine();
                        while(lastName.equals("") || lastName.equals(" "))
                        {
                            System.out.print("Please make an entry.");
                            System.out.print("Enter Customer Last Name: ");
                            lastName = in.nextLine();
                        }
                        System.out.println("Enter Customer Address: ");
                        address = in.nextLine();
                        
                        System.out.println("Enter Customer Phone Number: ");
                        phoneNumber = in.nextLine();
                        while(phoneNumber.length() != 10)
                        {
                            System.out.println("Invalid Entry: Please enter a 10-digit phone number");
                            System.out.print("Enter Customer Phone Number: ");
                            phoneNumber = in.nextLine();
                        }
                        System.out.println("Enter Customer Email Address: ");
                        emailAddress = in.nextLine();
                        customerList.add(new Customer(firstName, lastName, address, phoneNumber, emailAddress, countID));
                        countID++;
                        break;
                    
                    //Creates Contractor Object, add it to contractor ArrayList
                    case "1b":
                        uniqueID = countID;
                        String businessName;
                        System.out.println("Enter Contractor First Name: ");
                        firstName = in.nextLine();
                        while(firstName.equals("") || firstName.equals(" "))
                        {
                            System.out.println("Please make an entry.");
                            System.out.print("Enter Contractor First Name: ");
                            firstName = in.nextLine();
                        }
                        
                        System.out.println("Enter Contractor Last Name: ");
                        lastName = in.nextLine();
                        while(lastName.equals("") || firstName.equals(" "))
                        {
                            System.out.println("Please make an entry.");
                            System.out.print("Enter Contractor Last Name: ");
                            lastName = in.nextLine();
                        }
                        
                        System.out.println("Enter Business Name: ");
                        businessName = in.nextLine();
                        while(businessName.equals("") || firstName.equals(" "))
                        {
                            System.out.println("Please make an entry.");
                            System.out.print("Enter Business Name: ");
                            firstName = in.nextLine();
                        }
                        System.out.println("Enter Business Address: ");
                        address = in.nextLine();
                        System.out.println("Enter Contractor Phone Number: ");
                        phoneNumber = in.nextLine();
                        while(phoneNumber.length() != 10)
                        {
                            System.out.println("Invalid Entry: Please enter a 10-digit phone number");
                            System.out.print("Enter Contractor Phone Number: ");
                            phoneNumber = in.nextLine();
                        }
                        
                        System.out.println("Enter Contractor Email Address: ");
                        emailAddress = in.nextLine();
                        contractorList.add(new Contractor(firstName, lastName, businessName, address, phoneNumber,
                                emailAddress, countID));
                        countID++;
                        break;
                    // Edits Customer Object, add it to customer ArrayList
                    case "2a":
                        for(int x = 0; x < customerList.size();x++){
                            System.out.println("Option # " + x + ": " + customerList.get(x).toString());
                        }
                        System.out.println("Enter the Option # to edit a customter from the list above: ");
                        choice = in.nextInt();
                        in.nextLine();
                        tempCust = customerList.get(choice);
                       
                        
                        System.out.println("First name: " + tempCust.getFirstName());
                        System.out.println("Last name: " + tempCust.getLastName());
                        System.out.println("Address: " + tempCust.getAddress());
                        System.out.println("Phone number: " + tempCust.getPhoneNumber());
                        System.out.println("Email: " + tempCust.getEmail());
                        System.out.println("Type the category of information you would like to change:");
                        scannerRead = in.nextLine();
                        
                        switch (scannerRead) {
                            case "first name":
                            case "First name":
                            case "First Name":
                                System.out.print("What would you like to change " + tempCust.getFirstName() + " to: \n");
                                customerList.get(choice).setFirstName(in.nextLine());
                                while(customerList.get(choice).getFirstName().equals("") || customerList.get(choice).getFirstName().equals(" "))
                                {
                                    System.out.println("Please make an entry.");
                                    System.out.print("What would you like to change " + tempCust.getFirstName() + " to: \n");
                                    customerList.get(choice).setFirstName(in.nextLine());
                                }
                                break;
                            case "last name":
                            case "Last name":
                            case "Last Name":
                                System.out.print("What would you like to change " + tempCust.getLastName() + " to: \n");
                                customerList.get(choice).setLastName(in.nextLine());
                                while(customerList.get(choice).getLastName().equals("") || customerList.get(choice).getLastName().equals(" "))
                                {
                                    System.out.println("Please make an entry.");
                                    System.out.print("What would you like to change " + tempCust.getLastName() + " to: \n");
                                    customerList.get(choice).setLastName(in.nextLine());
                                }
                                break;
                            case "address":
                            case "Address":
                                System.out.print("What would you like to change " + tempCust.getAddress() + " to: \n");
                                customerList.get(choice).setAddress(in.nextLine());
                                break;
                            case "phone number":
                            case "Phone number":
                            case "Phone Number":
                                System.out.print("What would you like to change " + tempCust.getPhoneNumber() + " to: \n");
                                customerList.get(choice).setPhoneNumber(in.nextLine());
                                while(customerList.get(choice).getPhoneNumber().length() != 10)
                                {
                                    System.out.println("Invalid Entry: Please enter a 10-digit phone number");
                                    System.out.print("What would you like to change " + tempCust.getPhoneNumber() + " to: \n");
                                    customerList.get(choice).setPhoneNumber(in.nextLine());
                                }
                                break;
                            case "Email":
                            case "email":
                                System.out.print("What would you like to change " + tempCust.getEmail() + " to: \n");
                                customerList.get(choice).setEmail(in.nextLine());
                                break;
                            default:
                                System.out.print("Invalid Syntax: Enter in the word describing the information you would like to change.");
                                break;
                        }
                        break;
                    // Edits Contractor Object, add it to contractor ArrayList
                    case "2b":
                        for(int x = 0; x < contractorList.size();x++){
                           System.out.println("Option #" + x + ": " + contractorList.get(x).toString());
                        }
                        System.out.println("Enter the Option # to edit a contractor from the list above: ");
                        choice = in.nextInt();
                        in.nextLine();
                        tempCont = contractorList.get(choice);
                        
                        System.out.println("First Name: " + tempCont.getFirstName());
                        System.out.println("Last Name: " + tempCont.getLastName());
                        System.out.println("Business Name: " + tempCont.getBusinessName());
                        System.out.println("Business Address: " + tempCont.getAddress());
                        System.out.println("Phone number: " + tempCont.getPhoneNumber());
                        System.out.println("Email: " + tempCont.getEmail());
                        System.out.println("Type the category of information you would like to change:");
                        scannerRead = in.nextLine();
                        
                        switch (scannerRead) {
                            case "first name":
                            case "First name":
                            case "First Name":
                                System.out.println("What would you like to change " + tempCont.getFirstName() + " to: \n");
                                contractorList.get(choice).setFirstName(in.nextLine());
                                {
                                    System.out.println("Please make an entry.");
                                    System.out.print("What would you like to change " + tempCont.getFirstName() + " to: \n");
                                    customerList.get(choice).setFirstName(in.nextLine());
                                }
                                break;
                            case "last name":
                            case "Last name":
                            case "Last Name":
                                System.out.println("What would you like to change " + tempCont.getLastName() + " to: \n");
                                contractorList.get(choice).setLastName(in.nextLine());
                                while(contractorList.get(choice).getFirstName().equals("") || contractorList.get(choice).getFirstName().equals(" "))
                                {
                                    System.out.println("Please make an entry.");
                                    System.out.print("What would you like to change " + tempCont.getFirstName() + " to: \n");
                                    customerList.get(choice).setLastName(in.nextLine());
                                }
                                break;
                            case "business name":
                            case "Business name":
                            case "Business Name":
                                System.out.print("What would you like to change " + tempCont.getBusinessName() + " to: \n");
                                contractorList.get(choice).setBusinessName(in.nextLine());
                                break;
                            case "business address":
                            case "Business address":
                            case "Business Address":
                                System.out.print("What would you like to change " + tempCont.getAddress() + " to: \n");
                                contractorList.get(choice).setAddress(in.nextLine());
                                break;
                            case "phone number":
                            case "Phone number":
                            case "Phone Number":
                                System.out.println("What would you like to change " + tempCont.getPhoneNumber() + " to: \n");
                                contractorList.get(choice).setPhoneNumber(in.nextLine());
                                while(contractorList.get(choice).getPhoneNumber().length() != 10)
                                {
                                    System.out.println("Invalid Entry: Please enter a 10-digit phone number");
                                    System.out.print("What would you like to change " + tempCont.getPhoneNumber() + " to: \n");
                                    contractorList.get(choice).setPhoneNumber(in.nextLine());
                                }
                                break;
                            case "Email":
                            case "email":
                                System.out.print("What would you like to change " + tempCont.getEmail() + " to: \n");
                                contractorList.get(choice).setEmail(in.nextLine());
                                break;
                            default:
                                System.out.print("Invalid Syntax: Enter in the word describing the information you would like to change.");
                                break;
                        }
                        break;
                        
                    default:
                        System.out.println("Please enter in a valid response (1a, 1b, 2a, 2b)");
                        break;
                } 
                break;
            // Creating/Editing an Inventory Item    
            case 2:
                int invChoice, vendorID;
                int choice1, inventory;
                Item tempInv;
                String itemName, description, StringInvChoice;
                int id;
                double salePrice, pricePaid, weight;
                    
                System.out.println("Would you like to Create or Edit? (Enter Option 1 or 2");
                System.out.println("1. Create an Inventory Item.");
                System.out.println("2. Edit an Inventory Item");
                System.out.print("Selection: ");
                invChoice = in.nextInt();
                in.nextLine();
                switch (invChoice) {
                    case 1:
                        uniqueID = countID;
                        System.out.println("Enter Item Name: ");
                        itemName = in.nextLine();
                        while(itemName.equals("") || itemName.equals(" "))
                        {
                            System.out.println("Please make an entry.");
                            System.out.print("Enter Item Name: ");
                            itemName = in.nextLine();
                        }
                        
                        System.out.println("Enter Item Weight: ");
                        weight = in.nextDouble();
                        while(!(weight > 0))
                        {
                            System.out.println("Please enter a positive weight.");
                            System.out.print("Enter Item Weight: ");
                            weight = in.nextDouble();
                        }
                        in.nextLine();
                        System.out.println("Enter Item Description: ");
                        description = in.nextLine();
                        System.out.println("Enter Sales Price for Item: ");
                        salePrice = in.nextDouble();
                        while(!(salePrice >= 0))
                        {
                            System.out.println("Please enter a positive value for sale price.");
                            System.out.print("Enter Sale Price for Item: ");
                            salePrice = in.nextDouble();
                        }
                        in.nextLine();
                        System.out.println("Enter Price Paid for Item: ");
                        pricePaid = in.nextDouble();
                        while(!(pricePaid >= 0))
                        {
                            System.out.println("Please enter a positive value for price paid.");
                            System.out.print("Enter Price Paid for Item: ");
                            pricePaid = in.nextDouble();
                        }
                        in.nextLine();
                        System.out.println("Enter Quantity Purchased: ");
                        inventory = in.nextInt();
                        while(!(inventory > 0))
                        {
                            System.out.println("Please enter a non-zero positive value for quantity purchased.");
                            System.out.print("Enter Quantity Purchased: ");
                            inventory = in.nextInt();
                        }
                        in.nextLine();
                        int countVendorList = 0;
                        for(int x = 0; x < vendorList.size(); x++){
                        	System.out.println("Vendor " + countVendorList + ": " + vendorList.get(x).getBusinessName());
                                countVendorList++;
                        }
                        System.out.println("Enter Vendor ID: ");
                        vendorID = in.nextInt();
                        in.nextLine();
                        itemList.add(new Item(countID, itemName, weight, description, salePrice, pricePaid, inventory, vendorList.get(vendorID).vendorID));
                        countID++;
                        break;
                    case 2:
                        for(int x = 0; x < itemList.size();x++){
                            System.out.println("Option # " + x + ": " + itemList.get(x).toString());
                        }
                        System.out.println("Enter the Option # to edit an Inventory Item from the list above: ");
                        choice1 = in.nextInt();
                        in.nextLine();
                        tempInv = itemList.get(choice1);
                        
                        
                        System.out.println("Item Name: " + tempInv.getItemName());
                        System.out.println("Weight: " + tempInv.getWeight());
                        System.out.println("Description: " + tempInv.getDescription());
                        System.out.println("Sale Price: " + tempInv.getPrice());
                        System.out.println("Price Paid: " + tempInv.getPricePaid());
                        System.out.println("Inventory: " + tempInv.getInventory());
                        System.out.println("Vendor ID: " + tempInv.getVendorId());
                        System.out.println("Type the category of information you would like to change:");
                        scannerRead = in.nextLine();
                        
                          switch (scannerRead) {
                            case "Item Name":
                            case "item name":
                            case "Item name":
                                System.out.println("What would you like to change " + tempInv.getItemName() + " to: ");
                                itemList.get(choice1).setItemName(in.nextLine());
                                while(itemList.get(choice1).getItemName().equals("") || itemList.get(choice1).getItemName().equals(" "))
                                {
                                    System.out.println("Please make an entry.");
                                     System.out.println("What would you like to change " + tempInv.getItemName() + " to: ");
                                    itemList.get(choice1).setItemName(in.nextLine());
                                }
                                break;
                            case "Weight":
                            case "weight":
                                System.out.println("What would you like to change " + tempInv.getWeight() + " to: ");
                                itemList.get(choice1).setWeight(in.nextDouble());
                                while((itemList.get(choice1).getWeight() > 0))
                                {
                                    System.out.println("Please enter a positive weight.");
                                    System.out.print("What would you like to change " + tempInv.getWeight() + " to: ");
                                    itemList.get(choice1).setWeight(in.nextDouble());
                                }
                                break;
                            case "Description":
                            case "description":
                                System.out.print("What would you like to change " + tempInv.getDescription() + " to: \n");
                                itemList.get(choice1).setDescription(in.nextLine());
                                break;
                            case "sale price":
                            case "Sale price":
                            case "Sale Price":
                                System.out.print("What would you like to change " + tempInv.getPrice() + " to: \n");
                                itemList.get(choice1).setPrice(in.nextDouble());
                                while(!(itemList.get(choice1).getPrice() >= 0))
                                {
                                    System.out.println("Please enter a positive value for sale price.");
                                    System.out.print("What would you like to change " + tempInv.getPrice() + " to: \n");
                                    itemList.get(choice1).setPrice(in.nextDouble());
                                }
                                break;
                            case "inventory":
                            case "Inventory":
                                System.out.println("Would you like to add/subtract/manually change inventory?");
                                System.out.println("1. Add inventory");
                                System.out.println("2. Subtract inventory");
                                System.out.println("3. Change inventory level to a number");
                                
                                int choiceForInventory = in.nextInt();
                                
                                in.nextLine();
                                int inventoryChange;
                                switch(choiceForInventory){
                                    case 1:
                                        System.out.print("Enter Inventory Change: ");
                                        inventoryChange = in.nextInt();
                                        itemList.get(choice1).addInventory(inventoryChange);
                                        break;
                                    case 2:
                                        int inventoryIndicator;
                                        System.out.print("Enter Inventory Change: ");
                                        inventoryChange = in.nextInt();
                                        inventoryIndicator = itemList.get(choice1).inventoryStatus(inventoryChange);
                                        
                                        switch(inventoryIndicator){
                                            case 0: 
                                            case 1:
                                                itemList.get(choice1).subtractInventory(inventoryChange);
                                                break;
                                            case 2:
                                                break;
                                        }
                                        
                                        break;
                                    case 3:
                                        System.out.print("Enter Inventory Change: ");
                                        inventoryChange = in.nextInt();
                                        itemList.get(choice1).setInventory(inventoryChange);
                                        break;
                                    default:
                                        System.out.println("Enter in a valid number");
                                        break;   
                                }
                                
                                break;
                            case "vendor id":
                            case "Vendor id":
                            case "Vendor ID":
                                System.out.print("What would you like to change " + tempInv.getVendorId() + " to: \n");
                                itemList.get(choice1).setVendorId(in.nextInt());
                                break;
                            default:
                                System.out.print("Invalid Syntax: Enter in the word describing the information you would like to change.");
                                break;        
                        } 
                        break;  
                    default:
                        System.out.println("Please enter selection 1 or 2.");
                break;
                }       
            break;
            // Creating/Editing a Vendor    
            case 3:
                Vendor tempVendor;
                int vendorChoice, editChoice;
                System.out.println("Would you like to Create or Edit? (Enter Option 1 or 2)");
                System.out.println("1. Create Vendor");
                System.out.println("2. Edit Vendor");
                System.out.print("Seleciton: ");
                vendorChoice = in.nextInt();
                in.nextLine();
                switch (vendorChoice)
                {       // add in exception handling
                        case 1: 
                            System.out.print("Enter Vendor's business name: ");
                            String vendorName = in.nextLine();
                            while((vendorName.equals("") || vendorName.equals(" ")))
                            {
                                System.out.println("Please make an entry.");
                                System.out.print("Enter Vendor's business name: ");
                                vendorName = in.nextLine();
                            }
                            System.out.print("Enter Vendor's business address: ");
                            String vendorAddress = in.nextLine();
                            System.out.print("Enter Vendor's phone number: ");
                            String vendorPhone = in.nextLine();
                            while(vendorPhone.length() != 10){
                                System.out.println("Invalid Entry: Please enter a 10-digit phone number");
                                System.out.print("Enter Vendor's phone number (numbers only): ");
                                vendorPhone = in.nextLine();} 
                            vendorList.add(new Vendor(countID, vendorName, vendorAddress, vendorPhone));
                            countID++;
                            break;
                            
                        case 2:
                            for(int x = 0; x < vendorList.size();x++){
                            System.out.println("Option #" + x + ": " + vendorList.get(x).toString());
                            }
                            System.out.print("Enter the option # to edit a vendor from the list above: ");
                            editChoice = in.nextInt();
                            while ((editChoice < 0 || editChoice > vendorList.size())){
                                System.out.println("Invalid Entry: Please enter a correct vendor number");
                                for(int x = 0; x < vendorList.size();x++){
                                    System.out.println("Option #" + x + ": " + vendorList.get(x).toString());
                                }
                                System.out.print("Enter the option # to edit a vendor from the list above: ");
                                editChoice = in.nextInt();
                            }
                            in.nextLine();
                            tempVendor = vendorList.get(editChoice);
                            
                            System.out.println("Vendor name: " + tempVendor.getBusinessName());
                            System.out.println("Vendor address: " + tempVendor.getBusinessAddress());
                            System.out.println("Vendor phone number: " + tempVendor.getPhoneNumber());
                            System.out.print("Type the category of information you use to change (ex. Vendor Name): ");
                            scannerRead = in.nextLine();
                            scannerRead = scannerRead.toUpperCase();
                            
                            switch (scannerRead) {
                                
                            case "VENDOR NAME":
                                System.out.println("What would you like to change " + tempVendor.getBusinessName() + " to: ");
                                vendorList.get(editChoice).setBusinessName(in.nextLine());
                                while(vendorList.get(editChoice).getBusinessName().equals("") || vendorList.get(editChoice).getBusinessName().equals(" "))
                                {
                                    System.out.println("Please make an entry.");
                                    System.out.println("What would you like to change " + tempVendor.getBusinessName() + " to: ");
                                    vendorList.get(editChoice).setBusinessName(in.nextLine());
                                }
                                break;
                            case "VENDOR ADDRESS":
                                System.out.println("What would you like to change " + tempVendor.getBusinessAddress() + " to: ");
                                vendorList.get(editChoice).setBusinessAddress(in.nextLine());
                                break;
                            case "VENDOR PHONE NUMBER":
                                System.out.println("What would you like to change " + tempVendor.getPhoneNumber() + " to: ");
                                vendorList.get(editChoice).setPhoneNumber(in.nextLine());
                                while(vendorList.get(editChoice).getPhoneNumber().length() != 10)
                                {
                                    System.out.println("Invalid Entry: Please enter a 10-digit phone number");
                                    System.out.println("What would you like to change " + tempVendor.getPhoneNumber() + " to: ");
                                    vendorList.get(editChoice).setPhoneNumber(in.nextLine());
                                }
                                break;
                            default:
                                System.out.println("Invalid Syntax: enter in the word describing the information you would like to change");
                                break;
                            }
                            break;
                    default: 
                    System.out.println("Please enter in a valid response (1 or 2)");          
                    break;
                }
            break;
            // Entering a Sale    
            case 4:
                    Item itemSold;
                    int itemID;
                    int inventoryIndicator;
                    int quantity;
                    String date; 
                    int customerChoice;
                    int saleCount = 0;
                    int listCount = 0;
                    Customer customer;
                    boolean cont;
                    String option;
                   
                    
                    while (cont = true) {
                    
                        
                        for(int x = 0; x < itemList.size(); x++){
                            System.out.println(listCount + ". " + itemList.get(x).getDescription());
                            listCount ++; 
                        }
                        listCount = 0;
                    
                        
                        System.out.println("Select an Item: ");
                        itemID = in.nextInt();
                        
                        System.out.println("Enter Quantity: ");
                        quantity = in.nextInt();
                        while(!(quantity > 0))
                        {
                            System.out.println("Please enter a positive value for quantity.");
                            System.out.println("Enter Quantity: ");
                            quantity = in.nextInt();
                            
                        }
                        
                        inventoryIndicator = itemList.get(itemID).inventoryStatus(quantity);

                        switch(inventoryIndicator){
                                            case 0: 
                                            case 1:
                                                itemList.get(itemID).subtractInventory(quantity);
                                                break;
                                            case 2: 
                                                System.out.println("NOT ENOUGH INVENTORY TO PERFORM CHANGE");
                                                break;
                                        }
                        if(inventoryIndicator == 2){
                            break;
                        }
                        
                        in.nextLine();
                        System.out.println("Enter Date of Delivery: ");
                        date = in.nextLine();
                        for(int x = 0; x < customerList.size(); x++){
                            System.out.println(x + ". " + customerList.get(x).toString());
                        }    
                        System.out.println("Choose Customer: ");
                        customerChoice = in.nextInt();
                        in.nextLine();
                 
                        customer = customerList.get(customerChoice);
                        
                        saleList.add(new Sale(itemList.get(itemID), quantity, date, customer, countID));
                        countID++;
                        itemList.get(itemID).recordTransaction(new Sale(itemList.get(itemID), quantity, date, customer, countID));
                        itemList.get(itemID).subtractInventory(quantity);
                        countID++; 
                    
                        System.out.println("Would you like to enter another sale? (y/n)");
                        option = in.nextLine();
                        if (option.equals("n")) {
                            cont = false;
                            break;
                        }
                        else if (option.equals("y") ) {
                            cont = true;
                            
                        }
                    }
                    
                        break;
                    
            // Printing a Receipt    
            case 5:
                int selectionOfSale = 0;
                System.out.println("Select Number 0 through " + (saleList.size() - 1)); 
                for (int i = 0; i < saleList.size(); i++){
                    System.out.println(i + ". SaleID: " + saleList.get(i).id +  "\tCustomer Name: " + saleList.get(i).getCustomer().getName() + "\t On: " + saleList.get(i).date);
                }
                System.out.print("----------------------------\nSelection: ");
                selectionOfSale = in.nextInt();
                System.out.println("");
                in.nextLine();
                
                System.out.println(saleList.get(selectionOfSale).toString());
                System.out.println("");
                break;
            
            // Printing a Report    
            case 6:
                System.out.println("Please select which report you would like to view.");
                System.out.println("1. Customer Purchase History Report.");
                System.out.println("2. Contractor Purchase History Report.");
                System.out.println("3. Item Purchase History Report.");
                System.out.println("4. Current Inventory Report.");
                System.out.println("Selection: ");
                int reportChoice = in.nextInt();
                in.nextLine();
                
                switch(reportChoice){
                   case 1:
                        Customer tempCustomer;
                        int choiceOfCustomer;
                    for(int x = 0; x < customerList.size();x++){
                        System.out.println("Option #" + x + ": " + customerList.get(x).toString());
                    }
                    System.out.print("Enter the option # from the customer above: \n");
                    choiceOfCustomer = in.nextInt();
                    in.nextLine();
                    tempCustomer = customerList.get(choiceOfCustomer);
                    for(int z = 0; z < saleList.size(); z++){
                        if(saleList.get(z).getCustomer().equals(tempCustomer)){
                            System.out.println(saleList.get(z).toString());
                        }
                    }        
                    System.out.println(tempCustomer.describeCustomer() + "\n");
                    break;
                    case 2:         
                        Contractor tempContractor;
                        int contractorChoice;
                
                        for(int x = 0; x < contractorList.size();x++){
                            System.out.println("Option #" + x + ": " + contractorList.get(x).toString());
                        }
                        System.out.print("Enter the option # from the customer above: \n");
                        contractorChoice = in.nextInt();
                        in.nextLine();
                        tempContractor = contractorList.get(contractorChoice);
                        for(int z = 0; z < saleList.size(); z++){
                            if(saleList.get(z).getCustomer().equals((Customer)(tempContractor))){
                                System.out.println(saleList.get(z).toString());
                            }
                        }        
                        
                        System.out.println(tempContractor.toString() + "\n");
                        break;
                    case 3:
                        ArrayList<String> test = new ArrayList<String>();
                        
                        System.out.println("Item Purchase History Report");
                        System.out.println("============================");
                        for(int x = 0; x < itemList.size();x++)
                        {
                            test = itemList.get(x).passItemTransHistory();
                            if(test.size() == 0){
                                System.out.print("");
                            }
                            else if(test.size() > 1){
                                for(int y = 0; y < test.size(); y++){
                                    System.out.println(test.get(y));
                                }
                            }
                            else
                                System.out.println(test.get(0));
                        }
                        System.out.println("");
                        break;

                    case 4:
                        for (int i = 0; i < itemList.size(); i++)
                                System.out.println("Item: " + itemList.get(i).getItemName() + ", Quantity: " + itemList.get(i).getInventory()); 
                        break;       
            // Exits the program    
            case 7:
                System.out.println("The program has ended.");
                break;
            
            // Default statement if user inputs a selection out of range.    
            default:
                System.out.println("Try Again. Please enter a selection between 1 - 7.");
        }
    }
    }  
    }
}

