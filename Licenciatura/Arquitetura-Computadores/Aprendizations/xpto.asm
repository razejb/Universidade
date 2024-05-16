Considere as seguintes funções recursivas escrita em linguagem C:

int xpto(int n) {
  if (n == 0)
    return n;
  else
    return n + xpto(n - 1);
}

xpto:
    addi sp, sp, -8    
    sw ra, 4(sp)       
    sw s0, 0(sp)        
    
    mv s0, a0           # Move n para o registrador s0
    
    beqz s0, retorna    # Verifica se n == 0, se sim retorna n
    
    addi a0, s0, -1     # Subtrai 1 de n e move o resultado para o registrador a0
    jal xpto            # Chama a função xpto com o novo valor de n
    
    add a0, a0, s0      # Soma n ao valor retornado pela função xpto
    
retorna:
    lw s0, 0(sp)        
    lw ra, 4(sp)        
    addi sp, sp, 8      
    ret                 
    
    
 --------------------------------------------------------------------------------------
 
 int xpto(int n) {
  if (n == 0)
    return n;
  else
    return n | xpto(n >> 1);
}

xpto:

addi sp, sp, -8     
sw ra, 4(sp)        
sw s0, 0(sp)        

beqz a0, retorna    # verifica se o valor passado é zero, se sim, retorna zero
mv s0, a0           # move o valor de a0 (n) para s0

srai a0, a0, 1      # desloca os bits de a0 (n) para a direita por 1 posição
jal xpto            # chama a função xpto recursivamente com o novo valor de a0

or a0, s0, a0       # faz a operação "OR" bit a bit com o valor original de a0 (n) e o valor de retorno da chamada recursiva

retorna:
lw s0, 0(sp)       
lw ra, 4(sp)        
addi sp, sp, 8     
ret                




























