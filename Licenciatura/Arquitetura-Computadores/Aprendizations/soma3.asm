

Pretende-se desenvolver uma função int soma3(int x, int y) que some os números inteiros no intervalo fechado de x a y, saltando de 3 em 3. Assuma que x é menor ou igual a y.

Exemplos:

    soma3(5, 5) retorna 5.
    soma3(5, 11) calcula 5+8+11.
    soma3(5, 16) calcula 5+8+11+14.

Escreva a função em assembly RISC-V.

Em C ficaria:

int soma3(int x, int y) {
    int z = 0;

    // Verifica se o intervalo é menor que 3
    if (y - x < 3) {
        return x;
    }

    // Calcula a soma pulando de 3 em 3
    z = x;
    while (z + 3 <= y) {
        z = z + 3;
        x = x + z;
    }

    return x;
}

Em risc-v:

soma3:
    addi sp, sp, -8                       #Cria espaço na pilha para salvar os registradores     
    sw ra, 0(sp)                          #Salva o ra na pilha
    sw s0, 4(sp)                          #Salva o s0 na pilha

# Inicializa a variável z com 0

li s0, 0                                 



# Verifica se o intervalo é menor que 3

sub t0, a1, a0                            #Subtrai a1 com a0(a1 - a0) e guarda o valor em t0
li t1, 3                                  
blt t0, t1, exit                          #Se for menor que 3, exit
mv s0, a0                                 #Caso contrário, define z, como o valor de x


loop:
# Verifica se z + 3 é menor ou igual a y
addi t0, s0, 3                           #Soma s0 com 3(s0 + 3) e guarda o valor em t0
bge t0, a1, exit                         #Se t0 > a1, exit


# Atualiza o valor de x
addi s0, s0, 3                          #Soma s0 com 3(s0 + 3) e guarda o valor em s0
add a0, a0, s0                          #Soma a0 com s0(a0 + s0) e guarda o valor em a0

# Repete o loop
j loop

exit:
    lw s0, 4(sp)                        #Restaura o valor de s0
    lw ra, 0(sp)                        #Restaura o valor de ra
    addi sp, sp, 8                      #Desfaz o espaço na pilha  
    ret 
         

