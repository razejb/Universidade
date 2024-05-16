public class Q2Main {

    public static void main(String[] args) {
        QuestionTwo q2;
        q2 = new QuestionTwo();
        q2.init();
        q2.increment();
        q2.increment();
        System.out.println(q2.getCount());
    }
}
    class QuestionTwo{

        private int count;
        public void init(){
            count = 1;
        }

        public void increment(){
            count = count + 1;
        }

        public int getCount(){
            return count ;
        }
    }

    /*
        Classe QuestionTwo:
        Esta classe define um objeto chamado QuestionTwo.
        Ela possui um campo privado count para armazenar um valor inteiro.
        O método init() inicializa o valor de count para 1.
        O método increment() incrementa o valor de count em 1.
        O método getCount() retorna o valor atual de count.

    Classe Q2Main:
        Esta é a classe principal com o método main(String[] args), que é o ponto de entrada do programa.
        Ela cria uma instância da classe QuestionTwo chamada q2 usando new QuestionTwo().
        Em seguida, chama o método init() do objeto q2, que define o valor de count para 1.
        Depois, chama o método increment() duas vezes, o que aumenta o valor de count em 1 duas vezes.
        Finalmente, imprime o valor atual de count usando System.out.println(q2.getCount()), que neste caso, será 3.

        Em resumo, esse código demonstra o uso de uma classe QuestionTwo para contar o número de incrementos e um objeto q2 da
        classe QuestionTwo. O programa inicializa o contador, incrementa-o duas vezes e, em seguida, exibe o valor resultante do contador, que é 3.
     */
