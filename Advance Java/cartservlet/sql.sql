show databases;

create database shoppingCart;

use shoppingCart;

show tables;

create table users (
	employeeID int primary key,
    firstName varchar(30),
    lastName varchar(30),
    designation varchar(30),
	contactNumber numeric(10),
	email varchar(255),
	dob date,
	address varchar(100),
	profilePicture mediumtext,
	link varchar(255),
	language varchar(20),
	password varchar(25)
);

create table courses (
	courseID int primary key,
    name varchar(50),
    category varchar(50),
    price varchar(10),
    image varchar(50)
);

create table orders (
	orderID int not null primary key auto_increment,
    courseID int not null,
    employeeID int not null,
    quantity int not null,
    date date not null,
    foreign key (courseID) references courses(CourseID),
    foreign key (employeeID) references users(employeeID)
);

drop table courses; 

drop table orders;

drop table users;

insert into courses values
	(1, "C++", "Programming", "599", "cpp.jpeg"),
    (2, "Java", "Programming", "999", "java.jpeg"),
    (3, "C Programming", "Programming", "399", "c.jpeg"),
    (4, "HTML", "Web Development", "499", "html5.jpeg"),
    (5, "CSS", "Web Development", "399", "css.jpeg"),
    (6, "HTML/CSS", "Web Development", "799", "htmlcss.jpg");
    
    
select * from courses;
select * from users;
select * from users where employeeID = 101;
delete from users;

select * from orders;
delete from orders;
select * from orders where employeeID=123 order by orders.orderID desc;

