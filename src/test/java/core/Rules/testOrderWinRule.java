package core.Rules;

import core.Entities.Piece;
import core.Entities.StateManager;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class testOrderWinRule {


    private final OrderWinRule orderWin = new OrderWinRule();

    @Test
    public void testOrderWinsRow() {
        StateManager gameState = new StateManager(6);

        for (int i=0;i<6;i++){
        gameState.newTurn(new Point(0, i), Piece.o);
        }
        assertTrue(orderWin.isValid(gameState));
    }

    @Test
    public void testOrderWinsColumn() {
        StateManager gameState = new StateManager(6);

        for (int i=0;i<6;i++){
            gameState.newTurn(new Point(i, 0), Piece.o);
        }
        assertTrue(orderWin.isValid(gameState));
    }

    @Test
    public void testOrderWinsLeftDiag() {
        StateManager gameState = new StateManager(6);

        for (int i=0;i<6;i++){
            gameState.newTurn(new Point(i, i), Piece.o);
        }
        assertTrue(orderWin.isValid(gameState));
    }

    @Test
    public void testOrderWinsRightDiag() {
        StateManager gameState = new StateManager(6);

        for (int i=0;i<6;i++){
            gameState.newTurn(new Point(5-i, 5-i), Piece.o);
        }
        assertTrue(orderWin.isValid(gameState));
    }

    @Test
    public void testOrderLooseRightDiag() {
        StateManager gameState = new StateManager(6);

        for (int i=0;i<6;i++) {
            if (i % 2 == 0) {
                gameState.newTurn(new Point(5 - i, 5 - i), Piece.o);
            } else {
                gameState.newTurn(new Point(5 - i, 5 - i), Piece.x);
            }
        }
        assertFalse(orderWin.isValid(gameState));
    }

    @Test
    public void testOrderWinsPartialRow() {
        StateManager gameState = new StateManager(6);

        for (int i=1;i<6;i++){
            gameState.newTurn(new Point(0, i), Piece.o);
        }
        assertTrue(orderWin.isValid(gameState));
    }
}