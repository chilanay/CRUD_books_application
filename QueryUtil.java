public class QueryUtil {

    // -----------------------------------Insert-----------------------------------

    public static String insertBookQuery() {
        return "INSERT INTO books (bookID, title, stock) VALUES (?, ?,?)";
    }

    public static String insertAuthorQuery() {
        return "INSERT INTO authors (authorID, authorName) VALUES (?, ?)";
    }

    public static String insertOrdersQuery() {
        return "INSERT INTO orders (orderID, orderDate, quantityOrder) VALUES (?, ?, ?)";
    }

    public static String insertCustomersQuery() {
        return "INSERT INTO customers (customerID, customerName, address, phoneNumber) VALUES (?, ?, ?, ?)";
    }

    // -----------------------------------Select-----------------------------------

    public static String selectAllBookQuery() {
        return "SELECT * FROM books";
    }

    public static String selectAllAuthorQuery() {
        return "SELECT * FROM authors";
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

    public static String deleteAuthorByIdQuery(int authorID) {
        return "DELETE FROM authors WHERE authorID = " + authorID;
    }

    public static String selectAuthorById(int authorID) {
        return "SELECT * FROM authors WHERE authorID = " + authorID;
    }

    public static String deleteOrderByIdQuery(int orderID) {
        return "DELETE FROM orders WHERE orderID = " + orderID;
    }

    public static String selectOrderById(int orderID) {
        return "SELECT * FROM orders WHERE orderID = " + orderID;
    }

    public static String deleteCustomerByIdQuery(int customerID) {
        return "DELETE FROM customers WHERE customerID = " + customerID;
    }

    public static String selectCustomerById(int customerID) {
        return "SELECT * FROM customers WHERE customerID = " + customerID;
    }

    // -----------------------------------Update-----------------------------------

    public static String updateBookQuery(int bookID) {
        return "UPDATE books SET bookID = ?, title = ?, stock = ? WHERE bookID = " + bookID;
    }

    public static String updateAuthorQuery(int authorID) {
        return "UPDATE authors SET authorID = ?, authorName = ? WHERE authorID = " + authorID;
    }
}
