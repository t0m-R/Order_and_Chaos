package core.Entities;

import java.awt.Point;
import java.util.Iterator;
import java.util.stream.Stream;

import static java.util.stream.IntStream.range;

public class Board implements Iterable<Cell>{

    public Board(int s){
        size = s;
        board = new Cell [s][s];
        for (int x=0;x<s;x++){
            for(int y=0;y<s;y++){
                board[x][y] = new Cell(new Point(x,y));
            }
        }
    }

    private final int size;

    private final Cell[][] board;

    public int getSize(){ return size; }

    public Cell getCell(Point p){ return board[p.x][p.y];}

    public void setCell(Point p, Piece x) {
        getCell(p).setPiece(x);
    }

    public boolean isValid(Point p) {
        return ( 0 <= p.x && p.x < size) && ( 0 <= p.y && p.y < size);
    }

    public Stream<Cell> getRow(int index){
        return range(0,board.length).mapToObj(i -> board[index][i]);    }

    public Stream<Cell> getColumn(int index){
        return range(0,board.length).mapToObj(i -> board[i][index]);
    }

    public Stream<Cell> getRightDiag(){
        return range(0,board.length).mapToObj(i -> board[i][board.length-1-i]);
    }

    public Stream<Cell> getRightDiagUpper(){
        return range(1,board.length-1).mapToObj(i -> board[i][board.length-i]);
    }

    public Stream<Cell> getRightDiagLower(){
        return range(0,board.length-2).mapToObj(i -> board[i][board.length-i-2]);
    }

    public Stream<Cell> getLeftDiag(){
        return range(0,board.length).mapToObj(i -> board[i][i]);
    }

    public Stream<Cell> getLeftDiagUpper(){
        return range(0,board.length-1).mapToObj(i -> board[i][i+1]);
    }

    public Stream<Cell> getLeftDiagLower(){
        return range(1,board.length).mapToObj(i -> board[i][i-1]);
    }




    // Iterator Override

    @Override
    public Iterator<Cell> iterator() {
        return new Iterator<>() {

            private final Point thisPoint = new Point(0,0);

            @Override
            public boolean hasNext() {
                return thisPoint.x <= size-1 && thisPoint.y <= size -1;
            }

            @Override
            public Cell next() {
                Point current = new Point(thisPoint);
                Point nextPoint = ( thisPoint.x == size-1) ? new Point(0, thisPoint.y + 1) : new Point(thisPoint.x + 1, thisPoint.y );
                thisPoint.setLocation(nextPoint);
                return getCell(current);

            }
        };
    }

}
