#include <iostream> 
using namespace std; 
  //Note that head in this program is empty and doesn't have any datavalue
class Single_List
{
    public:
    int x;
    Single_List *next;

    Single_List();
    Single_List(int y)
    {
        x=y;
        next=NULL;      
    
    }

}; 


void ins_end(Single_List *head,int data)
{
     Single_List *addthis = new Single_List(data);
    
    Single_List *temp=head->next;
    if(head->next==NULL)
    {
        head->next=addthis;
    }
    else
    {

    
    while(temp->next !=NULL)
    {
       temp=temp->next;
    }

    temp->next=addthis;
    addthis->next=NULL;
    }
    


}
void ins_start(Single_List *head,int data)
{
     Single_List *addthis = new Single_List(data);
    
    Single_List *temp=head;

    
addthis->next=head->next;
head->next=addthis;
    
    


}

void insertNodeAtPosition(Single_List* head, int data, int n) {
    Single_List *t1 =new Single_List(data) ;
    t1->x=data;
    
    Single_List *temp=head;
    for(int i=0;i<n-1;i++)
    {
         temp=temp->next;


    }
     t1->next=temp->next;
     temp->next=t1;

     



}



void display(Single_List *head)
{
    Single_List *temp=head->next;
    if(head->next==NULL)
    {
        
        
        cout<<"Only head present \n";
    }
    else
    {
       while(temp->next !=NULL)
       {
        cout<<temp->x<<"----->";
        temp=temp->next;
       }
       cout<<temp->x<<"\n";
    }
}




int main(void)
{ int x=100;
    Single_List *head ;
        head->next=NULL;
    while(x>10)
    {
        
        cout<<" 1.To insert at start \n 2.To insert at end \n 3.To insert at n \n 4.To delete at start \n 5.To delete at n \n 6.Display \n 7.Exit \n";
        int n;
        cin>>n;
        switch(n)
        {
            case 1: int d2;
            cin>>d2; 
            ins_start(head,d2);
            break;
            
            case 2: int d1;
            cin>>d1; 
            ins_end(head,d1);
            break;
            
            case 3: int d,n;
            cout<<"Give node followed by position in an array!";
            cin>>d;
            cin>>n;
             insertNodeAtPosition(head,d,n);
            break;
            case 6: display(head);
            break;
            case 7: x=-1;
             break;

        }
    }

}