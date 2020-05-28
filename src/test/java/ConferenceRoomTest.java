import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {

    ConferenceRoom conferenceRoom;
    Guest guest;
    Guest guest2;
    Guest guest3;


    @Before
    public void setUp() {
        conferenceRoom = new ConferenceRoom("Room 24", 2);
        guest = new Guest("Giorgio");
        guest2 = new Guest("Filippo");
        guest3 = new Guest("GianGiorgio");
    }
    @Test
    public void hasCapacity() {
        assertEquals(2, conferenceRoom.getCapacity());
    }

    @Test
    public void hasName() {
        assertEquals("Room 24", conferenceRoom.getName());
    }

    @Test
    public void guestStartsEmpty() {
        assertEquals(0, conferenceRoom.countGuest());
    }

    @Test
    public void canCountGuests(){
        assertEquals(0, conferenceRoom.countGuest());
    }
    @Test
    public void canCheckInGuest() {
        conferenceRoom.checkInGuest(guest);
        conferenceRoom.checkInGuest(guest2);
        assertEquals(2, conferenceRoom.countGuest());
    }

    @Test
    public void canNotCheckInGuestBecauseOverCapacity() {
        conferenceRoom.checkInGuest(guest);
        conferenceRoom.checkInGuest(guest2);
        conferenceRoom.checkInGuest(guest3);
        assertEquals(2, conferenceRoom.countGuest());
    }

    @Test
    public void canCheckOutGuests() {
        conferenceRoom.checkInGuest(guest);
        conferenceRoom.checkInGuest(guest2);
        conferenceRoom.checkOutGuests();
        assertEquals(0, conferenceRoom.countGuest());
    }


}