public class Person {

    private String name ;

    public Person() {
        name = "Unknown" ;
    }

    public String getName(){

        return name ;
    }

    public void setName(String name){

        this.name = name ;
    }
}

//Para ficar acessível fora do package myutil é necesśário usar o import:

//Exemplo:

//import myutil.Person ;
//import myutil.Fraction ;