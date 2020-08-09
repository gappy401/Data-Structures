import java.util.*;
//note to delete a list in java makde node null
public class SLL_Part
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
    public static SLL_Part ins(SLL_Part list,int data)
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
    public static int len(SLL_Part list)
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

    public static void printL(SLL_Part list)
    {
        Node currNode = list.head; 
        while (currNode != null) { 
            
            System.out.print(currNode.data + " "); 
            currNode = currNode.next; 
        } 
    
    }
     
     public static SLL_Part Part(SLL_Part list,int x) //del and add to end
     {
        SLL_Part less = new SLL_Part();
        SLL_Part more = new SLL_Part();
        Node curr=list.head;
        while(curr!=null)
        {
            if(curr.data>x)
            {
                ins(more,curr.data);
                curr=curr.next;
            }
            if(curr.data<x)
            {
                ins(less,curr.data);
                curr=curr.next;
            }
        }
        Node end=less.head;
        while(end.next!=null)
        {
            end=end.next;
        }
        end.next=more.head;
     return less;  
     }

    public static void main(String args[]) {
      //  Scanner s = new Scanner(System.in);
        SLL_Part l2 = new SLL_Part();
        //SLL_Part l1 = new Single_List();
        ins(l2, 10);
        ins(l2, 11);
        ins(l2,99);
        ins(l2, 14);
        ins(l2, 60);
        ins(l2, 30);
        ins(l2, 24);
        ins(l2, 20);
        
        int u=len(l2);
       SLL_Part less=Part(l2,21);
        printL(less);
   
    }
}