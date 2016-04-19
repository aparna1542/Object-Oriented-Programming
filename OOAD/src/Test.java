import java.io.*;
import java.util.ArrayList;
import java.util.List;
class Parent{}
class Child extends Parent {}
public class Test {
	public static void cat(File file) throws IOException,FileNotFoundException {
		
	    RandomAccessFile input = null;
	    String line = null;

	    try {
	        input = new RandomAccessFile(file, "r");
	        while ((line = input.readLine()) != null) {
	            System.out.println(line);
	        }
	        return;
	    } finally {
	        if (input != null) {
	            input.close();
	        }
	    }
	}
    public void test(Parent f) {
         System.out.println ("in Parent function");}
     public void test(Child b) {
         System.out.println ("in Child function");}

		public static void main (String [] args){
			Test t = new Test();
      		t.test(new Parent());	
      		t.test(new Child());	
			// make a note of this
      		Parent p = new Child();
       		t.test(p);		
		}
}
