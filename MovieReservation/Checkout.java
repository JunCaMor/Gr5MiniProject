import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Checkout {
    private String ticketID;
    private String title;
    private String date;
    private String cinemaNum;
    private String time;
    private String seats;
    private String premiere;
    private String ticketPaper;
    private double price;
    Scanner sc = new Scanner(System.in);

    public Checkout(String ticketID, String title, String date, String cinemaNum, String time, String seats,
            String premiere) {
        this.ticketID = ticketID;
        this.title = title;
        this.date = date;
        this.cinemaNum = cinemaNum;
        this.time = time;
        this.seats = seats;
        this.premiere = premiere;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
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

    public void setSeats(String[] seatsTaken) {
        String seats = "";
        for (String seatTaken : seatsTaken) {
            seats += seatTaken;
        }
        this.seats = seats;
    }

    public String getSeats() {
        return seats;
    }

    public void setPremiere(String premiere) {
        this.premiere = premiere;
    }

    public String getPremiere() {
        return premiere;
    }

    public void setTicketPaper(String ticketPaper) {
        this.ticketPaper = ticketPaper;
    }

    public String getTicketPaper() {
        return ticketPaper;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void createTicketPaper(String cinemaNum, String movie, String date, String time, String[] chosenSeats,
            String ticketID, double price) {
        ticketPaper = "";
        String temp = "";
        int i;
        ticketPaper += "+--------------------------------------------------+\n";// 51
        temp = "|Cinema " + cinemaNum;
        for (i = 0; i < 42; i++) {
            temp += " ";
        }
        ticketPaper += temp;
        ticketPaper += "|\n|" + movie;
        for (i = 0; i < 50 - movie.length(); i++) {
            ticketPaper += " ";
        }
        ticketPaper += "|\n|";
        temp = "";
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
        ticketPaper += "|\n|";
        for (i = 0; i < 50; i++) {
            ticketPaper += " ";
        }
        ticketPaper += "|\n|";
        temp = ticketID + "                PHP " + String.valueOf(price);
        ticketPaper += temp;
        for (i = 0; i < 50 - temp.length(); i++) {
            ticketPaper += " ";
        }
        ticketPaper += "|\n+--------------------------------------------------+";
        setTicketPaper(ticketPaper);

    }

    public void generatePrice() {
        int i = 0, j = 0, seatAmount = 1, start = 0, end = 2;
        double total = 0;
        String[] seatsTaken;
        for (i = 0; i < getSeats().length(); i++) {
            if (getSeats().charAt(i) == ' ') {
                seatAmount++;
            }
        }
        seatsTaken = new String[seatAmount];
        seatAmount = 1;
        seatsTaken[0] = getSeats().substring(start, end);
        for (i = 0; i < getSeats().length(); i++) {
            if (getSeats().charAt(i) == ' ') {
                start += 4;
                end += 4;
                seatsTaken[seatAmount++] = getSeats().substring(start, end);
            }
        }
        if (getPremiere().equals("true")) {
            for (i = 0; i < seatAmount; i++) {
                total += 500;
            }
        } else {
            String confirm = "N";
            while (confirm.equals("N")) {
                System.out.print(
                        "*--------------------------------------------*\nHow many are senior citizens or PWDs? [0-"
                                + seatAmount + "] ");
                String choice = sc.nextLine();
                while (!choice.matches("-?\\d+(\\.\\d+)?") || Integer.parseInt(choice) > seatAmount
                        || Integer.parseInt(choice) < 0) {
                    System.out.print("Please choose within 0 to " + seatAmount + ": ");
                    choice = sc.next() + sc.nextLine();
                }
                System.out.print("Your choice:\n" + choice + "\nConfirm? [Y/N] ");
                confirm = sc.nextLine();
                while (!confirm.equals("Y") && !confirm.equals("N") || confirm.equals("Y") && confirm.equals("N")) {
                    System.out.print("Please choose between 'Y' or 'N': ");
                    confirm = sc.next() + sc.nextLine();
                }
                if (confirm.equals("Y")) {
                    // int x; // This is for trapping the excess input bug
                    for (i = 0; i < Integer.parseInt(choice); i++) {
                        total += 280;
                    }
                    for (j = 0; j < seatAmount - Integer.parseInt(choice); j++) {
                        total += 350;
                    }
                }
            }
        }
        price = total;
        createTicketPaper(cinemaNum, title, date, time, seatsTaken, ticketID, total);
        System.out.println(getTicketPaper() + "\n\n*Enjoy your movie!*\n\n*----------------------------------*\n");
        reserveTicket(ticketID, date, cinemaNum, time, seats, String.valueOf(getPrice()));
    }

    public void reserveTicket(String ticketID, String date, String cinemaNum, String time, String seats, String price) {
        String ticket = "\"" + ticketID + "\",\"" + date + "\",\"" + cinemaNum + "\",\"" + time + "\",\"" + seats
                + "\",\"" + price + "\"\n";
        try {
            BufferedWriter write = new BufferedWriter(new FileWriter(
                    "Reservations.csv",
                    true));
            write.write(ticket);
            write.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error while processing the file: " + e.getMessage());
        }
    }
}