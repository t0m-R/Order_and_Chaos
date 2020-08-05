package core.Entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testName() {
        Player player = new Player("Marco");
        assertEquals(player.getName(), "Marco");
    }

    @Test
    public void testDifferentName() {
        Player player = new Player("Marco");
        assertNotEquals(player.getName(), "Tommaso");
    }


}
