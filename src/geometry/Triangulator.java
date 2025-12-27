package geometry;

import java.util.List;

/**
 * Класс для выполнения триангуляции простым алгоритмом
 */
public class Triangulator {

    /**
     * Алгоритм триангуляции - fan triangulation
     * Соединяет первую вершину со всеми остальными
     */
    public static TriangulatedModel triangulateFan(BaseModel baseModel) {
        TriangulatedModel triangulatedModel = new TriangulatedModel(
                baseModel.getModelName() + " (триангулированная)"
        );

        List<Vertex> vertices = baseModel.getVertices();

        // Копируем все вершины из базовой модели
        for (Vertex vertex : vertices) {
            triangulatedModel.addVertex(vertex);
        }

        // Простейшая триангуляция: соединяем первую вершину с каждой парой соседних вершин
        if (vertices.size() >= 3) {
            Vertex firstVertex = vertices.get(0);

            for (int i = 1; i < vertices.size() - 1; i++) {
                Vertex v2 = vertices.get(i);
                Vertex v3 = vertices.get(i + 1);
                triangulatedModel.addTriangle(firstVertex, v2, v3);
            }

            // Если модель замкнутая, добавляем последний треугольник
            if (vertices.size() > 3) {
                Vertex lastVertex = vertices.get(vertices.size() - 1);
                Vertex secondVertex = vertices.get(1);
                triangulatedModel.addTriangle(firstVertex, lastVertex, secondVertex);
            }
        }

        return triangulatedModel;
    }

    /**
     * Алгоритм триангуляции для произвольного многоугольника
     */
    public static TriangulatedModel triangulatePolygon(BaseModel baseModel) {
        TriangulatedModel triangulatedModel = new TriangulatedModel(
                baseModel.getModelName() + " (триангулированный полигон)"
        );

        List<Vertex> vertices = baseModel.getVertices();

        // Копируем все вершины
        for (Vertex vertex : vertices) {
            triangulatedModel.addVertex(vertex);
        }

        // Для выпуклого многоугольника просто соединяем вершины по порядку
        if (vertices.size() >= 3) {
            for (int i = 1; i < vertices.size() - 1; i++) {
                Vertex v1 = vertices.get(0);
                Vertex v2 = vertices.get(i);
                Vertex v3 = vertices.get(i + 1);
                triangulatedModel.addTriangle(v1, v2, v3);
            }
        }

        return triangulatedModel;
    }

    /**
     * Триангуляция для набора точек (создание выпуклой оболочки)
     */
    public static TriangulatedModel triangulatePointSet(BaseModel baseModel) {
        TriangulatedModel triangulatedModel = new TriangulatedModel(
                baseModel.getModelName() + " (триангуляция точек)"
        );

        List<Vertex> vertices = baseModel.getVertices();

        // Копируем все вершины
        for (Vertex vertex : vertices) {
            triangulatedModel.addVertex(vertex);
        }

        // Простая триангуляция: создаем треугольники из каждых трех последовательных точек
        if (vertices.size() >= 3) {
            for (int i = 0; i < vertices.size() - 2; i += 3) {
                Vertex v1 = vertices.get(i);
                Vertex v2 = vertices.get(i + 1);
                Vertex v3 = vertices.get(i + 2);
                triangulatedModel.addTriangle(v1, v2, v3);
            }
        }

        return triangulatedModel;
    }
}