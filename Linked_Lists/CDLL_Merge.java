import java.util.*;
public class CDLL_Merge
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
public static CDLL_Merge ins(CDLL_Merge list,int item)
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
public static void printL(CDLL_Merge list)
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
public static void del(CDLL_Merge list,int item)
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
public static CDLL_Merge rev(CDLL_Merge list)
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
public static CDLL_Merge List_Merge( CDLL_Merge l1,CDLL_Merge l2)
{ CDLL_Merge temp= new CDLL_Merge();
    if(l1.head.data>l2.head.data) //to make l1 have smaller head
    {
        temp=l2;
        l2=l1;
        l1=temp;
        //printL(l1);
        //printL(l2);
    }
     Node h1=l1.head;
     Node  h2=l2.head;
   
        while(h2.next !=l2.head)
        {
            while(h1.next !=l1.head)
            {
                if(h2.data>h1.data)
                {
                    h1=h1.next;
                }
                else
                {
                    //add h2 behind of h1
                    Node n = new Node(h2.data);
                    n.next=h1;
                    n.prev=h1.prev;
                    h1.prev.next=n;
                    h1.prev=n;
                    break;

                }
            }
            h2=h2.next;
            h1=l1.head;

        }
        h1=l1.head;
      h2=l2.head;
     Node h1_last=h1.prev;
     Node h2_last=h2.prev;
        if(h1.prev.data>h2.prev.data)
        {
            h1_last.prev.next=h2_last;
            h2_last.prev=h1_last.prev;
            h2_last.next=h1_last;

            //insert l2 data before end of l1
        }
        else
        {
          h1_last.next=h2_last;
          h2_last.prev=h1_last;
          h2_last.next=h1;

        }
       
    




    return l1;
}
    
//Sorted circular linked lists get merged

public static void main(String args[])
{
    CDLL_Merge l1= new CDLL_Merge();
    ins(l1, 1);
    ins(l1, 15);
    ins(l1, 23);
    ins(l1, 45);
    ins(l1, 1200);
    CDLL_Merge l2= new CDLL_Merge();
   
    ins(l2, 0);
    ins(l2, 14);
    ins(l2, 22);
    ins(l2, 48);
    ins(l2, 120);

    l1=List_Merge(l1,l2);
    
    printL(l1);

}

}