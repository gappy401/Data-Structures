import java.util.*;
public class CDLL
{
Node head;
public static class Node
{
    int data;
    Node next=null;
    Node prev=null;
    Node(int x)
    {
    this.data=x;
    
    }
}
public static CDLL ins(CDLL list,int item)
{ Node n=new Node(item);
Node h=list.head;
if(h==null)
{
    list.head=n;
    n.prev=n;
    n.next=n;

}
else
{
    while(h.next != list.head)
    {
        h=h.next;
    }
    h.next=n;
    n.prev=h;
    n.next=list.head;
    list.head.prev=n;

}

    return list;
}
public static void printL(CDLL list)
    { Node h1=list.head;
        //System.out.println(h1.data +""+h1.next.data);
        Node currNode = list.head; 
        while (currNode.next != list.head) { 
            
            System.out.print(currNode.data+ " " ); 
         /*   if(currNode.prev !=null)
            {
                System.out.println(currNode.prev.data  +"prevvvv");
            }*/
            currNode = currNode.next; 
        } 
        System.out.print(currNode.data + " "); 

    
    }
public static void del(CDLL list,int item)
{
    Node h1 =list.head;
    if(h1.data ==item)
    {
        list.head=h1.next;
        h1.prev.next=h1.next;
        h1.next.prev=h1.prev;
       
       
    }
    else
    {
        while(h1.data !=item)
        {
            h1=h1.next;

        }
        //h1 needs to be deleted
        h1.prev.next=h1.next;
        h1.next.prev=h1.prev;

        
       
    }

}
public static CDLL rev(CDLL list)
{
    Node curr=list.head;
    Node temp =null;
 if(list!=null)
 {
    while (curr != null)  
    {  
        temp = curr.prev;  
        curr.prev = curr.next;  
        curr.next = temp;              
        curr = curr.prev;  
    } 
    list.head=temp.prev;
    
 }
 
    
    return list;
}


public static void main(String args[])
{
    CDLL l1= new CDLL();
    ins(l1, 100);
    ins(l1, 156);
    ins(l1, 23);
    ins(l1, 45);
    ins(l1, 12);
    del(l1,100);
    del(l1,12);
    
    printL(l1);

}

}