package shapes;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(2.0, 4.0);

        rectangle.calculatePerimeter();
        rectangle.calculateArea();
        System.out.println(rectangle.getArea());
        System.out.println(rectangle.getPerimeter());

        Circle circle = new Circle(5.0);

        circle.calculatePerimeter();
        circle.calculateArea();

        System.out.println(circle.getArea());
        System.out.println(circle.getPerimeter());
    }
}
