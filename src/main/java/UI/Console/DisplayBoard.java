package UI.Console;

import core.Entities.Board;
import core.Entities.Cell;
import java.awt.Point;
import java.util.stream.IntStream;

public class DisplayBoard {

    private DisplayBoard() {}

    private static String padLeft(String s) { return String.format("%" + 3 + "s", s); }

    private static void showCell(Cell cell) {
        System.out.print(DisplayCell.getRepresentation(cell.getPiece()));
    }

    private static void showRow(Board board, int y) {
        System.out.print(y + " \t");
        IntStream.range(0, board.getSize()).forEach(x -> showCell(board.getCell(new Point(x, y))));
        System.out.println();
    }

    public static void showBoard(Board board) {
        System.out.println();
        IntStream.iterate(board.getSize() - 1, x -> --x).limit(board.getSize()).forEach(y -> showRow(board, y));
        System.out.print("\n\t");
        IntStream.range(0, board.getSize()).forEach(i -> System.out.print(padLeft(i + " ")));
        System.out.println("\n");
    }
}
