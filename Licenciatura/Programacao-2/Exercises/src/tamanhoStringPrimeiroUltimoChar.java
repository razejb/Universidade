import java.util.Scanner;

public class tamanhoStringPrimeiroUltimoChar {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in) ;

        System.out.println("Introduza a string") ;
        String string = scanner.nextLine() ;

        System.out.println( string.length());
        System.out.println(string.charAt(0));
        System.out.println(string.charAt(string.length() - 1));

    }

}
