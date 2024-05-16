/**
 *  Implemente a hierarquia apresentada na alínca anterior (em java). Para todas as classes implementadas,
 *  defina os métodos que considere absolutamente necessários e ainda os métodos equals, e toString().
 *  Considere que as figuras são comparáveis, dentro da mesma classe, por perímetro, e figuras de classes distintas,
 *  são comparadas por área.
 */


abstract class GeometricShape {

    // Declara uma variável de instância do tipo String chamada type
    String type;

    // Construtor que aceita uma String como parâmetro
    public GeometricShape(String type){
        // Atribui o valor do parâmetro à variável de instância type
        this.type=type;
    }

    // Método setter para a variável type
    public void setType(String type){
        this.type=type;
    }

    // Método getter para a variável type
    public String getType(){
        return type;
    }

    // Declara dois métodos abstratos getArea e getPerimeter
    abstract double getArea();
    abstract double getPerimeter();

    // Método toString que retorna a variável type
    public String toString(){
        return this.type;
    }
}

// Define uma classe chamada Circle que estende GeometricShape
class Circle extends GeometricShape  {
    // Declara uma variável de instância do tipo double chamada raio
    double raio;

    // Construtor que aceita um double como parâmetro
    public Circle(double r){
        // Chama o construtor da superclasse passando "Circle" como parâmetro
        super("Circle");
        // Atribui o valor do parâmetro à variável de instância raio
        raio=r;
    }

    // Implementa o método getArea da superclasse
    public double getArea(){
        // Retorna a área do círculo
        return(Math.PI * Math.pow(raio, 2));
    }

    // Implementa o método getPerimeter da superclasse
    public double getPerimeter(){
        // Retorna o perímetro do círculo
        return (2 * Math.PI * this.raio);
    }
}

// Define uma classe chamada Rectangle que estende GeometricShape
class Rectangle extends GeometricShape{
    // Declara duas variáveis de instância do tipo double chamadas l1 e l2
    double l1;
    double l2;

    // Construtor que aceita dois doubles como parâmetros
    public Rectangle(double l1,double l2){
        // Chama o construtor da superclasse passando "Quadrilateral" como parâmetro
        super("Quadrilateral");
        // Atribui os valores dos parâmetros às variáveis de instância l1 e l2
        this.l1=l1;
        this.l2=l2;
    }

    // Implementa o método getArea da superclasse
    public double getArea(){
        // Retorna a área do retângulo
        return l1*l2;
    }

    // Implementa o método getPerimeter da superclasse
    public double getPerimeter(){
        // Retorna o perímetro do retângulo
        return 2*(l1+l2);
    }
}

// Define uma classe chamada Square que estende Rectangle
class Square extends Rectangle{
    // Construtor que aceita um double como parâmetro
    public Square(double side){
        // Chama o construtor da superclasse passando o lado como parâmetro para ambos os lados
        super(side,side);
    }
}

/**
    Classe Abstrata: Uma classe abstrata em Java é uma classe que não pode ser
                     instanciada diretamente. Ela serve como um modelo para
                     outras classes. As classes abstratas podem conter ou não
                     métodos abstratos.

    Método Abstrato: Um método abstrato é um método que não tem implementação.
                     Ele define apenas a assinatura do método. Os métodos
                     abstratos definidos em uma classe abstrata devem ser
                     implementados em uma classe concreta.

 **/
/**
 * Getter: Um método getter é usado para acessar o valor de um atributo.
 *         Ele retorna o valor do atributo especificado. Por convenção,
 *         os getters começam com a palavra “get” seguida do nome da variável,
 *         com a primeira letra em maiúscula.
 *
 * Setter: Um método setter é usado para definir ou atualizar o valor de um atributo.
 *         Ele recebe um parâmetro e o atribui ao atributo. Os setters começam com a
 *         palavra “set”, seguida do nome da variável, com a primeira letra em maiúscula.
 *
 * Construtor: Um construtor em Java é um bloco de código especial que é usado para
 *             inicializar um objeto. Ele é chamado quando uma instância do objeto é
 *             criada, e a memória é alocada para o objeto. É uma maneira eficaz de
 *             definir os atributos de um objeto no momento da criação.
 */

/**
 *

 this(): A palavra-chave this é uma referência à instância atual de um objeto.
         É usada para acessar variáveis e métodos da instância atual e para invocar
         o construtor da própria classe.

 super(): A palavra-chave super é usada para se referir à superclasse imediata (ou classe pai) de uma classe.
          É usada para chamar métodos da superclasse e para acessar o construtor da superclasse.

 instanceof: O operador instanceof é usado para verificar se um objeto é uma instância de uma classe
             específica ou de uma interface.

 throws: É usada na declaração de um método para indicar que esse método pode lançar exceções de um determinado tipo.
         Quando você vê throw new Exception(), isso significa que um novo objeto de exceção está sendo criado e lançado.


 */