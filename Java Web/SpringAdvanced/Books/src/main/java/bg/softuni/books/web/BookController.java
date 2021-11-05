package bg.softuni.books.web;

import bg.softuni.books.model.dto.BookDTO;
import bg.softuni.books.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public ResponseEntity<List<BookDTO>> index() {

        List<BookDTO> allBooks = bookService.getAllBooks();
        return ResponseEntity.ok(allBooks);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookDTO> delete(@PathVariable("id") long id) {
        bookService.deleteBook(id);

        return ResponseEntity.
                noContent().
                build();
    }

    @PutMapping("put")
    public ResponseEntity<BookDTO> create(@RequestBody BookDTO bookDTO,
                                          UriComponentsBuilder builder) {
        long bookId = bookService.create(bookDTO);

        URI location = builder.path("/books/{id}").buildAndExpand(bookId).toUri();

        return ResponseEntity.created(location).build();
    }
}
