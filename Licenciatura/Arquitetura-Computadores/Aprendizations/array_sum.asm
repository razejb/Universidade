
Prentende-se desenvolver uma função int array_sum(int array[], int size) que calcule a soma de um array de inteiros.

Se o tamanho do array for zero, a soma deverá ser zero.

Escreva a função em assembly RISC-V.

Em C ficaria:

int array_sum(int array[], int size) 
{

int j = 0;
for(int i = 0; i < size; i++)
  {
    j = j + array[i] ;
  } 
  return j;
}


Em risc-v ficaria:

array_sum:
    addi sp, sp, -4    # reserva espaço na pilha para salvar o registrador ra
    sw ra, 0(sp)       # salva o registrador ra na pilha
    
    li t1, 0           # inicializa o acumulador com zero
    li t2, 0           # inicializa o índice do loop com zero
    
    bnez a1, loop      # se o tamanho do array não for igual a zero, salta para o loop
    
    j exit             # retorna zero
    
loop:
    lw t3, 0(a0)       # carrega o valor do array em t3
    addi a0, a0, 4     # incrementa o ponteiro do array em 4 bytes
    add t1, t1, t3     # soma o valor do array no acumulador
    addi t2, t2, 1     # incrementa o índice do loop em 1
    
    blt t2, a1, loop   # se o índice do loop for menor que o tamanho do array, volta para o início do loop
    
exit:
    lw ra, 0(sp)       # restaura o registrador ra
    addi sp, sp, 4     # libera o espaço na pilha
    mv a0, t1          # move o resultado para o registrador de retorno
    ret                # retorna o resultado

