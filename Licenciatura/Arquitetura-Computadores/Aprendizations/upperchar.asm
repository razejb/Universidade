Pretende-se uma função upperchar que converta um carácter de letra minúscula para maiúscula. Se o carácter não for uma letra minúscula, então a função deve retornar o carácter inalterado.

O protótipo da função em C seria:

    char upperchar(char c);

Escreva a função em assembly RISC-V. A tabela ASCII para as letras maiúsculas e minúsculas encontra-se na tabela seguinte.

upperchar:

	li t1, 97           	# carácter 'a' em ASCII
	li t2, 122          	#carácter 'z' em ASCII
	
	blt a0, t1, exit	# se a0 < t1, sai da função
	bge t1, a0, verifica    # se t1 >= a0, verifica
	
	
	verifica:
	bgt a0, t2, exit	# se a0  > t2, sai da funcao
	ble t2, a0, converte    # se t2 >= a0, converte
	
	converte:
	addi a0, a0, -32    	# converte a letra minúscula em maiúscula, alterando o valor em t0

exit:
	ret                
	               	    	
	
	
	
