import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = input.readLine().split(" ");
        int locais = Integer.parseInt(firstLine[0]);
        int correntes = Integer.parseInt(firstLine[1]);
        int viagens = Integer.parseInt(firstLine[2]);

        Graph graph = new Graph(locais);
        for(int i = 0; i < correntes; i++) {
            String[] edgeParts = input.readLine().split(" ");
            int origem = Integer.parseInt(edgeParts[0]);
            int destino = Integer.parseInt(edgeParts[1]);
            int peso = Integer.parseInt(edgeParts[2]);
            graph.addEdge(origem, destino, peso, true);
            graph.addEdge(destino, origem, peso, false);
        }

        for(int i = 0; i < viagens; i++) {
            String[] travelParts = input.readLine().split(" ");
            int partida = Integer.parseInt(travelParts[0]);
            int chegada = Integer.parseInt(travelParts[1]);
            int[] distances = graph.dijkstra(partida);
            System.out.println(distances[chegada]);
        }

        input.close();
    }
}

class Graph {
    public static final int INFINITY = Integer.MAX_VALUE;
    private static final int NONE = -1;
    private HashMap<Integer, Node> Map = new HashMap<>();
    private int size;

    public Graph(int size) {
        this.size = size;
    }

    public void addEdge(int origem, int destino, int peso, boolean favorCorrente) {
        Node nodeOrigem = this.addNode(origem);
        Node nodeDestino = this.addNode(destino);
        // Se a aresta estiver a favor da corrente, o peso é ajustado.
        int pesoAjustado = favorCorrente ? 0 : peso;
        nodeOrigem.addNeighbor(nodeDestino, pesoAjustado);
        // Se a corrente estiver contra, adiciona-se a aresta inversa com o peso original.
        if (!favorCorrente) {
            nodeDestino.addNeighbor(nodeOrigem, peso);
        }
    }

    private Node addNode(int id) {
        return Map.computeIfAbsent(id, k -> new Node(id));
    }

    public int[] dijkstra(int s) {
        int[] d = new int[size];
        int[] p = new int[size];
        for (int v = 0; v < size; ++v) {
            d[v] = INFINITY;
            p[v] = NONE;
        }
        d[s] = 0;
        PriorityQueue<KeyValuePair<Integer, Integer>> Q = new PriorityQueue<>(Comparator.comparingInt(a -> a.key));
        Q.add(new KeyValuePair<>(0, s));
        while (!Q.isEmpty()) {
            KeyValuePair<Integer, Integer> u = Q.remove();
            if (u.key > d[u.value])
                continue;
            Node uNode = Map.get(u.value);
            for (Edge e : uNode.neighbors) {
                int v = e.destination.id;
                if (d[u.value] + e.weight < d[v]) {
                    d[v] = d[u.value] + e.weight;
                    p[v] = u.value;
                    Q.add(new KeyValuePair<>(d[v], v));
                }
            }
        }
        return d;
    }
}

class Node {
    int id;
    List<Edge> neighbors = new ArrayList<>();

    public Node(int id) {
        this.id = id;
    }

    public void addNeighbor(Node neighbor, int weight) {
        this.neighbors.add(new Edge(this, neighbor, weight));
    }
}

class Edge {
    Node source;
    Node destination;
    int weight;

    public Edge(Node source, Node destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

class KeyValuePair<K, V> {
    K key;
    V value;

    public KeyValuePair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
