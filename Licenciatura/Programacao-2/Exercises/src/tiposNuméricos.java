public class tiposNuméricos {

    public static void main(String[] args){

        int i = 3, j = 4, k = 5;
        float x = 34.5f, y = 1225f ;

        float result = 0 ;



        //System.out.println((x + 1.5) / (250.1 * (i/j)));
        /* Como os dados são do tipo int o resultado vai dar "infinity"
        se trocar int para float é possível obter um resultado em concreto
        mas se mesmo assim quisermos usar int o numerador(i) tem que ser
        maior que o denominador(j)
         */

        System.out.println(x + 1.5 / 250.0 * i / j);
        /* É possivel obter um resultado diferente do anterior pois a precedência muda */

        System.out.println(-x * -y * (i + j) / k);

        System.out.println( (i / 5) * y);
        //Mesma situação do primeiro caso

        System.out.println(Math.min(i, Math.min(j, k)));
        //Math.min é um método que compara dois valores
        // int menorValor = Math.min(valor1, valor2);
        //Retorna o menor dos 2 valores

        /*System.out.println(Math.exp(3, 2));
        Math.exp irá retornar o valor da função exponencial, mas
        está errado pois Math.exp só pode receber 1 valor
         */

        System.out.println(y % x);
        //Irá retornar o resto de y por x

        System.out.println(Math.pow(3, 2));
        //Math.pow recebe dois valores a base e o expoente
        //Math.pow(base, expoente) ;

        System.out.println((int) y % k);
        //Simplesmete diz y vai ser tratado como um inteiro

        System.out.println(i / 5 * y);
        //Int = 0.0 se fosse float já seria outro resultado



    }
}
