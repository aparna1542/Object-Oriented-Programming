import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/**
 * To Find whether a given string has duplicate or not
 * using data structure and without using data struct
 * @author Aparna Ganesh
 *
 */
public class StringUnique {

	
	public static void main(String[] args) {

		StringUnique testUnique = new StringUnique();
		System.out.println("Enter your name ");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		
		boolean result = testUnique.checkUnique(name);
		if(result) {
			System.out.println("Your name is unique ");
		}
		else 
			System.out.println("Duplicate character found");
	}

	public boolean checkUnique(String name) {
		
		//with data staructures
		/*Set<Character> hashSet = new HashSet<>();

		for (char c : name.toCharArray()) { // iterate through character array

			if (!hashSet.add(Character.toUpperCase(c))) //unable to add into hashset
				return false;

		}
		return true;*/
//without using data structures - storing boolean true/false in array with ASCII value as array index		
		boolean strArray[] = new boolean[256];
		
		for(Character c : name.toCharArray()) {
			
			int val = c; //val stores the ascii value of character
			if(strArray[val]) {
				return false; 
			}
			strArray[val] = true;
		}
		return true;

	}

}
