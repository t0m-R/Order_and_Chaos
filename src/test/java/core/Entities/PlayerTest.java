package core.Entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testName() {
        Player player = new Player("Marco");
        assertEquals(player.getName(), "Tommaso");
        assertEquals(player.getName(), "Marco");

    }


}
