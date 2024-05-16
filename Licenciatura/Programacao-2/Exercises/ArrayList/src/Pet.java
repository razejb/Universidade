abstract class Pet {

    protected String name ;
    protected char specie ;

    public Pet(String name, char specie) {
        this.name = name;
        this.specie = specie;
    }

    public String getName() {
        return name;
    }

    public char getSpecie() {
        return specie;
    }

    public abstract String getInfo() ;


}
