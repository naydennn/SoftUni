import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Articles2 {
    public  static class Article {
        String title;
        String content;
        String author;

        Article (String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public String getAuthor() {
            return author;
        }

        @Override
        public String toString() {
            return String.format("%s - %s: %s", getTitle(), getContent(), getAuthor());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Article> list = new ArrayList<>();
        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <num ; i++) {
            String[] input = scanner.nextLine().split(", ");
            Article article = new Article(input[0], input[1], input[2]);
            list.add(article);
        }
        String filter = scanner.nextLine();

        switch (filter) {
            case "author":
                list.stream().sorted((p1,p2) -> p1.getAuthor().compareTo(p2.getAuthor())).forEach(article -> System.out.println(article));
                break;
            case "content":
                list.stream().sorted((p1,p2) -> p1.getContent().compareTo(p2.getContent())).forEach(article -> System.out.println(article));
                break;
            case "title":
                list.stream().sorted((p1,p2) -> p1.getTitle().compareTo(p2.getTitle())).forEach(article -> System.out.println(article));
                break;
        }

    }
}
