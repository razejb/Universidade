import java.security.InvalidParameterException;


public class Main {
    public static void main(String[] args) {
        // Declaração de variáveis do tipo StA e StB inicializadas como null
        StA p1=null, p2=null, p3=null, p4=null, p5=null, p6=null;

        // Bloco try-catch para lidar com possíveis exceções
        try {
            // Criação de objetos das classes StA e StB
            p1 = new StA();
            p2 = new StA("Joao");
            p3 = new StA("Sr. Joao");
            p4 = new StB("Sra. Maria", "Fonseca");
            p5 = new StB("António", "Fernandes");
            p6 = new StA(new Integer(123));
        }
        // Caso uma exceção do tipo InvalidParameterException seja lançada, imprime a mensagem da exceção
        catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        }
        // O bloco finally é executado independentemente de uma exceção ser lançada ou não
        finally {
            // Imprime os objetos criados
            System.out.println(p1);
            System.out.println(p2);
            System.out.println(p3);
            System.out.println(p4);
            System.out.println(p5);
            System.out.println(p6);
        }
    }
}

