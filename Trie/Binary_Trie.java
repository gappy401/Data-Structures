
import java.util.*;
public class Binary_Trie
{
    private class Node
    {
        Map<Character,Node> children;
        boolean eow=false;
        Map<Character,Integer>num;
        public Node()
        {
            children=new HashMap();
            num=new HashMap<>();
            eow=false;
        }
    }
    private final Node root;
    public Binary_Trie() {
        root = new Node();
    }
   public void  insert(String word)
   { Node curr=root;
    for(int i=0;i<word.length();i++)
    {
        char ch=word.charAt(i);
        Node n=curr.children.get(ch);
        if(n==null)
        {
           n =new Node();
           curr.children.put(ch,n);
           curr.num.put(ch, 1);
        }
        else{
            curr.num.put(ch, curr.num.get(ch)+1);
        }
        curr=n;

    }
    curr.eow=true;
   



   }
   public int  searchXOR(String word) //take example its 110 so you need 
   { 
       Node prev,curr=root;
     
       char ch='a';
       int x=0;
    for(int i=0;i<word.length();i++)
    {
         ch=word.charAt(i);
        Node n=curr.children.get(ch);
        if(n==null)
        {
           
           return 0;
        }
        else
        { 
            prev=curr;
             curr=n;
              x=prev.num.get(ch);


        }
       
    }
   // System.out.println(ch);
   // ch=word.charAt(word.length()-1);
    return x;

   }
    



    public static void main(String args[])
    {
        Binary_Trie s=new Binary_Trie();
        s.insert(Integer.toBinaryString(3));
        s.insert(Integer.toBinaryString(8));
        //s.insert("hackerank");
        System.out.println(s.searchXOR(Integer.toBinaryString(3)));


    }

}