CREATE DATABASE demoTuan3;

USE `demoTuan3`;

CREATE TABLE users (
  id INT AUTO_INCREMENT NOT NULL,
  username VARCHAR(50) NULL,
  password VARCHAR(50),
  email VARCHAR(50) NULL,
  fullname VARCHAR(100) NULL,
  images VARCHAR(500) NULL,
  PRIMARY KEY (`id`));
  
INSERT INTO users (username, password, email, fullname, images)
VALUES
( 'john_doe', 'password123', 'john@example.com', 'John Doe', 'john_doe.jpg'),
( 'jane_smith', 'securePass!456', 'jane@example.com', 'Jane Smith', 'jane_smith.png'),
( 'alice_nguyen', 'alicePassword789', 'alice@example.com', 'Alice Nguyen', 'alice_nguyen.png'),
( 'bob_le', 'bobSecure!123', 'bob@example.com', 'Bob Le', 'bob_le.jpg'),
( 'charlie_kim', 'charlie789!', 'charlie@example.com', 'Charlie Kim', 'charlie_kim.png');
