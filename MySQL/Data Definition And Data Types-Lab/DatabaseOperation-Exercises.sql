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