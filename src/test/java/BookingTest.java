import org.junit.Before;
import org.junit.Test;

public class BookingTest {
    private Booking booking;
    private Bedroom bedroom;

    @Before
    public void setUp(){
        bedroom = new Bedroom(25,3,"double",42.5);
        booking = new Booking(bedroom,4);
    }
    @Test
    public void hasNumberOfNights() {
        assertEquals(4, booking.getNumOfNights());
    }

    @Test
    public void hasBedroom() {
        assertEquals(bedroom, booking.getBedroom());
    }

    @Test
    public void canTellHowMuchTheStayWillCost(){
        assertEquals(170, booking.totalCost(), 0.01);
    }


}
