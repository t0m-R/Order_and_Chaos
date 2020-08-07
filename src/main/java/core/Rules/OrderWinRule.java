package core.Rules;

import core.Entities.Board;
import core.Entities.Cell;
import core.Entities.Piece;
import core.Entities.StateManager;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class OrderWinRule implements Rule{

    @Override
    public boolean isValid(StateManager gameState) {
        return isFiveStreak(gameState.getBoard(), Piece.x) || isFiveStreak(gameState.getBoard(), Piece.o);
    }
    public boolean isFiveStreak(Board board, Piece p){
        return checkRows(board, p) || checkCols(board, p) || checkLeftDiags(board, p) || checkRightDiags(board, p);
    }

    public boolean checkRows(Board board, Piece p){
        boolean winner = false;
        for (int i = 0; i < 6; i++) {
            final int x = i;
            Supplier<Stream<Cell>> cells = () -> board.getRow(x);
            winner = isWinner(p, winner, cells);
        }
        return winner;
    }

    public boolean checkCols(Board board, Piece p){
        boolean winner = false;
        for (int i = 0; i < 6; i++) {
            final int x = i;
            Supplier<Stream<Cell>> cells = () -> board.getColumn(x);
            winner = isWinner(p, winner, cells);
        }
        return winner;
    }

    public boolean checkLeftDiags(Board board, Piece p){
        boolean winner = false;
        Supplier<Stream<Cell>> cells = board::getLeftDiag;
        winner = isWinner(p, winner, cells);
        cells = board::getLeftDiagUpper;
        winner = isWinner(p, winner, cells);
        cells = board::getLeftDiagLower;
        winner = isWinner(p, winner, cells);
        return winner;
    }

    public boolean checkRightDiags(Board board, Piece p){
        boolean winner = false;
        Supplier<Stream<Cell>> cells = board::getRightDiag;
        winner = isWinner(p, winner, cells);
        cells = board::getRightDiagUpper;
        winner = isWinner(p, winner, cells);
        cells = board::getRightDiagLower;
        winner = isWinner(p, winner, cells);
        return winner;
    }

    private boolean isWinner(Piece p, boolean winner, Supplier<Stream<Cell>> cells) {
        if (!winner) {
            winner = checkCellStream(cells.get(), p);
        }
        if (!winner) {
            winner = checkCellStream(cells.get().skip(1), p);
        }
        if (!winner) {
            winner = checkCellStream(cells.get().limit(5), p);
        }
        return winner;
    }

    public boolean checkCellStream(Stream<Cell> cells, Piece p){
            return cells.allMatch(x->x.hasThisPiece(p));
        }
}

