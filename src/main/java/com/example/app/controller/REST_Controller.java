package com.example.app.controller;

import com.example.app.model.Author;
import com.example.app.model.Book;
import com.example.app.repository.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
public class REST_Controller {
    private final Repository repository;

    public REST_Controller(Repository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity<>(repository.getAllBooks(), HttpStatus.OK);
    }
//    public Book bookForm() {
//        return new Book("No title", "No Author", Book.Genre.NONE);
//    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Book> getBook(@PathVariable long id){
        Book book = repository.getBookById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable long id) {
        repository.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(Book book){
        repository.updateBook(book);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Book bookAdd(Book book) {
        List<Book> books = repository.getAllBooks();
        if (books.contains(book)) {
            throw new RuntimeException("This book already exists in database");
        } else {
            repository.addBook(book);
        }
        System.out.println("New book is " + book.toString());
        book = repository.getLastBook();
        return book;
    }

    @GetMapping(value = "/dashboard")
    public List<Book> search(String title){
        List<Book> tmp = repository.searchBookByTitle(title);
        System.out.println("Search result : " + tmp.toString());
        return tmp;
    }

//    @GetMapping("/listbooks")
//    public List<Book> listAllBooks () {
//        return repository.getAllBooks();
//    }
////
//    @PostMapping(value = "/search")
//    public List<Book> searchBookByAuthor(@RequestParam String author_name) {
//        var res = repository.searchByAuthor(author_name);
//        System.out.println("result " + res.toString());
//        return res;
//    }

    @GetMapping("/listauthors")
    public List<Author> getAuthorsSortedByDate(){
        return repository.getListOfAuthorsSortedByDate();
    }

    @GetMapping("/listbooks")
    public List<Book> getBooksSortedByName(){
        var res = new ArrayList<Book>(repository.getListOfBooksSortedByDate());
        res.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getAuthor_name().compareTo(o2.getAuthor_name());
            }
        });
        return res;
    }

    @GetMapping("/listgenres")
    public List<Book> getSortedByGenre(@ModelAttribute String id) {
        var res = new ArrayList<Book>(repository.getAllBooks());
        res.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getGenreName().compareTo(o2.getGenreName());
            }
        });
        return res ;
    }



//    @GetMapping("/deletebyauthor")
//   // @ResponseStatus(value = HttpStatus.OK, reason = "List of deleted books:")
//    public List<Book> deleteBooksByAuthorDB(String author_name){
//        var res = repository.deleteBooksByAuthor(author_name);
//        if (res.size()==0){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Books by this author does not exist");
//        }
//        else {
//            return res;
//        }
//    }
}

