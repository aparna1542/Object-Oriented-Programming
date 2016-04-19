import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 */

/**
 * @author Aparna Ganesh
 *
 */
public class StringToDate {

	public static Date stringToDate(String str) {
		
		Date date = null;
		try {
			date = new SimpleDateFormat("MM/dd/yyyy").parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
		
	}
	public static void main(String args[]) {
		String str = "04/05/2016";
		System.out.println("String to Date "+stringToDate(str));
	}
}
