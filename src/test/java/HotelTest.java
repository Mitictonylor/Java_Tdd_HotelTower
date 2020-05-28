import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class HotelTest {

    private Hotel hotel;
    private ConferenceRoom conferenceRoom;
    private Bedroom bedroom;
    private Guest ally;
    private Guest colin;
    private Guest anna;
    private Guest jenny;
    private DiningRoom diningRoom;
    private Bedroom bedroom2;


    @Before
    public void setUp(){
        hotel = new Hotel("tower");
        conferenceRoom = new ConferenceRoom("Crystal",1);
        diningRoom = new DiningRoom("Bistro");
        bedroom = new Bedroom(25,3,"double", 80.25);
        bedroom2 = new Bedroom(20,1,"double", 50.50);
        ally = new Guest("Ally");
        colin = new Guest("Colin");
        jenny = new Guest("Jenny");
        anna = new Guest("Anna");
        hotel.addBedroom(bedroom);
        hotel.addBedroom(bedroom2);
        hotel.addConferenceRoom(conferenceRoom);
        hotel.addToDiningHashMap(diningRoom);
    }

    @Test
    public void canFindABedroom() {
        Bedroom foundRoom = hotel.findBedroom(25);
        assertEquals(bedroom, foundRoom);
    }

    @Test
    public void cantFindABedroom() {
        Bedroom wrongRoom = hotel.findBedroom(5);
        assertNull(wrongRoom);
    }

    @Test
    public void canFindAConfRoom() {
        ConferenceRoom foundConferenceRoom = hotel.findConfRoom("Crystal");
        assertEquals(conferenceRoom, foundConferenceRoom);
    }

    @Test
    public void cantFindAConfRoom() {
        ConferenceRoom wrongRoom = hotel.findConfRoom("Charcoal");
        assertNull(wrongRoom);
    }

    @Test
    public void canCheckGuestsIntoBedroom() {
        ArrayList<Guest> guests = new ArrayList<Guest>();
        guests.add(ally);
        hotel.checkInToBedroom(guests, 25);
        assertEquals(1, bedroom.countGuest());

    }

    @Test
    public void canNotCheckGuestsIntoBedroom() {
        ArrayList<Guest> guests = new ArrayList<Guest>();
        guests.add(ally);
        guests.add(anna);
        hotel.checkInToBedroom( guests, 20);
        assertEquals(1, bedroom2.countGuest());
    }
    @Test
    public void canCheckGuestsIntoConfRoom() {
        ArrayList<Guest> guests = new ArrayList<Guest>();
        guests.add(jenny);
        hotel.checkInToConfRoom(guests,"Crystal");
        assertEquals(1, conferenceRoom.countGuest());

    }

    @Test
    public void canNotCheckIntoConferenceRoom() {
        ArrayList<Guest> guests = new ArrayList<Guest>();
        guests.add(colin);
        guests.add(ally);
        hotel.checkInToConfRoom(guests, "Crystal");
        assertEquals(2, conferenceRoom.countGuest());
    }
    @Test
    public void canCheckOutOfBedroom() {
        ArrayList<Guest> guests = new ArrayList<Guest>();
        guests.add(colin);
        hotel.checkInToBedroom(guests, 25);
        hotel.checkOutFromBedroom(25);
        assertEquals(0, bedroom2.countGuest());
    }

    @Test
    public void canCheckOutOfConferenceRoom() {
        ArrayList<Guest> guests = new ArrayList<Guest>();
        guests.add(jenny);
        hotel.checkInToConfRoom(guests, "Crystal");
        hotel.checkOutFromConfRoom("Crystal");
        assertEquals(0, conferenceRoom.countGuest());
    }

    @Test
    public void canCreateBooking() {
        Booking booking = hotel.bookRoom(bedroom, 2);
        assertEquals(160.50, booking.totalCost(), 0.01);
    }

    @Test
    public void canFindEmptyBedrooms() {
        ArrayList<Guest> guests = new ArrayList<Guest>();
        guests.add(colin);
        hotel.checkInToBedroom( guests, 25);
        ArrayList<Bedroom> vacantRooms = hotel.getFreeBedrooms();
        assert(vacantRooms.contains(bedroom2));
    }

    @Test
    public void canFindADiningRoom() {
        DiningRoom foundDiningRoom = hotel.findDiningRoom("Bistro");
        assertEquals(diningRoom, foundDiningRoom);
    }

    @Test
    public void cantFindADiningRoom() {
        DiningRoom wrongDiningRoom = hotel.findDiningRoom("La vita");
        assertNull(wrongDiningRoom);
    }

    @Test
    public void canCheckGuestsIntoDiningRoom() {
        ArrayList<Guest> guests = new ArrayList<Guest>();
        guests.add(anna);
        hotel.checkInToDiningRoom( guests, "Bistro");
        assertEquals(1, diningRoom.countGuests());
    }

    @Test
    public void canCheckGuestsOutOfDiningRoom() {
        ArrayList<Guest> guests = new ArrayList<Guest>();
        guests.add(ally);
        hotel.checkInToDiningRoom(guests, "Bistro");
        hotel.checkOutFromDiningRoom("Bistro");
        assertEquals(0, diningRoom.countGuests());
    }
}