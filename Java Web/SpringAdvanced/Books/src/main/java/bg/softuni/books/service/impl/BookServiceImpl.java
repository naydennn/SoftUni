package bg.softuni.books.service.impl;

import bg.softuni.books.model.dto.AuthorDTO;
import bg.softuni.books.model.dto.BookDTO;
import bg.softuni.books.model.entity.Author;
import bg.softuni.books.model.entity.Book;
import bg.softuni.books.repository.AuthorRepository;
import bg.softuni.books.repository.BookRepository;
import bg.softuni.books.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final ModelMapper modelMapper;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(ModelMapper modelMapper, BookRepository bookRepository, AuthorRepository authorRepository) {
        this.modelMapper = modelMapper;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public long create(BookDTO bookDTO) {

        Author author = authorRepository.findByName(bookDTO.getAuthor().getName()).
                orElseGet(() -> new Author().setName(bookDTO.getAuthor().getName()));

        Book book = modelMapper.map(bookDTO, Book.class);

        book.setAuthor(author);
        return bookRepository.save(book).getId();
    }

    private BookDTO map(Book book) {
        BookDTO bookDTO = modelMapper.map(book, BookDTO.class);

        bookDTO.setAuthor(modelMapper.map(book.getAuthor(), AuthorDTO.class));
        return bookDTO;
    }
}
