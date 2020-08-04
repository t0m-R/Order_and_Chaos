package core.Entities;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class CellTest {
    private final Cell cell = new Cell(new Point(2, 3));

    @Test
    public void testNullCell(){
        assertNull(cell.getPiece());
    }

    @Test
    public void testSetPiece(){
        cell.setPiece(Piece.x);
        assertSame(cell.getPiece(), Piece.x);
    }

    @Test
    public void testPieceEqualityTrue() {
        cell.setPiece(Piece.o);
        assertTrue(cell.hasThisPiece(Piece.o));
        assertFalse(cell.hasThisPiece(Piece.x));
    }



    @Test
    public void testCoordinates() {
        assertEquals(cell.getCoordinates(), new Point(2,3));
    }


}
