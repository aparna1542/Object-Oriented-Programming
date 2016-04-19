/**
 * 
 */
package cci.sort.search;

/**
 * @author Aparna Ganesh
 * Program to search a string from a sorted array
 */
public class StringSearchEmptyStrings {
 
	/**
	 * @param stringArr
	 * this method returns the location of the string
	 */
	private static int search(String[] stringArr,String str,int start,int end) {
		if (start > end) { //base case
			return -1;
		}
		
		int mid = (start+end) /2;
		//if stringArr[mid] if its empty, then position mid closest to non empty string
		if(stringArr[mid].isEmpty()) {
			int left = mid-1;
			int right = mid+1;
			while(true) {
			if(left<start && right >end ) {
				return -1;
			}
			else if(left>= start && !stringArr[left].isEmpty()) {
				mid = left;
				break;
			}
			else if(right <= end && !stringArr[right].isEmpty()) {
				mid= right;
				break;
			}
			right++;
			left--;
			}
		}
		
		if(str.equals(stringArr[mid])) {
			return mid;
		}
		else if(str.compareTo(stringArr[mid]) >0) { //find in RHS
			return search(stringArr, str, mid+1, end);
			
		}
		else { //find in LHS
			return search(stringArr,str,start,mid-1);
		}
		
	}
	
	public static void main(String args[]) {
		String[] stringArr = {"apple","banana","","cc","","","dd"};
		String str ="dd";
		int location = StringSearchEmptyStrings.search(stringArr,str,0,stringArr.length -1);
		System.out.println("Location of "+str+" is "+location);
	}

	
}
