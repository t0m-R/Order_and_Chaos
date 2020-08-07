package core;

import UI.Console.DisplayBoard;
import core.Entities.Piece;
import core.Entities.Rulebook;
import core.Entities.StateManager;
import core.Rules.ChaosWinRule;
import core.Rules.OrderWinRule;

import java.awt.*;
import java.util.Scanner;

public class OrderAndChaosGame {

    private static final Scanner sc = new Scanner(System.in);
    private final StateManager gameState ;

    public OrderAndChaosGame(){
        gameState = new StateManager(6);
    }

    public void playGame(){
        while (!checkWinConditions()){
            makeTurn();
            DisplayBoard.showBoard(gameState.getBoard());
        }
    }

    public boolean checkWinConditions(){
        if (Rulebook.queryRule(gameState, ChaosWinRule::new)){
            System.out.println("Chaos wins");
            return true;
        }
        if (Rulebook.queryRule(gameState, OrderWinRule::new)){
            System.out.println("Order wins");
            return true;
        }
        return false;
    }

    private void makeTurn(){
        System.out.println("New turn");
        gameState.newTurn(getPoint(), getPiece());
    }

    private static Point getPoint(){
        System.out.println("Select x coordinate:");
        int x = getInt();
        System.out.println("Select y coordinate:");
        int y = getInt();
        return new Point(x,y);
    }

    private static Piece getPiece(){
        System.out.println("Select your piece:");
        char piece = sc.next().charAt(0);
        if (piece == 'x'){
            return Piece.x;
        }
        if (piece == 'o'){
            return Piece.o;
        }
        else{
            return null;
        }
    }

    private static int getInt(){
        return sc.nextInt();
    }
}