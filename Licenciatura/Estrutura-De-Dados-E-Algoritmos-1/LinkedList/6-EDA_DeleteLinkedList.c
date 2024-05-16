/*--------------------------------------------------------------
|                                                              |
|                     Made by: João Santos                     |
|                                                              |
--------------------------------------------------------------*/



#include <stdio.h>
#include <stdlib.h>


struct Node
{
    int data;
    struct Node *next;  
}
*first = NULL;

void create(int A[], int n)
{
    int i;
    struct Node *t, *last;

    // Cria o primeiro nó
    first = (struct Node *)malloc(sizeof(struct Node));
    first->data = A[0];
    first->next = NULL;
    last = first;

    // Cria e conecta os nós restantes
    for (i = 1; i < n; i++)
    {
        t = (struct Node*)malloc(sizeof(struct Node));
        t->data = A[i] ;
        t->next=NULL ;
        last->next = t;
        last = t;
    }
}

// Conta o número de nós na lista
int count(struct Node *p)
{
    int l = 0;

    while(p)
    {
        l++;
        p = p->next;
    }
    return l;
}

// Exibe os elementos da lista
void Display(struct Node *p)
{
    while(p != NULL)
    {
        printf("%d ", p->data) ;
        p = p->next ;
    }
}

// Exibe os elementos da lista de forma reversa usando recursão
void RDisplay(struct Node *p)
{
    if(p != NULL)
    {
        RDisplay(p->next);
        printf("%d ", p->data) ;
    }
}

// Exclui um elemento da lista com base no índice
int Delete(struct Node *p, int index)
{
    struct Node *q = NULL;
    int x = -1, i;

    if(index < 1 || index > count(p))
        return -1;
    
    if(index == 1)
    {
        q = first;
        x = first->data;
        free(q);
        return x;
    }
    else
    {
        for(i = 0; i < index - 1; i++)
        {
            q = p;
            p = p->next;
        }
        q->next = p->next;
        x = p->data;
        free(p);
        return x;
    }
}

int main() 
{
    int A[] = {3, 5, 7, 12, 16};
    create(A, 5);
    
    printf("Valor excluído: %d\n", Delete(first, 2));

    Display(first);
    return 0;
}

