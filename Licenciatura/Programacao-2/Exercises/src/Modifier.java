class Modifier {

    public static void change(int x, int y){

        x = x - 10;
        y = y + 10;
    }

    public static void main(String[] args) {

        int x = 40 ;
        int y = 20 ;

        Modifier.change(x, y);
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }
}

//O output produto é x = 40 e y = 20 porque a função
//não retorna nenhum valor.