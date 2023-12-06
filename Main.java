// The Main class contains the main method for executing the application.
import java.util.Scanner;
import tables.Authors;
import tables.Books;
import tables.Customers;
import tables.Orders;

public class Main {

   public static void main(String[] args) {

      // Creating an instance of the DatabaseService class to interact with the database.
      DatabaseService databaseService = new DatabaseService();

      // Using try-with-resources to automatically close the Scanner.
      try (Scanner scanner = new Scanner(System.in);) {
         boolean isRunning = true;

         // Main loop for the interactive menu.
         while (isRunning) {
            // Displaying the main menu options.
            System.out.println("Enter choice");
            System.out.println("1. Insert");
            System.out.println("2. Select");
            System.out.println("3. Delete Book");
            System.out.println("4. Update Book");
            System.out.println("Exit (5)");
            System.out.println("Access Metadata (6)");

            // Reading the user's choice.
            int choice = Integer.parseInt(scanner.nextLine());

            // Switching based on the user's choice.
            switch (choice) {
               // ----------------------- Insert Operations -----------------------
               case 1:
                  System.out.println("Insert into:");
                  System.out.println("1. Books table");
                  System.out.println("2. Authors table");
                  System.out.println("3. Orders table");
                  System.out.println("4. Customers table");

                  // Reading user's choice for insert operation.
                  int choiceInsert = Integer.parseInt(scanner.nextLine());

                  // Switching based on the user's choice for insert operation.
                  switch (choiceInsert) {
                     case 1:
                        // Reading input for a new book.
                        System.out.println("Enter ID, Title, Stock, Author ID");
                        String[] bookInput = scanner.nextLine().split(",");
                        int bookID = Integer.parseInt(bookInput[0]);
                        String title = bookInput[1].trim();
                        int stock = Integer.parseInt(bookInput[2].trim());
                        int authorIDBooks = Integer.parseInt(bookInput[3].trim());

                        // Inserting the new book into the database.
                        databaseService.insertBooks(new Books(bookID, title, stock, authorIDBooks));
                        break;
                     case 2:
                        // Reading input for a new author.
                        System.out.println("Enter AuthorID, Author Name");
                        String[] authorInput = scanner.nextLine().split(",");
                        int authorID = Integer.parseInt(authorInput[0]);
                        String authorName = authorInput[1].trim();

                        // Inserting the new author into the database.
                        databaseService.insertAuthors(new Authors(authorID, authorName));
                        break;
                     case 3:
                        // Reading input for a new order.
                        System.out.println("Enter OrderID, OrderDate, OrderQuantity, BookID");
                        String[] orderInput = scanner.nextLine().split(",");
                        int orderID = Integer.parseInt(orderInput[0]);
                        String orderDate = orderInput[1].trim();
                        int quantityOrder = Integer.parseInt(orderInput[2].trim());
                        int bookIDOrders = Integer.parseInt(orderInput[3].trim());

                        // Inserting the new order and updating stock in the database.
                        databaseService.insertOrderAndUpdateStock(new Orders(orderID, orderDate, quantityOrder,
                              bookIDOrders));
                        break;
                     case 4:
                        // Reading input for a new customer.
                        System.out.println("Enter CustomerID, Customer Name, Address, Phone Number");
                        String[] customerInput = scanner.nextLine().split(",");
                        int customerID = Integer.parseInt(customerInput[0]);
                        String customerName = customerInput[1].trim();
                        String customerAddress = customerInput[2].trim();
                        int phoneNumber = Integer.parseInt(customerInput[3]);

                        // Inserting the new customer into the database.
                        databaseService.insertCustomers(
                              new Customers(customerID, customerName, customerAddress, phoneNumber));
                        break;
                  }
                  break;

               // ----------------------- Select Operations -----------------------
               case 2:
                  System.out.println("Select from:");
                  System.out.println("1. Books table");
                  System.out.println("2. Authors table");
                  System.out.println("3. Orders table");
                  System.out.println("4. Customers table");

                  // Reading user's choice for select operation.
                  int choiceSelect = Integer.parseInt(scanner.nextLine());

                  // Switching based on the user's choice for select operation.
                  switch (choiceSelect) {
                     case 1:
                        // Displaying all books.
                        databaseService.getAllBooks();
                        break;
                     case 2:
                        // Displaying all authors.
                        databaseService.getAllAuthors();
                        break;
                     case 3:
                        // Displaying all orders.
                        databaseService.getAllOrders();
                        break;
                     case 4:
                        // Displaying all customers.
                        databaseService.getAllCustomers();
                        break;
                  }
                  break;

               // ----------------------- Delete Operation -----------------------
               case 3:
                  // Reading input for deleting a book by its ID.
                  System.out.println("Enter ID of book:");
                  databaseService.deleteBookById(Integer.parseInt(scanner.nextLine()));
                  break;

               // ----------------------- Update Operation -----------------------
               case 4:
                  // Reading input for updating a book by its ID.
                  System.out.println("Enter ID of book:");
                  int updateId = Integer.parseInt(scanner.nextLine());

                  // Checking if the book with the given ID exists.
                  boolean isFound = databaseService.getBookById(updateId);

                  if (isFound) {
                     System.out.println("Enter Title, Stock, Author ID:");

                     // Reading updated information for the book.
                     String title = scanner.nextLine();
                     String stockStr = scanner.nextLine();
                     String authorStr = scanner.nextLine();

                     // Validating and updating the book information.
                     if (!title.trim().isEmpty() && !stockStr.trim().isEmpty() && !authorStr.trim().isEmpty()) {
                        Books book = new Books(updateId, title, Integer.parseInt(stockStr),
                              Integer.parseInt(authorStr));
                        databaseService.updateBook(book);
                     } else {
                        System.out.println("Invalid input. Title, Stock, and Author cannot be empty.");
                     }
                  }
                  break;

               // ----------------------- Exit -----------------------
               case 5:
                  // Exiting the application.
                  System.out.println("Thank you. Visit again.");
                  isRunning = false;
                  break;

               // ----------------------- Metadata Operations -----------------------
               case 6:
                  // Displaying metadata options.
                  System.out.println("Metadata Options:");
                  System.out.println("1. Display Table Names");
                  System.out.println("2. Display Column Info for a Table");
                  System.out.println("3. Display Primary Keys for a Table");
                  System.out.println("4. Display Foreign Keys for a Table");
                  int metadataOption = Integer.parseInt(scanner.nextLine());

                  // Switching based on the user's choice for metadata operations.
                  switch (metadataOption) {
                     case 1:
                        // Displaying table names.
                        databaseService.displayTableInfo();
                        break;
                     case 2:
                        // Reading the table name and displaying column information.
                        System.out.println("Enter Table Name:");
                        String tableName = scanner.nextLine();
                        databaseService.displayColumnInfo(tableName);
                        break;
                     case 3:
                        // Reading the table name and displaying primary keys.
                        System.out.println("Enter Table Name:");
                        tableName = scanner.nextLine();
                        databaseService.displayPrimaryKeys(tableName);
                        break;
                     case 4:
                        // Reading the table name and displaying foreign keys.
                        System.out.println("Enter Table Name:");
                        tableName = scanner.nextLine();
                        databaseService.displayForeignKeys(tableName);
                        break;
                  }
                  break;

               // ----------------------- Default Case -----------------------
               default:
                  // No action for invalid choices.
                  break;
            }
         }

      } catch (Exception e) {
         // Handling exceptions and throwing a runtime exception with a message.
         throw new RuntimeException("Something went wrong " + e);
      }
   }
}
