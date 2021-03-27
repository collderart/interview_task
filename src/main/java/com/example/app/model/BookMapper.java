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
        res.setName(rs.getString("name"));
        res.setAuthor(rs.getString("author"));
        res.setPrice(rs.getInt("price"));
        res.setGenre(rs.getString("genre"));
        res.setDate_time(rs.getObject("date_time", LocalDateTime.class));
        return res;
    }
}
