

public class Train {
    private int TrainId;

    private String Name;

    private String Source;

    private String Designation;

    private int TotalSeat;

    private int AvailableSeat;

    public Train(int trainId, String name, String source, String designation, int totalSeat) {
        TrainId = trainId;
        Name = name;
        Source = source;
        Designation = designation;
        TotalSeat = totalSeat;
        AvailableSeat = TotalSeat;
    }

    public int getTrainId() {
        return TrainId;
    }

    public void setTrainId(int trainId) {
        TrainId = trainId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public int getTotalSeat() {
        return TotalSeat;
    }

    public void setTotalSeat(int totalSeat) {
        TotalSeat = totalSeat;
    }

    public int getAvailableSeat() {
        return AvailableSeat;
    }

    public void setAvailableSeat(int availableSeat) {
        AvailableSeat = availableSeat;
    }



    public boolean BookSeat(int count){

        if(count<=AvailableSeat){
            AvailableSeat -=count;
            return true;
        }
        return false;
    }



    public void CancelSeats(int count){
        AvailableSeat +=count;
    }

    @Override
    public String toString() {
        return TrainId + "  | "+Name+" | " +Source+ " -> "+Designation+ " Seats Available: "+AvailableSeat;
    }
}
