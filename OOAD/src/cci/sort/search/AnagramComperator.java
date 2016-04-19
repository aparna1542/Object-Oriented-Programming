/**
 * 
 */
package cci.sort.search;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Aparna Ganesh
 *
 */
public class AnagramComperator implements Comparator<String> {

	public String sortString(String s) {
		char[] stringArray = s.toCharArray();
		Arrays.sort(stringArray);
		return new String(stringArray);
	}

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(String s1, String s2) {
		
		return sortString(s1).compareTo(sortString(s2));
	}
	
	
}
