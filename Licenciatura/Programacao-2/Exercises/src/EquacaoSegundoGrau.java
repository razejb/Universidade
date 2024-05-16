import java.util.Scanner;

public class EquacaoSegundoGrau {

    public static float[] formulaResolvente(int A, int B, int C) {

        float[] raizes = new float[2] ;

        float discriminante = (float)(Math.pow(B, 2) - 4 * A * C);

        if (discriminante < 0) {
            // A equação não tem raízes reais
            raizes[0] = Float.NaN ;
            raizes[1] = Float.NaN ;
        } else {
            raizes[0] = (float)((-B + Math.sqrt(discriminante)) / (2 * A));
            raizes[1] = (float)((-B - Math.sqrt(discriminante)) / (2 * A));
        }

        return raizes;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in) ;

        System.out.println("Insira o A de: Ax2 + Bx + C = 0   -> ");
        int A = scanner.nextInt() ;

        System.out.println("Insira o B de: Ax2 + Bx + C = 0   -> ");
        int B = scanner.nextInt() ;

        System.out.println("Insira o C de: Ax2 + Bx + C = 0   -> ");
        int C = scanner.nextInt() ;

        float[] raizes = formulaResolvente(A, B, C) ;

        System.out.println("Raiz 1: " + raizes[0]);
        System.out.println("Raiz 2: " + raizes[1]);
    }
}


