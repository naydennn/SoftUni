package com.example.springintro.repository;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByCopiesLessThanAndEditionTypeIs(Integer copies, EditionType editionType);

    List<Book> findAllByPriceIsLessThanOrPriceGreaterThan(BigDecimal lower, BigDecimal upper);

    List<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate before, LocalDate after);

    List<Book> findAllByTitleContains(String pattern);

    List<Book> findAllByAuthor_LastNameStartsWith(String pattern);

    @Query("select count(b) from Book b where length(b.title) > :length")
    int countAllByTitleLengthLongerThan(@Param(value = "length") int length);

    @Query("select b.copies from Book b where b.author.firstName = :firstName and b.author.lastName = :lastName")
    List<Integer> getCopiesByFullNameOfAuthor(@Param(value = "firstName") String firstName, @Param(value = "lastName") String lastName);

    @Query("select b.title, b.editionType, b.ageRestriction, b.price from Book b where b.title = :title")
    List<Object[]> getInformationOfBookByGivenTitle(@Param(value = "title") String title);

}
