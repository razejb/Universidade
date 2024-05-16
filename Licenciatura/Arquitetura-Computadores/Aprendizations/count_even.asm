

Pretende-se desenvolver uma função int count_even(int a, int b) que conte os números pares entre a e b, inclusivé. Assume-se que a é menor ou igual a b.

Exemplos:

    count_even(2, 6) deve retornar 3.
    count_even(1, 5) deve retornar 2.
    count_even(2, 2) deve retornar 1.
    count_even(3, 3) deve retornar 0.

Escreva a função em assembly RISC-V. Não inclua a função main.

O código em C ficaria:

int count_even(int a, int b)
{
  int j;
  for(int i = a; i <= b; i++ )
    {
      if(i % 2 == 0)
      {
        j++ ;
      }
    }
    
  return j;
}


Em risc-v ficaria:

count_even:
    li s0, 0		      # Inicializa o contador j com 0   
    mv t0, a0         # Move o valor de a0 para t0 (variavel i)

loop:
    bgt t0, a1, exit  # Verifica se t0(i) é maior que a1(b)
    andi t1, t0, 1    # Mascara o bit menos significativo
    beqz t1, counter  # Se for 0, é par
    addi t0, t0, 1    # Incremeta t0(i)
    j loop            

counter:
    addi s0, s0, 1    # Incrementa s0(j)
    addi t0, t0, 1    # Incrementa t0(j)
    j loop

exit:
    mv a0, s0         # Move o valor s0(j) para a0
    ret

