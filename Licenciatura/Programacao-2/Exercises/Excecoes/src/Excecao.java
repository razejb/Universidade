import java.util.InputMismatchException;
import java.util.Scanner;

public class Excecao {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        try {
            int num = s.nextInt();

            // Se o número não for zero, lança uma exceção personalizada
            if (num != 0) {
                throw new Exception("Não zero. ");
            }

            // Se o número for zero, imprime uma mensagem
            System.out.println("Estou satisfeito com o valor.");

        } catch (InputMismatchException e) {
            // Captura a exceção se o usuário inserir um tipo de dado diferente de int
            System.out.println("Entrada inválida");

        } catch (Exception w) {
            // Captura exceções gerais (não relacionadas a InputMismatchException)
            System.out.println("Erro: " + w.getMessage());

        } finally {
            // Bloco finally, independentemente de exceções, será sempre executado
            System.out.println("Instrução 'finally' executada. ");
        }

        s.close();
    }
}

//A declaração throw lança uma exceção definida pelo usuário. A execução da função atual
// vai parar (as instruções após o throw não serão executadas), e o controlo será passado
// para o primeiro bloco catch na pilha de chamadas. Se nenhum bloco catch existe entre as
// funções "chamadoras", o programa vai terminar.

//A exceção InputMismatchException é lançada pela instância do Scanner quando o token recuperado
// não corresponde ao tipo esperado. InputMismatchException se estende da classe
// NoSuchElementException , que é usada para indicar que o elemento solicitado não existe.

// -1,  é inteiro e o resultado é "Erro: Não zero"
// 0, "Estou satisfeito com o valor"
//12XY, como não é inteiro "Entrada inválida"