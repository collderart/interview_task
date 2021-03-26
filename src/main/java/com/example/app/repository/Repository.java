package com.example.app.repository;

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
}
