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

// Insere um elemento na lista em uma determinada posição
void Insert(struct Node *p, int index, int x)
{
    struct Node *t;
    int i;

    if(index < 0 || index > count(p))
        return;

    t = (struct Node *)malloc(sizeof(struct Node));
    t->data = x ;

    if (index == 0)
    {
        t->next = first;
        first = t;
    }
    else
    {
        for(i = 0; i < index - 1; i++)
            p = p->next;

        t->next = p->next;
        p->next = t;
    }
}

int main() 
{
    int A[] = {3, 5, 7};
    create(A, 3);
    
    Insert(first, 0, 5);

    Display(first);
    return 0;
}

