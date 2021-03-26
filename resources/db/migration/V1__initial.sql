DROP TABLE IF EXISTS authors;
DROP TABLE IF EXISTS books;

CREATE TABLE authors (
id BIGSERIAL UNIQUE NOT NULL PRIMARY KEY,
name VARCHAR(255) NOT NULL,
date_time TIMESTAMP NOT NULL,
total_price INT );

CREATE TABLE books (
id BIGSERIAL UNIQUE NOT NULL PRIMARY KEY NOT NULL,
author_id BIGINT REFERENCES authors(id),
name VARCHAR(50) NOT NULL,
price INT NOT NULL );

INSERT INTO authors (name, date_time)
VALUES(
('A. S. Pushkin', (SELECT NOW()::timestamp)),
('M. A. Bulgakov', (SELECT NOW()::timestamp)),
('F. M. Dostoevsky', (SELECT NOW()::timestamp))
);

INSERT INTO books (name, price, author_id)
VALUES(
('Idiot', '134', (SELECT id FROM authors WHERE id = 3)),
('Master and Margarita', '250', (SELECT id FROM authors WHERE id = 2))
);
