CREATE SCHEMA `finance_manager` DEFAULT CHARACTER SET utf8 COLLATE utf8_polish_ci;
use `finance_manager`;

CREATE TABLE income (
	id int AUTO_INCREMENT PRIMARY KEY,
    amount double NOT NULL,
    entry_date date NOT NULL,
    comment_income varchar(100)
);

CREATE TABLE category (
	id int AUTO_INCREMENT PRIMARY KEY,
    category_name varchar(100) NOT NULL
);

CREATE TABLE expense (
	id int AUTO_INCREMENT PRIMARY KEY,
    amount double NOT NULL,
    entry_date DATE NOT NULL,
    comment_expense varchar(100),
    category_id int not null,
    CONSTRAINT `category_fk` FOREIGN KEY(category_id) REFERENCES category(id)
);