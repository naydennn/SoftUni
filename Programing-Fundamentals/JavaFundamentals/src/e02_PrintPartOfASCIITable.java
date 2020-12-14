import java.util.Scanner;

public class e02_PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstChar = Integer.parseInt(scanner.nextLine());
        int secondChar = Integer.parseInt(scanner.nextLine());

        for (int i = firstChar; i <= secondChar ; i++) {
            System.out.print((char)i + " ");
        }
    }
}
