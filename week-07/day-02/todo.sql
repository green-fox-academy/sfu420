# CREATE DATABASE todo;
# USE todo;

CREATE TABLE tasks (
	id INT PRIMARY KEY AUTO_INCREMENT,
	task VARCHAR(255) NOT NULL,
	done BOOLEAN
);

INSERT INTO tasks (task, done) VALUES ("Buy Milk", 0), ("Feed the dog", 0), ("Do homework", 1);

SELECT * FROM tasks;

UPDATE tasks SET done = 1 WHERE id = 1;

DELETE FROM tasks WHERE id = 3;

