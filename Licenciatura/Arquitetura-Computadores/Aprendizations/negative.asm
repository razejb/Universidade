Pretende-se desenvolver uma função que retorne 1 se o número x é negativo e 0 caso contrário. O protótipo da função em C seria

    int negative(int x);

Escreva a função em assembly RISC-V.

negative: 
                  
slti t0, a0, 1    #testa se o bit mais significativo de a0 é 1
beqz t0, positive #se for zero, salta para a label 'positive'
li a0, 1          #se for um, coloca 1 em a0
ret               #retorna a função

positive:         #
li a0, 0          #coloca 0 em a0

ret
