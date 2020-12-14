import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        int x = text.lastIndexOf('\\');
        int y = text.lastIndexOf('.');
        String fileName = text.substring(x+1, y);
        String extensionName = text.substring(y+1);
        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + extensionName);
    }
}
