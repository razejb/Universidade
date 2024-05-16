

Pretende-se desenvolver uma função que retorne a soma dos seus 3 argumentos. O protótipo da função em C seria

    int add3(int x, int y, int z);

Escreva a função em assembly RISC-V.


add3:

add a0, a0, a1  #soma os 2 primeiros argumentos(a0 e a1) e armazena em a0
add a0, a0, a2  #soma o resultado anterior (que ficou armazenado no a0), soma com o 3º argumento(a2) e armazena em a0

ret
