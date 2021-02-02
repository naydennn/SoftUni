package Froggy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {

            int[] numbers = Arrays.stream(input.split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            Lake lake = new Lake(numbers);

            StringBuilder sb = new StringBuilder();
            for (Integer n:lake) {
                sb.append(n).append(", ");
            }
            System.out.println(sb.substring(0, sb.lastIndexOf(",")));


            input = scanner.nextLine();
        }

    }
}
