/**
 * 
 */
package leetcode;

/**
 * @author Aparna Ganesh
 *
 */
public class HDTV implements Comparable<HDTV> {


	int size;
	String name;
	
	public HDTV(int size,String name) {
		this.size = size;
		this.name = name;
	}
	public int compareTo(HDTV tv) {
		if(this.size > tv.size) {
			return 1;
		}
		else
		return -1;
	}
	
	public static void main(String args[]) {
		HDTV tv1 = new HDTV(44,"toshiba");
		HDTV tv2 = new HDTV(43,"apple");
		if(tv1.compareTo(tv2) >0) {
			System.out.println(tv1.name+ " is better");
		}
		else {
			System.out.println(tv2.name+" is better");
		}
	}

	
}
