package org.archid.civ4.utils;

public class StringUtils {

	/*
	 * Convert Given String to Camel Case i.e.
	 * Capitalise first letter of every word to upper case
	 * "THIS_TEXT" -> "This_Text"
	 */
	public static String camelCase(String str, char delim)
	{
		StringBuilder builder = new StringBuilder(str);
		
		// Flag to keep track if last visited character is a white space or not
		boolean isLastSpace = true;
		
		// Iterate String from beginning to end.
		for(int i = 0; i < builder.length(); i++)
		{
			char ch = builder.charAt(i);
			
			if(isLastSpace && ch >= 'a' && ch <='z')
			{
				// Character need to be converted to uppercase
				builder.setCharAt(i, (char)(ch + ('A' - 'a') ));
				isLastSpace = false;
			}
			else if (ch != delim)
				isLastSpace = false;
			else
				isLastSpace = true;
		}
	
		return builder.toString();
	}

	/*
	 * Convert Given String to Camel Case, removing the word delimiter i.e.
	 * Capitalise first letter of every word to upper case
	 * "THIS_TEXT" -> "ThisText"
	 */
	public static String camelCaseCompress(String str, char delim)
	{
		StringBuilder input = new StringBuilder(str);
		StringBuilder output = new StringBuilder();
		
		// Flag to keep track if last visited character is a white space or not
		boolean isLastSpace = true;
		
		// Iterate String from beginning to end.
		for(int i = 0; i < input.length(); i++)
		{
			char ch = input.charAt(i);
			
			if(isLastSpace && ch >= 'a' && ch <='z')
			{
				// Character need to be converted to uppercase
				output.append((char)(ch + ('A' - 'a') ));
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

	/*
	 * Convert Given String to Camel Case, replacing the word delimiter with a space i.e.
	 * Capitalise first letter of every word to upper case
	 * "THIS_TEXT" -> "This Text"
	 */
	public static String camelCaseSpace(String str, char delim)
	{
		StringBuilder input = new StringBuilder(str);
		StringBuilder output = new StringBuilder();
		
		// Flag to keep track if last visited character is a white space or not
		boolean isLastSpace = true;
		
		// Iterate String from beginning to end.
		for(int i = 0; i < input.length(); i++)
		{
			char ch = input.charAt(i);
			
			if(isLastSpace && ch >= 'a' && ch <='z')
			{
				// Character need to be converted to uppercase
				output.append((char)(ch + ('A' - 'a') ));
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
