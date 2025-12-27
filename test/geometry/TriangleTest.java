package geometry;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

    @Test
    void testPerimeter() {
        Triangle t = new Triangle(
                new Vertex(0, 0, 0),
                new Vertex(3, 0, 0),
                new Vertex(0, 4, 0)
        );

        assertEquals(12.0, t.calculatePerimeter(), 1e-6);
    }

    @Test
    void testArea() {
        Triangle t = new Triangle(
                new Vertex(0, 0, 0),
                new Vertex(3, 0, 0),
                new Vertex(0, 4, 0)
        );

        assertEquals(6.0, t.calculateArea(), 1e-6);
    }
}
