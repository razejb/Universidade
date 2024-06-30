import java.util.*;

public class Main2 {
    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int L = scanner.nextInt();
        scanner.nextLine();
        String[] movements = new String[L];
        for (int i = 0; i < L; i++) {
            movements[i] = scanner.nextLine();
        }
        printForwardPath(movements);
        minMovements(movements);
    }

    static void printForwardPath(String[] movements) {
        System.out.println("Forward path:");
        Map<Character, Node> directions = new HashMap<>();
        directions.put('N', new Node(0, 1));
        directions.put('S', new Node(0, -1));
        directions.put('E', new Node(1, 0));
        directions.put('W', new Node(-1, 0));

        Node current = new Node(0, 0);
        System.out.println("Start at (" + current.x + ", " + current.y + ")");

        for (String line : movements) {
            for (char move : line.toCharArray()) {
                Node direction = directions.get(move);
                current = new Node(current.x + direction.x, current.y + direction.y);
                System.out.println("Move " + move + " to (" + current.x + ", " + current.y + ")");
            }
        }
    }

    static void minMovements(String[] movements) {
        System.out.println("Backward path:");
        Map<Character, Node> directions = new HashMap<>();
        directions.put('N', new Node(0, 1));
        directions.put('S', new Node(0, -1));
        directions.put('E', new Node(1, 0));
        directions.put('W', new Node(-1, 0));

        Node start = new Node(0, 0);
        Node current = new Node(0, 0);

        List<Node> path = new ArrayList<>();
        path.add(start);

        for (String line : movements) {
            for (char move : line.toCharArray()) {
                Node direction = directions.get(move);
                Node next = new Node(current.x + direction.x, current.y + direction.y);
                current = next;
                path.add(next);
            }
        }

        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> parent = new HashMap<>();
        queue.offer(current);
        parent.put(current, null);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.equals(start))
                break;
            for (Node dir : directions.values()) {
                Node neighbor = new Node(node.x + dir.x, node.y + dir.y);
                if (path.contains(neighbor) && !parent.containsKey(neighbor)) {
                    parent.put(neighbor, node);
                    queue.offer(neighbor);
                }
            }
        }

        List<Node> reversePath = new ArrayList<>();
        Node currentNode = start;
        while (currentNode != null) {
            reversePath.add(currentNode);
            currentNode = parent.get(currentNode);
        }

        // Adiciona a contagem do caminho de volta
        System.out.println("Backward path count: " + (reversePath.size() - 1));

        for (int i = reversePath.size() - 1; i >= 0; i--) {
            Node node = reversePath.get(i);
            System.out.println("Move to (" + node.x + ", " + node.y + ")");
        }
    }
}
