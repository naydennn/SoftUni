package bg.softuni.books.service.impl;

import bg.softuni.books.model.dto.AuthorDTO;
import bg.softuni.books.model.dto.BookDTO;
import bg.softuni.books.model.entity.Book;
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

    public BookServiceImpl(ModelMapper modelMapper, BookRepository bookRepository) {
        this.modelMapper = modelMapper;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    private BookDTO map(Book book) {
        BookDTO bookDTO = modelMapper.map(book, BookDTO.class);

        bookDTO.setAuthor(modelMapper.map(book.getAuthor(), AuthorDTO.class));
        return bookDTO;
    }
}
