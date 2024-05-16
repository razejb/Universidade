public class Cat extends Pet{

    private String  coatColor ;

    public Cat(String name, char specie, String coatColor) {
        super(name, 'c');
    }

    public String getCoatColor() {
        return coatColor;
    }

    public void setCoatColor(String coatColor) {
        this.coatColor = coatColor;
    }

    @Override
    public String getInfo() {
        return "Nome: " + name + ", Espécie " + specie + ", Cor: " + coatColor ;
    }
}
