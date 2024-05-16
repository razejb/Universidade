A biblioteca standard da linguagem C inclui a função atoi para converter uma string de algarismos num número inteiro. Se a string não contiver digitos, a função retorna 0.

O protótipo da função é o seguinte:

int atoi(char a[]);
~

Por exemplo,

    atoi("123") retorna o número inteiro 123.
    atoi("hello") retorna 0.
    atoi("123hello") retorna o número 123 correspondente ao início da string.

Escreva esta função em assembly RISC-V, sem usar a instrução mul. Assuma que os números nunca são negativos, pelo que não precisa de tratar este caso.

Em C ficaria:

int atoi(char a[])
{
  int i = 0; 
  int j = 0; 
  for(; a[i] != '\0'; i++)
  {

    if((a[i] >= 48) && (a[i] <= 57)) 
      {
        j = j * 10 + a[i] - '0';
     
      }
  }
  return j;
    

}


Em risc-v ficaria:

multi:
li t0, 0            # Inicia o registrador t0 com 0

Adiciona2:
beqz a1, Retorna2   # Se a1 == 0, salta para Retorna2
add t0, t0, a0      # t0 = t0 + a0

addi a1, a1, -1     # a1 = a1 - 1
bnez a1, Adiciona2  # Se a1 != 0, salta para Adiciona2


Retorna2:
mv a0, t0           # Move o valor de t0 para a0
ret 

atoi:
addi sp, sp, -12    # Aloca espaço na pilha para guardar os registradores
sw ra, 0(sp)        # Salva o registrador ra na pilha
sw s0, 4(sp)        # Salva o registrador s0 na pilha
sw s1, 8(sp)        # Salva o registrador s1 na pilha


li s0, 48           # Caractere '0' na tabela ASCII
li s1, 57           # Caractere '9' na tabela ASCII
li s3, 0            # Inicializa a contagem de caracteres lidos com 0
li s5, 0            # Inicializa o valor do número com 0
mv s6, a0           # Move o ponteiro da string para s6


LoopLeitura:

lbu s2, 0(s6)       # Lê o próximo caractere da string
blt s2, s0, Retorna # Se o caractere lido for menor que '0', salta para Retorna
bgt s2, s1, Retorna # Se o caractere lido for maior que '9', salta para Retorna

sub s2, s2, s0      # Converte o caractere em um número inteiro

beqz s3, AlteraBit  # Se ainda não leu nenhum caractere, salta para AlteraBit
mv a0, s5           # Move o valor do número para a0
li a1, 10           # Define 10 como o multiplicador
jal multi           # Chama a função multi para multiplicar o valor por 10
mv s5, a0           # Move o resultado da multiplicação para s5


AlteraBit:
add s5, s5, s2      # Adiciona o valor lido ao número
addi s3, s3, 1      # Incrementa a contagem de caracteres lidos
addi s6, s6, 1      # Avança o ponteiro para a próxima posição da string
j LoopLeitura       # Retorna para LoopLeitura para continuar a leitura dos caracteres

Retorna:
mv a0, s5           # Move o valor do número para a0

lw ra, 0(sp)        # Restaura o registrador ra
lw s0, 4(sp)        # Restaura o registrador s0
lw s1, 8(sp)        # Restaura o registrador s1
addi sp, sp, 12     # Desaloca espaço na pilha
ret 
