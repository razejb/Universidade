import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Player {

    private int x;
    private int y;
    private LinkedHashMap<Integer, String> path;
    private List<String> retracePath;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.path = new LinkedHashMap<>();
        this.retracePath = new ArrayList<>();
        this.path.put(0, "Start at (" + x + ", " + y + ")");
    }

    public void move(String direction, int dx, int dy, int step){
        this.x += dx;
        this.y += dy;
        this.path.put(step, "Move " + direction + " to (" + this.x + ", " + this.y + ")");
    }

    public void retracePath() {
        List<String> reversePath = new ArrayList<>(this.path.values());
        Collections.reverse(reversePath);
        this.retracePath.add("Retrace " + reversePath.get(0));
        for (int i = 1; i < reversePath.size(); i++) {
            if (!reversePath.get(i).equals(reversePath.get(i-1))) {
                this.retracePath.add("Retrace " + reversePath.get(i));
            }
        }
    }

    public Map<Integer, String> getPath() {
        return this.path;
    }

    public List<String> getRetracePath() {
        return this.retracePath;
    }

    public static void main(String[] args) throws IOException {

        Player player = new Player(0, 0);

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        // Lê o número de movimentos
        int numMovimentos = Integer.parseInt(input.readLine());

        // Lê a sequência de movimentos
        String sequencia = input.readLine();

        // Itera através da sequência de movimentos e salva as coordenadas
        int step = 1;
        for (char movimento : sequencia.toCharArray()) {
            switch (movimento) {
                case 'N':
                    player.move("N", 0, 1, step);
                    break;
                case 'E':
                    player.move("E", 1, 0, step);
                    break;
                case 'S':
                    player.move("S", 0, -1, step);
                    break;
                case 'W':
                    player.move("W", -1, 0, step);
                    break;
                default:
                    // Movimento inválido
                    break;
            }
            step++;
        }

        // Retrace o caminho de volta para a origem
        player.retracePath();

        // Imprime o caminho do jogador
        for (Map.Entry<Integer, String> entry : player.getPath().entrySet()) {
            System.out.println(entry.getValue());
        }

        // Imprime o caminho retrógrado do jogador
        for (String position : player.getRetracePath()) {
            System.out.println(position);
        }
    }
}
