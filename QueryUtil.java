public class QueryUtil {

    // -----------------------------------Insert-----------------------------------

    public static String insertBookQuery() {
        return "INSERT INTO books (bookID, title, stock, authorIDBooks) VALUES (?,?,?,?)";
    }

    public static String insertAuthorQuery() {
        return "INSERT INTO authors (authorID, authorName) VALUES (?,?)";
    }

    public static String insertOrdersQuery() {
        return "INSERT INTO orders (orderID, orderDate, quantityOrder, bookIDOrders) VALUES (?,?,?,?)";
    }

    public static String insertCustomersQuery() {
        return "INSERT INTO customers (customerID, customerName, address, phoneNumber) VALUES (?,?,?,?)";
    }

    // -----------------------------------Select-----------------------------------

    public static String selectAllBookQuery() {
        return "SELECT * FROM books";
    }

    public static String selectAllAuthorQuery() {
        return "SELECT * FROM authors";
    }

    public static String selectAuthorByIdQuery() {
        return "SELECT * FROM authors WHERE authorID = ?";
    }

    public static String selectAllOrderQuery() {
        return "SELECT * FROM orders";
    }

    public static String selectAllCustomerQuery() {
        return "SELECT * FROM customers";
    }

    // -----------------------------------Delete-----------------------------------

    public static String deleteBookByIdQuery(int bookID) {
        return "DELETE FROM books WHERE bookID = " + bookID;
    }

    public static String selectBookById(int bookID) {
        return "SELECT * FROM books WHERE bookID = " + bookID;
    }

    // -----------------------------------Delete-----------------------------------

    public static String updateBookStockQuery() {
        return "UPDATE books SET stock = stock - ? WHERE bookID = ?";
    }

    public static String updateBookQuery(int bookID) {
        return "UPDATE books SET bookID = ?, title = ?, stock = ?, authorIDBooks = ? WHERE bookID = " + bookID;
    }
}