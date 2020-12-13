import java.util.Scanner;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arrays = scanner.nextLine().split("\\|");

        String result ="";
        for (int i = arrays.length-1; i >=0; i--) {
            String[] current = arrays[i].split("\\s+");
            for (int j = 0; j <current.length ; j++) {
                if (!current[j].equals("")) {
                    result += current[j] + " ";
                }
            }
        }
        System.out.println(result.trim());
    }
}
