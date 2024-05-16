import java.util.Scanner;

public class BMI {

    public static float calcBMI(float w, float h)
    {
        return (float) (w / Math.pow((h / 100.0), 2)) ;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in) ;

        System.out.println("Insira o peso: ");
        float peso = scanner.nextFloat() ;

        System.out.println("Insere o tamanho do pénis: ");
        float altura = scanner.nextFloat();

        System.out.println(calcBMI(peso, altura));

        if(calcBMI(peso, altura) >= 20 && calcBMI(peso, altura) <= 25)
        {
            System.out.println("O BMI é considerado normal");
        }
        else
        {
            System.out.println("És gordo que fode");
        }
    }
}
