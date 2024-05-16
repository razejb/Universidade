package P_2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class fermi2_51966 {
    private int[] chaveSecreta;
    public fermi2_51966() {
        gerarChaveSecreta();
    }

    private void gerarChaveSecreta() {
        chaveSecreta = new int[3];
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            int novoD;
            do {
                novoD = random.nextInt(10);
            } while (contemValor(chaveSecreta, novoD));

            chaveSecreta[i] = novoD;
        }
    }

    private void iniciarJogo() {
        do {
            System.out.println("Insira 3 dígitos separados por espaço:");
            int[] palpite = lerPalpite();

            try {
                String[] respostas = verificarPalpite(palpite);
                misturarR(respostas);

                System.out.println("Resposta: " + Arrays.toString(respostas));
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (true);
    }

    private int[] lerPalpite() {
        Scanner scanner = new Scanner(System.in);
        int[] palpite = new int[3];
        for (int i = 0; i < 3; i++) {
            palpite[i] = scanner.nextInt();
        }
        return palpite;
    }

    private String[] verificarPalpite(int[] palpite) {
        if (palpite.length != 3) {
            throw new IllegalArgumentException("O palpite deve ter 3 dígitos.");
        }

        String[] respostas = new String[3];

        for (int i = 0; i < 3; i++) {
            if (palpite[i] == chaveSecreta[i]) {
                respostas[i] = "Fermi";
            } else if (contemValor(chaveSecreta, palpite[i])) {
                respostas[i] = "Pico";
            } else {
                respostas[i] = "Nano";
            }
        }
        return respostas;
    }

    private boolean contemValor(int[] array, int valor) {
        for (int i=0;i<array.length;i++) {
            if (array[i] == valor) {
                return true;
            }
        }
        return false;
    }

    private void misturarR(String[] respostas) {
        Random random = new Random();

        for (int i = respostas.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);

            String temp = respostas[index];
            respostas[index] = respostas[i];
            respostas[i] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Jogo de Fermi!");
        do {
            P_2.fermi2_51966 jogo = new fermi2_51966();
            jogo.iniciarJogo();
            System.out.println("Deseja jogar novamente? (s/n)");
        } while (scanner.next()!="s");

        System.out.println("Fim de jogo!\n");
        scanner.close();
    }
}
