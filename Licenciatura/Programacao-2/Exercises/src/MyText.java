public class MyText {

    private String word;
    private String temp;
    private int idx;

    public String firstLetter(){
        idx = 0;
        return  getLetter(word);
    }

    public String lastLetter(){
        idx = word.length() -1;
        return getLetter(word);
    }

    private String getLetter(String str){
        temp = str.substring(idx, idx + 1) ;
        return temp;
    }
}

/*
Existem alguns problemas e considerações que podem ser feitas sobre
a classe MyText:

    Atributos e Estado Interno:
        Os atributos word, temp, e idx são usados para manter o estado
        interno da classe. No entanto, a classe não possui um método
        para definir ou alterar a palavra (setWord). Isso significa que,
        uma vez que um objeto MyText é criado, a palavra não pode ser
        modificada. Dependendo dos requisitos, talvez seja desejável
        adicionar métodos para modificar a palavra.

    Segurança e Verificações:
        O método getLetter assume que o índice idx é válido, sem realizar
        verificações. Isso pode levar a StringIndexOutOfBoundsException se
        o índice estiver fora dos limites da palavra. Seria apropriado
        adicionar verificações para garantir que o índice esteja dentro
        dos limites da string.

    Encapsulamento e Visibilidade:
        Os métodos firstLetter e lastLetter modificam o estado interno (idx)
        antes de chamar o método privado getLetter. Isso pode tornar a
        classe propensa a erros se métodos públicos ou subclasses
        alterarem o estado interno de forma imprevista. É uma boa prática
        manter métodos privados independentes do estado externo.

    Passagem de Argumento para Métodos Privados:
        Passar um argumento para métodos privados pode ser apropriado, mas,
        neste caso, o método privado getLetter parece depender mais do
        estado interno (idx) do que do argumento passado (str).
        Pode ser mais apropriado tornar o método privado sem argumentos e
        depender do estado interno.
 */
