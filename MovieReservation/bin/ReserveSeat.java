/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.moviereservation;
public class ReserveSeat {
    private String id="";
    private String date;
    private String cinemaNum;
    private String time;
    private String showing;
    private String movie;
    private String movieLength;
    private int CSVSize;
    private ReserveSeat[] movies;
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
    }
    public ReserveSeat(int size){
        movies=new ReserveSeat[size];
        setCSVSize(size);
    }
    public void setCSVSize(int size){
        this.CSVSize=size;
    }
    public int getCSVSize(){
        return CSVSize;
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
    @Override
    public String toString(){
        return id+", "+date+", "+cinemaNum+", "+time+", "+showing+", "+movie+", "+movieLength;
    }
    public void displayMovies(){
        int i=0, j=0, k=-1, findPair=0;
        String[] display;
        display = new String[getCSVSize()];
        System.out.println("Welcome to Cinema World!\nSelect your movie:");
        
        for(i=0; i<getCSVSize();i++){
            display[++k]=movies[i].getMovie();
            for(j=0; j<=i;j++){
                System.out.println("i:"+i+"k:"+k+"j:"+j+" "+display[i]+"/"+display[j]);
                if(display[k]==display[j]&&i!=j){
                    k--;
                    System.out.println(k);
                }
            }
        }
        for(i=0; i<k; i++){
            System.out.println(display[i]);
        }
    }
}


