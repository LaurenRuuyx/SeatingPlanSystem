import java.awt.EventQueue;
import java.util.ArrayList;

public class MainLoop {
	
	public static ArrayList<Booking> Bookings = new ArrayList<Booking>();
	public static int No_Seats;
	public static String flight1 = "“08/03/2022, 06:20, 11:57, 01:37, 7021.04, 179, HND, Tokyo, SYD, Sydney, TS4977, Easyplane";
	public static String flight2 = "27/03/2022, 18:23, 03:44, 09:21, 11687.85, 10, SYD, Sydney, HND, Tokyo, ST4138, Eastair";
	public static String[] flight1_parts = flight1.split(", ");
	public static String[] flight2_parts = flight2.split(", ");
	
	public static void main(String[] args) {		
		// The following piece of code opens up the window that allows the user to select the number of tickets they wish to purchase
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewSeating frame = new ViewSeating();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	// The following method converts a string of type "hh/mm" to minutes
	public static int ConvertToMinutes(String time) {
		int total = 0;
		String[] conversion_parts = time.split(":");
		if(conversion_parts[0].split("")[0] == "0") {
			total += (Integer.valueOf(conversion_parts[0].split("")[1])) * 60;
		}
		else {
			total += Integer.valueOf(conversion_parts[0])*60;
		}
		
		if (conversion_parts[1].split("")[0] == "0") {
			total += Integer.valueOf(conversion_parts[1].split("")[1]);
		}
		else {
			total += Integer.valueOf(conversion_parts[1]);
		}
		return total;
		
	}

}
