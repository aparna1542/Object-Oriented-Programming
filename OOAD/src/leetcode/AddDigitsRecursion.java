package leetcode;

import java.util.Scanner;

/**
 * @author Aparna Ganesh
 * Program to add digits of a given posotive num and retun its digital root(sum of all digits)
 */
public class AddDigitsRecursion {

	public static int addDigits(int num) {
		if(num <10){
			return num;
		}
		int newNum =0;
		while(num>0){
			newNum += num%10;
			num = num/10;
		}
		 num = addDigits(newNum);
		 return num;
	}
	public static void main(String args[]) {
		System.out.println("enter the num");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int digitalRoot = AddDigitsRecursion.addDigits(num);
		System.out.println("Digital root of"+num+" is "+ digitalRoot);
	}
}
