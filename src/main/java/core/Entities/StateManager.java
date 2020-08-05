package core.Entities;

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

    public int getTurn() { return turn; }


}
