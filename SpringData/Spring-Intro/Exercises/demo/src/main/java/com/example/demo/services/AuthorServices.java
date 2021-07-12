package com.example.demo.services;


import com.example.demo.models.entity.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorServices {

    Author getRandomAuthor();

    void seedAuthors() throws IOException;

    List<String> getAllAuthorsOrderByBookCount();
}
