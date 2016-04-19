import java.io.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Program to practice Exception Handling
 * 
 * @author apar.sri
 *
 */

public class ListOfNumbers {
	private List<Integer> list;
	private static final int SIZE = 10;

	public ListOfNumbers() {
		list = new ArrayList<Integer>(SIZE);
		for (int i = 0; i < SIZE; i++)
			list.add(new Integer(i));
	}

	public void writeList() {
		PrintWriter out = null;

		try {
			System.out.println("Entering try statement");
			out = new PrintWriter(new FileWriter("OutFile.txt"));

			for (int i = 0; i < SIZE; i++)
				out.println(list.get(i));

		} catch (IndexOutOfBoundsException e) {
			System.err.println("Caught IndexOutOfBoundsException: "
					+ e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		} finally {
			if (out != null) {
				System.out.println("Closing PrintWriter");
				out.close();
			} else {
				System.out.println("PrintWriter not open");
			}
		}
	}

	// TODO
	// Add readList() -read int values from a file,print each value,append them
	// to end of vector
	// text file with numbers needed.
	// handle all errors
	public void readList()
	{

		BufferedReader in=null;
		try {
			in = new BufferedReader(new FileReader("Input.txt"));
			String s = null;
			while(( s = in.readLine()) !=null) {
				System.out.println("Read "+ s + " from file");
				try {
					list.add(Integer.valueOf(s));
				}
				catch(NumberFormatException e) {
					System.out.println("Non integer found " + e);
					System.out.println("Skipping!!!");
					continue;
				}

			}
			for(int i : list) {
				System.out.println("Value = "+ i);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("FILE NOT FOUND!!!");
			e.printStackTrace();
			return;
		}
		catch(IOException e) {
			e.printStackTrace();
		}

		finally {
			if(in != null) {
				try {
					System.out.println("Closing reader!!!");
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}



	}
	public static void main (String args[])
	{
		ListOfNumbers l = new ListOfNumbers();
		l.writeList();
		l.readList();
	}
}
