package src;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class cancelReservation{

    public cancelReservation() throws FileNotFoundException{
        Scanner input = new Scanner(System.in);

        System.out.println("\tCancel Reservation Page");
        System.out.println("Please enter Reservation ID: ");

        String reservationID = input.nextLine();

        try {
            FileInputStream fis = new FileInputStream("Reservation.csv");
    
            System.out.println("Data in the file: ");
    
            // Reads the first line
            int i = fis.read();
    
           while(i != -1) {
               System.out.print((char)i);
    
               // Reads next line from the file
               i = fis.read();
            }
            fis.close();
         }
    
         catch(Exception e) {
            e.getStackTrace();
         }
    }
}