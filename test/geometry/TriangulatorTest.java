package geometry;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangulatorTest {

    @Test
    void testFanTriangulation() {
        BaseModel polygon = new BaseModel("Triangle") {
            @Override
            public void displayInfo() {}

            @Override
            public double calculatePerimeter() {
                return 0;
            }
        };

        polygon.addVertex(0, 0, 0);
        polygon.addVertex(1, 0, 0);
        polygon.addVertex(0, 1, 0);

        TriangulatedModel result = Triangulator.triangulateFan(polygon);

        assertEquals(1, result.getTriangleCount());
        assertEquals(3, result.getVertexCount());
    }

    @Test
    void testPolygonTriangulation() {
        BaseModel polygon = new BaseModel("Quad") {
            @Override
            public void displayInfo() {}

            @Override
            public double calculatePerimeter() {
                return 0;
            }
        };

        polygon.addVertex(0, 0, 0);
        polygon.addVertex(1, 0, 0);
        polygon.addVertex(1, 1, 0);
        polygon.addVertex(0, 1, 0);

        TriangulatedModel result = Triangulator.triangulatePolygon(polygon);

        assertEquals(2, result.getTriangleCount());
    }
}
