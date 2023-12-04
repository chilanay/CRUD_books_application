public class QueryUtil {
    public static String insertBookQuery() {
        return "INSERT INTO books (bookID, title, stock) VALUES (?, ?,?)";
    }

    public static String selectAllBookQuery() {
        return "SELECT * FROM books";
    }

    public static String deleteBookByIdQuery(int bookID) {
        return "DELETE FROM books WHERE bookID = " + bookID;
    }

    public static String selectBookById(int bookID) {
        return "SELECT * FROM books WHERE bookID = " + bookID;
    }

    public static String updateBookQuery(int bookID) {
        return "UPDATE books SET bookID = ?, title = ?, stock = ? WHERE bookID = " + bookID;
    }
}
