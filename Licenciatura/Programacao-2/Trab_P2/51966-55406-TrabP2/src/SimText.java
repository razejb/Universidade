/* SimText.java */

import java.util.Random;

public class SimText {

    private static int i = 100; // Largura padrão do campo
    private static int j = 100; // Altura padrão do campo
    private static int starveTime = 5; // Tempo padrão que os coelhos vivem até morrerem de fome

    private static void draw(Grassland mead) {
        if (mead != null) {
            int width = mead.width();
            int height = mead.height();

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int contents = mead.cellContents(x, y);
                    if (contents == Grassland.RABBIT) { // Coloca um coelho no Standard Output
                        System.out.print("\uD83D\uDC30");
                    } else if (contents == Grassland.CARROT) { // Coloca uma cenoura no Standard Output
                        System.out.print("\uD83E\uDD55");
                    } else {    // Coloca relva no Standard Output
                        System.out.print("\uD83C\uDF31");
                    }
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] argv) throws InterruptedException {
        Grassland mea;

        // Lê os parâmetros da entrada
        if (argv.length > 0) {
            try {
                i = Integer.parseInt(argv[0]);
            } catch (NumberFormatException e) {
                System.out.println("O primeiro argumento para a Simulação não é um número.");
            }
        }

        if (argv.length > 1) {
            try {
                j = Integer.parseInt(argv[1]);
            } catch (NumberFormatException e) {
                System.out.println("O segundo argumento para a Simulação não é um número.");
            }
        }

        if (argv.length > 2) {
            try {
                starveTime = Integer.parseInt(argv[2]);
            } catch (NumberFormatException e) {
                System.out.println("O terceiro argumento para a Simulação não é um número.");
            }
        }
        // Cria o campo inicial
        mea = new Grassland(i, j, starveTime);

        // Visita cada célula; coloca aleatoriamente um coelho, uma cenoura,
        // ou nada em cada uma.
        Random random = new Random(0); // Cria um objeto "Random" com semente 0
        int x = 0;
        int y = 0;
        for (int xx = 0; xx < i; xx++) {
            x = (x + 78887) % i; // Irá visitar cada coordenada x uma vez
            if ((x & 8) == 0) {
                for (int yy = 0; yy < j; yy++) {
                    y = (y + 78887) % j; // Irá visitar cada coordenada y uma vez
                    if ((y & 8) == 0) {
                        int r = random.nextInt();
                        if (r < 0) { // 50% das células começam com uma cenoura
                            mea.addCarrot(x, y);
                        } else if (r > 1500000000) { // ~15% das células começam com um coelho
                            mea.addRabbit(x, y);
                        }
                    }
                }
            }
        }

        while (true) {
            Thread.sleep(1000);
            draw(mea);
            mea = mea.timeStep();
        }
    }
}