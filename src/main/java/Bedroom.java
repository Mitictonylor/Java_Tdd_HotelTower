import java.util.ArrayList;

public class Bedroom {
    private int roomNumber;
    private int capacity;
    private String type;
    private double rate;
    private ArrayList<Guest> guest;

    public Bedroom(int roomNumber, int capacity, String type, double rate) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.type = type;
        this.rate = rate;
        this.guest = new ArrayList<Guest>();
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getType() {
        return this.type;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public double getRate() {
        return this.rate;
    }

    public void addGuest(Guest guest){
        if(this.capacity > this.countGuest()){
            this.guest.add(guest);}
    }

    public int countGuest() {
        return this.guest.size();
    }
}
