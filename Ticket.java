public class Ticket {
    private int TicketId;

    private User user;

    private Train train;

    private int SeatBooked;

    private static int counter=1001;

    public Ticket( User user, Train train, int seatBooked) {
        this.TicketId = counter++;
        this.user = user;
        this.train = train;
        SeatBooked = seatBooked;
    }

    public int getTicketId() {
        return TicketId;
    }

    public void setTicketId(int ticketId) {
        TicketId = ticketId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public int getSeatBooked() {
        return SeatBooked;
    }

    public void setSeatBooked(int seatBooked) {
        SeatBooked = seatBooked;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Ticket.counter = counter;
    }

    @Override
    public String toString() {
        return "Ticket Id: "+TicketId+ " | Train "+train.getName()+ " | Route"+train.getSource()+
                " ->" +train.getDesignation()+ "| Seats: "+SeatBooked+ " | BookedBy: "+user.getFullName();
    }
}
