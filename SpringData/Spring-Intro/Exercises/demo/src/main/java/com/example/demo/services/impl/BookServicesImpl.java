package com.example.demo.services.impl;

import com.example.demo.models.entity.*;
import com.example.demo.repositories.BookRepository;
import com.example.demo.services.AuthorServices;
import com.example.demo.services.BookServices;
import com.example.demo.services.CategoryServices;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServicesImpl implements BookServices {

    private static final String BOOKS_FILE_PATH = "src/main/resources/files/books.txt";


    private final BookRepository bookRepository;
    private final AuthorServices authorServices;
    private final CategoryServices categoryServices;

    public BookServicesImpl(BookRepository bookRepository, AuthorServices authorServices, CategoryServices categoryServices) {
        this.bookRepository = bookRepository;
        this.authorServices = authorServices;
        this.categoryServices = categoryServices;
    }

    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() < 1) {
            List<String> rows = Files.readAllLines(Path.of(BOOKS_FILE_PATH));
            for (String row : rows) {

                Book book = getBook(row);

                bookRepository.save(book);
            }
        }
    }

    @Override
    public List<String> getAllTitleOfBookAfterReleasedYear(int year) {
        return bookRepository.findBookByReleaseDateIsAfter(LocalDate.of(year, 12, 31)).stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllAuthorNameOfBookBeforeReleasedYear(int year) {
        return bookRepository.findBookByReleaseDateIsBefore(LocalDate.of(year, 1, 1))
                .stream()
                .map(book -> String.format("%s %s", book.getAuthor().getFirstName(), book.getAuthor().getLastName()))
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDateTitle(String firstName, String lastName) {
       return bookRepository.findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(firstName,lastName)
                .stream()
                .map(book -> String.format("%s %s %d", book.getTitle(),
                        book.getReleaseDate(),
                        book.getCopies()))
               .collect(Collectors.toList());
    }

    private Book getBook(String row) {
        String[] data = row.split("\\s+");
        EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
        LocalDate localDate = LocalDate.parse(data[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        int copies = Integer.parseInt(data[2]);
        BigDecimal price = new BigDecimal(data[3]);
        AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];

        String title = Arrays.stream(data).skip(5)
                .collect(Collectors.joining(" "));

        Author author = authorServices.getRandomAuthor();
        Set<Category> categories = categoryServices.getRandomCategories();

        return new Book(title, editionType, price, copies, localDate
                , ageRestriction, author, categories);
    }


}
