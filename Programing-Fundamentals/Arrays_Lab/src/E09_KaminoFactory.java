import java.util.Arrays;
import java.util.Scanner;

public class E09_KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int[] bestArray = new int[num];
        int bestIndex = 0;
        int currentCount = 0;
        int bestSum = 0;
        int bestCount = 0;

        while (!input.equals("Clone them!")) {
            int[] arrays = Arrays.stream(input.split("!")).mapToInt(value -> Integer.parseInt(value))
                    .toArray();
            int index = 0;
            int sum = 0;
            int currentSum = Integer.MIN_VALUE;
            int minIndex = Integer.MAX_VALUE;
            int maxCount = Integer.MIN_VALUE;

            for (int i = 0; i <arrays.length ; i++) {
                if (arrays[i] == 1) {
                    currentCount++;
                    index = arrays[i];
                    if (index < minIndex) {
                        minIndex = index;
                    }
                } else {
                    currentCount = 0;
                }
            }
            for (int i = 0; i <arrays.length ; i++) {
                currentSum += arrays[i];
            }


            input = scanner.nextLine();
            }


        System.out.printf("Best DNA sample %d with sum: %d.", bestIndex, bestSum);
        System.out.println();
        for (int i = 0; i <bestArray.length ; i++) {
            System.out.print(bestArray[i] + " ");
        }
    }
}
