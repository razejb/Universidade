import java.util.Scanner;

public class nomeDOmeio {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in) ;

        System.out.println("Enter your first name: ");

        String firstName = scanner.next() ;

        System.out.println("Enter your middle name: ");

        String middleName = scanner.next() ;

        System.out.println("Enter your last name: ");

        String lastName = scanner.next() ;

        System.out.println(firstName + " " + middleName.charAt(0) + ". " + lastName);
    }
}
