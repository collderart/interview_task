package com.example.app.controller;

import com.example.app.model.Author;
import com.example.app.model.AuthorMapper;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "a/b/author")
public class AuthorController {
@GetMapping
    public List<String> authorController(){
    return List.of("Hello", "World");
}



}
