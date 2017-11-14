import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	
	public static void main(String[] args) {
		
		String i = "2017-11-14 10:39:09";
		
		Date date1= new Date();
		SimpleDateFormat compareDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		
		try {
			Date d1 = compareDate.parse(i);
			System.out.println(d1);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		
	}
}
