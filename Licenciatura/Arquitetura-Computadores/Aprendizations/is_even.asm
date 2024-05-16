Pretende-se desenvolver uma função que receba como argumento um inteiro de 32 bits e retorne 1 se o número é par e 0 se é ímpar.

O protótipo da função em C seria

    int is_even(int x);

Escreva a função em assembly RISC-V.


is_even:


andi t1, a0, 1  #realiza a operação AND bit a bit com o valor 1 para isolar o bit menos significativo
beqz t1, even   #se o bit menos significativo for 0, o número é par e a função salta para a label 'even'


#se o bit menos significativo for 1, o número é impar
li a0, 0        #carrega o valor 0 no registrador para indicar que o número é impar
j end           #salta para a label 'end' para finalizar a execução da função


#se o bit menos significativo for 0, o número é par
even: 
li a0, 1        #carrega o valor 1 no registrador a0 para indicar que o número é par
ret

end:
ret
