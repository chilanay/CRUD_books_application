package tables;

public class Orders {
    int orderID;
    String orderDate;
    int quantityOrder;
    int bookIDOrders;

    public Orders(int orderID, String orderDate, int quantityOrder, int bookIDOrders) {
        super();
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.quantityOrder = quantityOrder;
        this.bookIDOrders = bookIDOrders;

    }

    public int getOrderID() {
        return this.orderID;
    }

    public String getOrderDate() {
        return this.orderDate;
    }

    public int getQuantityOrder() {
        return this.quantityOrder;
    }

    public int getBookIDOrder() {
        return this.bookIDOrders;
    }
}
