package dmit2015.model;

public class Rectangle {
    private double length;
    private double width;

    public void setLength(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public Rectangle() {
        length = 1;
        width = 1;
    }

    public double area() {
        return length * width;
    }

    public double perimeter() {
        return 2 * (length + width);
    }

    public static void main(String[] args) {
        Rectangle currentRectangle = new Rectangle();

        currentRectangle.setLength(5.7);
        currentRectangle.setWidth(5);

        System.out.printf("Length: %.2f, Width: %.2f, Area: %.2f, Perimeter: %.2f%n",
                currentRectangle.getLength(),
                currentRectangle.getWidth(),
                currentRectangle.area(),
                currentRectangle.perimeter());
    }
}