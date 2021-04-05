package com.example.app.repository;

import com.example.app.model.Author;
import com.example.app.model.AuthorMapper;
import com.example.app.model.Book;
import com.example.app.model.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@org.springframework.stereotype.Repository
public class Repository {
    @Autowired
    private final JdbcTemplate jdbcTemplate;


    public Repository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Long> getListOfIds() {
        return jdbcTemplate.queryForList("select id from authors", Long.class);
    }

    public List<String> getListOfNames(){
        return jdbcTemplate.queryForList("select name from authors", String.class);
    }

    public List<Author> getListOfAuthors() { return jdbcTemplate.query("select * from authors", new AuthorMapper()); }

    public List<Book> getAllBooks() { return  jdbcTemplate.query("select * from books", new BookMapper()); }



    public List<Book> getListOfBooksSortedByDate() { return  jdbcTemplate.query(
            "select distinct on (books.date_time) books.*, authors.name from authors inner join books on books.author_id = authors.id order by books.date_time;", new BookMapper()); }

    public List<Book> getListOfBooksSortedByGenre() { return  jdbcTemplate.query("select * from books order by genre", new BookMapper()); }

    public List<Author> getListOfAuthorsSortedByDate() { return jdbcTemplate.query("select * from authors order by date_time", new AuthorMapper()); }

    public List<Book> getListOfBooksByAuthor(String name) { return  jdbcTemplate.query("select * from books where author_name = ? order by title asc", new BookMapper(), name);}

    public int getAuthorId(Book book) { return jdbcTemplate.queryForObject("select id from authors where name = ?", Integer.class, book.getAuthor_name());}

    public void addBook(Book book) {
        jdbcTemplate.update("insert into authors (name) values (?) on conflict (name) do nothing", book.getAuthor_name());
        jdbcTemplate.update("insert into books (title, genre, author_id, author_name ) values (?, ?, ?, ?)",
                book.getTitle(), book.getGenreName(), getAuthorId(book), book.getAuthor_name() );
    }
    //    public void addBook (Book book) {
//        jdbcTemplate.update("insert into books (title, genre, author, price) values (? , ?, (select currval(pg_get_serial_sequence('authors, id')), ?)");
//    }
}
