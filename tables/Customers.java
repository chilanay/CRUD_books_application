package tables;

public class Customers {
    int customerID;
    String customerName;
    String address;
    int phoneNumber;

    public Customers(int customerID, String customerName, String address, int phoneNumber) {
        super();
        this.customerID = customerID;
        this.customerName = customerName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getCustomerID() {
        return this.customerID;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public String getAddress() {
        return this.address;
    }

    public int getPhoneNumber() {
        return this.phoneNumber;
    }
}