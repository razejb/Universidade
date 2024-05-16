

Pretende-se desenvolver uma função int count_special(char s[]) que conte o número de caracteres "especiais" existentes na string s. Para determinar se um carácter é especial, é usada uma função já existente int is_special(char c) que retorna 1 se c for especial e 0 se não for.

Para contar os caracteres especiais foi desenvolvida a função seguinte, que está incompleta. Faltam alguns registos (indicados com ???) e algumas outras coisas que terá de adicionar à função.

 count_special:
    mv ???, a0      # string
    li s1, 0        # contador
L1:
    lbu a0, 0(s0)   # le char
    beqz a0, ???    # verifica nulo
    jal is_special  # verifica especial
    add s1, s1, ??? # soma 1 se especial, caso contrario soma 0
    addi s0, s0, 1  # endereco proximo char
    j L1
L2:
    mv ???, s1      # retorna valor do contador
    ret

A sua tarefa é completar esta função (não implemente a função is_special nem a main). Para facilitar, a função encontra-se copiada em baixo.

count_special:
	addi sp, sp, -12
    sw ra, 8(sp)
    sw s0, 4(sp)
    sw s1, 0(sp)

    mv s0, a0      # string
    li s1, 0        # contador
L1:
    lbu a0, 0(s0)   # le char
    beqz a0, L2    # verifica nulo
    jal is_special  # verifica especial
    add s1, s1, a0 # soma 1 se especial, caso contrario soma 0
    addi s0, s0, 1  # endereco proximo char
    j L1
L2:
	mv a0, s1      # retorna valor do contador
	lw s1, 0(sp)
    lw s0, 4(sp)
    lw ra, 8(sp)
    addi sp, sp, 12
    
    ret
