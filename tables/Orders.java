package tables;

public class Orders {
    int orderID;
    String orderDate;
    int quantityOrder;

    public Orders(int orderID, String orderDate, int quantityOrder) {
        super();
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.quantityOrder = quantityOrder;
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
}
