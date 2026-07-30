
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookingService {

    private List<Train> trainlist= new ArrayList<>();

    private List<Ticket> ticketlist= new ArrayList<>();

    public BookingService(){
        trainlist.add(new Train(101,"Rajdhani express","Delhi","Nagpur",100));
        trainlist.add(new Train(102,"Chambal express","Anvt","Tamil Naidu",67));
        trainlist.add(new Train(103,"Poorva express","Gomoh","Banaras",155));
        trainlist.add(new Train(104,"Jharkhand express","Ranchi","Patna",190));
        trainlist.add(new Train(105,"Duronto express","Kolkata","Rajkot",121));
        trainlist.add(new Train(106,"Kalyanpuri express","Lucknow","Banglore",12));

    }

    // isme date bhi add kar dena apmne se

    public List<Train> searchTrain(String source,String designation){
        List<Train> res= new ArrayList<>();
        for(Train train:trainlist){
            if(train.getSource().equalsIgnoreCase(source) && train.getDesignation().equalsIgnoreCase(designation)){
                res.add(train);
            }
        }
        return res;
    }
    public Ticket bookTicket(User user, int TrainId, int seatcount){
        for(Train train:trainlist){
            if(train.getTrainId()==TrainId){
                if(train.BookSeat(seatcount)){
                    Ticket ticket= new Ticket(user,train,seatcount);
                    ticketlist.add(ticket);
                    return ticket;

                }
                else{
                    System.out.println("Not enough seat Available");
                    return null;
                }
            }
        }
        System.out.println("Train Id not found ");
        return null;
    }

    public List<Ticket> getTicketByUser(User user) {
        List<Ticket> res = new ArrayList<>();
        for(Ticket ticket:ticketlist){
            if(ticket.getUser().getUserName().equalsIgnoreCase(user.getUserName())){
                res.add(ticket);
            }
        }
        return res;
    }
    public boolean CancelTicket(int ticketId, User user){
        Iterator<Ticket> iterator= ticketlist.listIterator();
        while(iterator.hasNext()){
            Ticket ticket=iterator.next();
            if(ticket.getTicketId()==ticketId && ticket.getUser().getUserName().equalsIgnoreCase(user.getUserName())){
                Train train= ticket.getTrain();
                train.CancelSeats(ticket.getSeatBooked());
                iterator.remove();
                System.out.println("ticket:"+ticketId + "cancelled successfully");
                return true;
            }
        }
        System.out.println("Ticket is not found or it does not belongs to user ");
        return false;
    }
    public void listAllTrain(){
        System.out.println("List of all Trains");
        for(Train train:trainlist){
            System.out.println(train);
        }
    }
}

