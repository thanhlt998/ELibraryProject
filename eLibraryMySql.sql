use elibrary;
drop table if exists e_book;
create table e_book(
	callNo varchar(200) not null, 
	name varchar(200), 
	author varchar(200), 
	publisher varchar(200), 
	quantity integer, 
	issued integer, 
	constraint e_book_pk primary key(callNo)
   );
   
drop table if exists e_librarian;
create table  e_librarian 
   (id integer,
	username varchar(20) not null,
	name varchar(200), 
	password varchar(200), 
	email varchar(200), 
	mobile varchar(11), 
	 constraint e_librarian_pk primary key (username)
   );
-- note: id must be generated through sequence in e_librarian table.

drop table if exists e_issuebook;
create table  e_issuebook 
   (callNo varchar(200) not null, 
	studentId varchar(200) not null, 
	studentName varchar(200), 
	studentMobile varchar(11), 
	issuedDate date, 
	returnStatus varchar(200),
    foreign key (callNo) references e_book(callNo)
   );


