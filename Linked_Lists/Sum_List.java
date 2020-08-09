import java.util.*;
//note to delete a list in java makde node null
public class Sum_List
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
    public static Sum_List ins(Sum_List list,int data)
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
    public static int len(Sum_List list)
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

    public static void printL(Sum_List list)
    {
        Node currNode = list.head; 
        while (currNode != null) { 
            
            System.out.print(currNode.data + " "); 
            currNode = currNode.next; 
        } 
    
    }
     
     public static void SUM(Sum_List l1,Sum_List l2) //del and add to end
     {
        String append="";
         Node curr1=l1.head,curr2=l2.head;
         int carry=0;
         while(curr1 !=null && curr2!=null)
         {
             int sum=curr1.data + curr2.data+carry;
             carry= sum/10;
             append+= sum%10;
             curr1=curr1.next;
             curr2=curr2.next;

         }
         if(curr1!=null)
         {
            int sum=curr1.data +carry;
            carry= sum/10;
            append+= sum%10;
            curr1=curr1.next;

         }
         if(curr2!=null)
         {
            int sum=curr2.data +carry;
            carry= sum/10;
            append+= sum%10;
            curr2=curr2.next;

         }
         System.out.println(append+" "+carry);
     }

    public static void main(String args[]) {
      //  Scanner s = new Scanner(System.in);
        Sum_List l2 = new Sum_List();
        Sum_List l1 = new Sum_List();
        ins(l2, 1);
        ins(l2, 1);
        ins(l2,9);
        ins(l1, 1);
        ins(l1, 6);
        ins(l1, 3);
        ins(l1,3);
        SUM(l1,l2);
   
    }
}