/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;

/**
 *
 * @author junel.mora
 */
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
public class ReserveSeat {
    private String id="";
    private String date;
    private String cinemaNum;
    private String time;
    private String showing;
    private String movie;
    private String movieLength;
    private int CSVSize;
    private String[][] seats;
    private ReserveSeat[] movies;
    private Scanner sc=new Scanner(System.in);
    //private Checkout checkout;
    public ReserveSeat(String date, String cinemaNum, String time, String showing, String movie, String movieLength){
        int movieKeyCharLimit=0;
        //For automatically generating an id for each movie.
        id=String.valueOf(movie.charAt(0)); // Gets first letter of movie. 
        for(int i=1; i<movie.length(); i++){ // Getting two more key sub-values.
            if(movie.charAt(i-1)==' '){
                id+=String.valueOf(movie.charAt(i));
                movieKeyCharLimit++;
            }
            if(movieKeyCharLimit==2){
                break; // Limits the characters of a movie key into three.
            }
        }
        while(id.length()<3){
            id+="0";
        }
        while(time.length()<5){
            time="0"+time;
        }
        id+=time.substring(0, 2);
        id+=cinemaNum;
        // Key generator ends here
        this.date=date;
        this.cinemaNum=cinemaNum;
        this.time=time;
        this.showing=showing;
        this.movie=movie;
        this.movieLength=movieLength;
        this.seats = new String[8][5] = {{"A1","A2","A3","A4","A5"},{"B1","B2","B3","B4","B5"},{"C1","C2","C3","C4","C5"},{"D1","D2","D3","D4","D5"},
                                    {"E1","E2","E3","E4","E5"},{"F1","F2","F3","F4","F5"},{"G1","G2","G3","G4","G5"},{"H1","H2","H3","H4","H5"}};
    }
    public ReserveSeat(int size){
        movies=new ReserveSeat[size];
        setCSVSize(size);
    }
    public void copyMovies(ReserveSeat[] copy){
        System.arraycopy(copy,0,movies,0,copy.length);
    }       
    public void setDate(String date){
        this.date=date;
    }
    public String getDate(){
        return date;
    }
    public void setCinemaNum(String cinemaNum){
        this.cinemaNum=cinemaNum;
    }
    public String getCinemaNum(){
        return cinemaNum;
    }
    public void setTime(String time){
        this.time=time;
    }
    public String getTime(){
        return time;
    }
    public void setShowing(String showing){
        this.showing=showing;
    }
    public String getShowing(){
        return showing;
    }
    public void setMovie(String movie){
        this.movie=movie;
    }
    public String getMovie(){
        return movie;
    }
    public void setMovieLength(String movieLength){
        this.movieLength=movieLength;
    }
    public String getMovieLength(){
        return movieLength;
    }
    public void setCSVSize(int size){
        this.CSVSize=size;
    }
    public int getCSVSize(){
        return CSVSize;
    }
//    public void setSeats(String[][] seats){
//        this.seats=seats;
//    }
    public String[][] getSeats(){
        return seats;
    }
    @Override
    public String toString(){
        return "ID: "+id+", DATE: "+date+", CINEMA: "+cinemaNum+", TIME: "+time+", SHOWING: "+showing+", TITLE: "+movie+", HOURS: "+movieLength+", SEATS: "+seats;
    }
    public void displayMovies(){
        int i=0, j=0, k=0, findPair=0;
        String[] display;
        display = new String[getCSVSize()];
        System.out.println("Welcome to Cinema World!\n\nHere are our movies:");
        for(i=0; i<getCSVSize();i++){
            display[k]=movies[i].getMovie();
            for(j=0; j<=i;j++){
                if(display[k]==display[j]&&k!=j){
                    display[k]=null;
                    k--;
                    break;
                }
            }
            k++;
        }
        for(i=0; i<k; i++){
            System.out.println("["+(i+1)+"] "+display[i]);
        }
        System.out.print("Choose your movie: ");
        int choice=sc.nextInt();
        while(choice>k||choice<1){
            System.out.print("Please choose within the choices: ");
            choice=sc.nextInt();
        }
        chooseSchedule(display[choice-1]);
    }
    public void chooseSchedule(String movie){
        int i=0, k=0, totalNumberOfScreens=0;
        ReserveSeat[] display;
        System.out.println("Great! Here are our schedules for the "+movie+" movie");
        for(i=0; i<getCSVSize(); i++){
            if(movies[i].getMovie().equals(movie)){
                totalNumberOfScreens++;
            }
        }
        display=new ReserveSeat[totalNumberOfScreens];
        for(i=0; i<getCSVSize(); i++){
            if(movies[i].getMovie().equals(movie)&&movies[i].getShowing().equals("true")){
                display[k++]=movies[i];
            }
        }
        for(i=0;i<k;i++){
            System.out.println("["+(i+1)+"] Cinema: "+display[i].getCinemaNum()+", Date: "+display[i].getDate()+", Time: "+display[i].getTime()+", Movie Length: "+display[i].getMovieLength());
        }
        System.out.print("Choose your schedule: ");
        int choice=sc.nextInt();
        while(choice>k||choice<1){
            System.out.print("Please choose within the schedules: ");
            choice=sc.nextInt();
        }
        chooseSeats(display[choice-1]);
    }
    public void chooseSeats(ReserveSeat display){
        int i=0, j=0;
        System.out.println("Awesome! Now choose your seats for the "+display.getMovie()+" movie");
        for(i=0; i<8; i++){
            for(j=0; j<5; j++){
                System.out.println(seats[i][j]);
            }
        }
    }
}
