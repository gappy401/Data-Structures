/* Class containing left and right child of current 
node and key value*/
class Node 
{ 
	int key; 
	Node left, right; 

	public Node(int item) 
	{ 
		key = item; 
		left = right = null; 
	} 
} 

// A Java program to introduce Binary Tree 
class BinaryTree 
{ 
	// Root of Binary Tree 
	Node root; 

	// Constructors 
	BinaryTree(int key) 
	{ 
		root = new Node(key); 
	} 

	BinaryTree() 
	{ 
		root = null; 
	} 

	public static void main(String[] args) 
	{ 
		BinaryTree tree = new BinaryTree(); 


		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 

		
	} 
} 
