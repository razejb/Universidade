Pretende-se desenvolver uma função int positive(int x) que verifique se um número é maior que zero. A função deve retornar 1 se x é positivo e 0 caso contrário.

positive:

li t0, 0

bgt a0, t0, POSITIVO
li a0, 0
ret

POSITIVO:
li a0, 1
ret

