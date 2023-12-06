package tables;

// The Customers class represents information about customers.
public class Customers {

    // Instance variables to store information about each customer.
    int customerID;        // Unique identifier for each customer.
    String customerName;   // Name of the customer.
    String address;        // Address of the customer.
    int phoneNumber;       // Phone number of the customer.

    // Constructor for creating a new Customers object with provided details.
    public Customers(int customerID, String customerName, String address, int phoneNumber) {
        // Call the superclass constructor (not necessary in this case as Customers doesn't extend another class).
        super();
        // Assign values to the instance variables using the provided parameters.
        this.customerID = customerID;
        this.customerName = customerName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    // Getter method to retrieve the customer's unique identifier (customerID).
    public int getCustomerID() {
        return this.customerID;
    }

    // Getter method to retrieve the customer's name.
    public String getCustomerName() {
        return this.customerName;
    }

    // Getter method to retrieve the customer's address.
    public String getAddress() {
        return this.address;
    }

    // Getter method to retrieve the customer's phone number.
    public int getPhoneNumber() {
        return this.phoneNumber;
    }
}
