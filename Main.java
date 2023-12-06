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
                        String[] bookInput = scanner.nextLine().split(",");
                        int bookID = Integer.parseInt(bookInput[0]);
                        String title = bookInput[1].trim();
                        int stock = Integer.parseInt(bookInput[2].trim());
                        databaseService.insertBooks(new Books(bookID, title, stock));
                        break;
                     case 2:
                        System.out.println("Enter AuthorID, Author Name");
                        String[] authorInput = scanner.nextLine().split(",");
                        int authorID = Integer.parseInt(authorInput[0]);
                        String authorName = authorInput[1].trim();
                        databaseService.insertAuthors(new Authors(authorID, authorName));
                        break;
                     case 3:
                        System.out.println("Enter OrderID, OrderDate, OrderQuantity");
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
                     System.out.println("Enter title, stock:");
                     Books book = new Books(updateId, scanner.nextLine(), Integer.parseInt(scanner.nextLine()));
                     databaseService.updateBook(book);
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