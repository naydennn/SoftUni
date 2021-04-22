CREATE DATABASE `TEST`;
CREATE DATABASE `gamebar`;
USE gamebar;
CREATE TABLE employees (
id INT PRIMARY KEY  NOT NULL AUTO_INCREMENT,
first_name VARCHAR(45) NOT NULL,
last_name VARCHAR(45) NOT NULL
);
CREATE TABLE categories(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL
);
DROP TABLE products;
CREATE TABLE products(  
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
category_id INT NOT NULL,
CONSTRAINT fk_categories_products
FOREIGN KEY (category_id)
REFERENCES categories(id)
);

Use gamebar;
INSERT INTO `employees` (first_name, last_name)
VALUES
('Test1', 'Test'),
('Test2', 'Test'),
('Test3', 'Test');
ALTER TABLE employees
ADD COLUMN middle_name VARCHAR(45) NOT NULL;

ALTER TABLE employees
MODIFY middle_name VARCHAR(100);