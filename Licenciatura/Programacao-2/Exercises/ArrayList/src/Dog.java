public class Dog extends Pet{

    private double weight ;
    public Dog(String name, char specie, double weight) {
        super(name, 'c');
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String getInfo() {
        return "Nome: " + name + ", Espécie " + specie + ", Peso: " + weight + "kg" ;
    }
}
