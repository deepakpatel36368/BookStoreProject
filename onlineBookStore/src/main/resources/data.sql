USE bookstore;

DROP table book;
-- SQL script to create the table
CREATE TABLE IF NOT EXISTS book (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    genre VARCHAR(100),
    isbn VARCHAR(50) NOT NULL
);

-- SQL script to insert sample data
INSERT INTO book VALUE ('1', 'Book Title 1', 'Author 1', 'Fiction', '1234567890');
INSERT INTO book VALUE ('2', 'Book Title 2', 'Author 2', 'Science Fiction', '0987654321');
INSERT INTO book VALUE ('3', 'Book Title 3', 'Author 3', 'Mystery', '5678901234');
INSERT INTO book VALUE ('4', 'Book Title 4', 'Author 4', 'Romance', '9876543210');
INSERT INTO book VALUE ('5', 'Book Title 5', 'Author 5', 'Thriller', '5432109876');

SELECT * from book;