public class Books {
    private int bookID;
    private String title;
    private int stock;

    public Books(int bookID, String title, int stock) {
        super();
        this.bookID = bookID;
        this.title = title;
        this.stock = stock;
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

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
