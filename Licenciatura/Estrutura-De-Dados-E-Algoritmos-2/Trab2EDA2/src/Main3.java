// Importa as classes necessárias para ler o input do usuário e para usar listas e mapas
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// Cria uma classe chamada Node2 que tem coordenadas x e y, um nó pai e um custo
class Node2 {
    int x, y;  // As coordenadas do nó
    Node2 parent;  // O nó pai, ou seja, o nó anterior
    double cost;  // O custo para chegar a este nó

    // Este é o construtor da classe Node2. Ele é chamado quando criamos um novo nó.
    // Ele recebe as coordenadas x e y, o nó pai e o custo para chegar a este nó.
    Node2(int x, int y, Node2 parent, double cost) {
        this.x = x;  // Define a coordenada x do nó
        this.y = y;  // Define a coordenada y do nó
        this.parent = parent;  // Define o nó pai
        this.cost = cost;  // Define o custo para chegar a este nó
    }
}

// Esta é a classe principal onde o programa começa
public class Main3 {
    // Cria um mapa para armazenar os nós. Cada nó é identificado por uma string que é a combinação de suas coordenadas x e y.
    static Map<String, Node2> graph = new HashMap<>();

    // Este método move o nó na direção especificada e cria um novo nó na posição deslocada.
    public static void move(String direction, Node2 Node2){
        int dx = 0, dy = 0;  // Variáveis para armazenar o deslocamento nas direções x e y
        // Dependendo da direção, atualiza o deslocamento
        switch (direction) {
            case "N":  // Para o norte, aumenta o y
                dy = 1;
                break;
            case "E":  // Para o leste, aumenta o x
                dx = 1;
                break;
            case "S":  // Para o sul, diminui o y
                dy = -1;
                break;
            case "W":  // Para o oeste, diminui o x
                dx = -1;
                break;
        }
        // Cria um novo nó na posição deslocada e adiciona ao grafo
        // O custo para chegar a este nó é o custo para chegar ao nó pai mais a distância euclidiana do nó pai a este nó
        Node2 newNode2 = new Node2(Node2.x + dx, Node2.y + dy, Node2, Node2.cost + Math.sqrt(dx*dx + dy*dy));
        graph.put(newNode2.x + "," + newNode2.y, newNode2);
    }

    // Este método retorna o caminho do nó atual até o nó inicial
    public static List<String> getPath(Node2 Node2) {
        List<String> path = new ArrayList<>();  // Cria uma lista para armazenar o caminho
        // Percorre o caminho do nó atual até o nó inicial
        while (Node2 != null) {
            path.add("(" + Node2.x + ", " + Node2.y + ")");  // Adiciona as coordenadas do nó ao caminho
            Node2 = Node2.parent;  // Vai para o nó pai
        }
        // Inverte o caminho para que comece no nó inicial
        Collections.reverse(path);
        return path;  // Retorna o caminho
    }

    // Este é o método principal onde o programa começa
    public static void main(String[] args) throws Exception {
        // Cria um BufferedReader para ler a entrada do usuário
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        // Lê o número de movimentos
        int numMovimentos = Integer.parseInt(input.readLine());

        // Lê a sequência de movimentos
        String sequence = input.readLine();

        // Cria o nó inicial e adiciona ao grafo
        Node2 start = new Node2(0, 0, null, 0);
        graph.put("0,0", start);

        // Move o nó de acordo com a sequência de movimentos
        Node2 current = start;
        for (char movement : sequence.toCharArray()) {
            move(String.valueOf(movement), current);
            current = graph.get((current.x + "," + current.y));
        }

        // Implementação do algoritmo de Dijkstra para encontrar o caminho mais curto de volta
        PriorityQueue<Node2> queue = new PriorityQueue<>(Comparator.comparingDouble(Node2 -> Node2.cost));
        queue.add(current);
        while (!queue.isEmpty()) {
            Node2 Node2 = queue.poll();
            if (Node2.x == start.x && Node2.y == start.y) {
                current = Node2;
                break;
            }
            move("N", Node2);
            move("E", Node2);
            move("S", Node2);
            move("W", Node2);
            for (Node2 nextNode2 : graph.values()) {
                if (nextNode2.cost < Node2.cost) {
                    queue.remove(nextNode2);
                    nextNode2.parent = Node2;
                    nextNode2.cost = Node2.cost;
                    queue.add(nextNode2);
                }
            }
        }

        // Obtém o caminho do nó atual até o nó inicial
        List<String> path = getPath(current);
        // Imprime o caminho
        for (String position : path) {
            System.out.println(position);
        }
    }
}
