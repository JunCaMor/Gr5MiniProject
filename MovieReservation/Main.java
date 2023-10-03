import java.text.ParseException;

public class Main {

	public static void main(String[] args) throws ParseException {
		ReserveSeat[] reserve=new ReserveSeat[]{
			new ReserveSeat("2023-10-02","1","12:00","true","Kung Fu Panda","1.75"),
			new ReserveSeat("2023-10-04","2","12:00","true","Kung Fu Hustle","1.75"),
		};
		ReserveSeat display=new ReserveSeat(reserve.length);
        display.copyMovies(reserve);
        display.displayMovies();
	}
}
