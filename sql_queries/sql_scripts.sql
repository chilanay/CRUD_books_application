create table authors 
(
	authorID int primary key,
	authorName varchar(15)
);

create table books 
(
	bookID int primary key,
	title varchar(15),
	stock int,
	authorID int,
	foreign key (AuthorID) references Authors(AuthorID)
);

create table customers 
(
	customerID int primary key,
	customerName varchar(15),
	address varchar (50),
	phoneNumber int
);

create table orders 
(
	orderID int primary key,
	customerID int,
	orderDate varchar(50),
	bookIDOrders int,
	quantityOrder int,
	foreign key (CustomerID) references Customers(CustomerID),
	foreign key (BookIDOrders) references Books(BookID)
);