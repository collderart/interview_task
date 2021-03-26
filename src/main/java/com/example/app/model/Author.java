package com.example.app.model;

import java.time.LocalDateTime;

public class Author {

    private long id;
    private String name;
    private int books_count;

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books_count=" + books_count +
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

    //    public LocalDateTime getTime() {
//        return time;
//    }
//
//    public void setTime(LocalDateTime time) {
//        this.time = time;
//    }
}
