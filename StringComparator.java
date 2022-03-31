package avlTree;
import java.util.*;
import java.lang.*;

//--------------------------------------------------------------------------------------------------
//Comparator for String objects. Should use lexographical order to compare strings. You can use Java’s
//build in method for Strings compareTo(), which implements lexographical order. 
//--------------------------------------------------------------------------------------------------

//The StringComparator must implement the provided Comparator interface. 
public class StringComparator implements Comparator  {

//  --------------------------------------------------------------------------------------------------
//	It must have only 1 public method, public int compare(Object a, Object b) throws ClassCastException.
//  --------------------------------------------------------------------------------------------------
	
	public int compare(Object a, Object b) throws ClassCastException {
		
		/*
		 * 1. Method compare should return a negative integer if the first String is less then the second String,  
		 * 2. 0 if the two Strings are equal
		 * 3. a positive integer if the first String is larger than the second String.
		 */
		
//		The actual objects passed to this comparator are of class String, so you must cast them into this 
//		type in your implementation of compare method in StringComparator. 
		String stringA = a.toString(), stringB = b.toString();
		
		
		if (stringA.compareTo(stringB) < 0) // if a is less than b
			return -1;
		else if (stringA.compareTo(stringB) == 0) // if a equals b
			return 0;
		else // if a is greater than b
			return 1;
	}
	
}
