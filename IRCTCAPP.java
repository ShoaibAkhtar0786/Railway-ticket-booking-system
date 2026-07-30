
import java.util.List;
import java.util.Scanner;

public class IRCTCAPP {

    private final Scanner scanner = new Scanner(System.in);

    private final UserService userservice = new UserService();

    private final BookingService bookingservice = new BookingService();

    static void main(String[] args) {
        new IRCTCAPP().start();
    }

    // public void start() {

    //     System.out.println("-------Welcome to IRCTC APP------");
    //     while (true) {
    //         if (!userservice.isLoggedIn()) {
    //             System.out.println("1.Register");
    //             System.out.println("2.Login");
    //             System.out.println("3.Exit");
    //             System.out.println("Enter choice ");
    //             int choice = scanner.nextInt();

    //             switch (choice) {
    //                 case 1 -> register();
    //                 case 2 -> login();
    //                 case 3 -> exitApp();
    //                 default -> System.out.println("Invalid Choice");
    //             }
    //         } else {
    //             showUsermenu();
    //         }
    //     }
    // }
    public void start() {
    System.out.println("-------Welcome to IRCTC APP------");
    while (true) {
        if (!userservice.isLoggedIn()) {
            System.out.println("\n1.Register");
            System.out.println("2.Login");
            System.out.println("3.Exit");
            System.out.print("Enter choice: ");
            
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); // Clear invalid input
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // 👈 CRITICAL FIX: Clears the buffer!

            switch (choice) {
                case 1 -> register();
                case 2 -> login();
                case 3 -> exitApp();
                default -> System.out.println("Invalid Choice");
            }
        } else {
            showUsermenu();
        }
    }
}


    public void register() {
        System.out.println("Enter Username");
        String username = scanner.next();
        System.out.println("Enter Password:");
        String password = scanner.next();
        System.out.println("Enter full name");
        scanner.nextLine();
        String fullname = scanner.nextLine();
        System.out.println("Enter Contact:");
        String conatact = scanner.next();

        userservice.registration(username, password, fullname, conatact);

    }

    public void login() {
        System.out.println("Enter Username");
        String username = scanner.next();
        System.out.println("Enter Password:");
        String password = scanner.next();
        userservice.loginuser(username, password);

    }

    private void showUsermenu() {

        while (userservice.isLoggedIn()) {
            System.out.println("\n-----User Menu -------");
            System.out.println("1.Search Trains");
            System.out.println("2.Book Ticket");
            System.out.println("3. View My Tickets ");
            System.out.println("4.Cancel ticket");
            System.out.println("5.View all Trains");
            System.out.println("6.Logout");
            System.out.println("Enter Choice");
            int choice=scanner.nextInt();
            switch (choice){
                case 1-> searchTrain();
                case 2->BookTicket();
                case 3->viewMyTicket();
                case 4->cancelTicket();
                case 5->bookingservice.listAllTrain();
                case 6->  userservice.Logout();
                default -> System.out.println("Invalid choice" );
            }

        }
    }

    private void searchTrain(){
        System.out.println("Enter source station ");
        String source = scanner.next();
        System.out.println("Enter designation ");
        String designation = scanner.next();

        List<Train> trains=bookingservice.searchTrain(source,designation);
        if(trains.isEmpty()){
            System.out.println("No train found between "+source +" and"+ designation);
            return;
        }
        System.out.println("train found");
        for(Train train:trains){
            System.out.println(train);
        }
        System.out.println("Do you want to book ticket in this window only ? (yes/no:");
        String choice = scanner.next();
        if(choice.equalsIgnoreCase("yes")){
            System.out.println("Enter train ID");
            int trainId= scanner.nextInt();
            System.out.println("Enter number of seats to book");
            int seats= scanner.nextInt();

            Ticket ticket= bookingservice.bookTicket(userservice.getCurrentUser(),trainId,seats);
            if(ticket!=null) {
                System.out.println("Booking Successfull");
                System.out.println(ticket);
            }

        }
        else{
            System.out.println("returning to user Menu");
        }
    }
 private void BookTicket(){
     System.out.println("Enter source station ");
     String source = scanner.next();
     System.out.println("Enter designation ");
     String designation = scanner.next();
     List<Train> trains=bookingservice.searchTrain(source,designation);
     if(trains.isEmpty()){
         System.out.println("No trains available for booking");
         return;
     }
     System.out.println("Available Trains ");
     for(Train train:trains){
         System.out.println(train);
     }
     System.out.println("Enter train ID");
     int trainId= scanner.nextInt();
     System.out.println("Enter number of seats to book");
     int seats= scanner.nextInt();

     Ticket ticket= bookingservice.bookTicket(userservice.getCurrentUser(),trainId,seats);
     if(ticket!=null) {
         System.out.println("Booking Successfull");
         System.out.println(ticket);
     }

 }
 private void viewMyTicket(){
     List<Ticket> ticketByUser= bookingservice.getTicketByUser(userservice.getCurrentUser());
     if(ticketByUser.isEmpty()){
         System.out.println("No ticket Booked yet");

     }
     else{
         System.out.println("Your Ticket is:");
         for (Ticket ticket:ticketByUser){
             System.out.println(ticket);
         }
     }
 }

 private void cancelTicket(){
     System.out.println("Enter Ticket ID to cancel ");
     int ticketId= scanner.nextInt();
     bookingservice.CancelTicket(ticketId,userservice.getCurrentUser());

 }


    private void exitApp(){
        System.out.println("Thankyou for using IRCTC app");
        System.exit(0);
    }
}