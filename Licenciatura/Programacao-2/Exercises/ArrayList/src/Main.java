import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Pet> pets = new ArrayList<>() ;

        Scanner s = new Scanner(System.in) ;
        String name ;
        char specie ;
        String coatColor ;
        double weight;

        while (true){

            System.out.println("Insira o animal de estimação ou 'STOP' para terminar");

            name = s.nextLine() ;

            if("STOP".equalsIgnoreCase(name)){
                break;
            }

            System.out.println("Insira a especie do animal (c: para Cat, d para Dog)");

            specie = s.nextLine().charAt(0) ;

            if(specie == 'c'){
                System.out.println("Insira a cor do pelo do gato: ");
                coatColor = s.nextLine() ;
                pets.add(new Cat(name, specie, coatColor)) ;

            } else if(specie == 'd'){
                System.out.println("Insira o peso do cão: ");

                weight = s.nextDouble();
                s.nextLine() ;

                pets.add(new Dog(name, specie, weight)) ;
            } else {
                System.out.println("Especie inválida");
            }
        }

        for(Pet pet : pets){
            System.out.println("Nome: " + pet.getName() + ", Espécie: "
                    + pet.getSpecie());
        }

        s.close();
    }
}
