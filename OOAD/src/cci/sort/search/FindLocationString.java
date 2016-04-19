package cci.sort.search;

/**
 * @author Aparna Ganesh
 * Given a sorted array of string,which is interspersed with empty string,find the location of the given string
 */
public class FindLocationString {
	public static int searchR(String[] strings, String str, int start, int end) {
		if (start > end) {
			return -1;
		}
		
		/* Move mid to the middle */
		int mid = (end + start) / 2;
		
		/* If mid is empty, find closest non-empty string. */
		if (strings[mid].isEmpty()) { 
			int left = mid - 1;
			int right = mid + 1;
			while (true) {
				if (left < start && right > end) {
					return -1;
				} else if (right <= end && !strings[right].isEmpty()) {
					mid = right;
					break;
				} else if (left >= start && !strings[left].isEmpty()) {
					mid = left;
					break;
				}
				right++;
				left--;
			}
		}
			
		/* Check for string, and recurse if necessary */
		if (str.equals(strings[mid])) { // Found it!
			return mid;
		} else if (strings[mid].compareTo(str) < 0) { // Search right
			return searchR(strings, str, mid + 1, end);
		} else { // Search left
			return searchR(strings, str, start, mid - 1);
		}
	}	
		
	public static int search(String[] strings, String str) {
		if (strings == null || str == null || str.isEmpty()) {
			return -1;
		}
		return searchR(strings, str, 0, strings.length - 1);
	}
	
	public static void main(String[] args) {
        String[] stringList = {"apple", "", "", "banana", "", "", "", "carrot", "duck", "", "", "eel", "", "flower"};
        System.out.println(search(stringList, "carrot"));
        
		//for (String s : stringList) {
		//	String cloned = new String(s);
        //	System.out.println("<" + cloned + "> " + " appears at location " + search(stringList, cloned));
		//}
	}
}
