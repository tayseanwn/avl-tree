package avlTree;
public class AVLTreeNode<K,V> {
//public class AVLTreeNode<K,V> implements Position<K,V> {
	private AVLTreeNode<K,V> parent;          // reference to the parent node
	private AVLTreeNode<K,V> left;            // reference to the left child
	private AVLTreeNode<K,V> right;           // reference to the right child
	private DictEntry<K,V> entry;         // reference to the entry stored at the node
	private int height;                   // height of the node for checking balance-height property
	
	public AVLTreeNode(DictEntry<K,V> inputEntry, AVLTreeNode<K,V>  inputParent, AVLTreeNode<K,V>  inputLeft, AVLTreeNode<K,V>  inputRight)
	{
	    entry  = inputEntry;
	    parent = inputParent;
	    left   = inputLeft;
	    right  = inputRight;
	    height = 0;
	    if (left != null ) height  = Math.max(height,1+left.getHeight());
	    if (right != null ) height = Math.max(height,1+right.getHeight()); 
	}
	
	public AVLTreeNode<K,V>  parent(){ return parent;}
	public AVLTreeNode<K,V>  left() {return left;}
	public AVLTreeNode<K,V>  right() {return right;}
	public int getHeight () { return height; }
	public DictEntry<K,V> getEntry() { return entry; } 
	public void setParent(AVLTreeNode<K,V>  newParent){ parent = newParent; }
	public void setLeft(AVLTreeNode<K,V>  newLeft) {left = newLeft;}
	public void setRight(AVLTreeNode<K,V>  newRight) { right = newRight; }  
	public void setEntry(DictEntry<K,V> newEntry) { entry = newEntry; }
	public DictEntry<K,V> element(){return entry;}
	
	public void resetHeight() throws AVLTreeException{
	if ( left == null || right == null ) throw  new AVLTreeException("Attempt to update height for external node ");
	height = 1+Math.max(left.getHeight(),right.getHeight());
	}
}

