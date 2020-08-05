package core.Entities;

import java.awt.Point;

public class StateManager {

    private final Board board;
    private final Player chaos;
    private final Player order;
    private String currentPlayer = "Order";
    private int turn;

    public StateManager(int size){
        board = new Board(size);
        chaos = new Player("Chaos");
        order = new Player("Order");
        turn = 1;
    }

    public Board getBoard() { return board; }

    public Player getPlayer() { return (order.getName().equals(currentPlayer)) ? order : chaos; }

    public String getOpponentPlayerName() { return (currentPlayer).equals("Order") ? chaos.getName() : order.getName(); }

    public int getTurn() { return turn; }

    public void newTurn(Point newPoint, Piece newPiece){
        board.setCell(newPoint, newPiece);
        currentPlayer = getOpponentPlayerName();
        turn ++;
    }


}
