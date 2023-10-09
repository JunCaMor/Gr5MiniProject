// import java.io.BufferedReader;
// import java.io.File;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Scanner;

// public class CheckoutPage {

//     public ReserveSeat reserveSeat;

//     public void checkout(ReserveSeat display, String ticketSeats, String[] chosenSeats) {
//         try {
//             File csvFile = new File("Reservation.csv");
//             if (csvFile.isFile()){
//             BufferedReader csvReader = new BufferedReader(new FileReader("Reservations.csv"));
//             String row;
//             while ((row = csvReader.readLine()) != null){
//                 String[] data = row.split(",");
//             }
//             }
//         } catch (Exception e) {
//             // TODO: handle exception
//         }

//         try {
//             FileWriter csvWriter = new FileWriter("new.csv");
//             csvWriter.append(valueOf(getTicketRefNum()));
//             csvWriter.append(",");
//             csvWriter.append(display.getDate());
//             csvWriter.append(",");
//             csvWriter.append(valueof(display.getCinemaNum()));
//             csvWriter.append(",");
//             csvWriter.append(display.getTime());
//             csvWriter.append(",");
//             csvWriter.append();

//         } catch (IOException e) {
//             // TODO Auto-generated catch block
//             e.printStackTrace();
//         }


//         Scanner sc = new Scanner(System.in);
//         String confirm = "N";
//         double price = 0;
//         while (confirm.equals("N") && display.getShowing().equals("false")) {
//             price = 0;
//             for (String chosenSeat : chosenSeats) {
//                 System.out.print("Is the person at seat " + chosenSeat + " a senior citizen? [Y/N] ");
//                 confirm = sc.next() + sc.nextLine();
//                 while (!confirm.equals("Y") && !confirm.equals("N") || confirm.equals("Y") && confirm.equals("N")) {
//                     System.out.print("Please choose between 'Y' or 'N': ");
//                     confirm = sc.next() + sc.nextLine();
//                 }
//                 if (confirm.equals("Y")) {
//                     price += 280;
//                 } else {
//                     price += 350;
//                 }
//             }
//             System.out.print("Your total price is: PHP" + price + "\nConfirm? [Y/N] ");
//             confirm = sc.nextLine();
//             while (!confirm.equals("Y") && !confirm.equals("N") || confirm.equals("Y") && confirm.equals("N")) {
//                 System.out.print("Please choose between 'Y' or 'N': ");
//                 confirm = sc.next() + sc.nextLine();
//             }
//         }
//         if (display.getShowing().equals("true")) {
//             for (String chosenSeat : chosenSeats) {
//                 price += 500;
//             }
//         }
//         reserveSeat.createTicketPaper(display.getCinemaNum(), display.getMovie(), display.getDate(), display.getTime(), chosenSeats,
//                 getTicketRefNum(), price);
//         reserveSeat.getReserveObject().put(getTicketRefNum(), List.of(getTicketRefNum(), display.getDate(), display.getCinemaNum(),
//                 display.getTime(), ticketSeats, String.valueOf(price)));
//         reserveSeat.getTicketObject().add(getTicketRefNum());
//         System.out.println(getTicketPaper());
//         System.out.println("\nEnjoy your movie!");

//         sc.close();
//     }

//     private CharSequence valueof(String cinemaNum) {
//         return null;
//     }

//     private CharSequence valueOf(String string) {
//         return null;
//     }

//     private String[] getTicketPaper() {
//         return getTicketPaper();
//     }

//     private String getTicketRefNum() {
//         return this.getTicketRefNum();
//     }
// }
