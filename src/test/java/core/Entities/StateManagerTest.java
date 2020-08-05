package core.Entities;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class StateManagerTest {

    private final StateManager gameState = new StateManager(6);

    private void fillBoard() {
        Board board = gameState.getBoard();
        board.setCell(new Point(0,0), Piece.x);
        board.setCell(new Point(1,0), Piece.o);
        board.setCell(new Point(0,1), Piece.x);
        board.setCell(new Point(1,1), Piece.o);
    }

    @Test
    public void testFirstPlayer() {
        Player firstPlayer = gameState.getPlayer();
        assertEquals(firstPlayer.getName(), "Order");
    }

    @Test
    public void testGetBoard() {
        Board empty = new Board(6);
        fillBoard();
        Board filled = gameState.getBoard();
        assertNotEquals(empty,filled);

    }

    @Test
    public void testGetTurn() {
        int turn = gameState.getTurn();
        assertEquals(1,turn);

    }

}
