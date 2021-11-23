package com.example.LibraryManagementSysrem.Controllers;

import com.example.LibraryManagementSysrem.Entities.Book;
import com.example.LibraryManagementSysrem.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

public class BookController {

    @Autowired
    private BookService service;
    @GetMapping("/books")
    public List<Book> searchBook( @RequestParam(value="name",required = false) String name, @RequestParam(value="author", required = false) String author){
        return  service.searchBook(name,author);
    }
    @PostMapping("/admin/book/create")
    public void createBook(@RequestBody Book book){
        service.createBook(book);
    }
    @PutMapping("/admin/book/update")
    public void updateBook(@RequestBody Book book) {
        service.updateBook(book);
    }

}
