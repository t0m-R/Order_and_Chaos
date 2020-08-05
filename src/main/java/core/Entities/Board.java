package core.Entities;

import java.awt.Point;
import java.util.Iterator;

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
