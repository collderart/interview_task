package com.example.app.controller;
import com.example.app.model.Author;
import com.example.app.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;

@Controller
public class AppController {
    @GetMapping("/")
    public String init(Book book) {
        //book.setTitle();
        return "index";
    }

    @GetMapping("/listbooks")
    public String getAuthors(Model model){
        return "listbooks";
    }

    @PostMapping(path = "/authors", consumes = "app/json", produces = "app/json")
    public void addAuthor(@RequestBody Member member) {

    }

}
