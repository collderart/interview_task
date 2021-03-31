package com.example.app.model;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class Book {
    private long id;
    @NotBlank(message = "Please, enter the title")
    private String title;
    private long author_id;
    @NotBlank(message = "Please, enter the author name")
    private String author_name;
    private int price;
    private Genre genre;
    private LocalDateTime date_time;


    public long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(long author_id) {
        this.author_id = author_id;
    }

    enum Genre {
        CLASSIC ("Classic"),
        NONFICTION ("Nonfiction"),
        FANTASY ("Fantasy"),
        DETECTIVE ("Detective"),
        EDUCATION ("Education");

        private String genreName;

        Genre(String genreName){ this.genreName = genreName; }
        public void setGenreName(String genreName) { this.genreName = genreName; }
        public String getGenreName() { return genreName;}
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author_name + '\'' + ", genre " + genre.genreName +
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

    public String getGenreName() {
        return genre.getGenreName();
    }

    public void setGenreName(String genreName){ genre.setGenreName(genreName);}

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
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
