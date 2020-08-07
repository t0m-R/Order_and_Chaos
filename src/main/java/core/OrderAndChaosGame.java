package core;

import UI.Console.DisplayBoard;
import UI.Messages;
import core.Entities.Board;
import core.Entities.Piece;
import core.Entities.Rulebook;
import core.Entities.StateManager;
import core.Rules.ChaosWinRule;
import core.Rules.OrderWinRule;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderAndChaosGame {

    private static final Scanner sc = new Scanner(System.in);
    private final StateManager gameState ;

    public OrderAndChaosGame(){
        gameState = new StateManager(6);
    }

    public void playGame(){
        System.out.println(Messages.greetings);
        while (!checkWinConditions()){
            makeTurn();
            DisplayBoard.showBoard(gameState.getBoard());
        }
    }

    public boolean checkWinConditions(){
        if (Rulebook.queryRule(gameState, ChaosWinRule::new)){
            System.out.println(Messages.chaosWin);
            return true;
        }
        if (Rulebook.queryRule(gameState, OrderWinRule::new)){
            System.out.println(Messages.orderWin);
            return true;
        }
        return false;
    }

    private void makeTurn(){
        System.out.println("New turn");
        gameState.newTurn(getPoint(gameState.getBoard()), getPiece());
    }

    private static Point getPoint(Board board){
        System.out.println("Select x coordinate:");
        int x = getInt();
        System.out.println("Select y coordinate:");
        int y = getInt();
        if (board.isValid(new Point(x,y))){
            return new Point(x,y);
        }
        else{
            System.out.println("Illegal point. Try again");
            return getPoint(board);
        }
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
            System.out.println("Illegal piece. Try again");
            return getPiece();
        }
    }

    private static int getInt(){
        try{ return sc.nextInt(); }
        catch (InputMismatchException e){
            System.out.println("Not a integer. Try again");
            sc.next();
            return getInt();
        }
    }
}