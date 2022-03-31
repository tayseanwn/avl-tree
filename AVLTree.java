package avlTree; 
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/* Class AVLTree */

 class AVLTree {
	 
	 
	 /*
	  * Provided instance variables
	  */
     private AVLNode root;

     
     /*
      * Implemented (additional) instance variables
      */
//     private AVLNode T1; // for String count
//     private AVLNode T2; // for Integer count
     private String[] words;
	 public AVLTree left;    
	 public AVLTree right; 
	 public static int position;
     
//	   -------------------------------------------------------------------------------------------------------
//     Implemented Methods:
//     
//     public isBST(t1): This method will return true if the provided tree is BST.
//     public isBalanced(t1): This method will return true if given BST tree is also AVL.
//	   -------------------------------------------------------------------------------------------------------
     /*
      * Constructor that takes in a data value
      * left will be set as the left of the root
      * right will be set as the right of the root
      */
     public AVLTree (int i) {
    	 root = new AVLNode (i);
    	 
    	 
     }
     
     public boolean isBST () {
    	 /*
    	  * We can check if the tree is a binary search tree by doing a test with:
    	  * 1. Since this is a binary tree (with at most 2 nodes) then this is correct
    	  * 2. Print out the tree in an inorder traversal
    	  * 3. if if every value is greater or equal to the value before it
    	  * 	a. if this is not true for all values then false
    	  * 	b. else then true this is a BST
    	  */
    	 
    	 System.out.print("We've confirmed this is a binary tree (every internal node has two children and every external node is a leaf).\n"
    	 		+ "Now scanning inorder traversal. "); 
    	 this.inorderTraversal();
    	 if (root == null) {
    		 System.out.println("This is a binary search tree");
    		 return true;
    	 }
    	 else {
    		 int numofNodes = this.countNodes();
        	 int[] inorderArr = new int[numofNodes]; // create node of size equal to n
    		 position = 0; //reset position
        	 this.inorderToArray(inorderArr, root); // store inorder in an Array
	    	 int prev = inorderArr[0];
	    	 int next;
	    	 boolean bst = true;
	    	 for (int i=1; i<inorderArr.length; i++) {
	    		 next = inorderArr[i];
	    		 if (next < prev) { // the next should always be greater than or equal to previous
	    			 bst = false;
	    			 System.out.println("Error: node with value ("+next+") is less than node with value ("+prev+"). "
	    			 		+ "Since this is not a BST, rebalancing cannot be performed.");
	    			 break;
	    		 } 
	    		 prev = next;
	    	 } 
	    	 if (bst) System.out.println("This is a binary search tree (the inorder traversal was in increasing order)");
	    	 
	    	 return bst;}
       }
       public boolean isBalanced () {
    	   /*
    	    * We check if the different in the height of the children of each node is 0 or 1
    	    * 1. if 0 or 1 then the tree is balanced
    	    * 2. if greater than 1 than the tree is not balanced
    	    */
    	   boolean balanced = this.treeBalanced(root);
    	   if (balanced) System.out.println("This tree is balanced (the difference between the height of each pair of siblings are no more than 1)");
    	   else System.out.println("This tree is unbalanced");
    	   
    	   return balanced;
       }
     
//	   -------------------------------------------------------------------------------------------------------
//	   Required Methods:
//     Used for Test.java - Needed As They Are Required In The Test.java
//	   -------------------------------------------------------------------------------------------------------
     	
       void insertElement(int i) {
    	   this.insert(i);} // invoked from provided method
       
       boolean searchElement(int i) {
    	   System.out.println("Now searching for a node with element " + i);
    	   if (this.search(i)) System.out.println("A node with this element exist.");
    	   else System.out.println("No node with this element exist.");
    	   System.out.print("Result: "); return this.search(i);} // invoked from provided method
       
       int getTotalNumberOfNodes() { 
    	   System.out.println("This tree currently contains " + this.countNodes() + " nodes."); return this.countNodes(); } // invoked from provided method
       
       boolean checkEmpty() {
    	   System.out.print("Checking if this tree is empty...\nResult: "); return this.isEmpty();} // invoked from provided method
       
       void removeAll() {
    	   if (root == null) {
    		   System.out.print("The tree is already empty. Clearing complete."); return; }
    	   System.out.print("Now removing all elements from tree with "+this.countNodes()+" node(s). "); this.makeEmpty();
    	   System.out.print("The tree now has "+this.countNodes()+" nodes."); System.out.println();} // invoked from provided method
       
	   	void postorderTraversal() {System.out.print("Output: "); this.postorder(); System.out.println();} // invoked from provided method
	    void preorderTraversal() {System.out.print("Output: ");this.preorder(); System.out.println();} // invoked from provided method
	   	void inorderTraversal() {System.out.print("Output: ");this.inorder(); System.out.println();} // invoked from provided method
	
	   	boolean external() {
	   		/*
	   		 * In a BST, this is an extended binary tree
	   		 * All external values must be null and all internal values must contain data values
	   		 * Check if p (parent) is empty
	   		 * 		a. if empty then external - true
	   		 * 		b. else internal - false
	   		 */
	   		// prompt user 
	   		boolean isExternal = true;
	   		AVLNode node = null;
	   		Scanner input = new Scanner(System.in);
	   		if (root == null) { System.out.println("The root is empty. P is an external node: " + isExternal); return isExternal;}
	   		System.out.print("Check if node is external. Start by choosing one of the following keys: "); 
	   		this.inorderTraversal(); 
	   		System.out.print("Enter here: ");
	   		int value = input.nextInt();
	   		node = this.searchKey(root, value); // store the node that was found with value
	   		while (node == null) { // if the node doesn't exist ask them to search again 
	   			System.out.print("Error! Please choose one of the following keys: "); this.inorderTraversal(); System.out.print("\nEnter here: ");
		   		value = input.nextInt();
		   		node = this.searchKey(root, value); 
	   		}
	   		System.out.println("Enter: p (check node), l (check left child), r (check right child)"); 	   		// ask user to search the node, it's left or right child
	   		char nValue = input.next().charAt(0);
	   		while(nValue != 'p' && nValue != 'l' && nValue != 'r') { // repeat if incorrect input
	   			System.out.println("Error, you entered: "+ nValue +"! Enter: p (check node), l (check left child), r (check right child)");
		   		nValue = input.next().charAt(0);
	   		}
	   		// check either the node itself, it's left child or right child
	   		if (nValue == 'p') { 
	   			if (node != null) { isExternal = false; } 
	   			System.out.println("Checking if node is external. result: " + isExternal);
	   		} else if (nValue == 'l') { 
	   			if (node.left != null) { isExternal = false; 
	   				System.out.println(isExternal + ": This is an internal node. Left child of node ("+node.data+") contains value: " + node.left.data); 
	   			} 
	   			else System.out.println("Checking if left child of node ("+node.data+") is external. result: " + isExternal); ;
	   		} else { 
	   			if (node.right != null) { isExternal = false; 
	   				System.out.println(isExternal + ": This is an internal node. Right child of node ("+node.data+") contains value: " + node.right.data); 
	   			} 
	   			else System.out.println("Checking if right child of node ("+node.data+") is external. result: " + isExternal); 
	   		} 
	   		return isExternal;
	   	}
	
	   	void modifyValue() {
	   		/*
	   		 * Prompt user to enter a val to search in the tree (root)
	   		 * 1. display if the val is present in the tree
	   		 * 		a. return to the user the node that contains the value
	   		 * 		b. change the value of the node at r to the new value entered by the user
	   		 * 		c. let user know the value has been modified
	   		 * 2. if the val is not present let the user know
			 */
	   		
	   		// prompt user 
	   		AVLNode node = null;
	   		Scanner input = new Scanner(System.in);
	   		System.out.println("Search for a value in the tree to modify. Enter a value of type integer:");
	   		int value = input.nextInt();
	   		// store the node that was found with value
	   		node = this.searchKey(root, value);
	   		
	   		//check if node is null
	   		if (node == null) {
	   			System.out.println("The key value '"+value+"' is not present in the tree. Cannot modify value!");
	   		}
	   		else {
	   			//change value of node
	   			System.out.println("The key value '"+value+"' is present in the tree. What would you like to change the value to (enter integer): ");
	   			int newValue = input.nextInt();
	   			node.data = newValue;
	   			System.out.println("The value of the node containing key value '"+value+"' has been modified and now contains: "+newValue);
	   		}
	   	}   
	   	
//		   -------------------------------------------------------------------------------------------------------
//		   Private Helper Methods:
//		   -------------------------------------------------------------------------------------------------------
	   	
	   	private AVLNode searchKey (AVLNode r, int val) { // return the node that contains key value
	         boolean found = false;
	         AVLNode nodeFound = null;
	         while ((r != null) && !found) {
	             int rval = r.data;
	             if (val < rval)
	                 r = r.left;
	             else if (val > rval)
	                 r = r.right;
	             else {
	                 found = true;
	                 nodeFound = r;
	                 break;
	             }
	         }
	         return nodeFound;
	     }
       
	   	private void inorderToArray(int[] arr, AVLNode r) {
	         if (r != null){
	        	 inorderToArray(arr, r.left);
	        	 // only update position after visiting
	             arr[position++] = r.data;
//	             System.out.print(r.data +"added to array in position " + (position-1));
	             inorderToArray(arr, r.right);
	         }
	   	}
	   	
	   	private int getTreeHeight () {
	   		if (root == null) { return -1; }
	   		else {
	   			// find depth of left and right child
	   			int leftChild = height(root.left);
	   			int rightChild = height(root.right);
	   		// retrieve the height of the child with greater height
	   			if (leftChild > rightChild) { return (leftChild + 1); }
	   			else { return (rightChild + 1); }
	   		}
	   	}
	   	
	   	private int getNodeHeight (AVLNode n) {
	   		if (n == null) { return -1; }
	   		else {
	   			// find depth of left and right child
	   			int leftChild = height(n.left);
	   			int rightChild = height(n.right);
	   		// retrieve the height of the child with greater height
	   			if (leftChild > rightChild) { return (leftChild + 1); }
	   			else { return (rightChild + 1); }
	   		}
	   	}
	
	   	private boolean treeBalanced (AVLNode r) {
	   		boolean result;
	   		if (r == null) 
	   			return true;
	   		else { // compare height with the right and left child. Max difference can be 1
	   			
		   		boolean unbalanced = ((getNodeHeight(r.left) - getNodeHeight(r.right)) > 1 ||  (getNodeHeight(r.left) - getNodeHeight(r.right)) < -1);
		   		if (unbalanced) {
		   			System.out.println("The right child of node ("+r+") has a height of \""+getNodeHeight(r.right)+"\" and its left child has a height of \""+getNodeHeight(r.left)+"\"");
		   			result = false; }
		   		else 
		   			result = true;
	   		}
	   		return result && treeBalanced(r.left) && treeBalanced(r.right);
	   	}

// 	   -------------------------------------------------------------------------------------------------------
//     Provided Methods:
//     	
//     This class implements various AVL operations and is a main supporting file to start with. It has
//     provided implementation details that would be helpful in presenting the solution. The description of
//     the methods are found in section 4. The provided methods are mentioned as follows
//     -------------------------------------------------------------------------------------------------------

     /* Constructor */

     public AVLTree()

     {

         root = null;

     }

     /* Function to check if tree is empty */

     public boolean isEmpty()

     {

         return root == null;

     }

     /* Make the tree logically empty */

     public void makeEmpty()

     {

         root = null;

     }

     /* Function to insert data */

     public void insert(int data)

     {
    	 System.out.println("Inserting data element: " + data);
         root = insert(data, root);
     }

     /* Function to get height of node */

     private int height(AVLNode t )

     {

         return t == null ? -1 : t.height;

     }

     /* Function to max of left/right node */

     private int max(int lhs, int rhs)

     {

         return lhs > rhs ? lhs : rhs;

     }

     /* Function to insert data recursively */

     private AVLNode insert(int x, AVLNode t)

     {

         if (t == null) {

             t = new AVLNode(x);
             
             // NOTIFICATION
             }

         else if (x < t.data)

         {

             t.left = insert( x, t.left );

             if( height( t.left ) - height( t.right ) == 2 )

                 if( x < t.left.data ) {
                	 System.out.println("Tree unbalanced after insertion. Rebalancing tree using LL Rotation");
                     t = rotateWithLeftChild( t );}

                 else {
                	 System.out.println("Tree unbalanced after insertion. Rebalancing tree using LR Rotation");
                     t = doubleWithLeftChild( t ); }
          
             }

         else if( x > t.data )

         {

             t.right = insert( x, t.right );

             if( height( t.right ) - height( t.left ) == 2 )

                 if( x > t.right.data) {
                	 System.out.println("Tree unbalanced after insertion. Rebalancing tree using RR Rotation");
                     t = rotateWithRightChild( t );}

                 else {
                	 System.out.println("Tree unbalanced after insertion. Rebalancing tree using RL Rotation");
                     t = doubleWithRightChild( t );}

         }

         else

           // NOTIFICATION
           System.out.println("Duplicate! Could not insert new element: " + x);  // Duplicate; do nothing

         t.height = max( height( t.left ), height( t.right ) ) + 1;

         return t;

     }

     /* Rotate binary tree node with left child */     

     private AVLNode rotateWithLeftChild(AVLNode k2)

     {

         AVLNode k1 = k2.left;

         k2.left = k1.right;

         k1.right = k2;

         k2.height = max( height( k2.left ), height( k2.right ) ) + 1;

         k1.height = max( height( k1.left ), k2.height ) + 1;

         return k1;

     }

 

     /* Rotate binary tree node with right child */

     private AVLNode rotateWithRightChild(AVLNode k1)

     {

         AVLNode k2 = k1.right;

         k1.right = k2.left;

         k2.left = k1;

         k1.height = max( height( k1.left ), height( k1.right ) ) + 1;

         k2.height = max( height( k2.right ), k1.height ) + 1;

         return k2;

     }

     /**

      * Double rotate binary tree node: first left child

      * with its right child; then node k3 with new left child */

     private AVLNode doubleWithLeftChild(AVLNode k3)

     {

         k3.left = rotateWithRightChild( k3.left );

         return rotateWithLeftChild( k3 );

     }

     /**

      * Double rotate binary tree node: first right child

      * with its left child; then node k1 with new right child */      

     private AVLNode doubleWithRightChild(AVLNode k1)

     {

         k1.right = rotateWithLeftChild( k1.right );

         return rotateWithRightChild( k1 );

     }    

     /* Functions to count number of nodes */

     public int countNodes()

     {

         return countNodes(root);

     }

     private int countNodes(AVLNode r)

     {

         if (r == null)

             return 0;

         else

         {

             int l = 1;

             l += countNodes(r.left);

             l += countNodes(r.right);

             return l;

         }

     }

     /* Functions to search for an element */

     public boolean search(int val)

     {

         return search(root, val);

     }

     private boolean search(AVLNode r, int val)

     {

         boolean found = false;

         while ((r != null) && !found)

         {

             int rval = r.data;

             if (val < rval)

                 r = r.left;

             else if (val > rval)

                 r = r.right;

             else

             {

                 found = true;

                 break;

             }

             found = search(r, val);

         }

         return found;

     }

     /* Function for inorder traversal */

     public void inorder()

     {

         inorder(root);

     }

     private void inorder(AVLNode r)

     {

         if (r != null)

         {

             inorder(r.left);

             System.out.print(r.data +" ");

             inorder(r.right);

         }

     }

     /* Function for preorder traversal */

     public void preorder()

     {

         preorder(root);

     }

     private void preorder(AVLNode r)

     {

         if (r != null)

         {

             System.out.print(r.data +" ");

             preorder(r.left);             

             preorder(r.right);

         }

     }

     /* Function for postorder traversal */

     public void postorder()

     {

         postorder(root);

     }

     private void postorder(AVLNode r)

     {

         if (r != null)

         {

             postorder(r.left);             

             postorder(r.right);

             System.out.print(r.data +" ");

         }

     }

  

 }
 
 
// Inserting data element: 6
// Inserting data element: 6
// Duplicate! Could not insert new element: 6
// Now removing all elements from tree with 1 node(s). The tree now has 0 nodes.
// Inserting data element: 5
// Inserting data element: 10
// Preorder Traversal: Output: 5 10 
// Inserting data element: 11
// Tree unbalanced after insertion. Rebalancing tree using RR Rotation
// This tree currently contains 3 nodes.
// Preorder Traversal: Output: 10 5 11 
// Postorder Traversal: Output: 5 11 10 
// We've confirmed this is a binary tree. Now scanning inorder traversal. Output: 5 10 11 
// This is a binary search tree (the inorder traversal was in increasing order)
// This tree is balanced (the difference between the height of each pair of siblings are no more than 1)
// Final result: This is an AVL tree
// Check if node is external. Start by choosing one of the following keys: Output: 5 10 11 
//
// Enter here: 5
// Enter: p (check node), l (check left child), r (check right child)
// r
// Checking if right child of node (5) is external. result: true
// Search for a value in the tree to modify. Enter a value of type integer:
// 10
// The key value '10' is present in the tree. What would you like to change the value to (enter integer): 
// 15
// The value of the node containing key value '10' has been modified and now contains: 15
