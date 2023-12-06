# Library Management System

The Library Management System is a Java application that allows users to manage books, authors, orders, and customers in a library database.

## Prerequisites

Before running the application, ensure you have the following installed:

- Java Development Kit (JDK)
- MySQL Database Server
- Maven (for building the project)

## Setup

1. **Database Setup:**
   - Create a MySQL database and execute the SQL script provided in the `database.sql` file to set up the necessary tables.
   
2. **Configuration:**
   - Open the `src/main/resources/application.properties` file.
   - Update the database connection properties such as `spring.datasource.url`, `spring.datasource.username`, and `spring.datasource.password` to match your MySQL database configuration.

3. **Build the Project:**
   - Open a terminal and navigate to the project root directory.
   - Run the following Maven command to build the project:
     ```bash
     mvn clean install
     ```

## Running the Application

1. **Run the Application:**
   - After successfully building the project, run the following command to start the application:
     ```bash
     java -jar target/library-management-system.jar
     ```

2. **Using the Application:**
   - Once the application is running, follow the on-screen prompts to interact with the system.
   - Use options such as insert, select, delete, update, and access metadata to perform various operations.

## Exiting the Application

To exit the application, choose the "Exit (5)" option from the main menu.

## Additional Notes

- The application includes metadata options for displaying table names, column info, primary keys, and foreign keys. Use these options to explore the database structure.

## Troubleshooting

- If you encounter any issues during setup or execution, ensure that the prerequisites are correctly installed and the database configuration is accurate.

