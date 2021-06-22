CREATE DATABASE stc;
use stc;

CREATE TABLE addresses (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(100) NOT NULL
);

CREATE TABLE categories (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(10) NOT NULL
);

CREATE TABLE clients (
id INT PRIMARY KEY AUTO_INCREMENT,
full_name VARCHAR(50) NOT NULL,
phone_number VARCHAR(20) NOT NULL
);

CREATE TABLE drivers (
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(30) NOT NULL,
last_name VARCHAR(30) NOT NULL,
age INT NOT NULL,
rating FLOAT DEFAULT 5.5
);

CREATE TABLE cars (
id INT PRIMARY KEY AUTO_INCREMENT,
make VARCHAR(20) NOT NULL,
model VARCHAR(20),
`year` INT NOT NULL DEFAULT 0,
mileage INT DEFAULT 0,
`condition` CHAR(1) NOT NULL,
category_id INT,
CONSTRAINT fk_cars_categories
FOREIGN KEY (category_id)
REFERENCES categories (id)
);

CREATE TABLE courses (
id INT PRIMARY KEY AUTO_INCREMENT,
from_address_id INT NOT NULL,
CONSTRAINT fk_courses_addresses
FOREIGN KEY (from_address_id)
REFERENCES addresses (id),
`start` DATETIME NOT NULL,
bill DECIMAL(10,2) DEFAULT 10,
car_id INT NOT NULL,
CONSTRAINT fk_courses_cars
FOREIGN KEY (car_id)
REFERENCES cars (id),
client_id INT NOT NULL,
CONSTRAINT fk_courses_clients
FOREIGN KEY (client_id)
REFERENCES clients (id)
);

CREATE TABLE cars_drivers (
car_id INT NOT NULL,
driver_id INT NOT NULL,
CONSTRAINT pk_cars_drivers_cars_drivers
PRIMARY KEY (car_id, driver_id),
CONSTRAINT fk_cars_drivers_cars
FOREIGN KEY (car_id)
REFERENCES cars (id),
CONSTRAINT fk_cars_drivers_drivers
FOREIGN KEY (driver_id)
REFERENCES drivers (id)
);

INSERT INTO clients (full_name, phone_number)
(SELECT CONCAT(first_name, ' ', last_name), CONCAT('(088) 9999', id * 2) 
FROM drivers
WHERE id BETWEEN 10 AND 20);

UPDATE `cars`
SET `condition` = 'C'
WHERE `mileage` >= 800000 OR year <= 2010
AND `make` NOT LIKE 'Mercedes-Benz';

SET foreign_key_checks = 0;
DELETE FROM clients
WHERE `id` NOT IN (SELECT `client_id` FROM `courses`) AND CHAR_LENGTH(full_name) > 3;

SELECT `make`, model, `condition` FROM cars
ORDER BY id;

SELECT d.first_name, d.last_name, c.`make` , c.model, c.mileage 
FROM drivers AS d
JOIN cars_drivers AS cd
ON d.id = cd.driver_id
JOIN cars AS c
ON cd.car_id = c.id
WHERE mileage IS NOT NULL
ORDER BY c.mileage DESC, d.first_name;

SELECT c.id, c.make, c.mileage, COUNT(co.id) AS count_of_courses,
ROUND(AVG(co.bill),2) AS avg_bill 
FROM courses AS co
RIGHT JOIN cars AS c
ON co.car_id = c.id
GROUP BY c.id
HAVING count_of_courses != 2
ORDER BY count_of_courses DESC, c.id;

SELECT c.full_name, COUNT(cars.id) AS count_of_cars, SUM(co.bill) AS total_sum
FROM clients AS c
JOIN courses AS co
ON c.id = co.client_id
JOIN cars AS cars
ON co.car_id = cars.id
GROUP BY c.id
HAVING LEFT(full_name,2) like '%a' AND count_of_cars > 1
ORDER BY full_name;

SELECT a.`name` AS `name`, IF(HOUR(cо.`start`) >= 6 AND HOUR(cо.`start`) <= 20, 'Day', 'Night')
 AS day_time, cо.bill AS bill, c.full_name, cars.make, cars.model, cat.`name` AS category_name
FROM addresses AS a
JOIN courses AS cо
ON cо.from_address_id = a.id
JOIN clients AS c
ON c.id = cо.client_id
JOIN cars
ON cо.car_id = cars.id
JOIN categories AS cat
ON cat.id = cars.category_id
GROUP BY cо.id
ORDER BY cо.id;