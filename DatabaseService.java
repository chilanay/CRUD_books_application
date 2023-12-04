import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tables.Books;

public class DatabaseService {
    ConnectToDatabase connectDatabase = new ConnectToDatabase();

    public void insertBooks(Books book) throws SQLException {
        try (Connection connection = connectDatabase.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.insertBookQuery());) {
            preparedStatement.setInt(1, book.getBookID());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setInt(3, book.getStock());

            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("Record created successfully.");
            } else {
                System.out.println("Insert operation failed...");
            }
        }
    }

    public void getAllBooks() throws SQLException {
        try (Connection connection = connectDatabase.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(QueryUtil.selectAllBookQuery());) {
            while (resultSet.next()) {
                printBook(new Books(resultSet.getInt("bookID"),
                        resultSet.getString("title"),
                        resultSet.getInt("stock")));
            }
        }
    }

    private void printBook(Books book) {
        System.out.println("Book ID: " + book.getBookID());
        System.out.println("Book Title: " + book.getTitle());
        System.out.println("Book Stock Info: " + book.getStock());
        System.out.println("---------------------------------------------");
    }

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
                        resultSet.getInt("stock")));
            } else {
                System.out.println("Record not found for ID = " + id);
            }
        }
        return isFound;
    }

    public void updateBook(Books book) throws SQLException {
        try (Connection connection = connectDatabase.getConnection();
                PreparedStatement preparedStatement = connection
                        .prepareStatement(QueryUtil.updateBookQuery(book.getBookID()));) {
            preparedStatement.setInt(1, book.getBookID());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setInt(3, book.getStock());

            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("Record updated.");
            } else {
                System.out.println("Something went wrong.");
            }
        }
    }
}
