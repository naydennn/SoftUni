package com.example.demo.services.impl;

import com.example.demo.models.entity.Author;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.services.AuthorServices;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class AuthorServicesImpl implements AuthorServices {

    private static final String AUTHORS_FILE_PATH = "src/main/resources/files/authors.txt";


    private final AuthorRepository authorRepository;

    public AuthorServicesImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getRandomAuthor() {
        Long randomId = ThreadLocalRandom.current().nextLong(1, authorRepository.count() + 1);
        return authorRepository.findById(randomId).orElse(null);
    }

    @Override
    public void seedAuthors() throws IOException {
        if (authorRepository.count() < 1) {
            List<String> rows = Files.readAllLines(Path.of(AUTHORS_FILE_PATH));

            for (String row : rows) {
                String[] fullName = row.split("\\s+");
                Author author = new Author(fullName[0], fullName[1]);

                authorRepository.save(author);
            }
        }
    }

    @Override
    public List<String> getAllAuthorsOrderByBookCount() {
        return authorRepository.getAuthorByBookDESC()
        .stream()
        .map(author -> String.format("%s %s %d", author.getFirstName(), author.getLastName(),
                author.getBooks().size()))
                .collect(Collectors.toList());
    }
}
