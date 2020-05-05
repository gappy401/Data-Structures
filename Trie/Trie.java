/*
A root is final Trie class object with the root initialized, each node simply has a map of charaters in the node
and the node that each charater leads to, every time a char is created a node is created that it points to 
with eow false which can be turned to true on completion of the word




*/
import java.util.*;
public class Trie
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
    public Trie() {
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
   public int  search(String word)
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
        Trie s=new Trie();
        s.insert("hack");
        s.insert("hackerank");
        System.out.println(s.search("hac"));


    }

}