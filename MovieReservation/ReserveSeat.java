import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ReserveSeat {
    private String id="";
    private String date;
    private String cinemaNum;
    private String time;
    private String showing;
    private String movie;
    private String movieLength;
    private int CSVSize;
    private String[] seatSample={"A1","A2","A3","A4","A5","B1","B2","B3","B4","B5",
                "C1","C2","C3","C4","C5","D1","D2","D3","D4","D5",
                "E1","E2","E3","E4","E5","F1","F2","F3","F4","F5",
                "G1","G2","G3","G4","G5","H1","H2","H3","H4","H5"};
    private HashMap<String,List<String>> seats=new HashMap<>();
    private HashMap<String,List<String>> ticket=new HashMap<>();
    private List<String> assign=new ArrayList<String>();
    private ReserveSeat[] movies;
    private Scanner sc=new Scanner(System.in);
    //private Checkout checkout;
    public ReserveSeat(String date, String cinemaNum, String time, String showing, String movie, String movieLength){
        this.date=date;
        this.cinemaNum=cinemaNum;
        this.time=time;
        this.showing=showing;
        this.movie=movie;
        this.movieLength=movieLength;
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
        id+=date.replaceFirst("20","").replace("-","");
        id+=time.substring(0, 2);
        id+=cinemaNum;
        // Key generator ends here
        seats.put(id, List.of("A1","A2","A3","A4","A5","B1","B2","B3","B4","B5",
                "C1","C2","C3","C4","C5","D1","D2","D3","D4","D5",
                "E1","E2","E3","E4","E5","F1","F2","F3","F4","F5",
                "G1","G2","G3","G4","G5","H1","H2","H3","H4","H5"));
        //System.out.println(seats.get(id));
        
        
    }
//    {{"A1","A2","A3","A4","A5"},{"B1","B2","B3","B4","B5"},{"C1","C2","C3","C4","C5"},{"D1","D2","D3","D4","D5"},
//                        {"E1","E2","E3","E4","E5"},{"F1","F2","F3","F4","F5"},{"G1","G2","G3","G4","G5"},{"H1","H2","H3","H4","H5"}}
    public ReserveSeat(int size){
        movies=new ReserveSeat[size];
        setCSVSize(size);
    }
    public void copyMovies(ReserveSeat[] copy){
        System.arraycopy(copy,0,movies,0,copy.length);
    }
    public String getID(){
        return id;
    }
    public List<String> getSeats(){
        return seats.get(id);
    }
    public void setSeats(ReserveSeat display, String[] assign){
        seats.put(display.id, List.of(assign));
        //System.out.println(seats.get(display.id));
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
    public String getSeatArrangement(){
        String seatArrangement=String.valueOf(seats.get(id)).replace(",","").replace("[","").replace("]","").replace(" ","");
        String movieSeats="";
        movieSeats="\t +----------------------+\n";
        movieSeats+="\t |\t  SCREEN        |\n";
        movieSeats+="\t +----------------------+\n\n";
        movieSeats+="|      | ["+seatArrangement.substring(0,2)+"] ["+seatArrangement.substring(2,4)+"] ["+seatArrangement.substring(4,6)+"] ["+seatArrangement.substring(6,8)+"] ["+seatArrangement.substring(8,10)+"]";
        movieSeats+="\n|      | ["+seatArrangement.substring(10,12)+"] ["+seatArrangement.substring(12,14)+"] ["+seatArrangement.substring(14,16)+"] ["+seatArrangement.substring(16,18)+"] ["+seatArrangement.substring(18,20)+"]";
        movieSeats+="\n|      | ["+seatArrangement.substring(20,22)+"] ["+seatArrangement.substring(22,24)+"] ["+seatArrangement.substring(24,26)+"] ["+seatArrangement.substring(26,28)+"] ["+seatArrangement.substring(28,30)+"]";
        movieSeats+="\n| EXIT | ["+seatArrangement.substring(30,32)+"] ["+seatArrangement.substring(32,34)+"] ["+seatArrangement.substring(34,36)+"] ["+seatArrangement.substring(36,38)+"] ["+seatArrangement.substring(38,40)+"]";
        movieSeats+="\n|      | ["+seatArrangement.substring(40,42)+"] ["+seatArrangement.substring(42,44)+"] ["+seatArrangement.substring(44,46)+"] ["+seatArrangement.substring(46,48)+"] ["+seatArrangement.substring(48,50)+"]";
        movieSeats+="\n|      | ["+seatArrangement.substring(50,52)+"] ["+seatArrangement.substring(52,54)+"] ["+seatArrangement.substring(54,56)+"] ["+seatArrangement.substring(56,58)+"] ["+seatArrangement.substring(58,60)+"]";
        movieSeats+="\n|      | ["+seatArrangement.substring(60,62)+"] ["+seatArrangement.substring(62,64)+"] ["+seatArrangement.substring(64,66)+"] ["+seatArrangement.substring(66,68)+"] ["+seatArrangement.substring(68,70)+"]";
        movieSeats+="\n|      | ["+seatArrangement.substring(70,72)+"] ["+seatArrangement.substring(72,74)+"] ["+seatArrangement.substring(74,76)+"] ["+seatArrangement.substring(76,78)+"] ["+seatArrangement.substring(78,80)+"]";
        return movieSeats;
    }
    public void chooseSeat(ReserveSeat display, String[] chosenSeats){
        int index;
        String[] seats={"A1","A2","A3","A4","A5","B1","B2","B3","B4","B5",
                "C1","C2","C3","C4","C5","D1","D2","D3","D4","D5",
                "E1","E2","E3","E4","E5","F1","F2","F3","F4","F5",
                "G1","G2","G3","G4","G5","H1","H2","H3","H4","H5"};
        List<String> seat=display.getSeats();
        for(int i=0; i<chosenSeats.length; i++){
            for(int j=0; j<40; j++){
                if(chosenSeats[i].equals(seats[j])){
                    seats[j]="XX";
                }
            }
        }
        setSeats(display,seats);
    }
    public int getAvailableSeatAmount(){
        int availableSeats=0;
        char taken='*', reserved='X';
        for(int i=0; i<getSeatArrangement().length();i++){
            if(getSeatArrangement().charAt(i)==taken||getSeatArrangement().charAt(i)==reserved){
                availableSeats++;
            }
        }
        return 50-availableSeats/2;
    }
    @Override
    public String toString(){
        return "ID: "+id+", DATE: "+date+", CINEMA: "+cinemaNum+", TIME: "+time+", SHOWING: "+showing+", TITLE: "+movie+", HOURS: "+movieLength+", SEATS: "+getAvailableSeatAmount();
    }
    public void displayMovies(){
        int i=0, j=0, k=0, findPair=0;
        String[] display;
        display = new String[getCSVSize()];
        System.out.println("Welcome to Cinema World!\n\nHere are our movies:");
        System.out.println("*------------------------------*");
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
        System.out.println("*------------------------------*");
        System.out.print("Choose your movie: ");
        String choice=sc.nextLine();
        while(Integer.parseInt(choice)>k||Integer.parseInt(choice)<1||!choice.matches("-?\\d+(\\.\\d+)?")){
            System.out.print("Please choose within the choices: ");
            choice=sc.nextLine();
        }
        chooseSchedule(display[Integer.parseInt(choice)-1]);
    }
    public void chooseSchedule(String movie){
        int i=0, k=0, totalNumberOfScreens=0;
        ReserveSeat[] display;
        System.out.println("\nGreat! Here are our schedules for the "+movie+" movie");
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
        System.out.println("----------------------------------------------------------------");
        for(i=0;i<k;i++){
            System.out.println("["+(i+1)+"] Cinema: "+display[i].getCinemaNum()+", Date: "+display[i].getDate()+", Time: "+display[i].getTime()+", Movie Length: "+display[i].getMovieLength());
        }
        System.out.print("----------------------------------------------------------------\nChoose your schedule: ");
        
        String choice=sc.nextLine();
        while(Integer.parseInt(choice)>k||Integer.parseInt(choice)<1||!choice.matches("-?\\d+(\\.\\d+)?")){
            System.out.print("Please choose within the choices: ");
            choice=sc.nextLine();
        }
        chooseSeats(display[Integer.parseInt(choice)-1]);
    }
    public void chooseSeats(ReserveSeat display){
        int instanceChecker=0;
        String[] chosenSeats;
        String confirm="N";
        System.out.println("\nAwesome! Now choose your seats for the "+display.getMovie()+" movie");
        System.out.print("How many seats will you take [1-40]? ");
        String choice=sc.nextLine();
        while(Integer.parseInt(choice)>40||Integer.parseInt(choice)<1||!choice.matches("-?\\d+(\\.\\d+)?")){
            System.out.print("Please choose within the choices: ");
            choice=sc.nextLine();
        }
        System.out.println(display.getSeatArrangement());
        System.out.println("Please choose "+Integer.parseInt(choice)+" seats: ");
        chosenSeats=new String[Integer.parseInt(choice)];
        while(confirm.equals("N")){
            String seats="";
            for(int i=0; i<Integer.parseInt(choice); i++){
                System.out.print("["+(i+1)+"] ");
                String choice2=sc.nextLine();
                while(!Arrays.asList(seatSample).contains(choice2)){
                    System.out.print("Please choose within the choices:\n["+(i+1)+"] ");
                    choice2=sc.nextLine();
                }
                do{ //Repeated input seats checker
                    instanceChecker=0;
                    for(int j=0; j<i; j++){
                        if(choice2.equals(chosenSeats[j])){
                            System.out.print("Please choose another seat:\n["+(i+1)+"] ");
                            choice2=sc.nextLine();
                            while(!Arrays.asList(seatSample).contains(choice2)){
                                System.out.print("Please choose within the seats:\n["+(i+1)+"] ");
                                choice2=sc.nextLine();
                            }
                            instanceChecker=1;
                        }
                    }
                }while(instanceChecker==1);
                chosenSeats[i]=choice2;
                seats+=choice2;
                if(i<Integer.parseInt(choice)-1){
                    seats+=", ";
                }
            }
            System.out.println(seats);
            System.out.print("Confirm? [Y/N] ");
            confirm=sc.nextLine();
            while(!confirm.equals("Y")&&!confirm.equals("N")||confirm.equals("Y")&&confirm.equals("N")){
                System.out.print("Please choose between 'Y' or 'N': ");
                confirm=sc.next()+sc.nextLine();
            }
            if(confirm.equals("Y")){
                //System.out.println(getSeatArrangement());
                chooseSeat(display,chosenSeats);
            }
        }
        display.getSeatArrangement();
    }
}