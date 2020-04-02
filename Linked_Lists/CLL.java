import java.util.*;
//note to delete a list in java makde node null
public class CLL
{
    Node head;
    public static class Node
    {
        int data;
        Node next;
        Node(int x)
        {
            this.data=x;
            this.next=null;

        }

    }
    public static CLL ins(CLL list,int data)
    {
        Node n1=new Node(data);
       // n1.next=null;
        Node h1=list.head;

        if (list.head == null) { 
            System.out.println("Nerr");
            list.head = n1; 
            n1.next=n1;
        } 
        else { 
            System.out.println("N");
       
            Node last = list.head; 
            while (last.next != h1) 
            { 
                last = last.next; 
            } 
  
            
            last.next = n1; 
            n1.next=h1;
        } 


        return list;
    }
    public static int len(CLL list)
    {
        Node h1=list.head;
        Node curr= list.head;
       if(curr.next==h1)
       {
           return 0;
       }
    int x=1;
    while(curr.next!= h1)
    {
        curr=curr.next;
        x++;
    }

    return x;

    }

    public static void printL(CLL list)
    { Node h1=list.head;
        //System.out.println(h1.data +""+h1.next.data);
        Node currNode = list.head; 
        while (currNode.next != h1) { 
            
            System.out.print(currNode.data + " "); 
            currNode = currNode.next; 
        } 
        System.out.print(currNode.data + " "); 

    
    }
   public static  CLL del(CLL list,int item)
    {
       Node curr=list.head;
       if(curr.data==item)
       {
          
           Node h1=list.head;
           list.head=curr.next;
           while(curr.next!=h1)
           {
               curr=curr.next;
           }
           curr.next=list.head;

          
       }
       else
       {
           Node prev=curr;
           while(curr.data!= item)
           {
               prev=curr;
               curr=curr.next;
           }
           prev.next=curr.next;
           
       }
        return list;

    }
    

    public static void main(String args[]) {
      //  Scanner s = new Scanner(System.in);
        CLL l2 = new CLL();
        ins(l2,10);
    
        ins(l2,18);
        
        ins(l2,199);
        del(l2,10);
        printL(l2);
    
        
   
    }
}