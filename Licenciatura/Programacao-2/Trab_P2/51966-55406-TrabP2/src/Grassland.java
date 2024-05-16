/*==============================================================
|                                                              |
|   _________________________________________________________  |
|  | Trabalho realizado por: João Santos & Catarina Andrade ;  |
|  |                 Número: 51966 & 55406                  ;  |
|  |                  Curso: EI                             ;  |
|  |                Docente: Lígia Ferreira                 ;  |
|   ---------------------------------------------------------  |
|                                                              |
|                                                              |
==============================================================*/


/* Grassland.java */

public class Grassland {

    //Constantes para representar os diferentes estados de uma célula
    public final static int EMPTY = 0;
    public final static int RABBIT = 1;
    public final static int CARROT = 2;

    // Matriz para representar o prado
    private int meadow[][] ;

    // Variável para armazenar o tempo que um coelho pode passar sem comer
    private int starveTime ;

    // Construtor da classe Grassland
    public Grassland(int i, int j, int starveTime) {
        // Inicializa a matriz do prado com as dimensões fornecidas
        this.meadow = new int[i][j];
        // Define o tempo que um coelho pode passar sem comer
        this.starveTime = starveTime;
    }

    // Método para obter a largura do prado
    public int width() {
        return meadow.length;
    }

    // Método para obter a altura do prado
    public int height() {
        return meadow[0].length;
    }

    // Método para obter o tempo que um coelho pode passar sem comer
    public int starveTime() {
        return starveTime;
    }

    // Método para adicionar uma cenoura numa posição específica, se estiver vazia
    public void addCarrot(int x, int y) {
        if(meadow[x][y] == EMPTY){
            meadow[x][y] = CARROT ;
        }
    }

    // Método para adicionar um coelho numa posição específica, se estiver vazia
    public void addRabbit(int x, int y) {
        if(meadow[x][y] == EMPTY){
            meadow[x][y] = RABBIT ;
        }
    }

    // Método para adicionar "nada" (ou relva) numa posição específica, se estiver vazia
    public void setEmpty(int x, int y) {
        if(meadow[x][y] == EMPTY){
            meadow[x][y] = EMPTY ;
        }
    }

    // Método para obter o conteúdo de uma célula específica
    public int cellContents(int x, int y) {
        if(meadow[x][y] == CARROT){
            return CARROT ;
        }
        else if(meadow[x][y] == RABBIT){
            return RABBIT ;
        }
        else{
            return EMPTY;
        }
    }

    // Método para avançar o estado do prado numa unidade de tempo
    public Grassland timeStep() {
        // Cria um novo prado para o próximo timestep
        Grassland nextMeadow = new Grassland(this.width(), this.height(), this.starveTime);
        // Itera sobre cada célula do prado
        for (int i = 0; i < this.width(); i++) {
            for (int j = 0; j < this.height(); j++) {
                // Obtem o conteúdo da célula atual
                int cell = this.cellContents(i, j);
                // Conta o número de cenouras e coelhos vizinhos
                int carrots = countNeighbors(i, j, CARROT);
                int rabbits = countNeighbors(i, j, RABBIT);

                // Aplica as regras do ecossistema
                if (cell == RABBIT) { // Se a célula atual contém um coelho
                    if (carrots > 0) { // Se há pelo menos uma cenoura nos vizinhos
                        nextMeadow.addRabbit(i, j); // O coelho come a cenoura e permanece na célula
                    } else if ( rabbits < this.starveTime + 1) { // Se não há cenouras e o coelho passou menos tempo sem comer do que o tempo de fome + 1
                        nextMeadow.setEmpty(i, j); // O coelho morre de fome
                    }
                } else if (cell == CARROT) { // Se a célula atual contém uma cenoura
                    if (rabbits == 0) { // Se não há coelhos nos vizinhos
                        nextMeadow.addCarrot(i, j); // A cenoura permanece na célula
                    } else if(rabbits == 1){
                        nextMeadow.setEmpty(i, j);
                    }else if (rabbits >= 2) { // Se há pelo menos dois coelhos nos vizinhos
                        nextMeadow.addRabbit(i, j); // Um coelho recém-nascido ocupa a célula
                    }
                } else if (cell == EMPTY) { // Se a célula atual está vazia
                    if(carrots < 2){
                        nextMeadow.setEmpty(i, j);
                    }
                    else if (carrots >= 2 && rabbits <= 1) { // Se há pelo menos duas cenouras e no máximo um coelho nos vizinhos
                        nextMeadow.addCarrot(i, j); // Uma nova cenoura nasce na célula
                    } else if (carrots >= 2 && rabbits >= 2) { // Se há pelo menos duas cenouras e pelo menos dois coelhos nos vizinhos
                        nextMeadow.addRabbit(i, j); // Um novo coelho nasce na célula
                    }
                }
            }
        }
        // Retorna o novo estado do prado
        return nextMeadow;
    }

    // Método para contar o número de vizinhos de um tipo específico
    private int countNeighbors(int x, int y, int type) {
        int count = 0;
        // Itera sobre cada célula vizinha
        for (int i = Math.max(0, x - 1); i <= Math.min(this.width() - 1, x + 1); i++) {
            for (int j = Math.max(0, y - 1); j <= Math.min(this.height() - 1, y + 1); j++) {
                if (i != x || j != y) {
                    // Incrementa a contagem se a célula vizinha é do tipo especificado
                    if (this.cellContents(i, j) == type) {
                        count++;
                    }
                }
            }
        }
        // Retorna o count
        return count;
    }
}

