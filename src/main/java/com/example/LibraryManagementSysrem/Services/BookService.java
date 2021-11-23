package com.example.LibraryManagementSysrem.Services;

import com.example.LibraryManagementSysrem.Entities.Book;
import com.example.LibraryManagementSysrem.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class BookService {
    @Autowired
    private BookRepository repository;

    public List<Book> searchBook(String name, String author){
        if(name==null && author==null){
            return repository.findAll();
        }
        if(name==null && author!=null){
            return repository.findByAuthorContainingIgnoringCase(author);
        }
        if(name!=null && author==null){
            return repository.findByNameContainingIgnoringCase(name);
        }
            return repository.findByNameContainingIgnoringCaseOrAuthorContainingIgnoringCase(name,author);
    }
    public void createBook(Book book){
        repository.save(book);
    }
    public void updateBook(Book book){
        repository.save(book);
    }
}
