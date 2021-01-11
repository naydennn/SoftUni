import java.io.*;


public class CopyBytes {
    public static void main(String[] args) throws IOException {
        String inPath = "D:\\Java\\StreamsFilesAndDirectories\\input.txt";
        String outPath = "D:\\Java\\StreamsFilesAndDirectories\\03.CopyBytesOutput.txt";
        FileInputStream fileReader = new FileInputStream(inPath);
        FileOutputStream fileWriter = new FileOutputStream(outPath);

        int oneByte = fileReader.read();

        while (oneByte >= 0){
                if (oneByte == 32 || oneByte == 10) {
                    fileWriter.write(oneByte);
                }else {
                    fileWriter.write(String.valueOf(oneByte).getBytes());
                }
            oneByte = fileReader.read();
        }
        fileReader.close();
    }
}
