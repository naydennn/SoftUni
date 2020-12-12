import java.util.Scanner;

public class AreaOfFigures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String shape = scanner.nextLine() ;
        double area = 0.0;

        if (shape.equals("square")) {
            double side = Double.parseDouble(scanner.nextLine());
             area = side * side;
        } else if (shape.equals("rectangle")) {
            double side = Double.parseDouble(scanner.nextLine());
            double side2 = Double.parseDouble(scanner.nextLine());
             area = side * side2;
        } else if (shape.equals("circle")) {
            double radius = Double.parseDouble(scanner.nextLine());
            area = (radius * radius) * Math.PI;
        } else if (shape.equals("triangle")) {
            double side = Double.parseDouble(scanner.nextLine());
            double weight = Double.parseDouble(scanner.nextLine());
            area = (side * weight) / 2;
        }
        System.out.printf("%.3f", area);
    }
}
