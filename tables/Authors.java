package tables;

public class Authors {
    int authorID;
    String authorName;

    public Authors(int authorID, String authorName) {
        super();
        this.authorID = authorID;
        this.authorName = authorName;
    }

    public int getAuthorID() {
        return this.authorID;
    }

    public String getAuthorName() {
        return this.authorName;
    }
}
