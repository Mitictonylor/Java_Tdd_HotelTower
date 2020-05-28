import java.util.ArrayList;

public class ConferenceRoom {

    private String name;
    private int capacity;
    private ArrayList<Guest> guests;

    public ConferenceRoom(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.guests = new ArrayList<Guest>();
    }

    public void addGuest(Guest guest){
        this.guests.add(guest);
    }

    public int countGuest() {
        return this.guests.size();
    }
    public int getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }

    public void checkInGuest(Guest guest) {
        if (this.countGuest() < this.capacity) {
            this.guests.add(guest);
        }
    }

    public void checkOutGuests() {
        if (this.countGuest() > 0) {
            this.guests.clear();
        }
    }
}

