import java.sql.Date;
import java.text.SimpleDateFormat;
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
            System.out.println("2. Select all");
            System.out.println("3. Delete employee");
            System.out.println("4. Update employee");
            System.out.println("Exit (5)");

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
                        System.out.println("Enter ID, title, stock");
                        int bookID = Integer.parseInt(scanner.nextLine());
                        String title = scanner.nextLine();
                        int stock = Integer.parseInt(scanner.nextLine());
                        databaseService.insertBooks(new Books(bookID, title, stock));
                        break;
                     case 2:
                        System.out.println("Enter AuthorID, Author Name");
                        int authorID = Integer.parseInt(scanner.nextLine());
                        String authorName = scanner.nextLine();
                        databaseService.insertAuthors(new Authors(authorID, authorName));
                        break;
                     case 3:
                        System.out.println("Enter OrderID, OrderDate, OrderQuantity");
                        int orderID = Integer.parseInt(scanner.nextLine());
                        String orderDate = scanner.nextLine();
                        int quantityOrder = Integer.parseInt(scanner.nextLine());
                        databaseService.insertOrders(new Orders(orderID, orderDate, quantityOrder));
                        break;
                     case 4:
                        System.out.println("Enter CustomerID, Customer Name, Address, Phone Number");
                        int customerID = Integer.parseInt(scanner.nextLine());
                        String customerName = scanner.nextLine();
                        String customerAddress = scanner.nextLine();
                        int phoneNumber = Integer.parseInt(scanner.nextLine());
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
                  System.out.println("Delete from:");
                  System.out.println("1. Books table");
                  System.out.println("2. Authors table");
                  System.out.println("3. Orders table");
                  System.out.println("4. Customers table");

                  int choiceDelete = Integer.parseInt(scanner.nextLine());

                  switch (choiceDelete) {
                     case 1:
                        System.out.println("Enter ID of Book:");
                        databaseService.deleteBookById(Integer.parseInt(scanner.nextLine()));
                        break;
                     case 2:
                        System.out.println("Enter ID of Author:");
                        databaseService.deleteAuthorById(Integer.parseInt(scanner.nextLine()));
                        break;
                     case 3:
                        System.out.println("Enter ID of Order:");
                        databaseService.deleteOrderById(Integer.parseInt(scanner.nextLine()));
                        break;
                     case 4:
                        System.out.println("Enter ID of Customer:");
                        databaseService.deleteCustomerById(Integer.parseInt(scanner.nextLine()));
                        break;
                  }
                  break;
               case 4:
                  System.out.println("Delete from:");
                  System.out.println("1. Books table");
                  System.out.println("2. Authors table");
                  System.out.println("3. Orders table");
                  System.out.println("4. Customers table");

                  int choiceUpdate = Integer.parseInt(scanner.nextLine());

                  switch (choiceUpdate) {
                     case 1:
                        System.out.println("Enter ID of Book:");
                        int updateId = Integer.parseInt(scanner.nextLine());
                        boolean isFound = databaseService.getBookById(updateId);

                        if (isFound) {
                           System.out.println("Enter title, stock:");
                           Books book = new Books(updateId, scanner.nextLine(), Integer.parseInt(scanner.nextLine()));
                           databaseService.updateBook(book);
                        }
                        break;
                     case 2:
                        System.out.println("Enter ID of Author:");
                        int updateIdAuthor = Integer.parseInt(scanner.nextLine());
                        boolean isFoundAuthor = databaseService.getBookById(updateIdAuthor);

                        if (isFoundAuthor) {
                           System.out.println("Enter Author Name:");
                           Authors author = new Authors(updateIdAuthor, scanner.nextLine());
                           databaseService.updateAuthor(author);
                        }
                        break;
                  }
                  break;
               case 5:
                  System.out.println("Thank you. Visit again.");
                  isRunning = false;
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
