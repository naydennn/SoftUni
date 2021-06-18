CREATE DATABASE fsd;
use fsd;

CREATE TABLE coaches (
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(10) NOT NULL,
last_name VARCHAR(20) NOT NULL,
salary DECIMAL(10,2) NOT NULL DEFAULT 0,
coach_level INT NOT NULL DEFAULT 0
);

CREATE TABLE skills_data (
id INT PRIMARY KEY AUTO_INCREMENT,
dribbling INT DEFAULT 0,
pace INT DEFAULT 0,
passing INT DEFAULT 0,
shooting INT DEFAULT 0,
speed INT DEFAULT 0,
strength INT DEFAULT 0
);

CREATE TABLE countries (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL
);

CREATE TABLE towns (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
country_id INT NOT NULL,
CONSTRAINT fk_towns_countries
FOREIGN KEY (country_id)
REFERENCES countries (id)
);

CREATE TABLE stadiums (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
capacity INT NOT NULL,
town_id INT NOT NULL,
CONSTRAINT fk_stadiums_towns
FOREIGN KEY (town_id)
REFERENCES towns(id)
);

CREATE TABLE teams (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
established DATE NOT NULL,
fan_base BIGINT NOT NULL DEFAULT 0,
stadium_id INT NOT NULL,
CONSTRAINT fk_teams_stadiums
FOREIGN KEY (stadium_id)
REFERENCES stadiums(id)
);

CREATE TABLE players (
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(10) NOT NULL,
last_name VARCHAR(20) NOT NULL,
age INT NOT NULL DEFAULT 0,
`position` CHAR(1) NOT NULL,
salary DECIMAL(10,2) NOT NULL DEFAULT 0,
hire_date DATETIME,
skills_data_id INT NOT NULL,
CONSTRAINT fk_players_skills_data
FOREIGN KEY (skills_data_id)
REFERENCES skills_data (id),
team_id INT,
CONSTRAINT fk_players_teams
FOREIGN KEY (team_id)
REFERENCES teams(id)
);

CREATE TABLE players_coaches (
player_id INT,
coach_id INT,
CONSTRAINT fk_players_coaches_players
FOREIGN KEY (player_id)
REFERENCES players(id),
CONSTRAINT fk_players_coaches_coaches
FOREIGN KEY (coach_id) 
REFERENCES coaches (id)
);

INSERT INTO `coaches`(`first_name`,`last_name`,`salary`,`coach_level`) (
	(SELECT `first_name`,`last_name`,`salary` * 2, CHAR_LENGTH(`first_name`) 
    FROM `players`
    WHERE `age` >= 45)
);

UPDATE coaches AS c
JOIN players_coaches AS pc
ON c.id = pc.coach_id
SET coach_level = coach_level + 1
WHERE LEFT(first_name , 1) = 'A';

DELETE FROM players
WHERE age >= 45;

SELECT first_name, age, salary
FROM players
ORDER BY salary DESC;

SELECT p.id, CONCAT(p.first_name, ' ', p.last_name) AS full_name ,p.age, p.`position`, p.hire_date
FROM players AS p
JOIN skills_data AS sd
ON p.skills_data_id = sd.id
WHERE p.age <23 AND p.`position` = 'A' AND p.hire_date IS NULL AND sd.strength >50
ORDER BY p.salary, p.age;

SELECT t.`name`, t.established, t.fan_base, COUNT(players.id) AS count_of_players
FROM players
JOIN teams AS t
ON players.team_id = t.id 
GROUP BY players.team_id
ORDER BY count_of_players DESC , t.fan_base DESC;

SELECT MAX(skills_data.speed) AS max_speed, towns.`name` FROM players
RIGHT JOIN skills_data
ON players.skills_data_id = skills_data.id
RIGHT JOIN teams 
ON players.team_id = teams.id
RIGHT JOIN stadiums 
ON teams.stadium_id = stadiums.id
RIGHT JOIN towns
ON stadiums.town_id = towns.id
WHERE teams.`name` != 'Devify' 
GROUP BY towns.id
ORDER BY max_speed DESC, towns.`name`;

SELECT countries.`name`, COUNT(players.id) AS total_count_of_players,
SUM(players.salary) AS total_sum_of_salaries FROM players
RIGHT JOIN teams 
ON players.team_id = teams.id
RIGHT JOIN stadiums 
ON teams.stadium_id = stadiums.id
RIGHT JOIN towns
ON stadiums.town_id = towns.id
RIGHT JOIN countries 
ON towns.country_id = countries.id
GROUP BY countries.`name`
ORDER BY total_count_of_players DESC , countries.`name`;

SELECT udf_stadium_players_count ('Linklinks') as `count`; 

CALL udp_find_playmaker (20, 'Skyble');