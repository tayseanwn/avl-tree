package avlTree;
/* Class AVLNode */

 class AVLNode

 {    

    AVLNode left;

	AVLNode right;

     int data;

     int height;

 

     /* Constructor */

     public AVLNode()

     {

         left = null;

         right = null;

         data = 0;

         height = 0;

     }

     /* Constructor */

     public AVLNode(int n)

     {

         left = null;

         right = null;

         data = n;

         height = 0;

     }     

 }
