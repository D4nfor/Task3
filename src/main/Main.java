package main;

import geometry.*;

/**
 * Основной класс для демонстрации работы модуля триангуляции
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Демонстрация модуля триангуляции ===\n");

        // Создаем базовую модель (многоугольник)
        BaseModel polygon = new BaseModel("Шестиугольник") {
            @Override
            public void displayInfo() {
                System.out.println("Базовая модель: " + modelName);
                System.out.println("Количество вершин: " + getVertexCount());
                System.out.println("Периметр (приблизительный): " + String.format("%.2f", calculatePerimeter()) + " ед.");
            }

            @Override
            public double calculatePerimeter() {
                // Простой расчет периметра для выпуклого многоугольника
                if (vertices.size() < 2) return 0;

                double perimeter = 0;
                for (int i = 0; i < vertices.size(); i++) {
                    Vertex current = vertices.get(i);
                    Vertex next = vertices.get((i + 1) % vertices.size());
                    perimeter += current.distanceTo(next);
                }
                return perimeter;
            }
        };

        // Добавляем вершины для шестиугольника (в плоскости XY)
        polygon.addVertex(0, 0, 0);
        polygon.addVertex(2, 0, 0);
        polygon.addVertex(3, 1, 0);
        polygon.addVertex(2, 2, 0);
        polygon.addVertex(0, 2, 0);
        polygon.addVertex(-1, 1, 0);

        // Выводим информацию о базовой модели
        polygon.displayInfo();
        polygon.printVertices();

        System.out.println("\n--- Выполняем триангуляцию веером ---");
        TriangulatedModel fanTriangulated = Triangulator.triangulateFan(polygon);
        fanTriangulated.displayInfo();
        fanTriangulated.printTriangles();

        System.out.println("\n--- Выполняем триангуляцию полигона ---");
        TriangulatedModel polygonTriangulated = Triangulator.triangulatePolygon(polygon);
        polygonTriangulated.displayInfo();

        System.out.println("\n=== Демонстрация с произвольным набором точек ===");

        // Создаем другую базовую модель с произвольными точками
        BaseModel pointCloud = new BaseModel("Облако точек") {
            @Override
            public void displayInfo() {
                System.out.println("Облако точек: " + modelName);
                System.out.println("Количество точек: " + getVertexCount());
            }

            @Override
            public double calculatePerimeter() {
                // Для облака точек периметр не определен
                return 0;
            }
        };

        // Добавляем случайные точки
        pointCloud.addVertex(0, 0, 0);
        pointCloud.addVertex(1, 0, 1);
        pointCloud.addVertex(0, 1, 0);
        pointCloud.addVertex(1, 1, 1);
        pointCloud.addVertex(0.5, 0.5, 0);
        pointCloud.addVertex(0.7, 0.3, 1);

        pointCloud.displayInfo();

        System.out.println("\n--- Триангуляция набора точек ---");
        TriangulatedModel cloudTriangulated = Triangulator.triangulatePointSet(pointCloud);
        cloudTriangulated.displayInfo();
        cloudTriangulated.printTriangles();

        System.out.println("\n=== Демонстрация работы с треугольниками ===");

        // Создаем отдельный треугольник
        Triangle testTriangle = new Triangle(
                new Vertex(0, 0, 0),
                new Vertex(3, 0, 0),
                new Vertex(0, 4, 0)
        );

        System.out.println("Тестовый треугольник: " + testTriangle);
        System.out.println("Площадь: " + String.format("%.2f", testTriangle.calculateArea()));
        System.out.println("Периметр: " + String.format("%.2f", testTriangle.calculatePerimeter()));

        System.out.println("\n=== Демонстрация наследования ===");

        // Показываем, что TriangulatedModel наследует от BaseModel
        System.out.println("TriangulatedModel является наследником BaseModel: " +
                (fanTriangulated instanceof BaseModel));

        // Демонстрация полиморфизма
        BaseModel[] models = new BaseModel[2];
        models[0] = polygon;  // Базовая модель
        models[1] = fanTriangulated;  // Триангулированная модель

        System.out.println("\nПолиморфный вызов displayInfo():");
        for (BaseModel model : models) {
            model.displayInfo();
            System.out.println();
        }
    }
}