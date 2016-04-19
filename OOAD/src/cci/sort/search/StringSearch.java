/**
 * 
 */
package cci.sort.search;

/**
 * @author Aparna Ganesh
 * Program to search a string from a sorted array
 */
public class StringSearch {
 
	/**
	 * @param stringArr
	 * this method returns the location of the string
	 */
	private static int search(String[] stringArr,String str,int start,int end) {
		if (start > end) { //base case
			return -1;
		}
		
		int mid = (start+end) /2;
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
		String[] stringArr = {"apple","banana"};
		String str ="banana";
		int location = StringSearch.search(stringArr,str,0,stringArr.length -1);
		System.out.println("Location of "+str+" is "+location);
	}

	
}
