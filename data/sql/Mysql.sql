create DATABASE db_user;
use db_user;
create TABLE usertable(
	id int(10) auto_increment PRIMARY KEY,
	username VARCHAR(50) not NULL,
	password VARCHAR(20) not NULL,
	email VARCHAR(20) not NULL,
	gender VARCHAR(10) not NULL,
	birthday date
);