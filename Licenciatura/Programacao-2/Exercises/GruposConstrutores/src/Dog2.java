public class Dog2 {

    private String name ;
    private double weight ;

    public Dog2(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public Dog2(double weight, String name) {
        this.name = name;
        this.weight = weight;
    }
}

//Não há um problema intrínseco com o grupo de construtores em si,
// mas a ordem dos parâmetros pode levar a confusão ao chamar os
// construtores.