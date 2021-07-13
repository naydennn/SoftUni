package com.example.demo.repositories;

import com.example.demo.models.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findBookByReleaseDateIsAfter(LocalDate localDate);

    List<Book> findBookByReleaseDateIsBefore(LocalDate localDate);

    @Query("select b from Book b where b.author.firstName = ?1 and b.author.lastName = ?2 order by b.releaseDate DESC, b.title")
    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String firstName, String lastName);
}
