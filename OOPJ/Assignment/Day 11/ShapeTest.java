abstract class Shape {
    protected String shapeName;

    public Shape(String shapeName) {
        this.shapeName = shapeName;
    }

    public String getShapeName() {
        return shapeName;
    }

    abstract double calculateArea();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        super("Rectangle");
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return length * width;
    }
}

public class ShapeTest {
    public static void main(String[] args) {
        Shape circle = new Circle(5.0);
        System.out.println("Shape: " + circle.getShapeName() + ", Area: " + circle.calculateArea());

        Shape rectangle = new Rectangle(4.0, 6.0);
        System.out.println("Shape: " + rectangle.getShapeName() + ", Area: " + rectangle.calculateArea());
    }
}
