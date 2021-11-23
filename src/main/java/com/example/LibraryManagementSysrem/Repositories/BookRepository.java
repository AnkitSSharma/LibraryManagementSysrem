package com.example.LibraryManagementSysrem.Repositories;

import com.example.LibraryManagementSysrem.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository <Book, Long>{

    List<Book> findByNameContainingIgnoringCaseOrAuthorContainingIgnoringCase(String name,String author);
    List<Book> findByNameContainingIgnoringCase(String name);
    List<Book> findByAuthorContainingIgnoringCase(String author);
    Optional<Book> findById(Long id);

}
