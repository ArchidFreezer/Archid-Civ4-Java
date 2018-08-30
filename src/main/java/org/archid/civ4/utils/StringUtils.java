package org.archid.civ4.utils;

public class StringUtils {

	/**
	 * Determine if a string contains any text or is null
	 * 
	 * @param s String to be examined.
	 * 
	 * @return true if the string is non-null and has at least 1 character in it.
	 */
	public static boolean hasCharacters(String s) {
		return !isNullOrEmpty(s);
	}

	/**
	 * Determine if a string is empty or null.
	 * 
	 * @param s String to be examined.
	 * 
	 * @return true if the String is null or has length == 0. false otherwise.
	 */
	public static boolean isNullOrEmpty(String s) {
		if ((s == null) || (s.length() == 0)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Converts a string value to null if it is empty
	 * 
	 * @param s String to be examined
	 * 
	 * @return <code>null</code> if the string is already null or empty; otherwise the unchanged string
	 */
	public static String getNullIfEmpty(String s) {
		return isNullOrEmpty(s) ? null : s;
	}

	/**
	 * Convert String to Start Case i.e.
	 * capitalise first letter of every word to upper case
	 * "THIS_TEXT" -> "This_Text"
	 * 
	 * @param str {@code String} to parse
	 * @param delim {@code char} delimiting the words
	 * 
	 * @return String converted to Start Case
	 */
	public static String startCase(String str, char delim)
	{
		StringBuilder builder = new StringBuilder(str.toLowerCase());
		
		str = str.toLowerCase();
		
		// Flag to keep track if last visited character is a white space or not
		boolean isLastSpace = true;
		
		// Iterate String from beginning to end.
		for(int i = 0; i < builder.length(); i++)
		{
			char ch = builder.charAt(i);
			
			if(isLastSpace)
			{
				// Character need to be converted to uppercase
				builder.setCharAt(i, Character.isLetter(ch) ? (char)(ch + ('A' - 'a') ) : ch);
				isLastSpace = false;
			}
			else if (ch != delim)
				isLastSpace = false;
			else
				isLastSpace = true;
		}
	
		return builder.toString();
	}

	/**
	 * Convert given String to Start Case, removing the word delimiter i.e.
	 * Capitalise first letter of every word to upper case
	 * "THIS_TEXT" -> "ThisText"
	 * 
	 * @param str {@code String} to parse
	 * @param delim {@code char} delimiting the words
	 * 
	 * @return String converted to Start Case
	 */
	public static String startCaseCompress(String str, char delim)
	{
		StringBuilder input = new StringBuilder(str.toLowerCase());
		StringBuilder output = new StringBuilder();
		
		str = str.toLowerCase();
		
		// Flag to keep track if last visited character is a white space or not
		boolean isLastSpace = true;
		
		// Iterate String from beginning to end.
		for(int i = 0; i < input.length(); i++)
		{
			char ch = input.charAt(i);
			
			if(isLastSpace)
			{
				// Character need to be converted to uppercase
				output.append(Character.isLetter(ch) ? (char)(ch + ('A' - 'a') ) : ch);
				isLastSpace = false;
			}	else if (ch != delim) {
				output.append(ch);
				isLastSpace = false;
			} else {
				isLastSpace = true;
			}
		}
	
		return output.toString();
	}

	/**
	 * Convert Given String to Camel Case, replacing the word delimiter with a space i.e.
	 * Capitalise first letter of every word to upper case
	 * "THIS_TEXT" -> "This Text"
	 * 
	 * @param str {@code String} to parse
	 * @param delim {@code char} delimiting the words
	 * 
	 * @return String converted to Start Case with delimiter converted to a space
	 */
	public static String startCaseSpace(String str, char delim)
	{
		StringBuilder input = new StringBuilder(str.toLowerCase());
		StringBuilder output = new StringBuilder();
		
		// Flag to keep track if last visited character is a white space or not
		boolean isLastSpace = true;
		
		// Iterate String from beginning to end.
		for(int i = 0; i < input.length(); i++)
		{
			char ch = input.charAt(i);
			
			if(isLastSpace)
			{
				// Character need to be converted to uppercase if it is a letter
				output.append(Character.isLetter(ch) ? (char)(ch + ('A' - 'a') ) : ch);
				isLastSpace = false;
			}	else if (ch != delim) {
				output.append(ch);
				isLastSpace = false;
			} else {
				output.append(' ');
				isLastSpace = true;
			}
		}
	
		return output.toString();
	}
}
