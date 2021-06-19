CREATE DATABASE softuni_stores_system;
USE softuni_stores_system;

CREATE TABLE pictures (
id INT PRIMARY KEY AUTO_INCREMENT,
url VARCHAR(100) NOT NULL,
added_on DATETIME NOT NULL
);

CREATE TABLE categories (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE products (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL UNIQUE,
best_before DATE,
price DECIMAL(10,2) NOT NULL,
`description` TEXT,
category_id INT,
CONSTRAINT fk_products_categories
FOREIGN KEY (category_id)
REFERENCES categories (id),
picture_id INT,
CONSTRAINT fk_products_pictures
FOREIGN KEY (picture_id)
REFERENCES pictures (id)
);

CREATE TABLE towns (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE addresses (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR (50) NOT NULL UNIQUE,
town_id INT,
CONSTRAINT fk_addresses_towns
FOREIGN KEY (town_id)
REFERENCES towns (id)
);

CREATE TABLE stores(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR (20) NOT NULL UNIQUE,
rating FLOAT NOT NULL,
has_parking BOOLEAN DEFAULT FALSE,
address_id INT,
CONSTRAINT fk_stores_addresses
FOREIGN KEY (address_id)
REFERENCES addresses (id)
);

CREATE TABLE products_stores (
product_id INT,
store_id INT,
CONSTRAINT fk_products_stores_products_stores
PRIMARY KEY (product_id, store_id),
CONSTRAINT fk_products_stores_products
FOREIGN KEY (product_id)
REFERENCES products (id),
CONSTRAINT fk_products_storres_stores
FOREIGN KEY (store_id)
REFERENCES stores (id)
);

CREATE TABLE employees (
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(15) NOT NULL,
middle_name CHAR(1),
last_name VARCHAR(20) NOT NULL,
salary DECIMAL(19,2) DEFAULT 0,
hire_date DATE NOT NULL,
manager_id INT,
CONSTRAINT fk_employees_employees
FOREIGN KEY (manager_id)
REFERENCES employees (id),
store_id INT,
CONSTRAINT fk_employees_stores
FOREIGN KEY (store_id)
REFERENCES stores (id)
);

INSERT INTO products_stores 
SELECT id, 1 FROM products
WHERE id NOT IN (SELECT product_id FROM products_stores);

UPDATE employees 
SET manager_id = 3
WHERE YEAR(hire_date) > 2003 AND store_id NOT IN (14,5);

DELETE FROM employees
WHERE salary >= 6000 AND manager_id IS NOT NULL;

SELECT first_name, middle_name, last_name, salary, hire_date 
FROM employees
ORDER BY hire_date DESC;

SELECT p.`name`, p.price, p.best_before, CONCAT(LEFT(p.`description`,10) , '...') AS short_description, pi.url
FROM products AS p
JOIN pictures AS pi
ON p.picture_id = pi.id
WHERE CHAR_LENGTH(`description`) > 100 AND YEAR(pi.added_on) < 2019
AND p.price > 20
ORDER BY p.price DESC;

SELECT s.`name`, COUNT(p.id) AS `count`, ROUND(AVG(p.price), 2) AS `avg` 
FROM products AS p
RIGHT JOIN products_stores AS ps
ON p.id = ps.product_id
RIGHT JOIN stores AS s
ON ps.store_id = s.id
GROUP BY s.`name`
ORDER BY count DESC , `avg` DESC, s.id;