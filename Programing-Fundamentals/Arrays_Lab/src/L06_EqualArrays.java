import java.util.Scanner;

public class L06_EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        boolean isEqual = false;
        String firstLine = scanner.nextLine();
        String[] first = firstLine.split(" ");
        int[] firstArray = new int[first.length];

        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = Integer.parseInt(first[i]);
        }
        String secondLine = scanner.nextLine();
        String[] second = secondLine.split(" ");
        int[] secondArray = new int[first.length];
        for (int i = 0; i < secondArray.length; i++) {
            secondArray[i] = Integer.parseInt(second[i]);
        }

        for (int i = 0; i <firstArray.length ; i++) {
            if (firstArray[i] != secondArray[i]) {
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                return;
            } else {
                isEqual = true;
                sum += firstArray[i];
            }
        }
        if (isEqual) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }
    }
}

