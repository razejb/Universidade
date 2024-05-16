Pretende-se calcular o valor absoluto da diferença |x-y| entre dois números inteiros x e y. A seguinte função implementa esta operação em linguagem C.

int abs_diff(int x, int y)
{
  if(x > y)
    return x - y;
   else
    return y - x;
}

abs_diff:
bgt a0, a1, R
sub a0, a1, a0
ret

R:
sub a0, a0, a1
ret
 
