package bg.softuni.books.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book extends BaseEntity{

    private String title;
    private String isbn;
    private Author author;

    public Book() {
    }


    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public Book setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Author getAuthor() {
        return author;
    }

    public Book setAuthor(Author author) {
        this.author = author;
        return this;
    }
}
