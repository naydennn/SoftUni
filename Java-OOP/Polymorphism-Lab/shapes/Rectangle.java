package shapes;

public class Rectangle extends Shape{

    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        setHeight(height);
        setWidth(width);
        this.calculateArea();
        this.calculatePerimeter();
    }


    private void setWidth(Double width) {
        this.width = width;
    }

    private void setHeight(Double height) {
        this.height = height;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    @Override
    protected void calculatePerimeter() {
        setArea(this.height * 2 + this.width * 2);

    }

    @Override
    protected void calculateArea() {
        setPerimeter(this.height * this.width);
    }
}
