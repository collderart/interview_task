package com.example.app.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Author {

    private long id;
    private String name;
    private int books_count;
    private LocalDateTime date_time;

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books_count=" + books_count +
                ", date " + date_time.truncatedTo(ChronoUnit.SECONDS) +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBooks_count() {return books_count;}

    public void setBooks_count(int books_count) {
        this.books_count = books_count;
    }

    public LocalDateTime getDate_time() {
      return date_time;
    }

    public void setDate_time(LocalDateTime date_time) {
        this.date_time = date_time;
    }
}
