// The QueryUtil class provides static methods to generate SQL queries related to books, authors, orders, and customers.
public class QueryUtil {

    // -----------------------------------Insert-----------------------------------

    // Returns an SQL query for inserting a new book into the 'books' table.
    public static String insertBookQuery() {
        return "INSERT INTO books (bookID, title, stock, authorIDBooks) VALUES (?,?,?,?)";
    }

    // Returns an SQL query for inserting a new author into the 'authors' table.
    public static String insertAuthorQuery() {
        return "INSERT INTO authors (authorID, authorName) VALUES (?,?)";
    }

    // Returns an SQL query for inserting a new order into the 'orders' table.
    public static String insertOrdersQuery() {
        return "INSERT INTO orders (orderID, orderDate, quantityOrder, bookIDOrders) VALUES (?,?,?,?)";
    }

    // Returns an SQL query for inserting a new customer into the 'customers' table.
    public static String insertCustomersQuery() {
        return "INSERT INTO customers (customerID, customerName, address, phoneNumber) VALUES (?,?,?,?)";
    }

    // -----------------------------------Select-----------------------------------

    // Returns an SQL query to select all records from the 'books' table.
    public static String selectAllBookQuery() {
        return "SELECT * FROM books";
    }

    // Returns an SQL query to select all records from the 'authors' table.
    public static String selectAllAuthorQuery() {
        return "SELECT * FROM authors";
    }

    // Returns an SQL query to select an author by their ID from the 'authors' table.
    public static String selectAuthorByIdQuery() {
        return "SELECT * FROM authors WHERE authorID = ?";
    }

    // Returns an SQL query to select all records from the 'orders' table.
    public static String selectAllOrderQuery() {
        return "SELECT * FROM orders";
    }

    // Returns an SQL query to select all records from the 'customers' table.
    public static String selectAllCustomerQuery() {
        return "SELECT * FROM customers";
    }

    // -----------------------------------Delete-----------------------------------

    // Returns an SQL query to delete a book by its ID from the 'books' table.
    public static String deleteBookByIdQuery(int bookID) {
        return "DELETE FROM books WHERE bookID = " + bookID;
    }

    // Returns an SQL query to select a book by its ID from the 'books' table.
    public static String selectBookById(int bookID) {
        return "SELECT * FROM books WHERE bookID = " + bookID;
    }

    // -----------------------------------Update-----------------------------------

    // Returns an SQL query to update the stock of a book in the 'books' table.
    public static String updateBookStockQuery() {
        return "UPDATE books SET stock = stock - ? WHERE bookID = ?";
    }

    // Returns an SQL query to update the details of a book in the 'books' table by its ID.
    public static String updateBookQuery(int bookID) {
        return "UPDATE books SET bookID = ?, title = ?, stock = ?, authorIDBooks = ? WHERE bookID = " + bookID;
    }
}
