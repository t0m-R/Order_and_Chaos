package core.Entities;

import java.awt.Point;

public class Cell {

    private Piece piece;
    private final Point coordinates;

    public Cell(Point p) {
        piece = null;
        coordinates = p;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece p){
        piece = p;
    }

    public boolean hasThisPiece(Piece p) {
        return piece == p;
    }

}
