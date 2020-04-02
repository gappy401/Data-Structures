import java.util.*;
//note to delete a list in java makde node null
public class Jhosephus_CLL
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
    public static Jhosephus_CLL ins(Jhosephus_CLL list,int data)
    {
        Node n1=new Node(data);
       // n1.next=null;
        Node h1=list.head;

        if (list.head == null) { 
          
            list.head = n1; 
            n1.next=n1;
        } 
        else { 
           
       
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
    public static int len(Jhosephus_CLL list)
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

    public static void printL(Jhosephus_CLL list)
    { Node h1=list.head;
        //System.out.println(h1.data +""+h1.next.data);
        Node currNode = list.head; 
        while (currNode.next != h1) { 
            
            System.out.print(currNode.data + " "); 
            currNode = currNode.next; 
        } 
        System.out.print(currNode.data + " "); 

    
    }
   public static  Jhosephus_CLL del(Jhosephus_CLL list,int item)
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
    public static  Jhosephus_CLL deln(Jhosephus_CLL list,int n)
    {
       Node curr=list.head;
       if(n==0)
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
           while(n>0 && curr.next !=list.head)
           {
               prev=curr;
               curr=curr.next;
               n--;
           }
           prev.next=curr.next;
           
       }
        return list;

    }
 
    public static int freedom(Jhosephus_CLL list,int len,int exe)
    { int x=0;
        int ans=0;
        while(len>1)
        { // 1 2 3 4 5  3
            // 1 2 4 5   2
            // 2 4 5     2
            // 2 4       1

             x=x+exe;
             if(x>len)
             {
                 x=x%len;
                 
             }
           
          // System.out.println( "x"+x+ "len  "+ len);
            deln(list,x-1);
            x--;
            
            len--;
            //printL(list);
            //System.out.println("im out");
        }
       


      ans=list.head.data;
        return ans;

    }
    

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        Jhosephus_CLL l2 = new Jhosephus_CLL();
        int len= s.nextInt();
        int exe=s.nextInt();
        for(int i=0;i<len;i++)
        {
            ins(l2,i+1);
        }
        printL(l2);
        System.out.println(freedom(l2, len, exe));
    
       
        s.close();
   
    }
}