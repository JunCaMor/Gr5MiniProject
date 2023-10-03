import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CancelReservation {

    public void cancel() throws ParseException {
        boolean response = true;

        try (Scanner input = new Scanner(System.in)) {
            while (response) {
                try {
                    System.out.println("\n\t\tCancel Reservation");
                    System.out.print("\nPlease enter your ticket's reference no.: ");

                    String reservationID = input.nextLine();
                    boolean idFound = false; // Flag to track if the ID is found
                    try {
                        // Read the CSV file
                        BufferedReader br = new BufferedReader(new FileReader("Reservations.csv"));
                        List<String> lines = new ArrayList<>();
                        String line;

                        while ((line = br.readLine()) != null) {
                            String[] parts = line.split(",");
                            if (parts.length > 0 && parts[0].equals("\"" + reservationID + "\"")) {
                                idFound = true; // Mark ID as found
                                System.out.println("____________________________________________________________");
                                System.out.println("\nCinema " + parts[2].replace("\"", ""));

                                 String inputDateStr = parts[1].replace("\"", ""); //Change index based on location of date

                                // Create a SimpleDateFormat object for parsing the input date
                                SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");

                                // Parse the input date string into a Date object
                                Date date = inputDateFormat.parse(inputDateStr);

                                // Create a SimpleDateFormat object for formatting the date in the desired format
                                SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd MMMM yyyy");

                                String formattedDate = outputDateFormat.format(date);

                                System.out.println(formattedDate);// Print the formatted date
                                System.out.println(parts[0].replace("\"", "") + ", @" + parts[3].replace("\"", ""));
                                System.out.println(parts[4].replace("\"", ""));
                                System.out.println("\nRef no.: " + parts[0].replace("\"", "") + "\t\tPHP "
                                        + parts[6].replace("\"", ""));
                                System.out.println("____________________________________________________________");
                                continue; // Skip this line, as it matches the reservationID
                            }
                            lines.add(line);
                        }
                        br.close();

                        if (idFound) {
                            System.out.print("\nDo you want to cancel this reservation? [Y/N]: ");
                            String confirm = input.nextLine();
                            if (confirm.equalsIgnoreCase("y")) {
                                // Write back to the CSV file without the matching reservationID
                                BufferedWriter bw = new BufferedWriter(new FileWriter("Reservations.csv"));
                                for (String updatedLine : lines) {
                                    bw.write(updatedLine);
                                    bw.newLine();
                                }
                                bw.close();

                                System.out.println("\nReservation canceled.");
                            } else {
                                System.out.println("\nCannot cancel reservation.");
                            }
                        } else {
                            System.out.println("\nID not found.");
                        }
                    } catch (FileNotFoundException e) {
                        System.err.println("File not found: " + e.getMessage());
                    } catch (IOException e) {
                        System.err.println("Error while processing the file: " + e.getMessage());
                    }
                } finally {
                    System.out.print("\nDo you want to cancel another reservation? [Y/N]: ");
                    String anotherReservation = input.nextLine();
                    // if (anotherReservation.equalsIgnoreCase("y")) {
                    //     response = true;
                    // } else {
                    //     response = false;
                    // }
                    response = anotherReservation.equalsIgnoreCase("y");
                }
            }
        }
    }
}
