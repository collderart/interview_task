package com.example.app.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book res = new Book();
        res.setId(rs.getLong("id"));
        res.setTitle(rs.getString("title"));
        res.setAuthor_name(rs.getString("author_name"));
        res.setPrice(rs.getInt("price"));
        res.setGenre(Book.Genre.valueOf(rs.getString("genre").toUpperCase()));
        res.setDate_time(rs.getObject("date_time", LocalDateTime.class));
        return res;
    }
}
