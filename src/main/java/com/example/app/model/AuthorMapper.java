package com.example.app.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class AuthorMapper implements RowMapper<Author> {
    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        Author res = new Author();
        res.setId(rs.getLong("id"));
        res.setName(rs.getString("name"));
        res.setDate_time(rs.getObject("date_time", LocalDateTime.class));
        return res;
    }
}
