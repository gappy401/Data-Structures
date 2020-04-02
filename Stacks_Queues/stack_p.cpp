#include<iostream>
#include<stdio.h>
#include<stdlib.h>
using namespace std;
#define MAX 50
void push(int x);
int pop();
int *TOS, *P1,stack[MAX];
int main()
{
     TOS=stack;
        P1=stack; //both point to the top of the stack

        int choice;
    while(1)
    {int x;
       
        cout<<"Enter Push or pop";
        cin>>choice;
        if(choice>2)
        break;
        switch (choice)
        {
            case 1 :  cout<<pop();
            
            break;
            case 2 : int pu;
            cin>>pu;
            push(pu);
            break;
            

        }
    }

}
void push(int x)
{
    P1++;
    if(P1==(TOS+MAX))
    {
        cout<<"OVERFLOWWWWW";
        exit(1);

    }
    *P1=x;
   

}
int pop()
{ 
    
    if(P1==TOS)
    {
        cout<<"UNDERLOWWWWW";
        exit(1);

    }
    P1--;
    return *(P1+1);


}