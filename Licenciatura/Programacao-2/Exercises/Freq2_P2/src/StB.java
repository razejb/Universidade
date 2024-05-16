
public class StB extends StA{
    String rest;

    // Construtor da classe StB que aceita duas Strings como parâmetros
    public StB(String x, String y){
        // Chama o construtor da superclasse (StA) passando a String x como parâmetro
        super(x);
        // Atribui o valor da String y à variável rest
        rest=y;
    }

    // Método toString que retorna uma representação em String do objeto
    public String toString(){
        // Chama o método toString da superclasse e atribui o resultado à variável p
        String p=super.toString();
        // Substitui "STA" por "STB" na String p e atribui o resultado à variável u
        String u=p.replaceAll("STA", "STB");
        // Retorna a String u concatenada com um espaço e a String rest
        return u + " " + rest;
    }
}
