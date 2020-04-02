import java.util.*;
//note to delete a list in java makde node null
public class Single_List
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
    public static Single_List ins(Single_List list,int data)
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
    public static int len(Single_List list)
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

    public static void printL(Single_List list)
    {
        Node currNode = list.head; 
        while (currNode != null) { 
            
            System.out.print(currNode.data + " "); 
            currNode = currNode.next; 
        } 
    
    }
    public static  Single_List del(Single_List list,int item)
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

    }
    public static int recur(Node list)
    { Node curr= list;
        if(curr.next==null)
        {
            return 1;
        }
        else
        return 1+ get(curr.next);

    }
    public static int get(Node head) 
    { 
        return recur(head); 
    }
    
    public static String palin(Single_List list)
    {
        Node r = list.head;
        int y =len(list);
        int []check=new int[y];
        int i=0;
      while(r.next!=null)
      {
          check[i]=r.data;
          i++;
          r=r.next;
      }
      check[i]=r.data;

      for(int k=0;k<y/2;k++)
      {
          if(check[k]==check[y-k-1])
          {
              continue;
          }
          else
          return "No";
        }


        return "Yes";
    }
    public static Single_List reveList( Single_List list)

    { Node h=list.head;
       
        if(h.next==null)
        {
            System.out.println("List is empty");
        }
        
        else
        {
            Node node=list.head;
           
        Node prev = null; 
        Node current = node; 
        Node next = null; 
        while (current != null)
         { 
            next = current.next; //20  
            current.next = prev; //10->null
            prev = current; //prev=10
            current = next; //current =20
        } 
        node = prev; 
        list.head=node;
         
            
        }

        return list;    

    }

    public static void main(String args[]) {
      //  Scanner s = new Scanner(System.in);
        Single_List l2 = new Single_List();
        //Single_List l1 = new Single_List();
        ins(l2, 10);
        ins(l2, 20);
        ins(l2, 10);
        ins(l2, 60);
        ins(l2, 30);
        ins(l2, 20);
        ins(l2, 20);
        del(l2, 10);
        reveList(l2);
        
        int u=len(l2);
        printL(l2);
        System.out.println(palin(l2)+ "" +u);
   
    }
}