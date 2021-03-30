package com.example.app.model;

import java.time.LocalDateTime;

public class Book {
    private long id;
    private String title;
    private String author;
    private int price;
    private Genre genre;
    private LocalDateTime date_time;



    enum Genre {
        CLASSIC ("Classic"),
        NONFICTION ("Nonfiction"),
        FANTASY ("Fantasy"),
        DETECTIVE ("Detective"),
        EDUCATION ("Education");

        private String genreName;

        Genre(String genreName){ this.genreName = genreName; }
        public String getGenreName() { return genreName;}
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' + ", genre " + genre.genreName +
                ", price=" + price + ", date " + date_time +
                '}';
    }

    public LocalDateTime getDate_time() {
        return date_time;
    }

    public void setDate_time(LocalDateTime date_time) {
        this.date_time = date_time;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
