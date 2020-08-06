package core.Rules;
import core.Entities.Piece;
import core.Entities.StateManager;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class testChaosWinRule {

    private final StateManager gameState = new StateManager(6);
    private final ChaosWinRule chaosWin = new ChaosWinRule();

    private void makeAllTurns(StateManager gameState, Piece p) {
        for (int i=0;i<6;i++){
            for (int j=0;j<6;j++){
                gameState.newTurn(new Point(i,j),p);
            }
        }
    }

    @Test
    public void testChaosWinRuleFalse() {
        gameState.newTurn(new Point(0,0),Piece.x);
        assertFalse(chaosWin.isValid(gameState));
    }

    @Test
    public void testChaosWinRuleTrue() {
        makeAllTurns(gameState, Piece.x);
        gameState.setCurrentPoint(new Point(5,5));
        assertTrue(chaosWin.isValid(gameState));
    }
}
