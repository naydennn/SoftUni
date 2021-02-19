package PointInFigure;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] coordinates = arrayParser(scanner);
        Point bottomLeft = createPoint(coordinates, 0, 1);
        Point topRight = createPoint(coordinates, 2, 3);

        Rectangle rectangle = new Rectangle(bottomLeft,topRight);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            int[] coordinate = arrayParser(scanner);
            System.out.println(rectangle.contains(createPoint(coordinate, 0, 1)));
        }
    }

    private static Point createPoint(int[] coordinates, int x, int y) {
        return new Point(coordinates[x], coordinates[y]);
    }

    private static int[] arrayParser(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
