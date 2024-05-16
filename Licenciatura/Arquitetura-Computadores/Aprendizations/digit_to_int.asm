

No código ASCII, os caracteres '0' a '9' são representados pelos números 48 a 57.

Neste problema, pretende-se converter de algarismos ASCII para os números inteiros correspondentes. Escreva, em Assembly RISC-V, uma função int digit_to_int(char) que faça essa conversão. No caso do carácter não ser um dígito a função deve retornar o valor -1.

Por exemplo, digit_to_int('3') deve retornar o inteiro 3, enquanto que digit_to_int('a') deve retornar -1.




digit_to_int:


    addi sp, sp, -4      # reserva espaço na pilha para salvar o registrador ra
    sw ra, 0(sp)         # salva o registrador ra na pilha

   
    li t1, 48            # carrega o valor 48 na variável temporária t1
    li t2, 57            # carrega o valor 57 na variável temporária t2
   
    
    blt a0, t1, exit     # se a0 < t1, sai da funcao
    bgt a0, t2, exit     # se a0 > t2, sai da funcao
    sub a0, a0, t1       # subtrai a0 com t1
ret


exit:
    li a0, -1
    lw ra, 0(sp)         # restaura o registrador ra
    addi sp, sp, 4       # libera o espaço na pilha
                         # move o resultado para o registrador de retorno
ret  






