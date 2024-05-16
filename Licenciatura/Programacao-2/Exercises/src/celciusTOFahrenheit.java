import java.util.Scanner;

public class celciusTOFahrenheit {

    public static float celsiusToF(float C)
    {
           return (float) (1.8 * C + 32);
    }

    public static float FahrenheitToC(float F)
    {
        return (float) ((5.0/9.0) * (F - 32)) ;
    }

    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in) ;

        System.out.println("Insira os Celsius: ");
        float C = scanner.nextFloat() ;

        System.out.println("Insira os Fahrenheit: ");
        float F = scanner.nextFloat() ;


        System.out.println("Celsius to Fahrenheit: " + celsiusToF(C));

        System.out.println("Fahrenheit to Celsius: " + FahrenheitToC(F));
    }
}
