CREATE DATABASE minions;
USE minions;

CREATE TABLE minions (
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
age INT NOT NULL
);
CREATE TABLE towns (
towns_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL
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
height DOUBLE (10,2),
weight DOUBLE (10,2),
gender CHAR(1),
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
username VARCHAR(30),
`password` VARCHAR(30),
profile_picture BLOB(900),
last_login_time TIME,
is_deleted BOOLEAN
);

INSERT INTO users
VALUES
(1, 'Gosho', 'klklk', NULL, NULL, true),
(2, 'Gosho','klklk', NULL, NULL, false),
(3, 'Gosho','klklk', NULL, NULL, true),
(4, 'Gosho','klklk', NULL, NULL, true),
(5, 'Gosho','klklk', NULL, NULL, true);
SELECT * FROM users;

CREATE DATABASE softu_uni;
CREATE DATABASE soft_uni;
USE soft_uni;

CREATE TABLE towns (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45)
);
CREATE TABLE addresses (
id INT PRIMARY KEY AUTO_INCREMENT,
address_text VARCHAR(45),
town_id INT,
CONSTRAINT fk_addresses_towns
FOREIGN KEY (town_id)
REFERENCES towns(id)
);

CREATE TABLE departments (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45)
);

CREATE TABLE employees (
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(45),
middle_name VARCHAR(45),
last_name VARCHAR(45),
job_title VARCHAR(45),
department_id INT,
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

SELECT * FROM towns
ORDER BY `name`;
SELECT * FROM departments
ORDER BY `name`;
SELECT * FROM employees
ORDER BY `salary` DESC;