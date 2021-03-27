DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS authors;

CREATE TYPE genres AS ENUM ('Classic', 'Nonfiction', 'Fantasy', 'Detective', 'Education' );

CREATE TABLE authors (
id BIGSERIAL PRIMARY KEY,
name VARCHAR(255) NOT NULL,
total_price INT ,
date_time TIMESTAMP);

CREATE TABLE books (
id BIGSERIAL PRIMARY KEY,
author_id BIGINT REFERENCES authors(id),
name VARCHAR(50) NOT NULL,
genre genres,
price INT,
date_time TIMESTAMP);

INSERT INTO authors (name, date_time)
VALUES
('A. S. Pushkin', (SELECT transaction_timestamp())),
('M. A. Bulgakov', (SELECT transaction_timestamp())),
('F. M. Dostoevsky', (SELECT transaction_timestamp()));

INSERT INTO books (name, price, author_id, genre, date_time)
VALUES
('Idiot', '134', (SELECT id FROM authors WHERE id = 3), 'Classic', (SELECT transaction_timestamp())),
('Master and Margarita', '250', (SELECT id FROM authors WHERE id = 2), 'Fantasy', (SELECT transaction_timestamp()));
