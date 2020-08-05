package core.Entities;

import org.junit.Test;

import java.awt.Point;
import java.util.Iterator;

import static org.junit.Assert.*;

public class BoardTest {

    private final Board board = new Board(6);

    @Test
    public void testSize(){
        assertEquals(6, board.getSize());
    }

    @Test
    public void testCell(){
        assertEquals(new Point(2,3), board.getCell(new Point(2,3)).getCoordinates());
    }

    @Test
    public void setCellTest(){
        Point p = new Point(1,1);
        board.setCell(p, Piece.x);
        assertSame(Piece.x, board.getCell(p).getPiece());
    }

    @Test
    public void testNext(){
        Board test = new Board(2);
        Iterator<Cell> cell = test.iterator();
        Cell origin = cell.next();
        assertEquals(origin.getCoordinates(), new Point(0,0));
        origin = cell.next();
        assertEquals(origin.getCoordinates(), new Point(1,0));
        origin = cell.next();
        assertEquals(origin.getCoordinates(), new Point(0,1));
    }

    @Test
    public void testHasNext() {
        Board test = new Board(1);
        Iterator<Cell> cell = test.iterator();
        assertTrue(cell.hasNext());
        cell.next();
        assertFalse(cell.hasNext());
    }

    @Test
    public void testIsValidTrue() {
        assertTrue(board.isValid(new Point(0,0)));
        assertTrue(board.isValid(new Point(0,5)));
        assertTrue(board.isValid(new Point(5,0)));
        assertTrue(board.isValid(new Point(5,5)));
        assertFalse(board.isValid(new Point(0,6)));
        assertFalse(board.isValid(new Point(-1,0)));
        assertFalse(board.isValid(new Point(-1,6)));
    }




}
