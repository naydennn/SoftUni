package com.example.springintro;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in)
    );

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        /*
        printAllBooksAfterYear(2000);
        printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
        printAllAuthorsAndNumberOfTheirBooks();
        printAllBooksByAuthorNameOrderByReleaseDate("George", "Powell");
        */

        System.out.println("Please enter exercises number:");
        int exNum = Integer.parseInt(reader.readLine());

        switch (exNum) {
            case 1 -> booksTitleByAgeRestriction();
            case 2 -> goldenBooks();
            case 3 -> bookByPrice();
            case 4 -> notReleasedBook();
            case 5 -> bookReleasedBeforeDate();
            case 6 -> authorsSearch();
            case 7 -> booksSearch();
            case 8 -> bookTitleSearch();
            case 9 -> countBooks();
            case 10 -> totalBookCopies();
            case 11 -> reducedBook();
        }
    }

    private void reducedBook() throws IOException {
        System.out.println("Please enter title of book:");

        String title = reader.readLine();
        bookService.getInformationOfBookByGivenTitle(title)
        .forEach(System.out::println);
    }

    private void totalBookCopies() throws IOException {

        System.out.println("Please write first name and last name of author separated by white space");
        String[] fullName = reader.readLine().split("\\s+");

        System.out.printf("%s %s - %d%n", fullName[0],
                fullName[1], bookService.getCopiesByFullNameOfAuthor(fullName[0], fullName[1]));
    }

    private void countBooks() throws IOException {

        System.out.println("Please enter min length for title");
        int length = Integer.parseInt(reader.readLine());

        System.out.println(bookService.countBooks(length));
    }

    private void bookTitleSearch() throws IOException {
        System.out.println("Please enter a pattern to find title and author by author last name starting with this pattern");

        String pattern = reader.readLine();

        bookService.findAllByAuthor_LastNameStartsWith(pattern)
                .forEach(System.out::println);
    }

    private void booksSearch() throws IOException {
        System.out.println("Please enter a pattern to find a books whose contains that:");

        String pattern = reader.readLine();
        bookService.findAllByTitleContains(pattern)
                .forEach(System.out::println);
    }

    private void authorsSearch() throws IOException {
        System.out.println("Please enter a pattern to find a authors whose name ends with that:");

        String pattern = reader.readLine();
        authorService.findAllByFirstNameEndingWith(pattern)
                .forEach(System.out::println);
    }


    private void bookReleasedBeforeDate() throws IOException {

        System.out.println("Please enter a date in format like dd-MM-yyyy:");

        LocalDate date = LocalDate.parse(reader.readLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        bookService.findAllByReleaseDateBefore(date)
                .forEach(System.out::println);
    }

    private void notReleasedBook() throws IOException {

        System.out.println("Please enter year:");

        int year = Integer.parseInt(reader.readLine());

        LocalDate beforeDate = LocalDate.of(year, 1, 1);
        LocalDate afterYear = LocalDate.of(year, 12, 31);

        bookService.findAllByReleaseDateBeforeOrReleaseDateAfter(beforeDate, afterYear)
                .forEach(System.out::println);
    }

    private void bookByPrice() throws IOException {

        System.out.println("Please enter lower bound");
        BigDecimal lower = new BigDecimal(reader.readLine());
        System.out.println("Please enter upper bound");
        BigDecimal upper = new BigDecimal(reader.readLine());

        bookService.findAllByPriceIsLessThanOrPriceGreaterThan(lower, upper)
                .forEach(System.out::println);
    }

    private void goldenBooks() throws IOException {
        System.out.println("Please enter number of copies:(please enter 5000)");

        int copies = Integer.parseInt(reader.readLine());

        bookService.findAllByCopiesLessThanAndEditionTypeIs(copies, EditionType.GOLD)
                .forEach(System.out::println);
    }

    private void booksTitleByAgeRestriction() throws IOException {
        System.out.println("Please enter a age restriction");

        AgeRestriction ageRestriction = AgeRestriction.valueOf(reader.readLine().toUpperCase());

        bookService.findAllByAgeRestriction(ageRestriction)
                .forEach(System.out::println);
    }

    private void printAllBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
