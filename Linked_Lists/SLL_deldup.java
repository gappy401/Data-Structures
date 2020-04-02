import java.util.*;
//note to delete a list in java makde node null
public class SLL_deldup
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
    public static SLL_deldup ins(SLL_deldup list,int data)
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
    public static int len(SLL_deldup list)
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

    public static void printL(SLL_deldup list)
    {
        Node currNode = list.head; 
        while (currNode != null) { 
            
            System.out.print(currNode.data + " "); 
            currNode = currNode.next; 
        } 
    
    }
    public static SLL_deldup  rmove_dup_srted(SLL_deldup list)
    {
        Node head = list.head;
        Node next=head.next;
        while(head.next !=null)
        {
            if(head.data==next.data)
            {
                head.next=next.next;
                next=next.next;
            }
            else
            {
                head=head.next;
                next=next.next;
            }
        }

    return list;
    }
    
    public static SLL_deldup  rmove_dup_notsrted(SLL_deldup list)
    {
        Node head = list.head;
        Node next=head.next;
        Node prev=head;
        while(head.next !=null)
        {    
            while(next.next !=null)
            {
              if(head.data==next.data )
              {
                  prev.next=next.next; //have a tab of prev of next so that you can del it
                //next.data=-1;
               
              } //10->11->12
              prev=next;
              next=next.next;
            }
            if(head.data==next.data )
              {
                prev.next=null;
               
              }
            head=head.next;
            prev=head;
            next=head.next;
            
        }

    return list;
    }



    public static void main(String args[]) {
      //  Scanner s = new Scanner(System.in);
        SLL_deldup l2 = new SLL_deldup();
        //SLL_deldup l1 = new SLL_deldup();
        ins(l2, 10);
        ins(l2, 20);
        ins(l2, 10);
        ins(l2, 60);
        ins(l2, 30);
        ins(l2, 20);
        ins(l2, 20);
    
       
       
      // System.out.println(palin(l2));
       l2=rmove_dup_notsrted(l2);
       printL(l2);
      
      

       
        
    }
}