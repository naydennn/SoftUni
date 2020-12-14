import java.util.Scanner;

public class Articles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        Article article = new Article(input[0], input[1], input[2]);
        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < num; i++) {
            String[] command = scanner.nextLine().split(": ");
            String token = command[0];
            switch (token) {
                case "Edit":
                    article.setContent(command[1]);
                    break;
                case "ChangeAuthor":
                    article.setAuthor(command[1]);
                    break;
                case "Rename":
                    article.setTittle(command[1]);
                    break;
            }
        }
        System.out.println(article);
    }

    static class Article {
        String tittle;
        String content;
        String author;

        public void setTittle(String tittle) {
            this.tittle = tittle;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        Article(String tittle, String content, String author) {
            this.tittle = tittle;
            this.content = content;
            this.author = author;
        }

        @Override
        public String toString() {
            return String.format("%s - %s: %s", this.tittle, this.content, this.author);
        }
    }
}
