Pretende-se desenvolver uma função int array_magic(int arr[], int sz) que verifica se algum dos números do array arr tem uma certa propriedade "mágica".

Para verificar essa propriedade, existe uma função int is_magic(int n) que será necessário usar. Esta função retorna 1 ou 0 consoante o argumento n tem a 
propriedade mágica ou não, respetivamente.

A função array_magic está parcialmente escrita. A ideia é percorrer o array verificando cada elemento, e retornar 1 se algum elemento for mágico. se o array 
for vazio a função deve retornar 0.

O objetivo é completar a função nos locais marcados com ??? e escrever o prólogo e epílogo marcados em comentário. Não modifique as instruções já existentes. 
Não inclua a função main nem a is_magic.

array_magic:

#
# prólogo
#
mv ???, a0          # array
mv ???, a1          # tamanho
beqz s4, L2         # se array vazio termina
li s5, 1

L1:
lw a0, 0(s1)        # lê número do array
jal is_magic        # verifica número mágico
bnez ???, L3        # encontrei um mágico

addi s1, s1, ???    # avança para próximo elemento do array
addi s4, s4, -1
bgtz s4, L1         # repete ciclo para próximo elemento do array

L2:
li s5, 0

L3:
mv a0, ???
#
# epílogo
#
ret

----------------------

array_magic:

addi sp, sp, -16
sw s5, 12(sp)
sw s4, 8(sp)
sw s1, 4(sp)
sw ra, 0(sp)


mv s1, a0           # array
mv s4, a1           # tamanho
beqz s4, L2         # se array vazio termina
li s6, 1

L1:
lw a0, 0(s1)        # lê número do array
jal is_magic        # verifica número mágico
bnez a0, L3         # encontrei um mágico

addi s1, s1, 4      # avança para próximo elemento do array
addi s4, s4, -1
bgtz s4, L1         # repete ciclo para próximo elemento do array

L2:
li s5, 0

L3:
mv a0, s5

lw ra, 0(sp)
lw s1, 4(sp)
lw s4, 8(sp)
lw s5, 12(sp)
addi sp, sp, 16
ret









