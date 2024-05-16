import javax.swing.*;
import java.util.Scanner;

public class frameWindow2 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in) ;
        JFrame myFrame = new JFrame() ;

        System.out.println("Insert width: ");

        int width = scanner.nextInt() ;

        System.out.println("Insert height: ");

        int height = scanner.nextInt() ;

        myFrame.setSize(width, height);
        myFrame.setTitle("frameWindow2");
        myFrame.setVisible(true);

    }

}
