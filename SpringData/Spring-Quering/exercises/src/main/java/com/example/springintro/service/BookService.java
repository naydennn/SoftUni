package com.example.springintro.service;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import org.springframework.data.repository.query.Param;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<String> findAllByCopiesLessThanAndEditionTypeIs(Integer copies, EditionType editionType);

    List<String> findAllByPriceIsLessThanOrPriceGreaterThan(BigDecimal lower, BigDecimal upper);

    List<String> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate before, LocalDate after);

    List<String> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<String> findAllByTitleContains(String pattern);

    List<String> findAllByAuthor_LastNameStartsWith(String pattern);

    int countBooks(int length);

    int getCopiesByFullNameOfAuthor(String firstName, String lastName);

    List<String> getInformationOfBookByGivenTitle(String title);

}
