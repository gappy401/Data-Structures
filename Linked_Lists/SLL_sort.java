import java.util.*;
//note to delete a list in java makde node null
public class SLL_sort
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
    public static SLL_sort ins(SLL_sort list,int data)
    {
        Node n1=new Node(data);
       // n1.next=null;
        

        if (list.head == null) { 
            list.head = n1; 
        } 
        else { 
       
            Node last = list.head; 
            while (last.next != null) { 
                last = last.next; 
            } 
  
            
            last.next = n1; 
        } 


        return list;
    }
    public static int len(SLL_sort list)
    {
        Node curr= list.head;
       if(curr.next==null)
       {
           return 0;
       }
    int x=1;
    while(curr.next!= null)
    {
        curr=curr.next;
        x++;
    }

    return x;

    }

    public static void printL(SLL_sort list)
    {
        Node currNode = list.head; 
        while (currNode != null) { 
            
            System.out.print(currNode.data + " "); 
            currNode = currNode.next; 
        } 
    
    }
    public static void sortt(SLL_sort list)
    { int x,y;
        Node curr=list.head;
        Node inner=curr.next;
        Node tochange=curr;
        while(curr.next!=null)
        {   y=curr.data;
            while(inner.next!=null)
            {
                if(inner.data<y)
                {
                    tochange=inner;
                }
                inner=inner.next;
              
            }
            if(inner.data<y)
            {
                tochange=inner;
            }
             x=tochange.data;
            tochange.data=y;
            curr.data=x;
            curr=curr.next;
            inner=curr.next;
           

        }
    }
  
    
   

    public static void main(String args[]) {
      //  Scanner s = new Scanner(System.in);
        SLL_sort l2 = new SLL_sort();
        SLL_sort l1 = new SLL_sort();
        ins(l2, 10);
        ins(l2, 20);
        ins(l2, 10);
        ins(l2, 60);
        ins(l2, 30);
        ins(l2, 20);
        ins(l2, 20);
      
        
    
       
       
      // System.out.println(palin(l2));
     sortt(l2);
       printL(l2);
      
      

       
        
    }
}