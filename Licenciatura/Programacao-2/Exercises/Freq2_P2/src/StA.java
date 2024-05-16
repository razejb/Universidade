import java.security.InvalidParameterException;

// Define a classe StA
public class StA {
    String pre;

    // Construtor padrão da classe StA
    public StA(){
        // Inicializa a variável pre com o valor "Sr.(a)"
        pre = "Sr.(a)";
    }

    // Construtor da classe StA que aceita um objeto como parâmetro
    public StA(Object x){
        // Chama o construtor padrão
        this();
        // Verifica se o objeto passado como parâmetro é uma instância de String
        if (!(x instanceof String))
            // Se não for, lança uma exceção do tipo InvalidParameterException
            throw new InvalidParameterException("Bad type");
        // Se for uma instância de String, chama o método act e atribui o resultado à variável pre
        pre = new String(act((String) x));
    }

    // Método que aceita uma String como parâmetro e retorna uma String
    public String act(String x) {
        // Verifica se a String x começa com "Sr"
        if (x.matches("Sr(.)*"))
            // Se sim, retorna a String x
            return x;
        else
            // Se não, retorna a String pre concatenada com um espaço e a String x
            return pre + " " + x;
    }

    // Método toString que retorna uma representação em String do objeto
    public String toString(){
        // Retorna o nome da classe e o valor da variável pre
        return (this.getClass() +":" + pre);
    }
}
