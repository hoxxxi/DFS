import java.util.*;

public class Graph {
    int verticesCount;
    Map<Integer, List<Integer>> adjacencyMap;

    /**
     * Assumes vertices are named after the numbers from 0 to V-1 for simplicity
     * @param verticesCount number of vertices in graph
     */
    public Graph(int verticesCount) {
        this.verticesCount = verticesCount;
        adjacencyMap = new HashMap<>(verticesCount);
        for(int i = 0; i< verticesCount; i++) {
            adjacencyMap.put(i,new LinkedList<>());
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyMap.get(source).add(destination);
    }

    public boolean isCyclical(){
        Stack<Integer> parentStack = new Stack<>();
        Map<Integer, Boolean> visitedMap = new HashMap<>();
        for(int key: adjacencyMap.keySet())
            visitedMap.put(key, false);

        for(int root: adjacencyMap.keySet()) {
            parentStack.push(root);
            visitedMap.put(root, true);
            while (!parentStack.empty()) {
                List<Integer> list = adjacencyMap.get(parentStack.peek());
                int nodesCounter = 0;
                for (int node : list) {
                    if (!visitedMap.get(node)) {
                        parentStack.push(node);
                        visitedMap.put(node, true);
                        break;
                    } else {
                        if (parentStack.contains(node))
                            return true;
                        nodesCounter++;
                    }
                }
                if (nodesCounter == list.size()) {
                    parentStack.pop();
                }
            }
        }
        return false;
    }
}
