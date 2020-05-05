
import java.util.*;
public class No_Prefix
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
    public No_Prefix() {
        root = new Node();
    }
    public boolean  insert(String word)
   { Node prev=root,curr=root;
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
            if(n.eow==true)
            {
                return true;
            }
           
            curr.num.put(ch, curr.num.get(ch)+1);
        }
        prev=curr;
        curr=n;

    }
    curr.eow=true;
    if( prev.children.size()!=0 && curr.children.size()!=0)
    {
        return true;
    }
    return false;
   



   }
   
  
    public static void main(String args[])
    {
        No_Prefix s=new No_Prefix();
        Scanner s1=new Scanner(System.in);
        int n=s1.nextInt();
        int flg=1;
        s1.nextLine();
        for(int i=0;i<n;i++)
        {  String e=s1.next();
            boolean check=s.insert(e);
            if(check==true)
            {
                System.out.println("BAD SET");
                System.out.println(e);
                flg=0;
                break;

            }

        }
        if(flg==1)
        {
             System.out.println("GOOD SET");
        }
       
       


    }

}
