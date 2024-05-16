public class Dog {

    private String name ;
    private double weight ;

    private double height ;

    public Dog(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public Dog(String name, double height) {
        this.name = name;
        this.height = height;
    }
}

//Existe ambiguidade nos construtores devido aos parâmetros