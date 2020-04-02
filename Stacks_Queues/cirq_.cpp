#include<iostream>
#include<stdio.h>
#include<stdlib.h>
using namespace std;
#define MAX 5
void push(int x);
int pop();
int *FRONT, *REAR,*MAXXX,stack[MAX];
int main()
{
     FRONT=stack;
        REAR=stack;
        MAXXX=(stack+MAX); //both point to the top of the stack
      
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
    
    if(REAR==MAXXX)
    {
        cout<<"OVERFLOWWWWW";
        exit(1);

    }
    *REAR=x;
    REAR++;
   

}
int pop()
{ 
    
    if(FRONT==REAR)
    {
        cout<<"UNDERLOWWWWW";
        exit(1);

    }

    FRONT++;
    return *(FRONT-1);


}