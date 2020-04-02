import java.util.*;

import javax.lang.model.util.ElementScanner6;
public class DLL_Biotonic
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
public static DLL_Biotonic ins(DLL_Biotonic list,int item)
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
public static void printL(DLL_Biotonic list)
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
public static void del(DLL_Biotonic list,int item)
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
public static DLL_Biotonic rev(DLL_Biotonic list)
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
public static DLL_Biotonic ins_sort(DLL_Biotonic list,int item)
{ Node n=new Node(item);
    Node h1=list.head;
    while(h1 !=null)
    {
        if(h1.data<item)
        {
            h1=h1.next;
        }
        else
        break;
    }
        //h1 is more threfore before it
        if(h1==list.head)
       {   n.next=h1;
           h1.prev=n;
           list.head=n;
       }

        else
        {
            h1.prev.next=n;
            n.prev=h1.prev;
            n.next=h1;
            h1.prev=n;


         }
    

    return list;
}
public static DLL_Biotonic sortb(DLL_Biotonic list)
{
    Node h1=list.head,h2=list.head;
    Node temp=h1.next;
    while(h1.data<temp.data)
    { 
        if(temp.next==null)
        break;
      System.out.println(h1.data+ " "+temp.data);
        h1=h1.next;
        temp=temp.next;
        System.out.println(h1.data+ " "+temp.data + "LL");
    }
    
    h2=temp;

    h1=list.head;
    while(h2 !=null)
    {
        while(h1 !=null)
        {
            if(h1.data>h2.data)
            {
                if(h2.next==null)
                {
                    h2.prev.next=h2.next;
                   // h2.next.prev=h2.prev;
                   System.out.println(h2.data);
                    ins_sort(list,h2.data);
                }
                else
                {
                    h2.prev.next=h2.next;
                     h2.next.prev=h2.prev;
                     System.out.println(h2.data);

                     ins_sort(list,h2.data);

                }
               
                System.out.println("Here");
                break;
                
            }
            else
            {
                h1=h1.next;

            }
        }
        h2=h2.next;
        h1=list.head;
        
    }
   
            
    

   

    return list;
}




public static void main(String args[])
{
    DLL_Biotonic l1= new DLL_Biotonic();
    ins(l1, 10);
    ins(l1, 11);
    ins(l1, 23);
    ins(l1, 90);
    ins(l1, 1);
    ins(l1, 20);
    sortb(l1);
    
   printL(sortb(l1));


}

}