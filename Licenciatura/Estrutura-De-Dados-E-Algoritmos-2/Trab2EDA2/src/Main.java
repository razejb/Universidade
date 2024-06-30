import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

// Classe principal que contém o método main.
class Main {
    // Método principal que pode lançar uma IOException.
    public static void main(String[] args) throws IOException {
        // Cria um BufferedReader para ler a entrada do usuário.
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        // Lê a primeira linha da entrada e converte para inteiro, representando o número de movimentos.
        int L = Integer.parseInt(input.readLine());
        // Cria um array para armazenar os movimentos.
        String[] movements = new String[L];
        // Loop para ler os movimentos do usuário.
        for (int i = 0; i < L; i++) {
            movements[i] = input.readLine();
            // Se um movimento lido for nulo, lança uma exceção.
            if(movements[i] == null){
                throw new IOException("Número insuficiente de linhas");
            }
            // Se o movimento exceder 80 caracteres, lança uma exceção.
            if (movements[i].length() > 80) {
                throw new IOException("Linha excede o limite de 80 caracteres");
            }
        }
        // Cria um novo objeto Graph.
        Graph graph = new Graph();
        // Chama o método para construir o grafo com base nos movimentos.
        buildGraph(graph, movements);
        // Resolve o grafo para encontrar a distância.
        graph.resolve();
        // Imprime a distância do ponto de partida.
        System.out.println(graph.Start.distance);
        // Fecha o BufferedReader.
        input.close();
    }

    // Método para construir o grafo com base nos movimentos.
    static void buildGraph(Graph graph, String[] movements) {
        // Adiciona o nó inicial ao grafo e define como ponto de partida.
        Node current = graph.addNode(0, 0);
        graph.Start = current;
        // Loop para processar cada linha de movimento.
        for (String line : movements) {
            // Loop para processar cada movimento individualmente.
            for (char move : line.toCharArray()) {
                // Variáveis temporárias para a posição atual.
                int x = current.x;
                int y = current.y;
                // Switch para determinar a direção do movimento.
                switch (move) {
                    case 'N': y++; break; // Move para o norte.
                    case 'S': y--; break; // Move para o sul.
                    case 'E': x++; break; // Move para o leste.
                    case 'W': x--; break; // Move para o oeste.
                }
                // Adiciona o próximo nó ao grafo e atualiza a posição atual.
                Node next = graph.addNode(x, y); //Esta linha adiciona um novo nó ao grafo nas coordenadas (x, y). O novo nó é armazenado na variável next
                current.addNeighbor(next); //Aqui, o nó next é adicionado à lista de vizinhos do nó current. Isto significa que existe uma conexão direta do nó current para o nó next no grafo.
                next.addNeighbor(current); //Similarmente, o nó current é adicionado à lista de vizinhos do nó next. Isso significa que também existe uma conexão direta do nó next para o nó current no grafo. Em outras palavras, a conexão entre current e next é bidirecional.
                current = next;  //Finalmente, a variável current é atualizada para ser o nó next. Isso prepara o código para o próximo movimento, que será relativo ao nó next.
            }
        }
        // Define o último nó como ponto final.
        graph.End = current;
    }
}

// Classe para representar o grafo.
class Graph {
    // Mapa para armazenar os nós com base em suas coordenadas.
    HashMap<String, Node> Map = new HashMap<>(); //Esta linha cria um HashMap chamado Map que é usado para armazenar os nós do grafo. As chaves do mapa são strings que representam as coordenadas dos nós, e os valores são os próprios nós.
    Node Start, End; // Nós para o início e fim do caminho.

