package geometry;

/**
 * Класс для представления треугольника
 */
public class Triangle {
    private Vertex v1;
    private Vertex v2;
    private Vertex v3;

    public Triangle(Vertex v1, Vertex v2, Vertex v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    public Vertex getV1() {
        return v1;
    }

    public Vertex getV2() {
        return v2;
    }

    public Vertex getV3() {
        return v3;
    }

    /**
     * Вычислить периметр треугольника
     */
    public double calculatePerimeter() {
        double side1 = v1.distanceTo(v2);
        double side2 = v2.distanceTo(v3);
        double side3 = v3.distanceTo(v1);
        return side1 + side2 + side3;
    }

    /**
     * Вычислить площадь треугольника по формуле Герона
     */
    public double calculateArea() {
        double side1 = v1.distanceTo(v2);
        double side2 = v2.distanceTo(v3);
        double side3 = v3.distanceTo(v1);
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public String toString() {
        return String.format("Triangle: %s, %s, %s", v1, v2, v3);
    }
}