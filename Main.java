import java.util.Scanner;

import tables.Authors;
import tables.Books;
import tables.Customers;
import tables.Orders;

public class Main {
   public static void main(String[] args) {

      DatabaseService databaseService = new DatabaseService();

      try (Scanner scanner = new Scanner(System.in);) {
         boolean isRunning = true;
         while (isRunning) {
            System.out.println("Enter choice");
            System.out.println("1. Insert");
            System.out.println("2. Select");
            System.out.println("3. Delete Book");
            System.out.println("4. Update Book");
            System.out.println("Exit (5)");
            System.out.println("Access Metadata (6)");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
               case 1:
                  System.out.println("Insert into:");
                  System.out.println("1. Books table");
                  System.out.println("2. Authors table");
                  System.out.println("3. Orders table");
                  System.out.println("4. Customers table");

                  int choiceInsert = Integer.parseInt(scanner.nextLine());

                  switch (choiceInsert) {
                     case 1:
                        System.out.println("Enter ID, Title, Stock, Author ID");
                        String[] bookInput = scanner.nextLine().split(",");
                        int bookID = Integer.parseInt(bookInput[0]);
                        String title = bookInput[1].trim();
                        int stock = Integer.parseInt(bookInput[2].trim());
                        int authodIDBooks = Integer.parseInt(bookInput[3].trim());

                        databaseService.insertBooks(new Books(bookID, title, stock, authodIDBooks));
                        break;
                     case 2:
                        System.out.println("Enter AuthorID, Author Name");
                        String[] authorInput = scanner.nextLine().split(",");
                        int authorID = Integer.parseInt(authorInput[0]);
                        String authorName = authorInput[1].trim();
                        databaseService.insertAuthors(new Authors(authorID, authorName));
                        break;
                     case 3:
                        System.out.println("Enter OrderID, OrderDate, OrderQuantity, BookID");
                        String[] orderInput = scanner.nextLine().split(",");
                        int orderID = Integer.parseInt(orderInput[0]);
                        String orderDate = orderInput[1].trim();
                        int quantityOrder = Integer.parseInt(orderInput[2].trim());
                        int bookIDOrders = Integer.parseInt(orderInput[3].trim());
                        databaseService
                              .insertOrderAndUpdateStock(new Orders(orderID, orderDate, quantityOrder, bookIDOrders));
                        break;
                     case 4:
                        System.out.println("Enter CustomerID, Customer Name, Address, Phone Number");
                        String[] customerInput = scanner.nextLine().split(",");
                        int customerID = Integer.parseInt(customerInput[0]);
                        String customerName = customerInput[1].trim();
                        String customerAddress = customerInput[2].trim();
                        int phoneNumber = Integer.parseInt(customerInput[3]);
                        databaseService
                              .insertCustomers(new Customers(customerID, customerName, customerAddress, phoneNumber));
                        break;
                  }
                  break;
               case 2:
                  System.out.println("Select from:");
                  System.out.println("1. Books table");
                  System.out.println("2. Authors table");
                  System.out.println("3. Orders table");
                  System.out.println("4. Customers table");

                  int choiceSelect = Integer.parseInt(scanner.nextLine());
                  switch (choiceSelect) {
                     case 1:
                        databaseService.getAllBooks();
                        break;
                     case 2:
                        databaseService.getAllAuthors();
                        break;
                     case 3:
                        databaseService.getAllOrders();
                        break;
                     case 4:
                        databaseService.getAllCustomers();
                        break;
                  }
                  break;
               case 3:
                  System.out.println("Enter ID of book:");
                  databaseService.deleteBookById(Integer.parseInt(scanner.nextLine()));
                  break;
               case 4:
                  System.out.println("Enter ID of book:");
                  int updateId = Integer.parseInt(scanner.nextLine());
                  boolean isFound = databaseService.getBookById(updateId);

                  if (isFound) {
                     System.out.println("Enter Title, Stock, Author ID:");

                     String title = scanner.nextLine();
                     String stockStr = scanner.nextLine();
                     String authorStr = scanner.nextLine();

                     if (!title.trim().isEmpty() && !stockStr.trim().isEmpty() && !authorStr.trim().isEmpty()) {
                        Books book = new Books(updateId, title, Integer.parseInt(stockStr),
                              Integer.parseInt(authorStr));
                        databaseService.updateBook(book);
                     } else {
                        System.out.println("Invalid input. Title, Stock, and Author cannot be empty.");
                     }
                  }
                  break;
               case 5:
                  System.out.println("Thank you. Visit again.");
                  isRunning = false;
                  break;

               case 6:
                  System.out.println("Metadata Options:");
                  System.out.println("1. Display Table Names");
                  System.out.println("2. Display Column Info for a Table");
                  System.out.println("3. Display Primary Keys for a Table");
                  System.out.println("4. Display Foreign Keys for a Table");
                  int metadataOption = Integer.parseInt(scanner.nextLine());

                  switch (metadataOption) {
                     case 1:
                        databaseService.displayTableInfo();
                        break;
                     case 2:
                        System.out.println("Enter Table Name:");
                        String tableName = scanner.nextLine();
                        databaseService.displayColumnInfo(tableName);
                        break;
                     case 3:
                        System.out.println("Enter Table Name:");
                        tableName = scanner.nextLine();
                        databaseService.displayPrimaryKeys(tableName);
                        break;
                     case 4:
                        System.out.println("Enter Table Name:");
                        tableName = scanner.nextLine();
                        databaseService.displayForeignKeys(tableName);
                        break;
                  }
                  break;
               default:
                  break;
            }

         }
      } catch (Exception e) {
         throw new RuntimeException("Something went wrong " + e);
      }
   }
}