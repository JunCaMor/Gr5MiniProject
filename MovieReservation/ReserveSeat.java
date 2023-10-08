import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ReserveSeat {
    private String id = "";
    private String date;
    private String cinemaNum;
    private String time;
    private String premiere;
    private String movie;
    private String movieLength;
    private String ticketRefNum;
    private String ticketPaper;
    private int CSVSize;
    private String[] seatSample = { "A1", "A2", "A3", "A4", "A5", "B1", "B2", "B3", "B4", "B5",
            "C1", "C2", "C3", "C4", "C5", "D1", "D2", "D3", "D4", "D5",
            "E1", "E2", "E3", "E4", "E5", "F1", "F2", "F3", "F4", "F5",
            "G1", "G2", "G3", "G4", "G5", "H1", "H2", "H3", "H4", "H5" };
    private int availableSeatsNum;
    private HashMap<String, List<String>> seats = new HashMap<>();
    private HashMap<String, List<String>> reserve = new HashMap<>();
    private List<String> tickets = new ArrayList<>();
    private ReserveSeat[] movies;
    private Scanner sc = new Scanner(System.in);

    // private Checkout checkout;
    public ReserveSeat(String date, String cinemaNum, String time, String premiere, String movie, String movieLength) {
        this.date = date;
        this.cinemaNum = cinemaNum;
        this.time = time;
        this.premiere = premiere;
        this.movie = movie;
        this.movieLength = movieLength;
        this.availableSeatsNum = 50;
        int movieKeyCharLimit = 0;
        // For automatically generating an id for each movie.
        id = String.valueOf(movie.charAt(0)); // Gets first letter of movie.
        for (int i = 1; i < movie.length(); i++) { // Getting two more key sub-values.
            if (movie.charAt(i - 1) == ' ') {
                id += String.valueOf(movie.charAt(i));
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

    public void setShowing(String premiere) {
        this.premiere = premiere;
    }

    public String getShowing() {
        return premiere;
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

    public void setCSVSize(int size) {
        this.CSVSize = size;
    }

    public int getCSVSize() {
        return CSVSize;
    }

    public void setSeats(ReserveSeat display, String[] assign) {
        seats.put(display.id, List.of(assign));
    }

    public List<String> getSeats(ReserveSeat display) {
        return seats.get(display.id);
    }

    public String[] getSeatsAsString(ReserveSeat display) {
        String[] movieSeats = new String[40];
        for (int i = 0; i < movieSeats.length; i++) {
            movieSeats[i] = String.valueOf(seats.get(display.id).get(i));
        }
        return movieSeats;
    }

    public int getAvailableSeatsNum() {
        return availableSeatsNum;
    }

    public void setAvailableSeatsNum(int availableSeatsNum) {
        this.availableSeatsNum = availableSeatsNum;
    }

    public void setTicketRefNum(String ticket) {
        int refNum = (int) Math.random() * 2;
        this.ticketRefNum = ticket + String.valueOf(refNum);
    }

    public String getTicketRefNum() {
        return ticketRefNum;
    }

    public String getSeatArrangement(ReserveSeat display) {
        String seatArrangement = String.valueOf(seats.get(display.id)).replace(",", "").replace("[", "")
                .replace("]", "").replace(" ", "");
        String movieSeats = "";
        movieSeats = "\t +----------------------+\n";
        movieSeats += "\t |\t  SCREEN        |\n";
        movieSeats += "\t +----------------------+\n\n";
        movieSeats += "|      | [" + seatArrangement.substring(0, 2) + "] [" + seatArrangement.substring(2, 4) + "] ["
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
        movieSeats += "\n\nLegend: [**] Taken, [!!] Reserved\n";
        return movieSeats;
    }

    public void selectSeats(ReserveSeat display, String[] chosenSeats) {
        int availableSeats = getAvailableSeatsNum();
        String[] sampleSeats = seatSample;
        for (int i = 0; i < chosenSeats.length; i++) {
            for (int j = 0; j < 40; j++) {
                if (chosenSeats[i].equals(sampleSeats[j])) {
                    sampleSeats[j] = "**";
                    availableSeats--;
                }
            }
        }
        setSeats(display, sampleSeats);
        setAvailableSeatsNum(availableSeats);
    }

    public void removeSeats(ReserveSeat display, String movieSeats) {
        String[] sampleSeats = seatSample;
        String[] newSeats = { "A1", "A2", "A3", "A4", "A5", "B1", "B2", "B3", "B4", "B5",
                "C1", "C2", "C3", "C4", "C5", "D1", "D2", "D3", "D4", "D5",
                "E1", "E2", "E3", "E4", "E5", "F1", "F2", "F3", "F4", "F5",
                "G1", "G2", "G3", "G4", "G5", "H1", "H2", "H3", "H4", "H5" };
        int seatAmount = 1, start = 0, end = 2, i, j;
        for (i = 0; i < movieSeats.length(); i++) {
            if (movieSeats.charAt(i) == ' ') {
                seatAmount++;
            }
        }
        for (i = 0; i < seatAmount; i++) {
            for (j = 0; j < newSeats.length; j++) {
                // System.out.print(sampleSeats[j]);
                // System.out.println(movieSeats.substring(start,end));
                if (newSeats[j].equals(movieSeats.substring(start, end))) {
                    sampleSeats[j] = movieSeats.substring(start, end);
                }
            }
            start += 4;
            end += 4;
        }
        seats.put(display.id, List.of(sampleSeats));
    }

    @Override
    public String toString() {
        return "ID: " + id + ", DATE: " + date + ", CINEMA: " + cinemaNum + ", TIME: " + time + ", PREMIERE: "
                + premiere + ", TITLE: " + movie + ", HOURS: " + movieLength + ", SEATS: " + availableSeatsNum;
    }

    public void displayMovies() {
        int i = 0, j = 0, k = 0;
        String[] display;
        display = new String[getCSVSize()];
        System.out.println("Welcome to Cinema World!\n\nHere are our movies:");
        System.out.println("*------------------------------*");
        for (i = 0; i < getCSVSize(); i++) {
            display[k] = movies[i].getMovie();
            for (j = 0; j <= i; j++) {
                if (display[k].equals(display[j]) && k != j) {
                    display[k] = null;
                    k--;
                    break;
                }
            }
            k++;
        }
        for (i = 0; i < k; i++) {
            System.out.println("[" + (i + 1) + "] " + display[i]);
        }
        System.out.println("*------------------------------*");
        System.out.print("Choose your movie: ");
        String choice = sc.nextLine();
        while (Integer.parseInt(choice) > k || Integer.parseInt(choice) < 1 || !choice.matches("-?\\d+(\\.\\d+)?")) {
            System.out.print("Please choose within the choices: ");
            choice = sc.nextLine();
        }
        chooseSchedule(display[Integer.parseInt(choice) - 1]);
    }

    public void createTicketPaper(String cinemaNum, String movie, String date, String time, String[] chosenSeats,
            String ticketID, double price) {
        ticketPaper = "";
        String temp = "";
        int i;
        ticketPaper += "+--------------------------------------------------+";// 51
        ticketPaper += "\n|Cinema " + cinemaNum + "\t\t\t\t\t  |";
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
        ticketPaper += "|\n|\t\t\t\t\t\t  |\n|";
        temp = ticketID + "                PHP " + String.valueOf(price);
        ticketPaper += temp;
        for (i = 0; i < 50 - temp.length(); i++) {
            ticketPaper += " ";
        }
        ticketPaper += "|\n+--------------------------------------------------+";
        setTicketPaper(ticketPaper);

    }

    public void setTicketPaper(String ticketPaper) {
        this.ticketPaper = ticketPaper;
    }

    public String getTicketPaper() {
        return ticketPaper;
    }

    public void chooseSchedule(String movie) {
        int i = 0, k = 0, totalNumberOfScreens = 0;
        ReserveSeat[] display;
        System.out.println("\nGreat! Here are our schedules for the " + movie + " movie");
        for (i = 0; i < getCSVSize(); i++) {
            if (movies[i].getMovie().equals(movie)) {
                totalNumberOfScreens++;
            }
        }
        display = new ReserveSeat[totalNumberOfScreens];
        for (i = 0; i < getCSVSize(); i++) {
            if (movies[i].getMovie().equals(movie)) {
                display[k++] = movies[i];
            }
        }
        System.out.println("------------------------------------------------------------------------------------");
        for (i = 0; i < k; i++) {
            System.out.println("[" + (i + 1) + "] Cinema: " + display[i].getCinemaNum() + ", Date: "
                    + display[i].getDate() + ", Time: " + display[i].getTime() + ", Movie Length: "
                    + display[i].getMovieLength() + ", Seats: " + display[i].getAvailableSeatsNum());
        }
        System.out.print(
                "------------------------------------------------------------------------------------\nChoose your schedule: ");

        String choice = sc.nextLine();
        while (Integer.parseInt(choice) > k || Integer.parseInt(choice) < 1 || !choice.matches("-?\\d+(\\.\\d+)?")) {
            System.out.print("Please choose within the choices: ");
            choice = sc.nextLine();
        }
        chooseSeats(display[Integer.parseInt(choice) - 1]);
    }

    public void chooseSeats(ReserveSeat display) {
        String ticketSeats = "";
        int instanceChecker;
        String[] chosenSeats;
        String confirm = "N";
        setSeats(display, seatSample);
        System.out.println("\nAwesome! Now choose your seats for the " + display.getMovie() + " movie");
        System.out.print("How many seats will you take [1-40]? ");
        String choice = sc.nextLine();
        while (Integer.parseInt(choice) > 40 || Integer.parseInt(choice) < 1 || !choice.matches("-?\\d+(\\.\\d+)?")) {
            System.out.print("Please choose within the choices: ");
            choice = sc.nextLine();
        }
        System.out.println(getSeatArrangement(display));
        System.out.println("Please choose " + choice + " seat(s): ");
        chosenSeats = new String[Integer.parseInt(choice)];
        while (confirm.equals("N")) {
            for (int i = 0; i < Integer.parseInt(choice); i++) {
                System.out.print("[" + (i + 1) + "] ");
                String choice2 = sc.nextLine();
                while (!Arrays.asList(seatSample).contains(choice2)) {
                    System.out.print("Please choose within the choices:\n[" + (i + 1) + "] ");
                    choice2 = sc.nextLine();
                }
                do { // Repeated input seats checker
                    instanceChecker = 0;
                    for (int j = 0; j < i; j++) {
                        if (choice2.equals(chosenSeats[j])) {
                            System.out.print("Please choose another seat:\n[" + (i + 1) + "] ");
                            choice2 = sc.nextLine();
                            while (!Arrays.asList(seatSample).contains(choice2)) {
                                System.out.print("Please choose within the seats:\n[" + (i + 1) + "] ");
                                choice2 = sc.nextLine();
                            }
                            instanceChecker = 1;
                        }
                    }
                } while (instanceChecker == 1);
                do { // Taken input seats checker
                    String[] seatChecker = new String[40];
                    instanceChecker = 0;
                    for (int j = 0; j < i; j++) {
                        seatChecker[j] = seatSample[j] + getSeatsAsString(display)[j];
                        if (choice2.equals(seatChecker[j].substring(0, 2))
                                && seatChecker[j].substring(2, 4).equals("**")
                                || choice2.equals(seatChecker[j].substring(0, 2))
                                        && seatChecker[j].substring(2, 4).equals("!!")) {
                            System.out.print("Please choose another seat:\n[" + (i + 1) + "] ");
                            choice2 = sc.nextLine();
                            while (!Arrays.asList(seatSample).contains(choice2)) {
                                System.out.print("Please choose within the seats:\n[" + (i + 1) + "] ");
                                choice2 = sc.nextLine();
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
            System.out.println("\nYour chosen seats:\n" + ticketSeats);
            System.out.print("Confirm? [Y/N] ");
            confirm = sc.nextLine();
            while (!confirm.equals("Y") && !confirm.equals("N") || confirm.equals("Y") && confirm.equals("N")) {
                System.out.print("Please choose between 'Y' or 'N': ");
                confirm = sc.next() + sc.nextLine();
            }
            if (confirm.equals("Y")) {
                // System.out.println(getSeatArrangement());
                selectSeats(display, chosenSeats);
            }
        }
        // getSeatArrangement(display);
        System.out.println(getSeatArrangement(display));
        setTicketRefNum(display.id);
        checkout(display, ticketSeats, chosenSeats);
    }

    public void checkout(ReserveSeat display, String ticketSeats, String[] chosenSeats) {
        String confirm = "N";
        double price = 0;
        while (confirm.equals("N") && display.getShowing().equals("false")) {
            price = 0;
            for (String chosenSeat : chosenSeats) {
                System.out.print("Is the person at seat " + chosenSeat + " a senior citizen? [Y/N] ");
                confirm = sc.next() + sc.nextLine();
                while (!confirm.equals("Y") && !confirm.equals("N") || confirm.equals("Y") && confirm.equals("N")) {
                    System.out.print("Please choose between 'Y' or 'N': ");
                    confirm = sc.next() + sc.nextLine();
                }
                if (confirm.equals("Y")) {
                    price += 280;
                } else {
                    price += 350;
                }
            }
            System.out.print("Your total price is: PHP" + price + "\nConfirm? [Y/N] ");
            confirm = sc.nextLine();
            while (!confirm.equals("Y") && !confirm.equals("N") || confirm.equals("Y") && confirm.equals("N")) {
                System.out.print("Please choose between 'Y' or 'N': ");
                confirm = sc.next() + sc.nextLine();
            }
        }
        if (display.getShowing().equals("true")) {
            for (String chosenSeat : chosenSeats) {
                price += 500;
            }
        }
        createTicketPaper(display.getCinemaNum(), display.getMovie(), display.getDate(), display.getTime(), chosenSeats,
                getTicketRefNum(), price);
        reserve.put(getTicketRefNum(), List.of(getTicketRefNum(), display.getDate(), display.getCinemaNum(),
                display.getTime(), ticketSeats, String.valueOf(price)));
        tickets.add(getTicketRefNum());
        System.out.println(getTicketPaper());
        System.out.println("\nEnjoy your movie!");
        cancelReservation();
    }

    public void cancelReservation() {
        int i, j;
        String confirm = "N", choice;
        do {
            System.out.println("Which ticket would you like to cancel?");
            for (i = 0; i < tickets.size(); i++) {
                System.out.println("[" + (i + 1) + "]" + reserve.get(tickets.get(i)));
            }
            System.out.print("Choice: ");
            choice = sc.next() + sc.nextLine();
            while (Integer.parseInt(choice) > tickets.size() || Integer.parseInt(choice) < 1
                    || !choice.matches("-?\\d+(\\.\\d+)?")) {
                System.out.print("Please choose within the tickets: ");
                choice = sc.next() + sc.nextLine();
            }
            System.out.print("Your choice:\n" + choice + "\nConfirm? [Y/N] ");
            confirm = sc.nextLine();
            while (!confirm.equals("Y") && !confirm.equals("N") || confirm.equals("Y") && confirm.equals("N")) {
                System.out.print("Please choose between 'Y' or 'N': ");
                confirm = sc.next() + sc.nextLine();
            }
            if (confirm.equals("Y")) {
                for (j = 0; j < movies.length; j++) {
                    if (movies[j].getID().contains(
                            String.valueOf(reserve.get(tickets.get(Integer.parseInt(choice) - 1))).substring(1, 13))) {
                        removeSeats(movies[j], reserve.get(tickets.get(Integer.parseInt(choice) - 1)).get(4));
                        System.out.println(
                                "\nTicket " + String.valueOf(reserve.get(tickets.get(Integer.parseInt(choice) - 1)))
                                        .substring(1, 14) + " deleted");
                        tickets.remove(tickets.get(Integer.parseInt(choice) - 1));
                        System.out.println(getSeatArrangement(movies[j]));
                    }
                }
            }
        } while (confirm.equals("N"));
    }
}