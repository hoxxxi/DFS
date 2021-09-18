import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GraphTest {
    @Test
    public void testIsCyclical() {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(4, 3);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        assertFalse(graph.isCyclical(), "The graph has no cycles");
        graph.addEdge(7, 5);
        assertTrue(graph.isCyclical(), "The graph has a cycle in the following pattern of vertices: 5->6->7->5");
    }
}
