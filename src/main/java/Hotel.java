import java.util.ArrayList;
import java.util.HashMap;

public class Hotel {

    private String name;
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private HashMap<String, DiningRoom> diningRooms;

    public Hotel(String name){
        this.name = name;
        this.bedrooms= new ArrayList<Bedroom>();
        this.conferenceRooms = new ArrayList<ConferenceRoom>();
        this.diningRooms = new HashMap<String, DiningRoom>();
    }
    public void addBedroom(Bedroom bedroom) {
        this.bedrooms.add(bedroom);
    }


    public void addConferenceRoom(ConferenceRoom conferenceRoom){
        this.conferenceRooms.add(conferenceRoom);
    }

    public Bedroom findBedroom(int roomNumber){
        Bedroom sameRoom = null;
        for (Bedroom bedroom : this.bedrooms){
            if (roomNumber == bedroom.getRoomNumber()){
                sameRoom = bedroom;
            }
        }
        return sameRoom;
    }

    public ConferenceRoom findConfRoom(String confRoomName){
        ConferenceRoom sameRoom = null;
        for (ConferenceRoom confRoom : this.conferenceRooms){
            if (confRoomName == confRoom.getName()){
                sameRoom = confRoom;
            }
        }
        return sameRoom;
    }
    public DiningRoom findDiningRoom(String diningRoomName){
        return this.diningRooms.get(diningRoomName);
    }

    public void checkInToBedroom(ArrayList<Guest> guests, int roomNumber ) {
        Bedroom assignedBedroom = findBedroom(roomNumber);
        if(assignedBedroom != null && assignedBedroom.isEmpty() ){
            for(Guest guest : guests)
                assignedBedroom.addGuest(guest);}
    }
    public void checkInToConfRoom(ArrayList<Guest> guests, String confRoomName ) {
        ConferenceRoom assignedConfRoom = findConfRoom(confRoomName);
        if(assignedConfRoom != null && (assignedConfRoom.countGuest() < assignedConfRoom.getCapacity()) ){
            for(Guest guest : guests)
                assignedConfRoom.addGuest(guest);}
    }


    public void checkOutFromBedroom(int roomNumber) {
        Bedroom bedroom = findBedroom(roomNumber);
        if (bedroom != null) {
            bedroom.removeGuest();
        }
    }
    public void checkOutFromConfRoom(String confRoomName) {
        ConferenceRoom conferenceRoom = findConfRoom(confRoomName);
        if (conferenceRoom != null) {
            conferenceRoom.checkOutGuests();
        }
    }
    public Booking bookRoom(Bedroom bedroom, int numOfNights){
        Booking booking = new Booking(bedroom,numOfNights);
        return booking;
    }
    public void checkInToDiningRoom(ArrayList<Guest> guests, String diningRoomName){
        DiningRoom diningRoom = findDiningRoom(diningRoomName);
        if (diningRoom != null){
            for(Guest guest : guests){
                diningRoom.addGuest(guest);
            }
        }
    }
    public void checkOutFromDiningRoom(String diningRoomName){
        DiningRoom diningRoom = findDiningRoom(diningRoomName);
        if (diningRoom != null){
            diningRoom.removeGuests();
        }
    }

    public void addToDiningHashMap(DiningRoom diningRoom){
        String key = diningRoom.getName();
        this.diningRooms.put(key, diningRoom);
    }

    public ArrayList<Bedroom> getFreeBedrooms() {
        ArrayList<Bedroom> freeRooms = new ArrayList<Bedroom>();
        for (Bedroom bedroom : this.bedrooms){
            if (bedroom.isEmpty()){
                freeRooms.add(bedroom);
            }
        }
        return freeRooms;
    }
}
