import java.util.LinkedList;
import java.util.Queue;

// Class to represent a Graph22 using adjacency list
class Graph2 {
    int vertices;
    LinkedList<Integer>[] adjList;

    @SuppressWarnings("unchecked") Graph2(int vertices)
    {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; ++i)
            adjList[i] = new LinkedList<>();
    }

    // Function to add an edge to the Graph2
    void addEdge(int u, int v) { adjList[u].add(v); }

    // Function to perform Breadth First Search on a Graph2
    // represented using adjacency list
    void bfs(int startNode)
    {
        // Create a queue for BFS
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[vertices];

        // Mark the current node as visited and enqueue it
        visited[startNode] = true;
        queue.add(startNode);

        // Iterate over the queue
        while (!queue.isEmpty()) {
            // Dequeue a vertex from queue and print it
            int currentNode = queue.poll();
            System.out.print(currentNode + " ");

            // Get all adjacent vertices of the dequeued
            // vertex currentNode If an adjacent has not
            // been visited, then mark it visited and
            // enqueue it
            for (int neighbor : adjList[currentNode]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
    public class Main {
        public static void main(String[] args) {
            // Number of vertices in the Graph2
            int vertices = 5;

            // Create a Graph2
            Graph2 Graph2 = new Graph2(vertices);

            // Add edges to the Graph2
            Graph2.addEdge(0, 1);
            Graph2.addEdge(0, 2);
            Graph2.addEdge(1, 3);
            Graph2.addEdge(1, 4);
            Graph2.addEdge(2, 4);

            // Perform BFS traversal starting from vertex 0
            System.out.print(
                    "Breadth First Traversal starting from vertex 0: ");
            Graph2.bfs(0);
        }

    }
}
