import java.io.*;



public class CopyPictures {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Nayden\\Pictures\\msiWallpaper.jpg";
        FileInputStream reader = new FileInputStream(path);

        FileOutputStream writer = new FileOutputStream("copy-image.jpg");
        int read = reader.read();
        while (read != -1) {
            writer.write(read);
            read = reader.read();
        }

        writer.close();
        reader.close();
    }
}
