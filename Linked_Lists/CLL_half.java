import java.util.*;
//note to delete a list in java makde node null
public class CLL_half
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
    public static CLL_half ins(CLL_half list,int data)
    {
        Node n1=new Node(data);
       // n1.next=null;
        Node h1=list.head;

        if (list.head == null) { 
          //  System.out.println("Nerr");
            list.head = n1; 
            n1.next=n1;
        } 
        else { 
            //System.out.println("N");
       
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
    public static int len(CLL_half list)
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

    public static void printL(CLL_half list)
    { Node h1=list.head;
        //System.out.println(h1.data +""+h1.next.data);
        Node currNode = list.head; 
        while (currNode.next != h1) { 
            
            System.out.print(currNode.data + " "); 
            currNode = currNode.next; 
        } 
        System.out.print(currNode.data + " "); 
        System.out.println("  ");

    
    }
   /* public static  CLL_half del(CLL_half list,int item)
    {
        Node curr=list.head;
        Node prev=curr;
        if(curr.data == item)
        {
            list.head =curr.next;   
        }
        while(curr.data!=item)
        {
            prev=curr;
            curr= curr.next;
        }
        prev.next=curr.next;

        return list;

    }*/
    public static CLL_half half (CLL_half list)
    {
        CLL_half l2=new CLL_half(); 
        Node h1=list.head;
        int x= len(list); 
        Node h2=list.head;//length 
       
        if(x>1)
        {
            x=x/2;
            x=x-1;
         
         while(x>0)
         { 
            h1=h1.next;
            x--;
         }  
        Node h1_end=h1;
        h2=h1_end.next;
        l2.head=h2;
        h1_end.next=list.head; //first list donr
     
       
        Node h2_end =h2;
        while(h2_end.next !=list.head)
        {
            h2_end=h2_end.next;
        }    
        h2_end.next=h2;
      
        }
       

        

        return l2;
    }
    

    public static void main(String args[]) {
      //  Scanner s = new Scanner(System.in);
        CLL_half l2 = new CLL_half();
        CLL_half l1 = new CLL_half();
        ins(l2,10);
    
         ins(l2,18);
         ins(l2,199);
         ins(l2,111);
         ins(l2,181);
         ins(l2,10000);
       
        System.out.println(len(l2));
        l1= half(l2); //second list
        printL(l1);
        printL(l2);


    
        
   
    }
}