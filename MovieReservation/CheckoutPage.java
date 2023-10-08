import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CheckoutPage {


    public static void checkout(){

        Scanner scan = new Scanner(System.in);

        System.out.println();

        //Display movie, Date, Screening time, Number of seats,  Seat number, Total price
        String file ="Reservations.csv";
        BufferedReader reader=null;
        String line="";

        try {
            reader= new BufferedReader(new FileReader(file));
            while ((line=reader.readLine())!= null){
                String[] row= line.split(",");

                for (String index: row){
                    System.out.printf(index);
                }
                System.out.println();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{ 
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Calculate Total Price
        // is movie premiere screening
        // if premiere, then total price = no.of seats * 500
        // else, then total price= (no. of seats * 350) + (no. of senior seats * 280)


        System.out.println("Do you want to proceed with the reservation? y/n");
        String proceed = scan.nextLine();

        if (proceed == "y"){
            //Display reservation ID
        }else if (proceed =="no"){ 
            //return to main page
        }
        else{
            System.out.println("Please enter only y or n . ");
        }

        scan.close();
    }
}
