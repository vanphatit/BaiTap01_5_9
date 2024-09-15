DROP DATABASE demotuan3;

CREATE DATABASE demoTuan3;

USE `demoTuan3`;

CREATE TABLE users (
  id INT AUTO_INCREMENT NOT NULL,
  username VARCHAR(50) NULL,
  password VARCHAR(50),
  email VARCHAR(50) NULL,
  roleid INT,
  phone VARCHAR(10) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE roles (
	roleid INT PRIMARY KEY,
    name VARCHAR(100) 
);

INSERT INTO roles (roleid, name) VALUES
(1, 'admin'),
(2, 'user');
  
INSERT INTO users (username, password, email, roleid, phone) VALUES
('john_doe', 'password123', 'john@example.com', 1, '0123456789'), -- Admin
('jane_smith', 'abc$5678', 'jane@example.com', 2, '0987654321'), -- User
('alice_wonder', 'alice@2023', 'alice@example.com', 2, '0912345678'), -- User
('bob_builder', 'builder99', 'bob@example.com', 2, '0856781234'), -- User
('charlie_brown', 'charlie_pass', 'charlie@example.com', 1, '0765432198'); -- Admin

