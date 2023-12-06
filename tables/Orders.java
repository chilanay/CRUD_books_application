package tables;

// The Orders class represents information about orders.
public class Orders {

    // Instance variables to store information about each order.
    int orderID;           // Unique identifier for each order.
    String orderDate;      // Date when the order was placed.
    int quantityOrder;     // Quantity of books ordered.
    int bookIDOrders;      // Identifier of the book associated with the order.

    // Constructor for creating a new Orders object with provided details.
    public Orders(int orderID, String orderDate, int quantityOrder, int bookIDOrders) {
        // Call the superclass constructor (not necessary in this case as Orders doesn't extend another class).
        super();
        // Assign values to the instance variables using the provided parameters.
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.quantityOrder = quantityOrder;
        this.bookIDOrders = bookIDOrders;
    }

    // Getter method to retrieve the order's unique identifier (orderID).
    public int getOrderID() {
        return this.orderID;
    }

    // Getter method to retrieve the date when the order was placed (orderDate).
    public String getOrderDate() {
        return this.orderDate;
    }

    // Getter method to retrieve the quantity of books ordered (quantityOrder).
    public int getQuantityOrder() {
        return this.quantityOrder;
    }

    // Getter method to retrieve the identifier of the book associated with the order (bookIDOrders).
    public int getBookIDOrder() {
        return this.bookIDOrders;
    }
}
