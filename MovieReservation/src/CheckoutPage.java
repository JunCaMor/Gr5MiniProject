package src;

import java.util.Scanner;

public class CheckoutPage {
    private String id;
    private String date;
    private int cinemaNum;
    private String time;
    private String movie;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCinemaNum() {
        return this.cinemaNum;
    }

    public void setCinemaNum(int cinemaNum) {
        this.cinemaNum = cinemaNum;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMovie() {
        return this.movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }



    public static void Checkout(CheckoutPage Checkout){
        Scanner scan = new Scanner(System.in);

        System.out.println();

        System.out.println("Do you want to proceed with the reservation? y/n");
        String proceed = scan.nextLine();

        if (proceed == "y"){
            //Display reservation ID
        }else{
            //return to main page
        }
    }
}
