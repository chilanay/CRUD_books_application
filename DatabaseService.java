import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tables.Authors;
import tables.Books;
import tables.Customers;
import tables.Orders;

public class DatabaseService {
    ConnectToDatabase connectDatabase = new ConnectToDatabase();

    // -----------------------------------Insert-----------------------------------

    public void insertBooks(Books book) throws SQLException {
        try (Connection connection = connectDatabase.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.insertBookQuery());) {
            preparedStatement.setInt(1, book.getBookID());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setInt(3, book.getStock());

            if (authorExists(book.getAuthorIDBooks())) {
                preparedStatement.setInt(4, book.getAuthorIDBooks());

                int rows = preparedStatement.executeUpdate();
                if (rows > 0) {
                    System.out.println("Record created successfully.");
                } else {
                    System.out.println("Insert operation failed...");
                }
            }
        }
    }

    private boolean authorExists(int authorID) {
        try (Connection connection = connectDatabase.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.selectAuthorByIdQuery())) {
            preparedStatement.setInt(1, authorID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void insertAuthors(Authors author) throws SQLException {
        try (Connection connection = connectDatabase.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.insertAuthorQuery());) {
            preparedStatement.setInt(1, author.getAuthorID());
            preparedStatement.setString(2, author.getAuthorName());

            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("Record created successfully.");
            } else {
                System.out.println("Insert operation failed...");
            }
        }
    }

    public void insertOrderAndUpdateStock(Orders order) throws SQLException {
        Connection connection = null;
        try {
            connection = connectDatabase.getConnection();
            connection.setAutoCommit(false);

            try (PreparedStatement insertOrderStatement = connection.prepareStatement(QueryUtil.insertOrdersQuery())) {
                insertOrderStatement.setInt(1, order.getOrderID());
                insertOrderStatement.setString(2, order.getOrderDate());
                insertOrderStatement.setInt(3, order.getQuantityOrder());
                insertOrderStatement.setInt(4, order.getBookIDOrder());
                int rowsOrder = insertOrderStatement.executeUpdate();

                if (rowsOrder <= 0) {
                    throw new SQLException("Insert operation for order failed.");
                }

                try (PreparedStatement updateStockStatement = connection
                        .prepareStatement(QueryUtil.updateBookStockQuery())) {
                    updateStockStatement.setInt(1, order.getQuantityOrder());
                    updateStockStatement.setInt(2, order.getBookIDOrder());
                    int rowsStock = updateStockStatement.executeUpdate();

                    if (rowsStock <= 0) {
                        throw new SQLException("Update operation for stock failed.");
                    }

                    connection.commit();
                    System.out.println("Transaction committed successfully.");
                }
            }
        } catch (SQLException e) {
            if (connection != null) {
                connection.rollback();
            }
            System.out.println("Transaction rolled back.");
            throw new SQLException("Transaction failed: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.setAutoCommit(true);
                connection.close();
            }
        }
    }

    public void insertCustomers(Customers customer) throws SQLException {
        try (Connection connection = connectDatabase.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.insertCustomersQuery());) {
            preparedStatement.setInt(1, customer.getCustomerID());
            preparedStatement.setString(2, customer.getCustomerName());
            preparedStatement.setString(3, customer.getAddress());
            preparedStatement.setInt(4, customer.getPhoneNumber());

            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("Record created successfully.");
            } else {
                System.out.println("Insert operation failed...");
            }
        }
    }

    // -----------------------------------Select-----------------------------------

    public void getAllBooks() throws SQLException {
        try (Connection connection = connectDatabase.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(QueryUtil.selectAllBookQuery());) {
            while (resultSet.next()) {
                printBook(new Books(resultSet.getInt("bookID"),
                        resultSet.getString("title"),
                        resultSet.getInt("stock"),
                        resultSet.getInt("authorIDBooks")));
            }
        }
    }

    private void printBook(Books book) {
        System.out.println("Book ID: " + book.getBookID());
        System.out.println("Book Title: " + book.getTitle());
        System.out.println("Book Stock Info: " + book.getStock());
        System.out.println("Author ID: " + book.getAuthorIDBooks());
        System.out.println("---------------------------------------------");
    }

    public void getAllAuthors() throws SQLException {
        try (Connection connection = connectDatabase.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(QueryUtil.selectAllAuthorQuery());) {
            while (resultSet.next()) {
                printAuthor(new Authors(resultSet.getInt("authorID"),
                        resultSet.getString("authorName")));
            }
        }
    }

    private void printAuthor(Authors author) {
        System.out.println("Author ID: " + author.getAuthorID());
        System.out.println("Author Name: " + author.getAuthorName());
        System.out.println("---------------------------------------------");
    }

    public void getAllOrders() throws SQLException {
        try (Connection connection = connectDatabase.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(QueryUtil.selectAllOrderQuery());) {
            while (resultSet.next()) {
                printOrder(new Orders(resultSet.getInt("orderID"),
                        resultSet.getString("orderDate"),
                        resultSet.getInt("quantityOrder"),
                        resultSet.getInt("bookIDOrders")));
            }
        }
    }

    private void printOrder(Orders order) {
        System.out.println("Order ID: " + order.getOrderID());
        System.out.println("Order Date: " + order.getOrderDate());
        System.out.println("Order Quantity: " + order.getQuantityOrder());
        System.out.println("---------------------------------------------");
    }

    public void getAllCustomers() throws SQLException {
        try (Connection connection = connectDatabase.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(QueryUtil.selectAllCustomerQuery());) {
            while (resultSet.next()) {
                printCustomer(new Customers(resultSet.getInt("customerID"),
                        resultSet.getString("customerName"),
                        resultSet.getString("address"),
                        resultSet.getInt("phoneNumber")));
            }
        }
    }

    private void printCustomer(Customers customers) {
        System.out.println("Order ID: " + customers.getCustomerID());
        System.out.println("Order Date: " + customers.getCustomerName());
        System.out.println("Order Date: " + customers.getAddress());
        System.out.println("Order Quantity: " + customers.getPhoneNumber());
        System.out.println("---------------------------------------------");
    }

    // -----------------------------------Delete-----------------------------------

    public void deleteBookById(int bookID) throws SQLException {
        try (Connection connection = connectDatabase.getConnection();
                Statement statement = connection.createStatement();) {
            int rows = statement.executeUpdate(QueryUtil.deleteBookByIdQuery(bookID));

            if (rows > 0) {
                System.out.println("Record deleted.");
            } else {
                System.out.println("Something went wrong.");
            }
        }
    }

    public boolean getBookById(int id) throws SQLException {
        boolean isFound = false;
        try (Connection connection = connectDatabase.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(QueryUtil.selectBookById(id));) {
            if (resultSet.next()) {
                isFound = true;
                printBook(new Books(resultSet.getInt("bookID"),
                        resultSet.getString("title"),
                        resultSet.getInt("stock"),
                        resultSet.getInt("authorIDBooks")));
            } else {
                System.out.println("Record not found for ID = " + id);
            }
        }
        return isFound;
    }

    // -----------------------------------Update-----------------------------------

    public void updateBook(Books book) throws SQLException {
        try (Connection connection = connectDatabase.getConnection();
                PreparedStatement preparedStatement = connection
                        .prepareStatement(QueryUtil.updateBookQuery(book.getBookID()));) {
            preparedStatement.setInt(1, book.getBookID());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setInt(3, book.getStock());
            preparedStatement.setInt(4, book.getAuthorIDBooks());

            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("Record updated.");
            } else {
                System.out.println("Something went wrong.");
            }
        }
    }

    // -----------------------------------Metadata-----------------------------------

    public void displayTableInfo() {
        try (Connection connection = connectDatabase.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet resultSet = metaData.getTables(null, null, "%", null);

            while (resultSet.next()) {
                System.out.println("Table Name: " + resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayColumnInfo(String tableName) {
        try (Connection connection = connectDatabase.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet resultSet = metaData.getColumns(null, null, tableName, "%");

            while (resultSet.next()) {
                System.out.println("Column Name: " + resultSet.getString("COLUMN_NAME"));
                System.out.println("Data Type: " + resultSet.getString("TYPE_NAME"));
                System.out.println("---------------------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayPrimaryKeys(String tableName) {
        try (Connection connection = connectDatabase.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet resultSet = metaData.getPrimaryKeys(null, null, tableName);

            while (resultSet.next()) {
                System.out.println("Primary Key: " + resultSet.getString("COLUMN_NAME"));
                System.out.println("---------------------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayForeignKeys(String tableName) {
        try (Connection connection = connectDatabase.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet resultSet = metaData.getImportedKeys(null, null, tableName);

            while (resultSet.next()) {
                System.out.println("Foreign Key: " + resultSet.getString("FKCOLUMN_NAME"));
                System.out.println("Referenced Table: " + resultSet.getString("PKTABLE_NAME"));
                System.out.println("Referenced Column: " + resultSet.getString("PKCOLUMN_NAME"));
                System.out.println("---------------------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}