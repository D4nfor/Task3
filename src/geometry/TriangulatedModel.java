package geometry;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс триангулированной модели, наследующий от BaseModel
 */
public class TriangulatedModel extends BaseModel {
    private List<Triangle> triangles;

    public TriangulatedModel() {
        super();
        this.triangles = new ArrayList<>();
    }

    public TriangulatedModel(String modelName) {
        super(modelName);
        this.triangles = new ArrayList<>();
    }

    /**
     * Добавить треугольник в модель
     */
    public void addTriangle(Triangle triangle) {
        triangles.add(triangle);
    }

    /**
     * Добавить треугольник по вершинам
     */
    public void addTriangle(Vertex v1, Vertex v2, Vertex v3) {
        triangles.add(new Triangle(v1, v2, v3));
    }

    /**
     * Получить количество треугольников
     */
    public int getTriangleCount() {
        return triangles.size();
    }

    /**
     * Получить треугольник по индексу
     */
    public Triangle getTriangle(int index) {
        if (index >= 0 && index < triangles.size()) {
            return triangles.get(index);
        }
        return null;
    }

    /**
     * Получить список всех треугольников
     */
    public List<Triangle> getTriangles() {
        return new ArrayList<>(triangles);
    }

    @Override
    public void displayInfo() {
        System.out.println("Триангулированная модель: " + modelName);
        System.out.println("Количество вершин: " + getVertexCount());
        System.out.println("Количество треугольников: " + getTriangleCount());
        System.out.println("Общая площадь поверхности: " + calculateSurfaceArea() + " кв.ед.");
        System.out.println("Периметр модели: " + calculatePerimeter() + " ед.");
    }

    @Override
    public double calculatePerimeter() {
        // Для триангулированной модели периметр - сумма периметров всех треугольников
        double totalPerimeter = 0;
        for (Triangle triangle : triangles) {
            totalPerimeter += triangle.calculatePerimeter();
        }
        return totalPerimeter;
    }

    /**
     * Вычислить общую площадь поверхности модели
     */
    public double calculateSurfaceArea() {
        double totalArea = 0;
        for (Triangle triangle : triangles) {
            totalArea += triangle.calculateArea();
        }
        return totalArea;
    }

    /**
     * Вывести информацию о всех треугольниках
     */
    public void printTriangles() {
        System.out.println("Треугольники модели '" + modelName + "':");
        for (int i = 0; i < triangles.size(); i++) {
            Triangle triangle = triangles.get(i);
            System.out.println("  " + i + ": " + triangle);
            System.out.println("    Площадь: " + String.format("%.2f", triangle.calculateArea()) +
                    ", Периметр: " + String.format("%.2f", triangle.calculatePerimeter()));
        }
    }

    /**
     * Очистить все треугольники
     */
    public void clearTriangles() {
        triangles.clear();
    }
}