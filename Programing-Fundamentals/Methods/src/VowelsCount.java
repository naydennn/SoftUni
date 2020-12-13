import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        int countOfVowels = getCountOfVowels(text);
        System.out.println(countOfVowels);
    }
    static int getCountOfVowels (String text) {
        int count = 0;
        for (int i = 0; i <text.length() ; i++) {
            if (text.charAt(i) == 65 || text.charAt(i) == 69 || text.charAt(i) == 73 || text.charAt(i) == 79 || text.charAt(i) == 85 ||
                    text.charAt(i) ==89 ||text.charAt(i) == 97 ||text.charAt(i) == 101 ||text.charAt(i) == 105 ||text.charAt(i) == 111 ||text.charAt(i) == 117 ||text.charAt(i) == 121) {
                count ++;
            }
        }
        return count;
    }
}
