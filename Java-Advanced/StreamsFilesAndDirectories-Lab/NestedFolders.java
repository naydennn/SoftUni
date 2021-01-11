import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class NestedFolders {
    public static void main(String[] args) {


        File file = new File("C:\\Users\\Nayden\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        Deque<File> queue = new ArrayDeque<>();
        queue.offer(file);
        int count = 1;
        while (!queue.isEmpty()) {
            File current = queue.poll();
            File[] files = current.listFiles();
            for (File f : files) {
                if (f.isDirectory()) {
                    queue.offer(f);
                    count++;
                }
            }
            System.out.println(current.getName());

        }
        System.out.println( count + " folders");
    }
}
