package geometry;

import java.util.ArrayList;
import java.util.List;

/**
 * Базовый класс для всех моделей
 */
public abstract class BaseModel {
    protected List<Vertex> vertices;
    protected String modelName;

    public BaseModel() {
        this.vertices = new ArrayList<>();
        this.modelName = "Unnamed Model";
    }

    public BaseModel(String modelName) {
        this.vertices = new ArrayList<>();
        this.modelName = modelName;
    }

    /**
     * Добавить вершину в модель
     */
    public void addVertex(Vertex vertex) {
        vertices.add(vertex);
    }

    /**
     * Добавить вершину по координатам
     */
    public void addVertex(double x, double y, double z) {
        vertices.add(new Vertex(x, y, z));
    }

    /**
     * Получить количество вершин
     */
    public int getVertexCount() {
        return vertices.size();
    }

    /**
     * Получить вершину по индексу
     */
    public Vertex getVertex(int index) {
        if (index >= 0 && index < vertices.size()) {
            return vertices.get(index);
        }
        return null;
    }

    /**
     * Получить список всех вершин
     */
    public List<Vertex> getVertices() {
        return new ArrayList<>(vertices);
    }

    /**
     * Установить имя модели
     */
    public void setModelName(String name) {
        this.modelName = name;
    }

    /**
     * Получить имя модели
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * Абстрактный метод для отображения информации о модели
     */
    public abstract void displayInfo();

    /**
     * Абстрактный метод для вычисления периметра/границы
     */
    public abstract double calculatePerimeter();

    /**
     * Вывести координаты всех вершин
     */
    public void printVertices() {
        System.out.println("Вершины модели '" + modelName + "':");
        for (int i = 0; i < vertices.size(); i++) {
            System.out.println("  " + i + ": " + vertices.get(i));
        }
    }
}