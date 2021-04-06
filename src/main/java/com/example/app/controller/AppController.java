package com.example.app.controller;
import com.example.app.model.Author;
import com.example.app.model.Book;
import com.example.app.repository.Repository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


@Controller
@Service
public class AppController {
private final Repository repository;

    public AppController(Repository repository) {
        this.repository = repository;
    }
    List<Book> books = new ArrayList<>();
    List<Author> authors = new ArrayList<>();

    @GetMapping("/book")
    public String bookForm(Model model) {
        model.addAttribute("book", new Book());
        //book.setTitle();
        return "book";
    }

    @PostMapping(value = "/book")
    public String bookSubmit(@ModelAttribute Book book, Model model) {
        List<Book> books = repository.getAllBooks();
            if (books.contains(book)) {
                throw new RuntimeException("This book already exists in database");
            } else {
                repository.addBook(book);
            }
        model.addAttribute("book", book);
        System.out.println("New book is " + book.toString());
        return "redirect:/book";
    }

    @GetMapping(value = "/search")
    public String searchForm(Model model){
        model.addAttribute("search", new Book());
        return "search";
    }

    @PostMapping(value = "/search")
    public String searchBookByAuthor(@RequestParam String author_name, Model model) {
        var res = repository.searchByAuthor(author_name);
        System.out.println("result " + res.toString());
        model.addAttribute("author_name", res);
        return "redirect:/search";
    }

    @GetMapping("/listauthors")
    public String getAuthorsSortedByDate(Model model){
        model.addAttribute("listauthors", new ArrayList<Author>(repository.getListOfAuthorsSortedByDate()));
        return "listauthors";
    }

    @GetMapping("/listbooks")
    public String getBooksSortedByName( Model model){
        var res = new ArrayList<Book>(repository.getListOfBooksSortedByDate());
        res.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getAuthor_name().compareTo(o2.getAuthor_name());
            }
        });
        model.addAttribute("listbooks", res);
        //books = repository.getListOfBooksSortedByDate();
        return "listbooks";
    }

    @GetMapping("/listgenres")
    public String getSortedByGenre(@ModelAttribute String id, Model model) {
        var res = new ArrayList<Book>(repository.getAllBooks());
        res.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getGenreName().compareTo(o2.getGenreName());
            }
        });
        return "";
    }



}
