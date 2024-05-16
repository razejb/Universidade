public class SquareRoot {

    private double n;

    // Construtor que recebe o número e verifica se é não-negativo
    public SquareRoot(double n) {
        if (n < 0) {
            throw new IllegalArgumentException("n < 0");
        }
        this.n = n;
    }

    // Método para calcular a raiz quadrada usando o método de Newton
    public double compute(double epsilon) {
        // Verifica se epsilon é positivo
        if (epsilon <= 0) {
            throw new IllegalArgumentException("epsilon <= 0");
        }
        return computeNewton(this.n, epsilon);
    }

    // Método que implementa o método de Newton para o cálculo da raiz quadrada
    public double computeNewton(double n, double epsilon) {

        double t = n;

        // Loop enquanto a diferença entre t e n/t for maior que epsilon * t
        while (Math.abs(t - n / t) > epsilon * t)
            t = (n / t + t) / 2.0;

        // Retorna a aproximação da raiz quadrada
        return t;
    }

    // Método main para testar a classe
    public static void main(String[] args) {
        SquareRoot sqrt = new SquareRoot(25);

        // Calcula a raiz quadrada com um epsilon de 0.0001
        double result = sqrt.compute(0.0001);

        // Imprime o resultado
        System.out.println("A raiz quadrada é: " + result);
    }
}
