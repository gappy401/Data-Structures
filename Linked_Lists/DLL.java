import java.util.*;
public class DLL
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
public static DLL ins(DLL list,int item)
{ Node n=new Node(item);
Node h=list.head;
if(h==null)
{
    list.head=n;

}
else
{
    while(h.next != null)
    {
        h=h.next;
    }
    h.next=n;
    n.prev=h;

}

    return list;
}
public static void printL(DLL list)
    { Node h1=list.head;
        //System.out.println(h1.data +""+h1.next.data);
        Node currNode = list.head; 
        while (currNode.next != null) { 
            
            System.out.print(currNode.data+ " " ); 
         /*   if(currNode.prev !=null)
            {
                System.out.println(currNode.prev.data  +"prevvvv");
            }*/
            currNode = currNode.next; 
        } 
        System.out.print(currNode.data + " "); 

    
    }
public static void del(DLL list,int item)
{
    Node h1 =list.head;
    if(h1.data ==item)
    {
        list.head=h1.next;
        h1=h1.next;
        h1.prev=null;
    }
    else
    {
        while(h1.data !=item)
        {
            h1=h1.next;

        }
        if(h1.next==null)
        {
            h1.prev.next=null;
        }
        else
        {
            Node pre=h1.prev;
            pre.next=h1.next;
            h1.next.prev=pre;

        }
       
    }

}
public static DLL rev(DLL list)
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
    DLL l1= new DLL();
    ins(l1, 100);
    ins(l1, 156);
    ins(l1, 23);
    ins(l1, 45);
    ins(l1, 12);
    
    printL(rev(l1));


}

}