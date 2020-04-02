/* C++ Implementation of Memory 
efficient Doubly Linked List */
#include <bits/stdc++.h> 
#include <inttypes.h> 
using namespace std; 

//  Memory efficient doubly linked list  with only one pointer called npx that saves the exor
//value of its previous and next pointers
class Node 
{ 
	public: 
	int data; 
	Node* npx; 
}; 


Node* XOR (Node *a, Node *b) 
{ /*
uintptr_t is an unsigned integer type that is capable of storing a data pointer.
 Which typically means that it's the same size as a pointer.
*/
	return (Node*) ((uintptr_t) (a) ^ (uintptr_t) (b)); 
} 

/* Insert a node at the beginning of the 
XORed linked list and makes the newly 
inserted node as head */
void insert(Node **head, int data) 
{  //https://www.geeksforgeeks.org/double-pointer-pointer-pointer-c/
	
	Node *new_node = new Node(); 
	new_node->data = data; 

	/* Since new node is being inserted at the 
	beginning, npx of new node will always be 
	XOR of current head and NULL */
	new_node->npx = XOR(*head, NULL);  //10->11 add 20 20's npx is xor of head becasue it will be next 
                                      // and null as that is the prev

	
	if (*head != NULL) 
	{ 
		// *(head)->npx is XOR of NULL and next.  we yhave to chane that to xor or prev and next
		// So if we do XOR of it with NULL, we get next of head and can multiply with prev that's the new
        //node we want to enter
		Node* next = XOR((*head)->npx, NULL); //get next of head
		(*head)->npx = XOR(new_node, next); //mul with new node
	} 

	*head = new_node; 
} 

void printList (Node *head) 
{ 
	Node *curr = head; 
	Node *prev = NULL; 
	Node *next; 
/*
or example when we are at node C, we must have address of B. XOR of add(B) and npx of C gives us the add(D). 
The reason is simple: npx(C) is “add(B) XOR add(D)”. If we do xor of npx(C) with add(B),
 we get the result as “add(B) XOR add(D) XOR add(B)” which is “add(D) XOR 0” which is “add(D)”. 
So we have the address of next node. Similarly we can traverse the list in backward direction.
*/
	
	while (curr != NULL) 
	{ 
		cout<<curr->data<<" "; 
		next = XOR (prev, curr->npx); 
		prev = curr; 
		curr = next; 
	} 
} 

// Driver code 
int main () 
{ 
	/* Create following Doubly Linked List 
	head-->40<-->30<-->20<-->10 */
	Node *head = NULL; 
	insert(&head, 10); 
	insert(&head, 20); 
	insert(&head, 30); 
	insert(&head, 40); 

	// print the created list 
	printList (head); 

	return (0); 
} 

