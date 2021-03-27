package com.example.app.service;

import com.example.app.model.Author;
import com.example.app.model.Book;
import com.example.app.repository.Repository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbProcessor implements InitializingBean {
    private final Repository repository;

    @Override
    public void afterPropertiesSet() throws Exception {
        //
        System.out.println("Loading data from DB");
        for (Long id : repository.getListOfIds()) {
            System.out.print(id + "\t");
        }
        System.out.println();
        for (var name:
                repository.getListOfNames()
             ) {
            System.out.print(name + " ");
        }
        System.out.println();

        List<Author> authors = repository.getListOfAuthorsSortedByDate();
        for (var author: authors) {
            System.out.println(author.toString());
        }
//        List<Book> books = repository.getListOfBooks();
//        for (var author: books) {
//            System.out.println(author.toString());
//        }
    }

    public DbProcessor(Repository repository) {
        this.repository = repository;
    }
}
