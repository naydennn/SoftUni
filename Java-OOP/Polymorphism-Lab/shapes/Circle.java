package shapes;

public class Circle extends Shape {

    private Double radius;

    public Circle(Double radius) {
        setRadius(radius);
        this.calculateArea();
        this.calculatePerimeter();
    }

    public final Double getRadius() {
        return radius;
    }

    private void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    protected void calculatePerimeter() {
        setPerimeter(2 * Math.PI * radius);
    }

    @Override
    protected void calculateArea() {
        setArea(Math.PI * Math.pow(radius , 2));
    }
}
