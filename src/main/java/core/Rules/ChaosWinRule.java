package core.Rules;

import core.Entities.Board;
import core.Entities.StateManager;

import java.awt.*;

public class ChaosWinRule implements Rule{

    @Override
    public boolean isValid(StateManager gameState) {
        return isFull(gameState.getBoard());
    }

    public boolean isFull(Board board){
        return board.getAllCells().noneMatch(x-> x.getPiece() == null);
    }
}
