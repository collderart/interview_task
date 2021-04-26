package com.example.app.repository;

import com.example.app.model.Author;
import com.example.app.model.AuthorMapper;
import com.example.app.model.Book;
import com.example.app.model.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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

    public Book getBookById(long id) { return jdbcTemplate.queryForObject("select * from books where id=?", new BookMapper(), id);}

    //public Book getLastBook() { return jdbcTemplate.queryForObject("")}

    public List<Book> getListOfBooksSortedByDate() { return  jdbcTemplate.query(
            "select distinct on (books.date_time) books.*, authors.name from authors inner join books on books.author_id = authors.id order by books.date_time;", new BookMapper()); }

    public List<Book> getListOfBooksSortedByGenre() { return  jdbcTemplate.query("select * from books order by genre", new BookMapper()); }

    public List<Author> getListOfAuthorsSortedByDate() { return jdbcTemplate.query("select * from authors order by date_time", new AuthorMapper()); }

    public List<Book> getListOfBooksByAuthor(String name) { return  jdbcTemplate.query("select * from books where author_name = ? order by title asc", new BookMapper(), name);}

    public int getAuthorId(Book book) { return jdbcTemplate.queryForObject("select id from authors where name = ?", Integer.class, book.getAuthor_name());}

    public void updateBook(Book book) {
        jdbcTemplate.update("update books set title=?, author_name=?, genre=? where id=?", book.getTitle(), book.getAuthor_name(), book.getGenreName(), book.getId());}

    public void addBook(Book book) {
        jdbcTemplate.update("insert into authors (name) values (?) on conflict (name) do nothing", book.getAuthor_name());
        jdbcTemplate.update("insert into books (title, genre, author_id, author_name ) values (?, ?, ?, ?)",
                book.getTitle(), book.getGenreName(), getAuthorId(book), book.getAuthor_name() );
    }
    public Book getLastBook() { return jdbcTemplate.queryForObject("select * from books order by date_time desc limit 1", new BookMapper()); }

    public List<Book> searchByAuthor(String author_name) {
        var tmp = getAllBooks();
        tmp.removeIf( r -> !r.getAuthor_name().equals(author_name));

//        List<Book> res = new ArrayList<>();
//        for (Book book: tmp
//             ) {
//            if (book.getAuthor_name().equals(author_name)){
//                res.add(book);
//            }
//        }
        return tmp;
    }

    public List<Book> deleteBooksByAuthor(String author_name) {
        return jdbcTemplate.query("delete from books where author_name = ?", new BookMapper(), author_name);
    }

    public void deleteBook(long id) {
        jdbcTemplate.update("delete from books where id = ?", id);
    }

    public List<Book> searchBookByTitle(String str) {
        return jdbcTemplate.query("select * from books where to_tsvector(title) @@ to_tsquery('%:*')", new BookMapper(), str);
//        var tmp = getAllBooks();
//        tmp.removeIf( r -> !r.getTitle().equalsIgnoreCase(title));
//        return tmp;
    }
}
