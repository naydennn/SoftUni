package bg.softuni.books.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author extends BaseEntity {

    private String name;
    private List<Book> books;

    public Author() {
    }

    public String getName() {
        return name;
    }

    public Author setName(String name) {
        this.name = name;
        return this;
    }

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    public List<Book> getBooks() {
        return books;
    }

    public Author setBooks(List<Book> books) {
        this.books = books;
        return this;
    }
}
