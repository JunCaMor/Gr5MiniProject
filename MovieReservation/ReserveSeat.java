import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReserveSeat {
    private String id = "";
    private String date;
    private String cinemaNum;
    private String time;
    private String showing;
    private String movie;
    private String movieLength;
    HashMap<String, List<String>> movieDeets = new HashMap<>();

    // private Checkout checkout;
    public ReserveSeat(String date, String cinemaNum, String time, String showing, String movie, String movieLength) {
        id = date + "0" + String.valueOf(cinemaNum);
        id = id.replaceFirst("20", "").replace("-", "");
        this.date = date;
        this.cinemaNum = cinemaNum;
        this.time = time;
        this.showing = showing;
        this.movie = movie;
        this.movieLength = movieLength;
        movieDeets.put(id, List.of(date, cinemaNum, time, showing, movie, movieLength));
        // new ReserveSeat(id, date, cinemaNum, time, showing, movie, movieLength);
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setCinemaNum(String cinemaNum) {
        this.cinemaNum = cinemaNum;
    }

    public String getCinemaNum() {
        return cinemaNum;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setShowing(String showing) {
        this.showing = showing;
    }

    public String getShowing() {
        return showing;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovieLength(String movieLength) {
        this.movieLength = movieLength;
    }

    public String getMovieLength() {
        return movieLength;
    }

    @Override
    public String toString() {
        return id + ", " + date + ", " + cinemaNum + ", " + time + ", " + showing + ", " + movie + ", " + movieLength;
    }

    public void displayCinemaMovies() {
        int i = 0;
        System.out.println("Welcome to Cinema World!");

    }
}
