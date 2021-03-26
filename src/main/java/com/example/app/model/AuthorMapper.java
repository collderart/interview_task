package com.example.app.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorMapper implements RowMapper<Author> {
    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        Author res = new Author();
        res.setId(rs.getLong("id"));
        res.setName(rs.getString("name"));
        return null;
    }
}
