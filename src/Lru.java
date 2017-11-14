import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Lru {

	private String buffer[][] = new String[4][4];
	private String dataBase[] = new String[7];

	public int checkTime() {

		SimpleDateFormat lastDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int lastDateIndex = 0;
		SimpleDateFormat compareDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String mostRecentDateString = this.getBuffer()[0][1];

		Date d2 = new Date();
		try {
			d2 = lastDate.parse(mostRecentDateString);
		} catch (ParseException e1) {

			e1.printStackTrace();
		}

		for (int j = 1; j < this.getBuffer().length; j++) {
			if (this.getBuffer()[j][1] != null) {
				String time = this.getBuffer()[j][1];

				try {

					Date d1 = compareDate.parse(time);

					if (d1.before(d2)) {
						d2 = d1;
						lastDateIndex = j;
					}

				} catch (ParseException e) {

					e.printStackTrace();
				}
			}
		}
		return lastDateIndex;

	}

	public int getIndexEmptyPage() {

		for (int i = 0; i < this.getBuffer().length; i++) {

			if (this.getBuffer()[i][0] == null)
				return i;

		}

		return -1;

	}

	public String[][] getBuffer() {
		return buffer;
	}

	public void setBuffer(String a) {
		int index =0;
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		if (this.getIndexEmptyPage() == -1) {
			 index = this.checkTime();
			this.buffer[index][0] = a;
			this.buffer[index][1] = date;
			
			
		}else {
			 index = this.getIndexEmptyPage();
			this.buffer[index][0] = a;
			this.buffer[index][1] = date;
		}

		

		

	}

	public String[] getDataBase() {
		return dataBase;
	}

	public void setDataBase(String[] dataBase) {
		this.dataBase = dataBase;
	}

	public static void main(String[] args) {

		Lru lru = new Lru();

		System.out.println(lru.getIndexEmptyPage());
		lru.setBuffer("Lol");

		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lru.setBuffer("mdr");

		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lru.setBuffer("tmtc");

		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(lru.getIndexEmptyPage());
		System.out.println(lru.getBuffer()[0][1]);
		System.out.println(lru.checkTime());

	}

}
