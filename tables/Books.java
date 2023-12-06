package tables;

public class Books {
    private int bookID;
    private String title;
    private int stock;
    private int authorIDBooks;

    public Books(int bookID, String title, int stock, int authorIDBooks) {
        this.bookID = bookID;
        this.title = title;
        this.stock = stock;
        this.authorIDBooks = authorIDBooks;
    }

    public int getBookID() {
        return this.bookID;
    }

    public String getTitle() {
        return this.title;
    }

    public int getStock() {
        return this.stock;
    }

    public int getAuthorIDBooks() {
        return this.authorIDBooks;
    }
}
