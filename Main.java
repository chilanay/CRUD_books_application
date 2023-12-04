import java.util.Scanner;

import tables.Books;

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
            System.out.println("Exit");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
               case 1:
                  System.out.println("Enter ID, title, stock");
                  int bookID = Integer.parseInt(scanner.nextLine());
                  String title = scanner.nextLine();
                  int stock = Integer.parseInt(scanner.nextLine());
                  databaseService.insertBooks(new Books(bookID, title, stock));
                  break;
               case 2:
                  databaseService.getAllBooks();
                  break;
               case 3:
                  System.out.println("Enter ID of book:");
                  databaseService.deleteBookById(Integer.parseInt(scanner.nextLine()));
                  break;
               case 4:
                  System.out.println("Enter ID of book:");
                  int updateId = Integer.parseInt(scanner.nextLine());
                  boolean isFound = databaseService.getBookById(updateId);

                  if(isFound){
                     System.out.println("Enter ID, title, stock:");
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
