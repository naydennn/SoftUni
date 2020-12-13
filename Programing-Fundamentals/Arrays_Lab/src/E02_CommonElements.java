import java.util.Scanner;

public class E02_CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstLine = scanner.nextLine();
        String secondLine = scanner.nextLine();

        String[] firstArray = firstLine.split(" ");
        String[] firstArrayElements = new String[firstArray.length];
        for (int i = 0; i < firstArrayElements.length; i++) {
            firstArrayElements[i] = firstArray[i];
        }

        String[] secondArray = secondLine.split(" ");
        String[] secondArrayElements = new String[secondArray.length];
        for (int i = 0; i < secondArrayElements.length; i++) {
            secondArrayElements[i] = secondArray[i];
        }

        for (int i = 0; i < secondArrayElements.length; i++) {
            for (int j = 0; j < firstArrayElements.length; j++) {

                if (secondArrayElements[i].equals(firstArrayElements[j])) {
                    System.out.print(secondArrayElements[i] + " ");
                }
            }
        }
    }
}
