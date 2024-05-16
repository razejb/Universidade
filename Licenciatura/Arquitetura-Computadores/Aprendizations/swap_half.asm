

Pretende-se desenvolver uma função que receba como argumento um inteiro de 32 bits e retorne o resultado da troca dos 16 bits da esquerda com os 16 da direita.

O protótipo da função em C seria

    int swap_half(int x);

Escreva a função em assembly RISC-V.


swap_half:

mv t1, a0       #move o argumento para o registrador temporário t1

srli t2, t1, 16 #desloca 16 bits para a direita, deixando apenas 16 bits da esquerda
slli t1, t1, 16 #desloca 16 bits para a esquerda, deixando apenas 16 bits da direita
or a0, t1, t2   #combina os valores para gerar o resultado

ret            
