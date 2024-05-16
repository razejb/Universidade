public class Main {

    public static void main(String[] args){

        calculateScore(true, 800, 5,1);


        boolean gameOver = true;
        int score = 2000;
        int levelCompleted = 7;
        int bonus = 200;

        int finalScore = score;

        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            System.out.println("Your final score was " + finalScore);
        }


    }
    public static void calculateScore(boolean gameOver, int score, int levelCompleted, int bonus){

        gameOver = true;
        score = 800;
        levelCompleted = 5;
        bonus = 100;

        int finalScore = score;

        score = 10000;
        levelCompleted = 8;
        bonus = 200;

        finalScore = score;

        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            System.out.println("Your final score was " + finalScore);
        }
    }
}
