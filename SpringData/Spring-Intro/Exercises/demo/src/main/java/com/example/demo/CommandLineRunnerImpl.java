package com.example.demo;

import com.example.demo.services.AuthorServices;
import com.example.demo.services.BookServices;
import com.example.demo.services.CategoryServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryServices categoryServices;
    private final AuthorServices authorServices;
    private final BookServices bookServices;

    public CommandLineRunnerImpl(CategoryServices categoryServices, AuthorServices authorServices, BookServices bookServices) {
        this.categoryServices = categoryServices;
        this.authorServices = authorServices;
        this.bookServices = bookServices;
    }


    @Override
    public void run(String... args) throws Exception {

        seedDatabase();
        // printTitlesOfAllBookAfterYear(2000);
        // printFirstNameAndLastNameOfAuthor(1990);
        // printFirstNameLastNameAndBookCountOfAuthor();
        printAllBookFromGeorgePowell("George", "Powell");

    }

    private void printAllBookFromGeorgePowell(String fName, String lName) {
        bookServices.getAllBookByAuthor(fName, lName);
    }

    private void printFirstNameLastNameAndBookCountOfAuthor() {
        authorServices.getAllAuthorsOrderByBookCount()
                .forEach(System.out::println);
    }

    private void printFirstNameAndLastNameOfAuthor(int year) {
        bookServices.getAllAuthorNameOfBookBeforeReleasedYear(year)
                .forEach(System.out::println);
    }

    private void printTitlesOfAllBookAfterYear(int year) {
        bookServices.getAllTitleOfBookAfterReleasedYear(year)
                .forEach(System.out::println);
    }

    private void seedDatabase() throws IOException {
        categoryServices.seedCategories();
        authorServices.seedAuthors();
        bookServices.seedBooks();
    }

}
