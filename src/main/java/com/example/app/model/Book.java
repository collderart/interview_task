package com.example.app.model;

import java.time.LocalDateTime;

public class Book {
    private long id;
    private String name;
    private String author;
    private int price;
    private Genre genre;
    private LocalDateTime date_time;

    public LocalDateTime getDate_time() {
        return date_time;
    }

    public void setDate_time(LocalDateTime date_time) {
        this.date_time = date_time;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = Genre.valueOf(genre);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' + ", genre " + genre.title +
                ", price=" + price + ", date " + date_time +
                '}';
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    enum Genre {
        CLASSIC ("Classic"),
        NONFICTION ("Nonfiction"),
        FANTASY ("Fantasy"),
        DETECTIVE ("Detective"),
        EDUCATION ("Education");

        private String title;

        Genre(String title){ this.title = title; }
        public String getTitle() { return title;}
    }
}
