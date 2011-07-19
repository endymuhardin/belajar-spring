DROP TABLE IF EXISTS person;

CREATE TABLE person(
	id INT PRIMARY KEY AUTO_INCREMENT, 
	nama VARCHAR(100),
	tanggal_lahir DATE
) Engine=InnoDB ;