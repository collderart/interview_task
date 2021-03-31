DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS authors;

--CREATE TYPE genres AS ENUM ('Classic', 'Nonfiction', 'Fantasy', 'Detective', 'Education' );

CREATE TABLE authors (
id BIGSERIAL PRIMARY KEY,
name VARCHAR(255) UNIQUE NOT NULL,
total_price INT,
date_time TIMESTAMP default current_timestamp(0));

CREATE TABLE books (
id BIGSERIAL PRIMARY KEY,
author_id BIGINT REFERENCES authors(id),
author_name VARCHAR(50) NOT NULL,
title VARCHAR(50) NOT NULL,
genre VARCHAR(50) NOT NULL,
price INT,
date_time TIMESTAMP default current_timestamp(0));

--INSERT INTO authors (name)
--VALUES
--('A. S. Pushkin'),
--('M. A. Bulgakov'),
--('F. M. Dostoevsky');
--
--INSERT INTO books (title, price, author_id, genre)
--VALUES
--('Idiot', '134', (SELECT id FROM authors WHERE id = 3), 'Classic'),
--('Master and Margarita', '250', (select currval(pg_get_serial_sequence('authors', 'id'))), 'Fantasy');


--select distinct on (books.id) books.*, authors.name from authors inner join books on books.author_id = authors.id order by books.id;
--insert into books (title, price, genre, author_id) values ('qwerty', '216', 'Nonfiction', 1);
