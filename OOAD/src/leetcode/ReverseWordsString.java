/**
 * 
 */
package leetcode;

/**
 * @author Aparna Ganesh
 * Reverse words in a String
 */
public class ReverseWordsString {
	
	public static String reverseWordsInString(String str) {
		//do null check 
		if(str ==null || str == "") {
			return "";
		}
		String[] arr = str.split(" ");
		StringBuilder sbr = new StringBuilder();
		for(int i=arr.length-1;i>=0;i--) {
			sbr.append(arr[i]+" ");
		}
		return sbr.toString();
	}

	public static void main(String args[]) {
		String str = ReverseWordsString.reverseWordsInString("aparna sri");
		System.out.println("Reversed String is "+str);
	}
	
}
