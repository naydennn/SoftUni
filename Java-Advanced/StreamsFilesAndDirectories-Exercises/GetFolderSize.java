import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {
        String path = "C:\\Users\\Nayden\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File file = new File(path);
        int sum = 0;
        for (File f : file.listFiles()) {
            sum += f.length();
        }
        System.out.println("Folder size: " + sum);
    }
}
