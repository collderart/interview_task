package com.example.app.controller;
import com.example.app.model.Author;
import com.example.app.model.AuthorMapper;
import com.example.app.model.Book;
import com.example.app.model.BookMapper;
import com.example.app.repository.Repository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

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

    @PostMapping("/book")
    public String bookSubmit(@ModelAttribute Book book, Model model) {
        model.addAttribute("book", book);
        repository.addBook(book);
        //final var ra = new RedirectAttributesModelMap();
        //ra.addFlashAttribute("Success", "Book has been added.");
        System.out.println("New book is " + book.toString());
        return "redirect:/book";
    }

    @PostMapping("/search")
    public String searchBookByAuthor(@ModelAttribute String string, Model model) {
        model.addAttribute("search", string);
        List<Book> books = repository.getAllBooks();
        
       // books = repository.getListOfBooksByAuthor(new String());
        System.out.println("Search result + ");
        return "redirect:/search";
    }

    @GetMapping("/listauthors")
    public String getAuthorsSortedByDate(Model model){
        model.addAttribute("listauthors", new ArrayList<Author>(repository.getListOfAuthorsSortedByDate()));
        //this.authors = repository.getListOfAuthorsSortedByDate();
        return "listauthors";
    }

    @GetMapping("/listbooks")
    public String getBooksSortedByDate( Model model){
        model.addAttribute("listbooks", new ArrayList<Book>(repository.getListOfBooksSortedByDate()));
        //books = repository.getListOfBooksSortedByDate();
        return "listbooks";
    }

}
