package bg.sofruni.booksclient;

import bg.sofruni.booksclient.models.BookDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Init implements CommandLineRunner {

    public static final Logger LOGGER = LoggerFactory.getLogger(Init.class);

    private final RestTemplate restTemplate;

    public Init(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        ResponseEntity<BookDTO[]> books = restTemplate.getForEntity("http://localhost:8080/books",
                BookDTO[].class);

        if (books.hasBody()) {
            BookDTO[] booksBody = books.getBody();

            for (BookDTO bookDTO : booksBody) {
                LOGGER.info("A book that come from server - > " + bookDTO.toString());
            }
        }
    }
}
