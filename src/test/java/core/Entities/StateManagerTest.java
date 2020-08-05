package core.Entities;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class StateManagerTest {

    private final StateManager gameState = new StateManager(6);

    @Test
    public void testFirstPlayer() {
        Player firstPlayer = gameState.getPlayer();
        assertEquals(firstPlayer.getName(), "Order");
    }

    @Test
    public void testGetBoard() {
        Board empty = gameState.getBoard();
        gameState.getBoard().setCell(new Point(0,0), Piece.x);
        Board filled = gameState.getBoard();
        assertNotEquals(empty,filled);
    }

    @Test
    public void testGetTurn() {
        int turn = gameState.getTurn();
        assertEquals(1,turn);

    }

}
