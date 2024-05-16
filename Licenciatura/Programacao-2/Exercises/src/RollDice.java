import java.util.Random;

class Die{
    private int sides;
    private Random random;

    public Die(int sides){
        this.sides = sides;
        random = new Random() ;
    }

    public int roll(){
        return random.nextInt(sides) + 1;
    }
}

public class RollDice {

    public static void main(String[] args){
        Die die = new Die(6);

        for(int i = 0; i < 3; i++){

            int result = die.roll() ;
            System.out.println("Lançamento " + (i + 1) + ": " + result);
        }
    }
}