/**
 * Numa classe Main, defina várias figuras e colecione-as numa ArrayList.
 * Para esta lista identifique a menor figura e a maior figura e apague-as da lista.
 */


public class MyClass {
    public static void main(String args[]) {

        // Criação de objetos das classes Circle, Square e Rectangle
        Circle s1 = new Circle(2);
        Square s2 = new Square(2.5);
        Square s3 = new Square(3.8);
        Rectangle s4 = new Rectangle(4,6);
        Rectangle s5 = new Rectangle(3.4, 9.2);
        Circle s6 = new Circle(4.6);

        // Criação de um array de GeometricShape para armazenar os objetos
        GeometricShape[] arr = {s1, s2, s3, s4, s5, s6};

        // Inicialização das variáveis max e min com o primeiro objeto do array
        GeometricShape max = s1;
        GeometricShape min = s1;

        // Loop para percorrer o array a partir do segundo objeto
        for( int i = 1; i < arr.length; i++){

            // Se o objeto max e o objeto atual são da mesma classe
            if(max.getClass() == arr[i].getClass()){
                // Se o perímetro do objeto max é menor que o do objeto atual
                if(max.getPerimeter() < arr[i].getPerimeter()){
                    // O objeto atual se torna o novo max
                    max = arr[i];
                }
            }
            else{
                // Se a área do objeto max é menor que a do objeto atual
                if(max.getArea() < arr[i].getArea()){
                    // O objeto atual se torna o novo max
                    max = arr[i];
                }
            }

            // Se o objeto min e o objeto atual são da mesma classe
            if(min.getClass() == arr[i].getClass()){
                // Se o perímetro do objeto min é maior que o do objeto atual
                if(min.getPerimeter() > arr[i].getPerimeter()){
                    // O objeto atual se torna o novo min
                    min = arr[i];
                }
            }
            else{
                // Se a área do objeto min é maior que a do objeto atual
                if(min.getArea() > arr[i].getArea()){
                    // O objeto atual se torna o novo min
                    min = arr[i];
                }
            }
        }

        // Loop para percorrer o array
        for( int i = 0; i < arr.length; i++){
            // Se o objeto atual é igual ao objeto max
            if(arr[i] == max){
                // O objeto é removido do array
                arr[i] = null;
            }
            // Se o objeto atual é igual ao objeto min
            if(arr[i] == min){
                // O objeto é removido do array
                arr[i] = null;
            }
        }
    }
}

