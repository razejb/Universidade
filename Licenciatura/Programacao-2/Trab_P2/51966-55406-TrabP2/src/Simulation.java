/* Simulation.java */

import java.awt.*;
import java.util.*;

public class Simulation {

    private static final int cellSize = 4; // Define o tamanho da célula

    private static int i = 500; // Largura padrão do campo
    private static int j = 300; // Altura padrão do campo
    private static int starveTime = 5; // Tempo padrão que os coelhos vivem até morrerem de fome

    // Método para desenhar o campo
    private static void draw(Graphics graphics, Grassland mead) {
        if (mead != null) {
            int width = mead.width();
            int height = mead.height();

            // Percorre todas as células do campo
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int contents = mead.cellContents(x, y);
                    if (contents == Grassland.RABBIT) {
                        graphics.setColor(Color.GRAY); // Desenha um coelho cinzento
                        graphics.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
                    } else if (contents == Grassland.CARROT) {
                        graphics.setColor(Color.ORANGE); // Desenha uma cenoura laranja
                        graphics.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
                    } else {
                        graphics.setColor(Color.GREEN); // Desenha uma célula vazia (relva)
                        graphics.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
                    }
                }
            }
        }
    }

    public static void main(String[] argv) throws InterruptedException {
        Grassland mea;


        // Lê os parâmetros da entrada
        if (argv.length > 0) {
            try {
                i = Integer.parseInt(argv[0]);
            }
            catch (NumberFormatException e) {
                System.out.println("O primeiro argumento para a Simulação não é um número.");
            }
        }

        if (argv.length > 1) {
            try {
                j = Integer.parseInt(argv[1]);
            }
            catch (NumberFormatException e) {
                System.out.println("O segundo argumento para a Simulação não é um número.");
            }
        }

        if (argv.length > 2) {
            try {
                starveTime = Integer.parseInt(argv[2]);
            }
            catch (NumberFormatException e) {
                System.out.println("O terceiro argumento para a Simulação não é um número.");
            }
        }

        // Cria uma nova janela com o título "Rabbits and Carrots"
        Frame frame = new Frame("Rabbits and Carrots");

        // Define o tamanho da janela
        frame.setSize(i * cellSize, j * cellSize );
        frame.setVisible(true);

        // Cria um "Canvas" onde podemos desenhar; anexa-o à janela
        Canvas canvas = new Canvas();
        canvas.setBackground(Color.white);
        canvas.setSize(i * cellSize, j * cellSize);
        frame.add(canvas);
        Graphics graphics = canvas.getGraphics();

        // Cria o campo inicial
        mea = new Grassland(i, j, starveTime);

        // Visita cada célula; coloca aleatoriamente um coelho, uma cenoura,
        // ou nada em cada uma.
        Random random = new Random(0); // Cria um objeto "Random" com seed 0
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
            draw(graphics, mea);
            mea = mea.timeStep();
        }
    }

}




