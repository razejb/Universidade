import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class BoardGame {
    String name;
    int players;
    int enthusiasm;

    public BoardGame(String name, int players, int enthusiasm) {
        this.name = name;
        this.players = players;
        this.enthusiasm = enthusiasm;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int availableSpace = Integer.parseInt(input.readLine());
        int numberOfGames = Integer.parseInt(input.readLine());

        List<BoardGame> games = new ArrayList<>();
        for (int i = 0; i < numberOfGames; i++) {
            String[] gameData = input.readLine().split(" ");
            games.add(new BoardGame(gameData[0], Integer.parseInt(gameData[1]), Integer.parseInt(gameData[2])));
        }

        games.sort((a, b) -> b.enthusiasm - a.enthusiasm);

        LinkedList<BoardGame> selectedGames = new LinkedList<>();
        int totalPlayers = 0;
        int totalEnthusiasm = 0;

        for (BoardGame game : games) {
            if (totalPlayers + game.players <= availableSpace) {
                selectedGames.addLast(game);
                totalPlayers += game.players;
                totalEnthusiasm += game.enthusiasm;
            }
        }

        Collections.reverse(selectedGames);

        System.out.println(selectedGames.size() + " " + totalPlayers + " " + totalEnthusiasm);
        for (BoardGame game : selectedGames) {
            System.out.println(game.name);
        }
    }
}
