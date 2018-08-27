package org.archid.civ4.utils;

/**
 * Interface describing a class that contains a key-value pair.
 * <p>
 * The keys and values can be of any object type
 * 
 * @author jim
 *
 * @param <S> Object type of the key
 * @param <T> Object type of the value
 */
public interface IKeyValuePair <S, T> {
	
	/**
	 * Sets the key of the pair
	 * 
	 * @param key value to set as the key
	 */
	void setKey(S key);
	
	/**
	 * Gets the key of the pair
	 * 
	 * @return key
	 */
	public S getKey();
	
	/**
	 * Sets the value of the pair
	 * 
	 * @param value value to set
	 */
	void setValue(T value);
	
	/**
	 * Gets the value of the pair
	 * 
	 * @return value object
	 */
	public T getValue();

}
