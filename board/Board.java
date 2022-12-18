package board;

import java.util.*;


public class Board {

    private Tile tile;

    private List<Tile> board;

    private Board() {
        for(int i = 0; i < 64; i++) {
            board.add(new Tile.EmptyTile(i));
        }
    }

    public Tile getTile(int coordinate) {
        return board.get(coordinate);
    }
}
