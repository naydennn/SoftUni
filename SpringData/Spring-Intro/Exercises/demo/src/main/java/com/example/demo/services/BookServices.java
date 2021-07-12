package com.example.demo.services;


import java.io.IOException;
import java.util.List;

public interface BookServices {

    void seedBooks() throws IOException;

    List<String> getAllTitleOfBookAfterReleasedYear(int year);

    List<String> getAllAuthorNameOfBookBeforeReleasedYear(int year);

    List<String> getAllBookByAuthor(String fName, String lName);
}