    // Método para adicionar ou obter um nó com base em suas coordenadas (x, y).
    Node addNode(int x, int y) {
        String key = x + " " + y; //Esta linha cria uma chave para o mapa Map concatenando as coordenadas x e y com um espaço entre elas.
        // Obtém o nó do mapa ou cria um novo se não existir.
        Node node = Map.getOrDefault(key, new Node(x, y));
        /*
        A linha Node node = Map.getOrDefault(key, new Node(x, y)); usa o método getOrDefault do objeto Map, que é uma instância da classe HashMap.

        O método getOrDefault é usado para obter o valor de uma chave específica do mapa. Se a chave existir no mapa, o método retorna o valor correspondente. Se a chave não existir no mapa, o método retorna um valor padrão fornecido.

        Nesta linha, a chave é a string key, que representa as coordenadas do nó. O valor padrão é um novo nó criado com as coordenadas (x, y).

        Portanto, se o mapa Map já tiver um nó nas coordenadas (x, y), esse nó será retornado e armazenado na variável node. Se não houver um nó nessas coordenadas, um novo nó será criado, adicionado ao mapa e retornado.
         */


        Map.put(key, node); //Esta linha adiciona o nó ao mapa Map com a chave correspondente.
        return node; //O nó é retornado
    }

    // Método para resolver o grafo e encontrar a distância mínima de todos os nós até o fim.
    void resolve() {
        // Fila para armazenar os nós a serem processados.
        Queue<Node> queue = new LinkedList<>();
        /*
        Queue é conhecido como estrutura de dados “FIFO” (First-In-First-Out). O <Node> indica que essa fila será usada para armazenar objetos do tipo Node.

        new LinkedList<>(): LinkedList é uma das classes no Java que implementa a interface Queue. Está sendo usada aqui para criar uma nova instância de uma fila. O operador new é usado para criar essa nova instância.


        O motivo pelo qual uma Queue (e especificamente uma LinkedList) é usada aqui é porque ela permite uma exploração eficiente do grafo em largura (Breadth-First Search - BFS).
        A BFS começa a partir de um nó raiz e visita todos os nós vizinhos antes de passar para os vizinhos dos vizinhos. A Queue é perfeita para isso porque garante que nós são
        processados na ordem em que são descobertos.

         */
        // Marca o nó final como visitado e define sua distância como 0.
        this.End.visited = true; //Esta linha marca o nó final como visitado. No contexto deste código, “visitado” significa que o nó foi processado ou, em outras palavras, que todas as suas propriedades necessárias foram definidas e ele foi adicionado à fila para processamento. Isso é feito para evitar o processamento repetido do mesmo nó.

        this.End.distance = 0; //Esta linha define a distância do nó final como 0. A distância aqui representa o número mínimo de passos necessários para chegar a um nó a partir do nó final. Como estamos no nó final, a distância é obviamente 0.

        queue.add(this.End); /* Esta linha adiciona o nó final à fila de nós a serem processados. A fila é usada para realizar uma busca em largura (Breadth-First Search - BFS) no grafo.
                             A BFS é um algoritmo que começa a partir de um nó raiz e visita todos os nós vizinhos antes de passar para os vizinhos dos vizinhos.
                             Portanto, ao adicionar o nó final à fila, estamos a preparar o algoritmo para começar a processar a partir do nó final.
                             */

        // Loop enquanto houver nós na fila.
        while (!queue.isEmpty()) {
            Node u = queue.remove();
            // Loop para visitar todos os vizinhos do nó atual.
            for (Node v : u.neighbors) { //Este é um loop interno que percorre todos os vizinhos do nó atual u.
                // Se o vizinho ainda não foi visitado, marca como visitado e atualiza a distância.
                if (!v.visited) {
                    v.visited = true;
                    v.distance = u.distance + 1; //Esta linha atualiza a distância do vizinho v. A nova distância é a distância do nó atual u mais um. Isso é baseado na suposição de que cada aresta no grafo tem peso 1.
                    queue.add(v);
                }
            }
        }
    }
}

// Classe para representar um nó no grafo.
class Node {
    int x, y; // Coordenadas do nó.
    int distance = Integer.MAX_VALUE; //Esta é a distância do nó até o fim. É inicializada com o valor máximo de um inteiro. Isso é feito porque no início, antes de calcular as distâncias reais, queremos que todas as distâncias sejam infinitas.
    List<Node> neighbors = new ArrayList<>(); //Esta é uma lista de todos os nós vizinhos. Um vizinho é um nó que pode ser alcançado diretamente a partir do nó atual.
    boolean visited; // Indica se o nó foi visitado.

    // Construtor para criar um nó com coordenadas específicas.
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Método para adicionar um vizinho à lista de vizinhos.
    void addNeighbor(Node neighbor) {

        this.neighbors.add(neighbor);
    }
}
