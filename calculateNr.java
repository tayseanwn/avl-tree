package avlTree;

import java.util.Scanner;

public class calculateNr {
	
   	
//	   -------------------------------------------------------------------------------------------------------
//	   Main Method:
//	   -------------------------------------------------------------------------------------------------------

	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);  //creating Scanner class object to get input from user
     
		System.out.println("Automatically generating an initial tree...");
	     AVLTree obj = new AVLTree();
	     obj.insertElement(10);
	     obj.insertElement(2); 
	     System.out.print("Preorder Traversal: "); obj.preorderTraversal();
	     obj.insertElement(1);
	     obj.getTotalNumberOfNodes();
	     System.out.print("Preorder Traversal: "); obj.preorderTraversal();
	     System.out.print("Postorder Traversal: ");obj.postorderTraversal();
	     System.out.print("Inorder Traversal: ");obj.inorderTraversal();
	     obj.external();
	     obj.modifyValue();
	     System.out.println("Checking if this is an AVL Tree:"); 
	     if (obj.isBST() && obj.isBalanced())
	     	System.out.println("Final result: This is an AVL tree");
	     else
	     	System.out.println("Final result: This is not an AVL tree");
	     obj.removeAll();
		System.out.println("Now you can create your own tree!");

	     
	     char choice;    //initialize a character type variable to choice  
	     boolean go = true;
	     while (go) {
	     	System.out.println("Would you like to continue? Enter y (yes) or n (no).");
	     	char ch1 = sc.next().charAt(0);
	     	if (ch1 == 'n') {
	     		go = false;
	     		break;
	     	}
	     	else { // perform operation of AVL Tree using switch 
		            System.out.println("\nSelect an operation:\n");  
		            System.out.println("1. Insert a node");  
		            System.out.println("2. Search a node");  
		            System.out.println("3. Get total number of nodes in AVL Tree");  
		            System.out.println("4. Is AVL Tree empty?");  
		            System.out.println("5. Remove all nodes from AVL Tree");  
		            System.out.println("6. Display AVL Tree in Post order");  
		            System.out.println("7. Display AVL Tree in Pre order");  
		            System.out.println("8. Display AVL Tree in In order");  
		            System.out.println("9. Display if P is an external node");  
		            System.out.println("10. Display if key is present in a tree, changes the value of this field of this entry to new value");  
		            int ch = sc.nextInt(); //get choice from user 
		            switch (ch){  
		                case 1 :   
		                    System.out.println("Please enter an element to insert in AVL Tree");  
		                    obj.insertElement( sc.nextInt() );                       
		                    break;                            
		                case 2 :   
		                    System.out.println("Enter integer element to search");  
		                    System.out.println(obj.searchElement( sc.nextInt() ));  
		                    break;                                            
		                case 3 :   
		                    System.out.println(obj.getTotalNumberOfNodes());  
		                    break;       
		                case 4 :   
		                    System.out.println(obj.checkEmpty());  
		                    break;       
		                case 5 :   
		                    obj.removeAll();  
		                    System.out.println("\nTree Cleared successfully");  
		                    break;  
		                case 6 :   
		                    System.out.println("\nDisplay AVL Tree in Post order");  
		                    obj.postorderTraversal();  
		                    break;  
		                case 7 :   
		                    System.out.println("\nDisplay AVL Tree in Pre order");  
		                    obj.preorderTraversal();  
		                    break;  
		                case 8 :   
		                    System.out.println("\nDisplay AVL Tree in In order");  
		                    obj.inorderTraversal();  
		                    break;  
		                case 9 :   
		                    System.out.println("\nDisplay if p is external node");  
		                    obj.external();  
		                    break;      
		                case 10 :   
		                    System.out.println("\nDisplay if key is present in a tree, changes the value field of this entry to new value");  
		                    obj.modifyValue();  
		                    break;      
		                default :   
		                    System.out.println("\n ");
		                    break;      
		                } // END SWITCH
		            System.out.println("11. Check the tree is it is valid AVL Tree");  
		            if (obj.isBST() && obj.isBalanced()) /* Check isBST, Check isBalanced, Check AVL Tree */
		            	System.out.println("Final result: This is an AVL tree");
		            else
		            	System.out.println("Final result: This is not an AVL tree");
		 		} // END WHILE
	     }
	     System.out.println("Test Ended\nThank you for participating.");
	} // END MAIN
}


//Inserting data element: 10
//Inserting data element: 2
//Preorder Traversal: Output: 10 2 
//Inserting data element: 1
//Tree unbalanced after insertion. Rebalancing tree using LL Rotation
//This tree currently contains 3 nodes.
//Preorder Traversal: Output: 2 1 10 
//Postorder Traversal: Output: 1 10 2 
//Inorder Traversal: Output: 1 2 10 
//Check if node is external. Start by choosing one of the following keys: Output: 1 2 10 
//Enter here: 2
//Enter: p (check node), l (check left child), r (check right child)
//l
//false: This is an internal node. Left child of node (2) contains value: 1
//Search for a value in the tree to modify. Enter a value of type integer:
//1
//The key value '1' is present in the tree. What would you like to change the value to (enter integer): 
//3
//The value of the node containing key value '1' has been modified and now contains: 3
//Checking if this is an AVL Tree:
//We've confirmed this is a binary tree (every internal node has two children and every external node is a leaf).
//Now scanning inorder traversal. Output: 3 2 10 
//Error: node with value (2) is less than node with value (3). Since this is not a BST, rebalancing cannot be performed.
//Final result: This is not an AVL tree
//Now removing all elements from tree with 3 node(s). The tree now has 0 nodes.
//Now you can create your own tree!
//Would you like to continue? Enter y (yes) or n (no).
//y
//
//Select an operation:
//
//1. Insert a node
//2. Search a node
//3. Get total number of nodes in AVL Tree
//4. Is AVL Tree empty?
//5. Remove all nodes from AVL Tree
//6. Display AVL Tree in Post order
//7. Display AVL Tree in Pre order
//8. Display AVL Tree in In order
//9. Display if P is an external node
//10. Display if key is present in a tree, changes the value of this field of this entry to new value
//1
//Please enter an element to insert in AVL Tree
//5
//Inserting data element: 5
//11. Check the tree is it is valid AVL Tree
//We've confirmed this is a binary tree (every internal node has two children and every external node is a leaf).
//Now scanning inorder traversal. Output: 5 
//This is a binary search tree (the inorder traversal was in increasing order)
//This tree is balanced (the difference between the height of each pair of siblings are no more than 1)
//Final result: This is an AVL tree
//Would you like to continue? Enter y (yes) or n (no).
//n
//Test Ended
//Thank you for participating.
