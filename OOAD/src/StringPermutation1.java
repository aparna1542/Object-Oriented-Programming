import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Aparna Ganesh
 *
 */
public class StringPermutation1 {

	public boolean stringPermutation(String str1, String str2) {

		if (str1.length() != str2.length()) {
			System.out.println("Please enter string of same length");
			return false;
		}

		return stringSort(str1).equals(stringSort(str2));

	}

	private String stringSort(String str1) {
		char[] string1 = str1.toCharArray();
		Arrays.sort(string1);
		return new String(string1);
	}

	public static void main(String args[]) {

		StringPermutation1 sp = new StringPermutation1();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the strings ");
		String str1 = scanner.nextLine();
		String str2 = scanner.nextLine();

		System.out.println(" Is " + str1 + " permutation of " + str2 + " "
				+ sp.stringPermutation(str1, str2));

	}

}
