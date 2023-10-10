import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ReserveSeat {
    private int tickets = 0;
    private int CSVSize;
    private int seatsNum;
    private int movieTicketsNum;
    private String id = "";
    private String date;
    private String cinemaNum;
    private String time;
    private String premiere;
    private String title;
    private String movieLength;
    private String ticketPaper;
    private String[] seatSample = { "A1", "A2", "A3", "A4", "A5", "B1", "B2", "B3", "B4", "B5",
            "C1", "C2", "C3", "C4", "C5", "D1", "D2", "D3", "D4", "D5",
            "E1", "E2", "E3", "E4", "E5", "F1", "F2", "F3", "F4", "F5",
            "G1", "G2", "G3", "G4", "G5", "H1", "H2", "H3", "H4", "H5" };
    private ReserveSeat[] movies;
    private HashMap<String, List<String>> seats = new HashMap<>();
    // private HashMap<String,List<String>> reserve=new HashMap<>();
    // private List<String> tickets=new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public ReserveSeat(String date, String cinemaNum, String time, String premiere, String title, String movieLength) {
        this.date = date;
        this.cinemaNum = cinemaNum;
        this.time = time;
        this.premiere = premiere;
        this.title = title;
        this.movieLength = movieLength;
        this.seatsNum = 40;
        int movieKeyCharLimit = 0;
        // For automatically generating an id for each movie.
        id = String.valueOf(title.charAt(0)); // Gets first letter of movie.
        for (int i = 1; i < title.length(); i++) { // Getting two more key sub-values.
            if (title.charAt(i - 1) == ' ') {
                id += String.valueOf(title.charAt(i));
                movieKeyCharLimit++;
            }
            if (movieKeyCharLimit == 2) {
                break; // Limits the characters of a movie key into three.
            }
        }
        while (id.length() < 3) {
            id += "0";
        }
        while (time.length() < 5) {
            time = "0" + time;
        }
        id += date.replaceFirst("20", "").replace("-", "");
        id += time.substring(0, 2);
        id += cinemaNum;
        setID(id);
        // Key generator ends here
        seats.put(id, List.of(seatSample));
    }

    public ReserveSeat(int size) {
        movies = new ReserveSeat[size];
        setCSVSize(size);
    }

    public void copyMovies(ReserveSeat[] copy) {
        System.arraycopy(copy, 0, movies, 0, copy.length);
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getID() {
        return id;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    public int getTickets() {
        return tickets;
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

    public void setPremiere(String premiere) {
        this.premiere = premiere;
    }

    public String getPremiere() {
        return premiere;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setMovieLength(String movieLength) {
        this.movieLength = movieLength;
    }

    public String getMovieLength() {
        return movieLength;
    }

    public void setTicketPaper(String ticketPaper) {
        this.ticketPaper = ticketPaper;
    }

    public String getTicketPaper() {
        return ticketPaper;
    }

    public void setCSVSize(int size) {
        this.CSVSize = size;
    }

    public int getCSVSize() {
        return CSVSize;
    }

    public void setSeatsNum(int seatsNum) {
        this.seatsNum = seatsNum;
    }

    public int getSeatsNum() {
        return seatsNum;
    }

    public void setMovieTicketsNum(int movieTicketsNum) {
        this.movieTicketsNum = movieTicketsNum;
    }

    public int getMovieTicketsNum() {
        return movieTicketsNum;
    }

    public void setSeats(ReserveSeat movie) {
        String temp = "", ticketSeats = "";
        String[] selectSeats = { "A1", "A2", "A3", "A4", "A5", "B1", "B2", "B3", "B4", "B5",
                "C1", "C2", "C3", "C4", "C5", "D1", "D2", "D3", "D4", "D5",
                "E1", "E2", "E3", "E4", "E5", "F1", "F2", "F3", "F4", "F5",
                "G1", "G2", "G3", "G4", "G5", "H1", "H2", "H3", "H4", "H5" };
        String[] ticketID;
        String[] seatArray = new String[40];
        int i = 0, j = 0, movieSeats = 40;
        movieTicketsNum = 0;
        try {
            BufferedReader read = new BufferedReader(new FileReader(
                    "C:\\Users\\Junra\\Documents\\NetBeansProjects\\MovieReservation\\src\\main\\java\\com\\mycompany\\moviereservation\\Reservations.csv"));
            String str;
            tickets = 0;
            while ((str = read.readLine()) != null) {
                tickets++;
                String[] data = str.split(",");
                temp = data[0].replace("\"", "");
                if (!temp.equals("")) { // Denies empty input
                    if (temp.substring(0, 12).equals(movie.getID())) {
                        movieTicketsNum++;
                    }
                }
            }
            // System.out.println(movieTicketsNum);
            movie.setMovieTicketsNum(movieTicketsNum);
            read.close();
            BufferedReader read2 = new BufferedReader(new FileReader(
                    "C:\\Users\\Junra\\Documents\\NetBeansProjects\\MovieReservation\\src\\main\\java\\com\\mycompany\\moviereservation\\Reservations.csv"));
            ticketID = new String[movieTicketsNum];
            while ((str = read2.readLine()) != null) {
                String[] data = str.split("\",\"");
                temp = data[0].replace("\"", "");
                if (!temp.equals("")) { // Denies empty input
                    if (temp.substring(0, 12).equals(movie.getID())) {
                        ticketID[i] = temp;
                        ticketSeats += data[4].replace("\"", "");
                    }
                }
            }
            read2.close();
            for (i = 0; i < ticketSeats.length(); i++) {
                if (ticketSeats.charAt(i) == 'A' || ticketSeats.charAt(i) == 'B' || ticketSeats.charAt(i) == 'C'
                        || ticketSeats.charAt(i) == 'D' ||
                        ticketSeats.charAt(i) == 'E' || ticketSeats.charAt(i) == 'F' || ticketSeats.charAt(i) == 'G'
                        || ticketSeats.charAt(i) == 'H') {
                    seatArray[j++] = ticketSeats.substring(i, i + 2);
                }
            }
            for (i = 0; i < j; i++) {
                for (int k = 0; k < 40; k++) {
                    if (seatArray[i].equals(selectSeats[k])) {
                        movieSeats--;
                        selectSeats[k] = "**";
                    }
                }
            }
            movie.setSeatsNum(movieSeats);
            // System.out.println("MS: "+movieSeats);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error while processing the file: " + e.getMessage());
        } catch (Exception e) { // Deny out of bounds error
        }
        seats.put(movie.getID(), List.of(selectSeats));
        // getSeats(movie.getID());
    }

    public List<String> getSeats(String id) {
        return seats.get(id);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", DATE: " + date + ", CINEMA: " + cinemaNum + ", TIME: " + time + ", PREMIERE: "
                + premiere + ", TITLE: " + title + ", HOURS: " + movieLength + ", SEATS: "
                + (seatsNum - movieTicketsNum);
    }

    public void createTicketPaper(String cinemaNum, String movie, String date, String time, String[] chosenSeats,
            String ticketID, double price) {
        ticketPaper = "";
        String temp = "";
        int i;
        ticketPaper += "+--------------------------------------------------+\n";// 51
        temp = "|Cinema " + cinemaNum;
        for (i = 0; i < 41; i++) {
            temp += " ";
        }
        ticketPaper += temp;
        ticketPaper += "\n|" + movie;
        for (i = 0; i < 50 - movie.length(); i++) {
            ticketPaper += " ";
        }
        ticketPaper += "|\n|";
        temp += date.substring(8, 10) + " ";
        temp += date.substring(5, 7).equals("01") ? "January"
                : date.substring(5, 7).equals("02") ? "February"
                        : date.substring(5, 7).equals("03") ? "March"
                                : date.substring(5, 7).equals("04") ? "April"
                                        : date.substring(5, 7).equals("05") ? "May"
                                                : date.substring(5, 7).equals("06") ? "June"
                                                        : date.substring(5, 7).equals("07") ? "July"
                                                                : date.substring(5, 7).equals("08") ? "August"
                                                                        : date.substring(5, 7).equals("09")
                                                                                ? "September"
                                                                                : date.substring(5, 7).equals("10")
                                                                                        ? "October"
                                                                                        : date.substring(5, 7).equals(
                                                                                                "11") ? "November"
                                                                                                        : "December";
        temp += " " + date.substring(0, 4) + " @ ";
        temp += time.substring(0,
                2).equals(
                        "08") ? "8:" + time.substring(3, 5) + " AM"
                                : time.substring(0,
                                        2).equals(
                                                "09") ? "9:" + time.substring(3, 5) + " AM"
                                                        : time.substring(0, 2)
                                                                .equals("10")
                                                                        ? "10:" + time.substring(3, 5) + " AM"
                                                                        : time.substring(0,
                                                                                2).equals(
                                                                                        "11") ? "11:" + time.substring(3, 5) + " AM" : time.substring(0, 2).equals("12") ? "12:" + time.substring(3, 5) + " NN" : time.substring(0, 2).equals("13") ? "1:" + time.substring(3, 5) + " PM" : time.substring(0, 2).equals("14") ? "2:" + time.substring(3, 5) + " PM" : time.substring(0, 2).equals("15") ? "3:" + time.substring(3, 5) + " PM" : time.substring(0, 2).equals("16") ? "4:" + time.substring(3, 5) + " PM" : time.substring(0, 2).equals("17") ? "5:" + time.substring(3, 5) + " PM" : time.substring(0, 2).equals("18") ? "6:" + time.substring(3, 5) + " PM" : time.substring(0, 2).equals("19") ? "7:" + time.substring(3, 5) + " PM" : "8:" + time.substring(3, 5) + " PM";
        ticketPaper += temp;
        for (i = 0; i < 50 - temp.length(); i++) {
            ticketPaper += " ";
        }
        ticketPaper += "|\n|";
        temp = "[";
        int hideOtherSeats = chosenSeats.length;
        if (hideOtherSeats > 9)
            hideOtherSeats = 9;
        for (i = 0; i < hideOtherSeats; i++) {
            temp += chosenSeats[i] + "] ";
            if (i < chosenSeats.length - 1) {
                temp += "[";
            }
        }
        if (chosenSeats.length > 9) {
            temp += "...";
        }
        ticketPaper += temp;
        for (i = 0; i < 50 - temp.length(); i++) {
            ticketPaper += " ";
        }
        ticketPaper += "\n|";
        for (i = 0; i < 50; i++) {
            ticketPaper += " ";
        }
        ticketPaper += "|\n";
        temp = ticketID + "                PHP " + String.valueOf(price);
        ticketPaper += temp;
        for (i = 0; i < 50 - temp.length(); i++) {
            ticketPaper += " ";
        }
        ticketPaper += "|\n+--------------------------------------------------+";
        setTicketPaper(ticketPaper);

    }

    public String getSeatArrangement(ReserveSeat movie) {
        String seatArrangement = String.valueOf(getSeats(movie.id)).replace(",", "").replace("[", "").replace("]", "")
                .replace(" ", "");
        String movieSeats = "";
        movieSeats = "\t +----------------------+\n";
        movieSeats += "\t |\t  SCREEN        |\n";
        movieSeats += "\t +----------------------+\n";
        movieSeats += "\n|      | [" + seatArrangement.substring(0, 2) + "] [" + seatArrangement.substring(2, 4) + "] ["
                + seatArrangement.substring(4, 6) + "] [" + seatArrangement.substring(6, 8) + "] ["
                + seatArrangement.substring(8, 10) + "]";
        movieSeats += "\n|      | [" + seatArrangement.substring(10, 12) + "] [" + seatArrangement.substring(12, 14)
                + "] [" + seatArrangement.substring(14, 16) + "] [" + seatArrangement.substring(16, 18) + "] ["
                + seatArrangement.substring(18, 20) + "]";
        movieSeats += "\n|      | [" + seatArrangement.substring(20, 22) + "] [" + seatArrangement.substring(22, 24)
                + "] [" + seatArrangement.substring(24, 26) + "] [" + seatArrangement.substring(26, 28) + "] ["
                + seatArrangement.substring(28, 30) + "]";
        movieSeats += "\n| EXIT | [" + seatArrangement.substring(30, 32) + "] [" + seatArrangement.substring(32, 34)
                + "] [" + seatArrangement.substring(34, 36) + "] [" + seatArrangement.substring(36, 38) + "] ["
                + seatArrangement.substring(38, 40) + "]";
        movieSeats += "\n|      | [" + seatArrangement.substring(40, 42) + "] [" + seatArrangement.substring(42, 44)
                + "] [" + seatArrangement.substring(44, 46) + "] [" + seatArrangement.substring(46, 48) + "] ["
                + seatArrangement.substring(48, 50) + "]";
        movieSeats += "\n|      | [" + seatArrangement.substring(50, 52) + "] [" + seatArrangement.substring(52, 54)
                + "] [" + seatArrangement.substring(54, 56) + "] [" + seatArrangement.substring(56, 58) + "] ["
                + seatArrangement.substring(58, 60) + "]";
        movieSeats += "\n|      | [" + seatArrangement.substring(60, 62) + "] [" + seatArrangement.substring(62, 64)
                + "] [" + seatArrangement.substring(64, 66) + "] [" + seatArrangement.substring(66, 68) + "] ["
                + seatArrangement.substring(68, 70) + "]";
        movieSeats += "\n|      | [" + seatArrangement.substring(70, 72) + "] [" + seatArrangement.substring(72, 74)
                + "] [" + seatArrangement.substring(74, 76) + "] [" + seatArrangement.substring(76, 78) + "] ["
                + seatArrangement.substring(78, 80) + "]";
        movieSeats += "\n\nLegend: [**] Taken\n";
        return movieSeats;
    }

    public void displayMovies() {
        int i = 0, j = 0, k = 0;
        String[] movie;
        movie = new String[getCSVSize()];
        System.out.println("\n\nHere are our movies:");
        System.out.println("*------------------------------*");
        for (i = 0; i < getCSVSize(); i++) {
            movie[k] = movies[i].getTitle();
            for (j = 0; j <= i; j++) {
                if (movie[k].equals(movie[j]) && k != j) {
                    movie[k] = null;
                    k--;
                    break;
                }
            }
            k++;
        }
        for (i = 0; i < k; i++) {
            System.out.println("[" + (i + 1) + "] " + movie[i]);
        }
        System.out.println("*------------------------------*");
        System.out.print("Choose your movie: ");
        String choice = sc.nextLine();
        while (!choice.matches("-?\\d+(\\.\\d+)?") || Integer.parseInt(choice) > k || Integer.parseInt(choice) < 1) {
            System.out.print("Please choose within the choices: ");
            choice = sc.nextLine();
        }
        chooseSchedule(movie[Integer.parseInt(choice) - 1]);
    }

    public void chooseSchedule(String movie) {
        int i = 0, k = 0, totalNumberOfChosenMovie = 0;
        int[] availableSeats = new int[getCSVSize()];
        String confirm = "N", choice = "";
        ReserveSeat[] schedule;
        System.out.println("\nGreat! Here are our schedules for the " + movie + " movie");
        for (i = 0; i < getCSVSize(); i++) {
            if (movies[i].getTitle().equals(movie)) {
                totalNumberOfChosenMovie++;
            }
        }
        schedule = new ReserveSeat[totalNumberOfChosenMovie];
        for (i = 0; i < getCSVSize(); i++) {
            if (movies[i].getTitle().equals(movie)) {
                setSeats(movies[i]);
                availableSeats[i] = movies[i].getSeatsNum();
                schedule[k++] = movies[i];
            }
        }
        while (confirm.equals("N")) {
            System.out.println("------------------------------------------------------------------------------------");
            for (i = 0; i < k; i++) {
                System.out.println("[" + (i + 1) + "] Cinema: " + schedule[i].getCinemaNum() + ", Date: "
                        + schedule[i].getDate() + ", Time: " + schedule[i].getTime() + ", Movie Length: "
                        + schedule[i].getMovieLength() + ", Seats: " + schedule[i].getSeatsNum());
            }
            System.out.print(
                    "------------------------------------------------------------------------------------\nChoose your schedule: ");

            choice = sc.nextLine();
            while (!choice.matches("back") && !choice.matches("-?\\d+(\\.\\d+)?")
                    || !choice.matches("back") && Integer.parseInt(choice) > k
                    || !choice.matches("back") && Integer.parseInt(choice) < 1) {
                System.out.print("Please choose within the choices: ");
                choice = sc.nextLine();
            }
            if (choice.matches("back")) { // reruns the method
                displayMovies();
            }
            System.out.print("Your choice:\n" + choice + "\nConfirm? [Y/N] ");
            confirm = sc.nextLine();
            while (!confirm.equals("Y") && !confirm.equals("N") || confirm.equals("Y") && confirm.equals("N")) {
                System.out.print("Please choose between 'Y' or 'N': ");
                confirm = sc.next() + sc.nextLine();
            }
        }
        System.out.println("\nAwesome! Now choose your seats for the "
                + schedule[Integer.parseInt(choice) - 1].getTitle() + " movie!");
        chooseSeats(schedule[Integer.parseInt(choice) - 1], availableSeats[Integer.parseInt(choice) - 1]);
    }

    public void chooseSeats(ReserveSeat movie, int availableSeats) {
        String[] chosenSeats;
        String confirm = "N";
        String ticketSeats = "";
        int instanceChecker = 0, i, j;
        // setSeats(movie);
        while (confirm.equals("N")) {
            System.out.print("\nCinema: " + movie.getCinemaNum() + ", Date: " + movie.getDate() + ", Time: "
                    + movie.getTime() + ", Movie Length: " + movie.getMovieLength()
                    + "\nHow many seats will you take [1-" + availableSeats + "]? ");
            String choice = sc.nextLine();
            while (!choice.matches("-?\\d+(\\.\\d+)?") && !choice.matches("back")
                    || !choice.matches("back") && Integer.parseInt(choice) > availableSeats
                    || !choice.matches("back") && Integer.parseInt(choice) < 1) {
                System.out.print("Please choose from 1 to " + availableSeats + ": ");
                choice = sc.nextLine();
            }
            if (choice.matches("back")) { // reruns the method
                continue;
            }
            System.out.println(getSeatArrangement(movie));
            System.out.println("Please choose " + choice + " seat(s): ");
            chosenSeats = new String[Integer.parseInt(choice)];
            ticketSeats = "";
            for (i = 0; i < Integer.parseInt(choice); i++) {
                System.out.print("[" + (i + 1) + "] ");
                String choice2 = sc.nextLine();
                while (!choice2.matches("back") && !Arrays.asList(seatSample).contains(choice2)) {
                    System.out.print("Please choose within the choices:\n[" + (i + 1) + "] ");
                    choice2 = sc.nextLine();
                }
                if (choice2.matches("back")) { // reruns the method
                    chooseSeats(movie, availableSeats);
                }
                do { // Repeated input seats checker
                    instanceChecker = 0;
                    for (j = 0; j <= i; j++) {
                        if (choice2.equals(chosenSeats[j])) {
                            System.out.print("Please choose another seat:\n[" + (i + 1) + "] ");
                            choice2 = sc.nextLine();
                            while (!choice2.matches("back") && !Arrays.asList(seatSample).contains(choice2)) {
                                System.out.print("Please choose within the seats:\n[" + (i + 1) + "] ");
                                choice2 = sc.nextLine();
                            }
                            if (choice2.matches("back")) { // reruns the method
                                chooseSeats(movie, availableSeats);
                            }
                            instanceChecker = 1;
                        }
                    }
                } while (instanceChecker == 1);
                do { // Taken input seats checker
                    instanceChecker = 0;
                    for (j = 0; j < 40; j++) {
                        if (choice2.equals(seatSample[j]) && seats.get(movie.getID()).get(j).equals("**")) {
                            System.out.print("Please choose another seat:\n[" + (i + 1) + "] ");
                            choice2 = sc.nextLine();
                            while (!choice2.matches("back") && !Arrays.asList(seatSample).contains(choice2)) {
                                System.out.print("Please choose within the seats:\n[" + (i + 1) + "] ");
                                choice2 = sc.nextLine();
                            }
                            if (choice2.matches("back")) { // reruns the method
                                chooseSeats(movie, availableSeats);
                            }
                            instanceChecker = 1;
                        }
                    }
                } while (instanceChecker == 1);
                chosenSeats[i] = choice2;
                ticketSeats += choice2;
                if (i < Integer.parseInt(choice) - 1) {
                    ticketSeats += ", ";
                }
            }
            System.out.print("\nYour chosen seats:\n" + ticketSeats + "\nConfirm? [Y/N] ");
            confirm = sc.nextLine();
            while (!confirm.equals("Y") && !confirm.equals("N") || confirm.equals("Y") && confirm.equals("N")) {
                System.out.print("Please choose between 'Y' or 'N': ");
                confirm = sc.next() + sc.nextLine();
            }
            if (confirm.equals("Y")) {
                // System.out.println(movie.getID()+String.valueOf(getTickets())+"
                // "+movie.getTitle()+" "+movie.getDate()+" "+movie.getCinemaNum()+"
                // "+movie.getTime()+" "+ticketSeats+" "+movie.getPremiere());
                Checkout checkout = new Checkout(movie.getID() + String.valueOf(getTickets()), movie.getTitle(),
                        movie.getDate(), movie.getCinemaNum(), movie.getTime(), ticketSeats, movie.getPremiere());
                checkout.generatePrice();
            }
        }
        System.out.println("Would you like to do reserve another movie? [Y/N] ");
        confirm = sc.nextLine();
        while (!confirm.equals("Y") && !confirm.equals("N") || confirm.equals("Y") && confirm.equals("N")) {
            System.out.print("Please choose between 'Y' or 'N': ");
            confirm = sc.next() + sc.nextLine();
        }
        if (confirm.equals("Y")) {
            displayMovies();
        } else {
            Menu menu = new Menu();
            menu.startMenu();
        }
    }
}
