package tables;
import java.sql.Date;

public class Orders {
    int orderID;
    Date orderDate;
    int quantityOrder;

    public int getOrderID() {
        return this.orderID;
    }

    public Date getOrderDate() {
        return this.orderDate;
    }

    public int getQuantityOrder() {
        return this.quantityOrder;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setQuantityOrder(int quantityOrder) {
        this.quantityOrder = quantityOrder;
    }
}
