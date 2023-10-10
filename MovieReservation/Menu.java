import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Menu {
	public void startMenu() {
		Scanner scan = new Scanner(System.in);
		CancelReservation cr = new CancelReservation();
		String transaction;

		System.out.println("*------------------------------*\nWelcome to Cinema World!\n");
		System.out.println("[1] Reserve Movie Ticket\n[2] Cancel Reservation Ticket\n");
		System.out.print("Enter your desired transaction: ");
		transaction = scan.nextLine();
		while (!transaction.equals("1") && !transaction.equals("2")
				|| transaction.equals("1") && transaction.equals("2")) {
			System.out.print("Please choose between '1' or '2': ");
			transaction = scan.next() + scan.nextLine();
		}
		if (Integer.parseInt(transaction) == 1) {
			int noOfSchedules = 0; // Reserve Seat Module
			try {
				BufferedReader brcount = new BufferedReader(new FileReader("MovieSchedule.csv")); // Read the movie
																									// schedules from
																									// the csv file
				String linecount;
				String csvSplitBy = ",";
				while ((linecount = brcount.readLine()) != null) { // cout for number of schedules
					noOfSchedules++;
				}
				brcount.close();

				BufferedReader br = new BufferedReader(new FileReader("MovieSchedule.csv")); // Read the movie schedules
																								// from the csv file
				String line;
				ReserveSeat[] reserve = new ReserveSeat[noOfSchedules];
				int i = 0;
				while ((line = br.readLine()) != null) {
					String[] data = line.split(csvSplitBy);
					String date = data[0].replace("\"", "");
					String cinemaNo = data[1].replace("\"", "");
					String time = data[2].replace("\"", "");
					String isPremiere = data[3].replace("\"", "");
					String movieTitle = data[4].replace("\"", "");
					String duration = data[5].replace("\"", "");
					reserve[i] = new ReserveSeat(date, cinemaNo, time, isPremiere, movieTitle, duration);
					i++;
				}
				br.close();
				ReserveSeat rs = new ReserveSeat(noOfSchedules);
				rs.copyMovies(reserve);
				rs.displayMovies();

			} catch (FileNotFoundException e) {
				System.err.println("File not found: " + e.getMessage());
			} catch (IOException e) {
				System.err.println("Error while processing the file: " + e.getMessage());
			}
		} else if (Integer.parseInt(transaction) == 2) {
			try {
				cr.cancel();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Invalid Transaction");
		}
		scan.close();
	}
}
