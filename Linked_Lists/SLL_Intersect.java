import java.util.*;
//note to delete a list in java makde node null
public class SLL_Intersect
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
    public static SLL_Intersect ins(SLL_Intersect list,int data)
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
    public static int len(SLL_Intersect list)
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

    public static void printL(SLL_Intersect list)
    {
        Node currNode = list.head; 
        while (currNode != null) { 
            
            System.out.print(currNode.data + " "); 
            currNode = currNode.next; 
        } 
    
    }
    public static SLL_Intersect  intersect(SLL_Intersect list,SLL_Intersect list2)
    {
        Node h1=list.head;
       
        Node h2=list2.head;
        int flag =0;
        while(h2.next!=null)
        {
            while(h1.next !=null)
            {
                if(h2.data==h1.data)
                {
                    flag=1;
                    break;
                }
                h1=h1.next;

            }
            if(flag==1)
            {
                flag=0;
                h2=h2.next;
              
            }
            else
            {
               ins(list,h2.data);
               h2=h2.next;
                
               

            }
            h1=list.head;
           


        }



        
    return list;
    }
    
    
     



    public static void main(String args[]) {
      //  Scanner s = new Scanner(System.in);
        SLL_Intersect l2 = new SLL_Intersect();
        SLL_Intersect l1 = new SLL_Intersect();
        ins(l2, 10);
        ins(l2, 20);
       
        ins(l2, 60);
        ins(l2, 15);
       

        ins(l1, 15);
        ins(l1, 77);
        ins(l1, 32);
        ins(l1, 87);
        ins(l1, 11);
        ins(l1, 34);
        ins(l1, 60);
    
       
       
      // System.out.println(palin(l2));
     
       printL(intersect(l1, l2));
      
      

       
        
    }
}