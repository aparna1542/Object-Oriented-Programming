import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class CollectionTest {
	
	public static void main(String args[]) {
	
	Person a1 = new Person("Aparna",26);
	Person a2 = new Person("Aparna",26);
	
	Set<Person> pset = new HashSet<>();
	List<Person> plist = new ArrayList<>();
	Map<Person,String> pmap = new HashMap<>();
	
	pset.add(a1);
	pset.add(a2);
	
	plist.add(a1);
	plist.add(a2);
	
	pmap.put(a1,a1.name);
	pmap.put(a2,a2.name);
	
	System.out.println("Set = "+pset);
	System.out.println("List = "+plist);
	System.out.println("Map = "+pmap);
	
	}
	
	
}

class Person {

	String name;
	int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public String toString() {
		return "[" + name + "," + age + "]";
	}
	
	
	
	
}
