package core.Rules;

import core.Entities.Piece;
import core.Entities.StateManager;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class testEmptyCellRule {

    private final StateManager gameState = new StateManager(6);
    private final EmptyCellRule emptyRule = new EmptyCellRule();

    @Test
    public void testEmptyRuleFalse() {
        gameState.newTurn(new Point(0,0),Piece.x);
        assertFalse(emptyRule.isValid(gameState));
    }

    @Test
    public void testEmptyRuleTrue() {
        gameState.setCurrentPoint(new Point(5,5));
        assertTrue(emptyRule.isValid(gameState));
    }
}
