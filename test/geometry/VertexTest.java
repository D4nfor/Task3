package geometry;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VertexTest {

    @Test
    void testDistanceTo() {
        Vertex v1 = new Vertex(0, 0, 0);
        Vertex v2 = new Vertex(3, 4, 0);

        assertEquals(5.0, v1.distanceTo(v2), 1e-6);
    }

    @Test
    void testEquals() {
        Vertex v1 = new Vertex(1, 2, 3);
        Vertex v2 = new Vertex(1, 2, 3);

        assertEquals(v1, v2);
    }
}
