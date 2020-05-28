import org.junit.Before;
import org.junit.Test;

public class DiningRoomTest {

        DiningRoom diningRoom;
        Guest guest;
        Guest guest2;
        Guest guest3;

        @Before
        public void setUp() {
            diningRoom = new DiningRoom("Bistro");
            guest = new Guest("Giorgio");
            guest2 = new Guest("Filippo");
            guest3 = new Guest("GianBattista");
        }

        @Test
        public void hasName() {
            assertEquals("Bistro", diningRoom.getName());
        }

        @Test
        public void guestArrayStartsEmpty() {
            assertEquals(0, diningRoom.countGuests());
        }
        @Test
        public void canAddGuest() {
            diningRoom.addGuest(guest);
            diningRoom.addGuest(guest2);
            assertEquals(2, diningRoom.countGuests());
    }
        @Test
        public void canClearTheRoom() {
            diningRoom.addGuest(guest);
            diningRoom.addGuest(guest2);
            diningRoom.removeGuests();
            assertEquals(0, diningRoom.countGuests());
        }
}
