import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuestTest {
    @Test
    public void hasAName(){
        Guest guest = new Guest("Giorgio");
        assertEquals("Giorgio", guest.getName());
    }

}