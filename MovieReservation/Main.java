import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
class main {

	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);
		CancelReservation cr = new CancelReservation();
		//ReserveSeat rs = new ReserveSeat(0);
		int transaction;
		System.out.println("Welcome to Cinema World!\n");
		System.out.println("[1] Reserve Movie Ticket\n[2] Cancel Reservation Ticket\n");
		System.out.print("Enter your desired transaction: ");
		transaction = scan.nextInt();
		if (transaction == 1){
			int noOfSchedules = 0;
			try {
				 BufferedReader br = new BufferedReader(new FileReader("MovieSchedule.csv"));
                    //List<String> schedules = new ArrayList<>();
					String line;
					String csvSplitBy = ",";
                    while ((line = br.readLine()) != null){
						String[]data = line.split(csvSplitBy);
						String date = data[0];
						String cinemaNo = data[1];
						String time = data[2];
						String isPremiere = data[3];
						String movieTitle = data[4];
						String duration = data [5];
						new ReserveSeat(date, cinemaNo, time, isPremiere, movieTitle, duration);
						noOfSchedules++;
					 }
					 br.close();
					ReserveSeat rs = new ReserveSeat(noOfSchedules);
					rs.displayMovies();
				
			} catch (FileNotFoundException e) {
				System.err.println("File not found: " + e.getMessage());
			} catch (IOException e) {
                        System.err.println("Error while processing the file: " + e.getMessage());
            }
		} else if (transaction == 2){
			cr.cancel(); // Cancel Reservation Module
		}else{
			System.out.println("Invalid Transaction");
		}

		scan.close();
	}
}

