package org.archid.civ4.utils;

public class JaxbUtils {
	
	/**
	 * Used when unmarshalling an {@code Integer} that could be {@code null} to populate an {@code int}
	 * 
	 * @param val {@code Integer} value to check
	 * @return {@code int} value of {@code val} if is is not null; otherwise 0
	 * 
	 * @see #marshallInteger(int)
	 */
	public static int unmarshallInteger(Integer val) {
		return val != null ? val : 0;
	}

	/**
	 * Used when populating an {@code Integer} for marshalling where the value should not be displayed if it is 0
	 * 
	 * @param val {@code int} to parse
	 * @return {@code Integer} value of {@code val} if it is non-zero; otherwise null
	 * 
	 * @see #unmarshallInteger(Integer)
	 */
	public static Integer marshallInteger(int val) {
		return val != 0 ? val : null;
	}
	
	/**
	 * Used when a {@code Integer} is used to populate a {@code boolean}
	 * 
	 * @param val {@code Integer} value to check
	 * @return {@code true} if {@code val} is is not null; otherwise {@code false}
	 * 
	 * @see #marshallBoolean(boolean)
	 */
	public static boolean unmarshallBoolean(Integer val) {
		return val != null;
	}
	
	/**
	 * Used when populating an {@code Integer} for marshalling where the value of 1 should be output for {@code true}
	 * and no tag when the value is {@code false} 
	 * 
	 * @param val {@code boolean} to parse
	 * @return {@code 1} if {@code val} is true; otherwise null
	 * 
	 * @see #unmarshallBoolean(Boolean)
	 */
	public static Integer marshallBoolean(boolean val) {
		return val ? 1 : null;
	}
	
	/**
	 * Used when unmarshalling a string to ensure that {@code null} is never returned
	 * 
	 * @param val {@code String} to parse 
	 * @return{@code val} if is is not null and contains a value; otherwise the empty string
	 * 
	 * @see #marshallString(String)
	 */
	public static String unmarshallString(String val) {
		return StringUtils.hasCharacters(val) ? val: "";
	}
	
	/**
	 * Used when marshalling a string whose tag should not appear if it is empty
	 *  
	 * @param val {@code String} to parse
	 * @return {@code val} if is not empty; otherwise {@code null}
	 */
	public static String marshallString(String val) {
		return StringUtils.getNullIfEmpty(val);
	}

}
