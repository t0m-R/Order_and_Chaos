package UI.Console;

import core.Entities.Piece;

import java.util.HashMap;
import java.util.Map;


public class DisplayCell {

    private static final Map<Piece, String> cellPieceMap = new HashMap<>() {{
        put(Piece.x, "[x]");
        put(Piece.o, "[o]");
        put(null, "[ ]");
    }};

    private DisplayCell() {}

    public static String getRepresentation(Piece piece) {
        return cellPieceMap.get(piece);
    }
}
