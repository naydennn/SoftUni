CREATE DATABASE minions;
USE minions;

CREATE TABLE minions (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
age INT
);
CREATE TABLE towns (
town_id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL
);

ALTER TABLE minions
ADD COLUMN town_id INT,
ADD CONSTRAINT fk_minions_towns
FOREIGN KEY (town_id)
REFERENCES towns(id);

INSERT INTO towns
VALUES
(1, 'Sofia'), 
(2, 'Plovdiv'), 
(3, 'Varna');
 
INSERT INTO minions
VALUES
(1, 'Kevin' ,22, 1),
(2, 'Bob' , 15 , 3),
(3, 'Steward', 15 , 2);

TRUNCATE minions;

DROP TABLE minions;
DROP TABLE towns;

CREATE TABLE people (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(200) NOT NULL,
picture BLOB,
height DOUBLE (5 , 2),
weight DOUBLE (5 , 2),
gender CHAR(1) NOT NULL,
birthdate DATE NOT NULL,
biography TEXT
);
 INSERT INTO people
 VALUES
 (1,'Naiden', NULL, 190.00, 88.00, 'm', '2015-12-17', NULL),
 (2,'Ivan', NULL, 190.00, 88.00, 'm', '2003-10-01', NULL),
 (3,'Gosho', NULL, 190.00, 88.00, 'm', '2003-10-01', NULL),
 (4,'Naiden', NULL, 190.00, 88.00, 'm', '2003-10-01', NULL),
 (5,'Naiden', NULL, 190.00, 88.00, 'm', '2003-10-01', NULL);
 
 SELECT * FROM people;

CREATE TABLE users (
id INT PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(30) NOT NULL UNIQUE,
`password` VARCHAR(26) NOT NULL,
profile_picture BLOB(900),
last_login_time DATETIME,
is_deleted BOOLEAN
);

INSERT INTO users
VALUES
(1, 'Gosho1', 'klklk', NULL, NULL, true),
(2, 'Gosho2','klklk', NULL, NULL, false),
(3, 'Gosho3','klklk', NULL, NULL, true),
(4, 'Gosho4','klklk', NULL, NULL, true),
(5, 'Gosho5','klklk', NULL, NULL, true);
SELECT * FROM users;

CREATE DATABASE softu_uni;
CREATE DATABASE soft_uni;
USE soft_uni;

CREATE TABLE towns (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL
);
CREATE TABLE addresses (
id INT PRIMARY KEY AUTO_INCREMENT,
address_text VARCHAR(45) NOT NULL, 
town_id INT NOT NULL,
CONSTRAINT fk_addresses_towns
FOREIGN KEY (town_id)
REFERENCES towns(id)
);

CREATE TABLE departments (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL
);

CREATE TABLE employees (
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(45) NOT NULL ,
middle_name VARCHAR(45) NOT NULL,
last_name VARCHAR(45) NOT NULL,
job_title VARCHAR(45) NOT NULL,
department_id INT NOT NULL,
CONSTRAINT fk_employees_departments
FOREIGN KEY (department_id)
REFERENCES departments(id),
hire_date DATE,
salary DECIMAL(19,2),
address_id INT,
CONSTRAINT fk_employees_addresses
FOREIGN KEY (address_id)
REFERENCES addresses(id)
);

INSERT INTO towns
VALUES
(1,'Sofia'),
(2,'Plovdiv'),
(3,'Varna'),
(4,'Burgas');

INSERT INTO departments
VALUES
(1, 'Engineering'),
(2, 'Sales'),
(3, 'Marketing'),
(4, 'Software Development'),
(5, 'Quality Assurance');

INSERT INTO employees(id, first_name, middle_name, last_name, job_title, department_id,
hire_date, salary)
VALUES
(1, 'Ivan', 'Ivanov', 'Ivanov', '.NET Developer', 4, '2013-02-01', 3500.00),
(2, 'Petar', 'Petrov', 'Petrov', 'Senior Engineer', 1, '2004-03-02', 4000.00),
(3, 'Maria', 'Petrova', 'Ivanova', 'Intern', 5, '2016-08-28', 525.25),
(4, 'Georgi', 'Terziev', 'Ivanov', 'CEO', 2, '2007-12-09', 3000.00),
(5, 'Peter', 'Pan', 'Pan', 'Intern', 3, '2016-08-28', 599.88);

SELECT `name` FROM towns
ORDER BY `name`;
SELECT `name` FROM departments
ORDER BY `name`;
SELECT first_name, last_name, job_title, salary FROM employees
ORDER BY `salary` DESC;

SET SQL_SAFE_UPDATES = 0;

UPDATE employees
SET salary = salary + salary * 0.1;
SELECT salary FROM employees;

