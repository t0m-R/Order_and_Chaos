package core.Rules;

import core.Entities.Board;
import core.Entities.StateManager;

import java.awt.*;

public class EmptyCellRule implements Rule{

    @Override
    public boolean isValid(StateManager gameState) {
        return isEmpty(gameState.getBoard(), gameState.getCurrentPoint());
    }

    public boolean isEmpty(Board board, Point point){
        return board.getCell(point).getPiece() == null;
    }
}
