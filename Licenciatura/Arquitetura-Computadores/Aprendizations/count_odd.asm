Escreva a função count_odd(int a, int b)(ímpar) em assembly RISC-V, sem usar instruções de multiplicação, divisão ou resto da divisão. Pode assumir que a é sempre menor ou igual a b.
Não inclua a função main.

count_odd:

mv t0, a0
andi t1, a0, 1
beq a0, a1, iguais
beq t1, zero, par

impar_conta:
li t2, 1

counter:
addi t0, t0, 2
bgt t0, a1, fim

addi t2, t2, 1
j counter

par:
addi t0, t0, 1
j impar_conta

fim:
mv a0, t2
ret

iguais:
mv a0, t1
ret


