DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS authors;

--CREATE TYPE genres AS ENUM ('Classic', 'Nonfiction', 'Fantasy', 'Detective', 'Education' );

CREATE TABLE authors (
id BIGSERIAL PRIMARY KEY,
name VARCHAR(255) NOT NULL,
total_price INT,
date_time TIMESTAMP default current_timestamp);

CREATE TABLE books (
id BIGSERIAL PRIMARY KEY,
author_id BIGINT REFERENCES authors(id),
name VARCHAR(50) NOT NULL,
genre VARCHAR(50),
price INT,
date_time TIMESTAMP default current_timestamp);

INSERT INTO authors (name)
VALUES
('A. S. Pushkin'),
('M. A. Bulgakov'),
('F. M. Dostoevsky');

INSERT INTO books (name, price, author_id, genre)
VALUES
('Idiot', '134', (SELECT id FROM authors WHERE id = 3), 'Classic'),
('Master and Margarita', '250', (select currval(pg_get_serial_sequence('authors', 'id'))), 'Fantasy');
