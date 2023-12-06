package tables;

// The Authors class represents information about authors.
public class Authors {

    // Instance variables to store information about each author.
    int authorID;         // Unique identifier for each author.
    String authorName;    // Name of the author.

    // Constructor for creating a new Authors object with provided details.
    public Authors(int authorID, String authorName) {
        // Call the superclass constructor (not necessary in this case as Authors doesn't extend another class).
        super();
        // Assign values to the instance variables using the provided parameters.
        this.authorID = authorID;
        this.authorName = authorName;
    }

    // Getter method to retrieve the author's unique identifier (authorID).
    public int getAuthorID() {
        return this.authorID;
    }

    // Getter method to retrieve the author's name.
    public String getAuthorName() {
        return this.authorName;
    }
}
