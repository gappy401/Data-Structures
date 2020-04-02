import java.util.*;
//note to delete a list in java makde node null
public class SLL_Merge
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
    public static SLL_Merge ins(SLL_Merge list,int data)
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
    public static int len(SLL_Merge list)
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

    public static void printL(SLL_Merge list)
    {
        Node currNode = list.head; 
        while (currNode != null) { 
            
            System.out.print(currNode.data + " "); 
            currNode = currNode.next; 
        } 
    
    }
    public static SLL_Merge  mergeList(SLL_Merge list,SLL_Merge list2)
    {
        Node h1=list.head,h2=list2.head;
        if(list.head==null)
        return list2;
        else if (list2.head==null)
        return list;
        else 
        {
            while(h1.next !=null)
            {
                h1=h1.next;
            }
            h1.next=h2;
        }
        
        

    return list;
    }
    
   

    public static void main(String args[]) {
      //  Scanner s = new Scanner(System.in);
        SLL_Merge l2 = new SLL_Merge();
        SLL_Merge l1 = new SLL_Merge();
        ins(l2, 10);
        ins(l2, 20);
        ins(l2, 10);
        ins(l2, 60);
        ins(l2, 30);
        ins(l2, 20);
        ins(l2, 20);
        
        ins(l1, 15);
        ins(l1, 77);
        ins(l1, 32);
        ins(l1, 87);
        ins(l1, 11);
        ins(l1, 34);
        ins(l1, 62);

        l1=mergeList(l1,l2);
        
    
       
       
      // System.out.println(palin(l2));
     
       printL(l1);
      
      

       
        
    }
}