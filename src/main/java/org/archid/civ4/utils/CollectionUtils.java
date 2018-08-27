/**
 * 
 */
package org.archid.civ4.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * Set of static functions to perform various operations on {@code Strings}
 *
 */
public class CollectionUtils {

	/**
	 * Determine if a collection contains elements
	 * 
	 * @param col {@link Collection} to be examined.
	 * 
	 * @return {@code true} if the collection has elements; {@code false} if the collection is either null or has no elements.
	 */
	public static <T extends Collection<?>> boolean hasElements(T col) {
		return col != null && !col.isEmpty();
	}
	
	/**
	 * Returns a {@link HashSet} populated with the elements of the passed in {@link Collection}
	 * 
	 * If the source collection is null or empty then an empty {@link HashSet} will be returned
	 * 
	 * @param source {@link Collection} to convert
	 * @return {@link HashSet} populated with the elements of {@code source} or empty if {@code source} is null.
	 */
	public static <T> HashSet<T> getHashSet(Collection<T> source) {
		return (source == null || source.isEmpty()) ? new HashSet<T>() : new HashSet<T>(source);
	}
	
	/**
	 * Returns a {@link HashSet} populated with the elements of the passed in {@link Collection}
	 * 
	 * If the source collection is null or empty then null will be returned
	 * 
	 * @param source {@link Collection} to convert
	 * @return {@link HashSet} populated with the elements of {@code source} or null if {@code source} is null.
	 */
	public static <T> HashSet<T> getHashSetOrNull(Collection<T> source) {
		return (source == null || source.isEmpty()) ? null : new HashSet<T>(source);
	}
	
	/**
	 * Returns an {@link ArrayList} populated with the elements of the passed in {@link Collection}
	 * 
	 * If the source collection is null or empty then an empty {@link ArrayList} will be returned
	 * 
	 * @param source {@link Collection} to convert
	 * @return {@link ArrayList} populated with the elements of {@code source} or empty if {@code source} is null.
	 */
	public static <T> ArrayList<T> getArrayList(Collection<T> source) {
		return (source == null || source.isEmpty()) ? new ArrayList<T>() : new ArrayList<T>(source);
	}
	
	/**
	 * Returns an {@link ArrayList} populated with the elements of the passed in {@link Collection}
	 * 
	 * If the source collection is null or empty then null will be returned
	 * 
	 * @param source {@link Collection} to convert
	 * @return {@link ArrayList} populated with the elements of {@code source} or null if {@code source} is null.
	 */
	public static <T> ArrayList<T> getArrayListOrNull(Collection<T> source) {
		return (source == null || source.isEmpty()) ? null : new ArrayList<T>(source);
	}
	
}
