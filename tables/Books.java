package tables;

// The Books class represents information about books.
public class Books {
    
    // Private instance variables to store information about each book.
    private int bookID;            // Unique identifier for each book.
    private String title;          // Title of the book.
    private int stock;             // Number of copies in stock.
    private int authorIDBooks;     // Identifier of the author associated with the book.

    // Constructor for creating a new Books object with provided details.
    public Books(int bookID, String title, int stock, int authorIDBooks) {
        // Assign values to the instance variables using the provided parameters.
        this.bookID = bookID;
        this.title = title;
        this.stock = stock;
        this.authorIDBooks = authorIDBooks;
    }

    // Getter method to retrieve the book's unique identifier (bookID).
    public int getBookID() {
        return this.bookID;
    }

    // Getter method to retrieve the book's title.
    public String getTitle() {
        return this.title;
    }

    // Getter method to retrieve the current stock of the book.
    public int getStock() {
        return this.stock;
    }

    // Getter method to retrieve the identifier of the author associated with the book.
    public int getAuthorIDBooks() {
        return this.authorIDBooks;
    }
}

