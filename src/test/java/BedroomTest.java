import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BedroomTest {

    Bedroom bedroom;
    Bedroom bedroom2;
    Guest guest;
    Guest guest1;
    Guest guest2;


    @Before
    public void setUp(){
        bedroom = new Bedroom(12,3,"double",45.99);
        bedroom2 = new Bedroom(10,1,"single",45.99);
        guest = new Guest("Giorgio");
        guest1 = new Guest("steven");
        guest2 = new Guest("Fab");

    }
    @Test
    public void canAddGuest() {
        bedroom.addGuest(guest);
        bedroom.addGuest(guest2);
        bedroom.addGuest(guest1);
        assertEquals(3, bedroom.countGuest());
    }
    @Test
    public void canCountGuests(){
        bedroom.addGuest(guest);
        bedroom.addGuest(guest2);
        assertEquals(2, bedroom.countGuest());

    }
    @Test
    public void canNotAddGuestBecauseOverCapacity() {
        bedroom2.addGuest(guest);
        bedroom2.addGuest(guest2);
        assertEquals(1, bedroom2.countGuest());
    }
    @Test
    public void canRemoveGuest() {
        bedroom.addGuest(guest);
        bedroom.addGuest(guest2);
        bedroom.addGuest(guest1);
        bedroom.removeGuest();
        assertEquals(0, bedroom.countGuest());
    }
    @Test
    public void theRoomIsEmpty(){
        assertEquals(true, bedroom.isEmpty());
    }
    @Test
    public void theRoomIsNotEmpty(){
        bedroom.addGuest(guest);
        assertEquals(false, bedroom.isEmpty());
    }
}
