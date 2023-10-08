import java.text.ParseException;

public class Main {

	public static void main(String[] args) throws ParseException {
		ReserveSeat[] reserve = new ReserveSeat[] {
				new ReserveSeat("2021-06-01", "1", "12:30", "true", "HP7 and the Deathly Hallows (Part 2)", "2.25"),
				new ReserveSeat("2021-06-01", "1", "15:00", "false", "HP7 and the Deathly Hallows (Part 2)", "2.25"),
				new ReserveSeat("2021-06-01", "1", "17:30", "false", "HP7 and the Deathly Hallows (Part 2)", "2.25"),
				new ReserveSeat("2021-06-01", "1", "20:00", "false", "HP7 and the Deathly Hallows (Part 2)", "2.25"),
				new ReserveSeat("2021-06-01", "2", "12:45", "false", "Kung Fu Panda 2", "1.75"),
				new ReserveSeat("2021-06-01", "2", "02:45", "false", "Kung Fu Panda 2", "1.75"),
				new ReserveSeat("2021-06-01", "2", "04:45", "false", "Kung Fu Panda 2", "1.75"),
				new ReserveSeat("2021-06-01", "2", "06:45", "false", "Kung Fu Panda 2", "1.75"),
				new ReserveSeat("2021-06-01", "2", "08:45", "false", "Kung Fu Panda 2", "1.75"),
				new ReserveSeat("2021-06-01", "3", "13:15", "false", "Transformers: Dark of the Moon", "2.75"),
				new ReserveSeat("2021-06-01", "3", "16:15", "false", "Transformers: Dark of the Moon", "2.75"),
				new ReserveSeat("2021-06-01", "3", "19:15", "false", "Transformers: Dark of the Moon", "2.75"),
				new ReserveSeat("2021-06-01", "4", "12:00", "false", "I Am Number Four", "2.00"),
				new ReserveSeat("2021-06-01", "4", "14:15", "false", "I Am Number Four", "2.00"),
				new ReserveSeat("2021-06-01", "4", "16:30", "false", "I Am Number Four", "2.00"),
				new ReserveSeat("2021-06-01", "4", "19:00", "false", "I Am Number Four", "2.00")
		};
		ReserveSeat display = new ReserveSeat(reserve.length);
		display.copyMovies(reserve);
		display.displayMovies();
	}
}
