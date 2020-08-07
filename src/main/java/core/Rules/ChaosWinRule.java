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
        for (int i=0;i<6;i++){
            if(board.getRow(i).anyMatch(x-> x.getPiece() == null)){return false;}
        }
        return true;
    }
}
