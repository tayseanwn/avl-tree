package avlTree;

public class DictEntry<K,V> {
	
	//------------------------------------------------------------------------------------------------
	// Instance Variables
	//------------------------------------------------------------------------------------------------
	
	private K key;
	private V value;
	
	//------------------------------------------------------------------------------------------------
	// Public Methods
	//------------------------------------------------------------------------------------------------
	
	/*
	 * A constructor which takes a key of type K and a value of type V
	 */
	public DictEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	/*
	 * Returns the key in the DictEntry
	 */
	public K key() {
		return this.key;
	}
	
	/*
	 * returns the key in the DictEntry
	 */
	public V value() {
		return this.value;
	}
	
	/*
	 * Update the value V with the newVal
	 */
	public void changeValue (V newVal) {
		this.value = newVal;
	}
	
	//------------------------------------------------------------------------------------------------
	// Private Methods (Not Mandatory)
	//------------------------------------------------------------------------------------------------
}
