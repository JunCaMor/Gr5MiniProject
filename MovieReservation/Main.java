import java.text.ParseException;
import java.util.Scanner;
class main {

	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);
		CancelReservation cr = new CancelReservation();
		int transaction;
		System.out.println("Welcome to Cinema World!\n");
		System.out.println("[1] Reserve Movie Ticket\n[2] Cancel Reservation Ticket\n");
		System.out.print("Enter your desired transaction: ");
		transaction = scan.nextInt();
		if (transaction == 1){
			System.out.println("Insert ReserveSeat module here");
		} else if (transaction == 2){
			cr.cancel();
		}else{
			System.out.println("Invalid Transaction");
		}
	}
}

