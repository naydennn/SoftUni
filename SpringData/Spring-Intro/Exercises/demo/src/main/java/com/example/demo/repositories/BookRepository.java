package com.example.demo.repositories;

import com.example.demo.models.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findBookByReleaseDateIsAfter(LocalDate localDate);

    List<Book> findBookByReleaseDateIsBefore(LocalDate localDate);

    List<Book> findBooksByAuthor_FirstNameAndAuthor_LastNameAndOrderByReleaseDateDesc(String fName, String lName);
}
