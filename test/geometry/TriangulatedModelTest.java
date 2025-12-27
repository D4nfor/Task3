package geometry;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangulatedModelTest {

    @Test
    void testAddTriangle() {
        TriangulatedModel model = new TriangulatedModel("Test");

        model.addTriangle(
                new Vertex(0, 0, 0),
                new Vertex(1, 0, 0),
                new Vertex(0, 1, 0)
        );

        assertEquals(1, model.getTriangleCount());
    }

    @Test
    void testSurfaceArea() {
        TriangulatedModel model = new TriangulatedModel();

        model.addTriangle(
                new Vertex(0, 0, 0),
                new Vertex(3, 0, 0),
                new Vertex(0, 4, 0)
        );

        assertEquals(6.0, model.calculateSurfaceArea(), 1e-6);
    }
}
