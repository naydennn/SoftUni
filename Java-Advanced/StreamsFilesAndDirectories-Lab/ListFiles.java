import java.io.File;

public class ListFiles {
    public static void main(String[] args) {


        File file = new File("C:\\Users\\Nayden\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isFile()) {
                System.out.println(file1.getName() + ": [" + file1.length() + "]");
            }
        }
    }
}
