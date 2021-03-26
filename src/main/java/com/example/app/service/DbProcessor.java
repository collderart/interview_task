package com.example.app.service;

import com.example.app.repository.Repository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

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
    }

    public DbProcessor(Repository repository) {
        this.repository = repository;
    }
}
