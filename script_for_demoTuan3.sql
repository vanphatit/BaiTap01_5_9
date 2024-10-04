DROP DATABASE demotuan3;

CREATE DATABASE demoTuan3;

USE `demoTuan3`;

CREATE TABLE users (
  id INT AUTO_INCREMENT NOT NULL,
  username VARCHAR(50) NULL,
  password VARCHAR(50),
  email VARCHAR(50) NULL,
  roleid INT,
  fullname VARCHAR(100),
  phone VARCHAR(10) NULL,
  image VARCHAR(1000) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE roles (
	roleid INT PRIMARY KEY,
    name VARCHAR(100) 
);

CREATE TABLE categories(
	categoryID INT PRIMARY KEY AUTO_INCREMENT, 
    categoryName NVARCHAR(255),
    images NVARCHAR(500),
    status INT
);

INSERT INTO roles (roleid, name) VALUES
(1, 'admin'),
(2, 'user');
  
INSERT INTO users (username, fullname, password, email, roleid, phone) VALUES
('john_doe', 'john_doe', '123', 'john@example.com', 1, '0123456789'), -- Admin
('jane_smith', 'jane_smith', '123', 'jane@example.com', 2, '0987654321'), -- User
('alice_wonder', 'alice_wonder', '123', 'alice@example.com', 2, '0912345678'), -- User
('bob_builder', 'bob_builder', '123', 'bob@example.com', 2, '0856781234'), -- User
('charlie_brown', 'charlie_brown', '123', 'charlie@example.com', 1, '0765432198'); -- Admin

INSERT INTO categories (CategoryName, images, status) VALUES
('Phim hành động', 'h1CBC93F0.png', 1),
('Anime', 'https://cdn.popsww.com/blog/sites/2/2023/06/thanh-guom-diet-quy-season-4.jpg', 1);