CREATE DATABASE car_rental;
USE car_rental;
CREATE TABLE categories(
id INT PRIMARY KEY AUTO_INCREMENT,
category VARCHAR(50) NOT NULL,
daily_rate DOUBLE (4,2), 
weekly_rate DOUBLE (4,2), 
monthly_rate DOUBLE (4,2),
weekend_rate DOUBLE (4,2)
);
CREATE TABLE cars (
id INT PRIMARY KEY AUTO_INCREMENT,
plate_number INT NOT NULL,
make VARCHAR(45) ,
model VARCHAR(45),
car_year YEAR,
category_id INT ,
CONSTRAINT fk_cars_categories
FOREIGN KEY (category_id)
REFERENCES categories(id),
doors INT,
picture BLOB,
car_conditions VARCHAR(45),
available BOOLEAN NOT NULL
);
CREATE TABLE employees (
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(45) NOT NULL,
last_name VARCHAR(45) NOT NULL,
title VARCHAR(45) NOT NULL,
notes TEXT
);
CREATE TABLE customers (
id INT PRIMARY KEY AUTO_INCREMENT,
driver_licence_number INT,
full_name VARCHAR(50),
adress VARCHAR(50),
zip_code INT NOT NULL,
notes TEXT
);

CREATE TABLE `rental_orders` (
`id`INT AUTO_INCREMENT PRIMARY KEY, 
`employee_id` INT NOT NULL, 
`customer_id` INT NOT NULL, 
`car_id` INT NOT NULL, 
`car_condition` VARCHAR(50), 
`tank_level` INT, 
`kilometrage_start` INT, 
`kilometrage_end` INT, 
`total_kilometrage` INT, 
`start_date` DATE, 
`end_date` DATE, 
`total_days` INT, 
`rate_applied` DECIMAL(4,2), 
`tax_rate`DECIMAL(4,2), 
`order_status` VARCHAR(50), 
`notes` TEXT
);

INSERT INTO `categories`(`category`) VALUES
('Category1'),
('Category2'),
('Category3');

INSERT INTO `cars`(`plate_number`,`category_id`, `available`) VALUES
('1',1,true),
('2',2,false),
('3',3,true);

INSERT INTO `employees`(`first_name`,`last_name`, `title`) VALUES
('Ivo','Ivanov','Employee1'),
('Emo','Andonow','Employee2'),
('Emil','Naidennow','Employee3');

INSERT INTO `customers`(`full_name`, `zip_code`) VALUES
('Customer1', 2),
('Customer2', 3),
('Customer3', 4);

INSERT INTO `rental_orders`(`employee_id`,`customer_id`, `car_id`) VALUES
(1,2,3),
(2,3,1),
(3,1,2);

USE `gamebar`;
CREATE TABLE `employees` (
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL
);
CREATE TABLE categories (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL
);
CREATE TABLE `products` (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
category_id INT NOT NULL
);

ALTER TABLE `employees`
ADD COLUMN `middle_name` VARCHAR(50) NOT NULL;

ALTER TABLE `products`
ADD CONSTRAINT fk_categories_products
FOREIGN KEY (category_id)
REFERENCES `categories`(id);
use soft_uni;

SELECT * FROM towns
ORDER BY `name`;

SELECT * FROM departments
ORDER BY `name`;

SELECT * FROM employees
ORDER BY `salary` DESC;

ALTER TABLE users
DROP PRIMARY KEY,
ADD CONSTRAINT pk_users
PRIMARY KEY (id, username);

USE minions;
ALTER TABLE users
CHANGE COLUMN last_login_time last_login_time DATETIME DEFAULT CURRENT_TIMESTAMP; 

INSERT INTO users (username, `password`,profile_picture, is_deleted)
VALUES
( 'Gosho1', 'klklk', NULL, true),
('Gosho2','klklk', NULL, false),
('Gosho3','klklk', NULL, true),
('Gosho4','klklk', NULL, true),
('Gosho5','klklk', NULL, true);
SELECT * FROM users;

CREATE DATABASE `movies`;
USE `movies`;

CREATE TABLE `directors` (
id INT PRIMARY KEY AUTO_INCREMENT,
director_name VARCHAR(50) NOT NULL,
notes TEXT
);
CREATE TABLE genres (
id INT PRIMARY KEY AUTO_INCREMENT,
genre_name VARCHAR(50) NOT NULL,
notes TEXT
);
CREATE TABLE `categories` (
id INT PRIMARY KEY AUTO_INCREMENT,
category_name VARCHAR(50) NOT NULL,
notes TEXT
);
CREATE TABLE `movies` (
id INT PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(50) NOT NULL,
director_id INT,
copyright_year YEAR,
length INT,
genre_id INT,
category_id INT,
rating FLOAT (5,2),
notes TEXT
);

INSERT INTO `categories` (`category_name`) VALUES
('Category1'),
('Category2'),
('Category3'),
('Category4'),
('Category5');

INSERT INTO `genres` (`genre_name`) VALUES
('Genre5'),
('Genre4'),
('Genre3'),
('Genre2'),
('Genre1');

INSERT INTO `movies` (`title`,`director_id`,`length`,`genre_id`,`category_id`) VALUES
('Movie1',1,90,1,5),
('Movie2',3,95,2,4),
('Movie3',4,120,3,3),
('Movie4',5,90,4,2),
('Movie5',2,90,5,1);

DROP SCHEMA test;