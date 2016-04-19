/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Aparna Ganesh
 *
 */
public class Person {

	String name;
	int height;
	public Person(String name,int height) {
		this.name = name;
		this.height = height;
	}
	public static void main(String args[]) {
		Person p1= new Person("Aparna",5);
		Person p2 = new Person("Sri",6);
		Person p3 = new Person("mila",4);
		ArrayList<Person> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		Collections.sort(list, new HeightComperator());
		for(Person p:list) {
			System.out.println(p.name);
		}
	}
}

class HeightComperator implements Comparator<Person> {

	
	@Override
	public int compare(Person p1, Person p2) {
		if(p1.height >p2.height) {
			return 1;	
		}
		else 
			return -1;
		
	}
	
}
