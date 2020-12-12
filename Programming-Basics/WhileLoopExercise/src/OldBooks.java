import java.util.Scanner;

public class OldBooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String favBook = scanner.nextLine();
        String book = scanner.nextLine();
        int counter = 0;

        while (!book.equals("No More Books") ) {
            if (favBook.equals(book)) {
                System.out.printf("You checked %d books and found it.", counter);
                return;
            }
            book = scanner.nextLine();
            counter++;
        }
        System.out.printf("The book you search is not here!%n");
        System.out.printf("You checked %d books.", counter);
    }
}
