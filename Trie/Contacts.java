import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Contacts {
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
    public Contacts() {
        root = new Node();
    }
   public void  insert(String word)
   { 
       Node curr=root;
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
   // System.out.println("success");

   }
    public int  search(String word)
   { 
       Node curr=root;
       Node prev;
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
    
    /*
     * Complete the contacts function below.
     */
   

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int queriesRows = Integer.parseInt(scanner.nextLine().trim());

        String[][] queries = new String[queriesRows][2];

        for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
                String queriesItem = queriesRowItems[queriesColumnItr];
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }
         Contacts s=new Contacts();
       int result[]=new int[queriesRows];
       int x=0;
        for(int i=0;i<queriesRows;i++)
        {
            if(queries[i][0].equals("add"))
            {
                //System.out.println(queries[i][1]);
                s.insert(queries[i][1]);

            }
            else
            {
                
                //System.out.println(ans);
                result[x]=s.search(queries[i][1]);
                x++;
                
            }

        }

       

        for (int resultItr = 0; resultItr < x; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
