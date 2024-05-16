
A biblioteca standard da linguagem C inclui a função strlen que calcula o comprimento de uma string (sem contar com o carácter nulo). O protótipo da função é o seguinte:

int strlen(char a[]);

Escreva esta função em assembly RISC-V.

Em C ficaria:

int strlen(char a[])
{
  int i;
  for(i = 0; a[i] != '\0'; i++)
  {
  }
  return i - 1 ;
}

Em risc-v ficaria:

strlen:
    addi sp, sp, -4
    sw ra, 0(sp)

    li t1, 0   # Inicializa o contador (i)

loop:
    lb t0, 0(a0)   # Carrega o próximo caractere da string em t0
    beqz t0, exit   # Se for o caractere nulo, sai do loop

    addi a0, a0, 1  # Incrementa o ponteiro do array em 1 byte
    addi t1, t1, 1  # Incrementa o contador em 1

    j loop          # Volta para o início do loop

exit:
    lw ra, 0(sp)
    addi sp, sp, 4
    mv a0, t1       # Move o valor do contador para o registrador a0 (onde o valor de retorno deve ser colocado)
    ret
