package com.example.app.repository;

import com.example.app.model.Author;
import com.example.app.model.AuthorMapper;
import com.example.app.model.Book;
import com.example.app.model.BookMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Repository {
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

    public List<Book> getListOfBooks() { return  jdbcTemplate.query("select * from books", new BookMapper()); }

    public List<Book> getListOfBooksSortedByDate() { return  jdbcTemplate.query("select * from books order by date_time", new BookMapper()); }

    public List<Book> getListOfBooksSortedByGenre() { return  jdbcTemplate.query("select * from books order by genre", new BookMapper()); }

    public List<Author> getListOfAuthorsSortedByDate() { return jdbcTemplate.query("select * from authors order by date_time", new AuthorMapper()); }
}
