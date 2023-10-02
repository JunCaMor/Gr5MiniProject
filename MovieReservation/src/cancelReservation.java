package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CancelReservation {

    public void cancel() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("\tCancel Reservation Page");
            System.out.print("Please enter Reservation ID: ");

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
                        continue; // Skip this line, as it matches the reservationID
                    }
                    lines.add(line);
                }

                br.close();

                // Write back to the CSV file without the matching reservationID
                BufferedWriter bw = new BufferedWriter(new FileWriter("Reservations.csv"));
                for (String updatedLine : lines) {
                    bw.write(updatedLine);
                    bw.newLine();
                }

                bw.close();

                if (idFound) {
                    System.out.print("Are you sure you want to cancel reservation? <yes/no>: ");
                    String confirm = input.nextLine();
                    if (confirm.equalsIgnoreCase("yes")) {
                        System.out.println("Reservation with ID " + reservationID + " has been canceled.");
                    } else {
                        System.out.println("Reservation with ID " + reservationID + " has not been canceled.");
                        return;
                    }
                } else {
                    System.out.println("ID not found.");
                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + e.getMessage());
            } catch (IOException e) {
                System.err.println("Error while processing the file: " + e.getMessage());
            }
        }
    }
}