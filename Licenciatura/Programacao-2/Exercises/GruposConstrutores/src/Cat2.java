public class Cat2 {

    private String name ;
    private double weight ;

    public Cat2(String name) {
        this.name = name;
    }

    public Cat2(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public Cat2(double weight) {
        this.weight = weight;
    }
}

//Existe ambiguidade nos construtores devido aos parâmetros